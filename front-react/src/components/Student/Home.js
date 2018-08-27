import React from 'react';
import Grid from '@material-ui/core/Grid';
import {Link} from 'react-router-dom';
import '../../styles/components/Student/Home.css';

import Clogo from '../../assets/c-logo.png';
import Plogo from '../../assets/python-logo.png';
import Jlogo from '../../assets/java-logo.svg';
import ExercisesTable from '../../containers/Student/ExercisesTable';

const Home = () => {
    return(
        <div className="list">
            <Grid container>
                <Grid item xs={2}></Grid>
                <Grid item xs={8} className="list-show">
                    <h1 className="list-title">Ejercicios</h1>
                    <Grid container>
                        <Grid item xs={4}>
                            <Link to="Estudiante/Ejercicios">
                                <img src={Clogo} alt="" className="item-c"/>
                            </Link>
                        </Grid>
                        <Grid item xs={4}>
                            <Link to="Estudiante/Ejercicios">
                                <img src={Plogo} alt="" className="item-python"/>
                            </Link>
                        </Grid>
                        <Grid item xs={4}>
                            <Link to="Estudiante/Ejercicios">
                                <img src={Jlogo} alt="" className="item-java"/>
                            </Link>
                        </Grid>
                    </Grid>
                </Grid>

                <Grid item xs={2}></Grid>

                <Grid item xs={2}></Grid>
                <Grid item xs={8} className="list-solved">Resueltos</Grid>
                <Grid item xs={2}></Grid>
            </Grid>
        </div>
    );
};

export default Home;