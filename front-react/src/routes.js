import React from 'react';
import {Switch, Route} from 'react-router-dom';

import HomePage from './components/Home/HomePage';
import HomeStudent from './components/Student/Home';
import ShowExercises from './containers/ShowExercises/ShowExercises';


const IndexRoutes = () => {
    return(
        <div>
            <Switch>
                <Route path="/" exact component={HomePage} />
                <Route path="/Estudiante" exact component={HomeStudent} />
                <Route path="/Estudiante/Ejercicios" exact component={ShowExercises} />
            </Switch>
        </div>
    );
};

export default IndexRoutes;