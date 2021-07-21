import React, { Component } from 'react';
import Navigation from './components/Navigation/Navigation';
import Signin from './components/Signin/Signin';
import Register from './components/Register/Register';
import Home from './components/Home/Home';
import './App.css';
import { error } from 'loglevel';

const particlesOptions = {
  particles: {
    number: {
      value: 30,
      density: {
        enable: true,
        value_area: 800
      }
    }
  }
}

const initialState = {
  route: 'signin',
  isSignedIn: false,
  user: {
    name: '',
    email: '',
  }
}

class App extends Component {
  constructor() {
    super();
    this.state = initialState;
  }

  loadUser = (data) => {
    this.setState({user: {
      name: data.name,
      email: data.email,
    }})
  }

  onDelete = () => {
    fetch(`http://localhost:8080/api/delete?email=${this.state.user.email}`, {
      method: 'GET', 
      headers: {
          'Content-Type': 'application/json'
      }
  })
      .then(response => response.json())
      .then(success => {
        if (success) {
          this.setState(initialState)
        }
      })
  }

  onRouteChange = (route) => {
    this.setState({route: route});
    if (route === 'signout') {
      this.setState(initialState)
    }else if (route === 'home') {
      this.setState({isSignedIn: true})
    }else if (route === 'update') {
      this.setState({isSignedIn: true,route:'register'})
    }else if (route === 'register') {
      this.setState({isSignedIn: false})
    }else if( route === 'delete'){
      this.onDelete();
    }
  }

  render() {
    const { isSignedIn, route } = this.state;
    return (
      <div className="App">
        <Navigation isSignedIn={isSignedIn} onRouteChange={this.onRouteChange} />
        { route === 'home'
          ? <div>
              <Home email={this.state.user.email} />
            </div>
          : (
             route === 'signin'
             ? <Signin loadUser={this.loadUser} onRouteChange={this.onRouteChange}/>
             : <Register loadUser={this.loadUser} isSignedIn={isSignedIn} email={this.state.user.email} onRouteChange={this.onRouteChange}/>
            )
        }
      </div>
    );
  }
}

export default App;
