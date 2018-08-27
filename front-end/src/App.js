import React from 'react';
import {BrowserRouter as Router, Route, NavLink} from 'react-router-dom';

import ProblemsStudent from './containers/ProblemsStudent.js'
import ProblemsTeacher from './containers/ProblemsTeacher.js'
import FormStudent from './containers/FormStudent.js'
import FormProblem from './containers/FormProblem.js'
import EditProblem from './containers/EditProblem.js'
import Header from "./components/Header/Header.jsx";
import Header2 from "./components/Header/Header2.jsx";
import fing from "./images/fing.png";
import udes from "./images/udes.png";
import Home from "./components/Home/Home.js";

// Assets
import 'bootstrap/dist/css/bootstrap.min.css';
import './styles/App.css';

const App = () => {
    return (
        <Router>
            <div className="App">
                <div id="sidebar" className="sidebar">
                  <div className="div-logo-udes">
                    <img src={udes} alt="logo_image" className="logo-udes"/>
                  </div>
                  <nav className="side-nav">
                      <ul>
                          <li>
                          <NavLink to="/home">
                            <span><i class="fa fa-pie-chart"> </i></span>
                            <span> Inicio</span>
                          </NavLink>
                          </li>
                          <li>
                          <NavLink to="/problems/student">
                            <span><i class="fas fa-columns"> </i></span>
                            <span> Problemas Es</span>
                          </NavLink>
                          </li>
                          <li>
                          <NavLink to="/problems/teacher">
                            <span><i class="fas fa-columns"> </i></span>
                            <span> Problemas Profesor</span>

                          </NavLink>
                          </li>
                          <li>
                          <NavLink to="/add">
                            <span><i class="far fa-calendar-plus"> </i></span>
                            <span> Añadir Problema</span>
                          </NavLink>
                          </li>
                          <li>
                          <NavLink to="/solve/1">
                          <span><i class="fa fa-keyboard"> </i></span>
                          <span> Resolver Problemas</span>
                          </NavLink>
                          </li>
                      </ul>
                  </nav>
                    <img src={fing} alt="logo_image" className="logo-fing"/>
                </div>
                <div className="container">
                      <Header {...this.props} />
                    <div className="views">
                      <Route path="/problems/student" component={ProblemsStudent}/>
                      <Route path="/problems/teacher" component={ProblemsTeacher}/>
                      <Route path="/add" component={FormProblem}/>
                      <Route path="/solve/:id" component={FormStudent}/>
                      <Route path="/edit/:id" component={EditProblem}/>
                      <Route path="/home" component={Home}/>
                    </div>
                </div>
            </div>
        </Router>
    );
};

export default App;
