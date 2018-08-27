import React, { Component } from 'react';
import MenuAppBar from './layout/MenuAppBar';
import IndexRoutes from './routes.js';
import './styles/App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <MenuAppBar />
        <IndexRoutes />
      </div>
    );
  }
}

export default App;
