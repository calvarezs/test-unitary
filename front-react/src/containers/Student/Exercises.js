import React, {Component} from 'react';
import Grid from '@material-ui/core/Grid';
import { Table, TableHead, TableRow, TableCell, TableBody, Paper } from '@material-ui/core';
import './Exercises.css';

class Exercises extends Component {
    render() {
        return(
            <div>
                <Grid container>
                    <Grid item xs={2}></Grid>
                    <Grid item xs={8}>
                        <div className="list-exercises">
                            <div className="list-item">
                                <Paper className="item">Problemita 1</Paper>
                            </div>
                            <Paper>Problemita 2</Paper>
                            <Paper>Problemita 3</Paper>
                            <Paper>Problemita 4</Paper>
                        </div>
                    </Grid>
                    <Grid item xs={2}></Grid>
                </Grid>
            </div>
        );
    }
}

export default Exercises;