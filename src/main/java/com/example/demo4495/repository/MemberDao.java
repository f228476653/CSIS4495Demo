package com.example.demo4495.repository;

import org.json.JSONArray;
import org.json.JSONObject;
import com.example.demo4495.models.MemberAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Repository
public class MemberDao {

    public MemberAccount addMember(MemberAccount memberAccount) throws IOException {
        System.out.println("EXCUTE INSERT MEMBER");
        String url = "http://45.76.207.32:8080/"+memberAccount.getEmail();
        String value= "{\"value\":\""+memberAccount.getPassword()+"\"}";
        try {
            String[] command = {"curl", "-X", "POST", "-H" ,"Content-Type: application/json" ,"-d", value, url};
            ProcessBuilder process = new ProcessBuilder(command);
            Process p;
            p = process.start();
            return memberAccount;
        }catch (Exception e){
            throw e;
        }
    }

    public MemberAccount signIn(MemberAccount memberAccount) throws IOException {
        String url = "45.76.207.32:8080/fetch/"+memberAccount.getEmail();
        try {
            String[] command = {"curl", "-i",  url};
            ProcessBuilder process = new ProcessBuilder(command);
            Process p;
            p = process.start();
            BufferedReader reader =  new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String last,line = null;
            while ( (line = reader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
            String result = builder.toString();
            String rsArray[] =result.split("\n");
            if(rsArray[0].equals("HTTP/1.1 200 OK")){
                JSONObject pair = new JSONObject(rsArray[rsArray.length-1]);
                if(pair.getString("value").equals(memberAccount.getPassword())){
                    System.out.println("EXCUTE signIn MEMBER");
                    return memberAccount;
                }else{
                    return new MemberAccount();
                }
            }else{
                return new MemberAccount();
            }
        }catch (Exception e){
            throw e;
        }
    }

}