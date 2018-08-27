import React, {Component} from 'react';
import axios from 'axios';
import {Table, Grid, Row, Col} from 'react-bootstrap';

class ShowExercises extends Component {
    constructor(props) {
        super(props);
        
        this.state = {
            problems: []
        }
    }


    componentDidMount() {
      axios.get('http://165.227.48.161:8082/problems').then(res => {
        const problems = res.data;
        this.setState({problems});
      })
    };

    render() {
        return(
            <div>
                <Grid fluid>
                    <Row className="show-grid">
                        <Col xs={12} md={4}>
                            <h1>Ejercicios</h1>
                            <p>Ejercicios disponibles para la asignatura de Fundamentos de Programación.</p>
                            
                            <p>Dropdown para hacer un filter por el lenguaje de prog.</p>
                            <p>Boton para ver los ejercicios resueltos</p>
                        </Col>
                        <Col xs={12} md={8}>
                            <Table responsive>
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Título</th>
                                        <th>Tipo</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {this.state.problems.map((item,i) => (
                                        <tr>
                                            <td>{i}</td>
                                            <td>{item.problemTitle}</td>
                                            <td>{item.language}</td>
                                            <button>Ver Detalle</button>
                                            <button>Ir</button>
                                        </tr>
                                        ))
                                    }
                                </tbody>
                            </Table>
                        </Col>
                    </Row>
                </Grid>
            </div>
        );
    }
}

export default ShowExercises;