import React from 'react';
import Tilt from 'react-tilt';
import brain from './brain.png';
import './Home.css';

const Home = ({email}) => {
  return (
    <div className='ma4 mt0'>
      <Tilt className="Tilt br2 shadow-2 d-block" options={{ max : 55 }} >
        <div className="Tilt-inner pa3">
          <img style={{paddingTop: '5px'}} alt='Home' src={brain}/>
        </div>
        <div>
          <h2>Welcome, {email} !</h2>
        </div>
      </Tilt>
    </div>
  );
}

export default Home;