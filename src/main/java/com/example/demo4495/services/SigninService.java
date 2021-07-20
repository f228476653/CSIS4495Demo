package com.example.demo4495.services;

import com.example.demo4495.models.MemberAccount;
import com.example.demo4495.repository.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SigninService {
    @Autowired
    MemberDao memberDao;
    public MemberAccount signIn(MemberAccount memberAccount) throws IOException {
        return memberDao.signIn(memberAccount);
    }
}
