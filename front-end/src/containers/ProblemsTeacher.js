import React, { Component } from 'react';
import axios from 'axios';
import {NavLink} from 'react-router-dom';
import {ButtonToolbar, Button, Modal} from "react-bootstrap";


class ProblemsTeacher extends Component {
  constructor(props) {
      super(props);

      this.handleShow = this.handleShow.bind(this);
      this.handleHide = this.handleHide.bind(this);

      this.state = {
        problems: []
      };
    }


    handleShow = (i) => (e) => {
      const newProblems = this.state.problems.map((problem, j) => {
        if (i !== j) return problem;
        return { ...problem, show: true,  };
      });
      this.setState({ problems: newProblems });
    }

    handleRemove = (id) => (e) => {
      console.log(id);
    }

    handleHide = (i) => (e) => {
      const newProblems = this.state.problems.map((problem, j) => {
        if (i !== j) return problem;
        return { ...problem, show: false,  };
      });
      this.setState({ problems: newProblems });
    }


      componentDidMount() {
        axios.get('http://localhost:8082/problems')
          .then(res => {
            const problems = res.data;
            this.setState({problems});
            console.log(problems.length);
            const asd = {show: false};
            for (var i = 0; i < problems.length; i++) {
             problems[i] = {...problems[i], ...asd };
            }
            this.setState(problems);
            console.log(this.state.problems);
          })
      }
  render() {
  return (
    <div className="problem-teacher">
      <h2 className="problem-student-title">Problemas</h2>
      <div className="table-student">
        <table className="table">
          <thead>
            <tr>
              <th className= "number">ID</th>
              <th className="th-description">Título</th>
              <th className="th-description">Descripción</th>
              <th className="th-description">Lenguaje</th>
              <th className="th-description">Editar</th>
              <th className="th-description">Eliminar</th>
            </tr>
          </thead>
          <tbody>

            {this.state.problems.map((item,i) => (
              <tr>
                <td className="td-name">
                  {i}
                </td>
                <td>
                  {item.problemTitle}
                </td>
                <td>
                  <ButtonToolbar>
                  <Button bsStyle="primary" onClick={this.handleShow(i)}>
                    Ver
                  </Button>
                  <Modal
                    show={this.state.problems[i].show}
                    onHide={this.handleHide(i)}
                    dialogClassName="custom-modal"
                  >
                    <Modal.Header closeButton>
                      Problema número {i+1}
                      <Modal.Title id="contained-modal-title-lg">
                        {this.problemTitle}
                      </Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                      <h4>Descripción</h4>
                      <p>
                        {item.problemStatement}
                      </p>
                    </Modal.Body>
                    <Modal.Footer>
                      <Button onClick={this.handleHide(i)}>Close</Button>
                    </Modal.Footer>
                  </Modal>
                </ButtonToolbar>
                </td>
                <td>
                  {item.language}
                </td>
                <td className="td-actions">
                <NavLink className="btn btn-primary btn-sm"
                                         to={'/edit/' + item.problemId}>Editar Problema</NavLink>
                </td>
                <td className="td-actions">
                <Button bsStyle="danger" bsSize="small" onClick={this.handleRemove(item.problemId)} >Eliminar</Button>
                </td>
              </tr>
            ))}


          </tbody>
        </table>
      </div>
    </div>
    );
  }
  }
  export default ProblemsTeacher;
