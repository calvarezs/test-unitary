import React, { Component } from "react";
import {Row, Col} from "react-bootstrap";
import {Button, FormGroup, ControlLabel, FormControl, HelpBlock} from "react-bootstrap";

const addProblem = problem => {
  console.log(problem.title);
  fetch('http://165.227.48.161:8082/problems', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        "problemTitle": problem.title,
        "problemStatement": problem.description,
        "example": {
          "input":{
            "type": problem.inputs[0].type,
            "value": problem.inputs[0].value
          },
          "result":{
            "type": problem.typeOutput,
            "value": problem.output
          }
        },
        "language": "Python",
        "user":{
          "userId": 1
        }
      })
  })
    .then(response => {
        alert(response);
    })
    .catch(error => {
        console.error(error);
    });
 }

 const addUser = user => {
   fetch('http://165.227.48.161:8082/users', {
       method: 'POST',
       headers: {
         'Content-Type': 'application/json'
       },
       body: JSON.stringify({
         "userEmail": "prueba@prueba.cl",
         "userPassword": "password",
         "userType": 0
       })
   })
     .then(response => {
         alert(response);
     })
     .catch(error => {
         console.error(error);
     });
  }

class FormProblem extends Component {
  constructor() {
    super();
    this.state = {
      title: '',
      output: '',
      typeOutput: 'str',
      description: '',
      inputs: [{ input: '', type: 'str' }],
    };
  }


  getValidationState() {
    const length = this.state.title.length;
    if (length > 10) return 'success';
    else if (length > 5) return 'warning';
    else if (length > 0) return 'error';
    return null;
  }

  Change = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  }

  handleShareholderNameChange = (idx) => (evt) => {
    const newShareholders = this.state.inputs.map((shareholder, sidx) => {
      if (idx !== sidx) return shareholder;
      return { ...shareholder, [evt.target.name]: evt.target.value,  };
    });

    this.setState({ inputs: newShareholders });
  }

  handleShareholderTypeChange = (idx) => (evt) => {
    const newShareholders = this.state.inputs.map((shareholder, sidx) => {
      if (idx !== sidx) return shareholder;
      return { ...shareholder, [evt.target.name]: evt.target.value,  };
    });
    this.setState({ inputs: newShareholders });
  }

  handleSubmit = (evt) => {
    evt.preventDefault();
    const { title, inputs } = this.state;
    alert(`Incorporated: ${title} with ${inputs.length} inputs`);
    //addUser(this.state);
    addProblem(this.state);
    console.log(this.state);
  }

  handleAddShareholder = () => {
    this.setState({ inputs: this.state.inputs.concat([{ input: '', type: 'str' }]) });
  }

  handleRemoveShareholder = (idx) => () => {
    this.setState({ inputs: this.state.inputs.filter((s, sidx) => idx !== sidx) });
  }

  render() {
    return (

      <div className="formStudent">
      <h1 className="title">Añadir un problema a la plataforma</h1>
      <h5 className="description">Aquí puedes añadir un nuevo problema
      a la plataforma......................................
      </h5>

      <form onSubmit={this.handleSubmit}>
      <FormGroup
          controlId="formBasicText"
          validationState={this.getValidationState()}
        >
          <ControlLabel>Título del problema:</ControlLabel>
          <FormControl
            name = "title"
            type="text"
            value={this.state.title}
            placeholder="Escribe el titulo del problema..."
            onChange={e => this.Change(e)}
          />
          <FormControl.Feedback />
          <HelpBlock>Un nombre coherente plis :D</HelpBlock>
        </FormGroup>

        <Row className="show-grid">
          <Col xs={10} md={4}>
            <ControlLabel>Entradas del problema:</ControlLabel>
          </Col>
          <Col xs={10} md={4}>
            <ControlLabel>Tipo:</ControlLabel>
          </Col>
          <Col xs={10} md={4}>
            <Button bsStyle="success" bsSize="xsmall" onClick={this.handleAddShareholder}>+</Button>
          </Col>
        </Row>


        {this.state.inputs.map((shareholder, idx) => (
          <div className="shareholder">
          <Row className="show-grid">
            <Col xs={6} md={4}>
            <FormControl
              name = "input"
              type= "text"
              value={shareholder.name}
              placeholder={`Entrada #${idx + 1}`}
              onChange={this.handleShareholderNameChange(idx)}
            />
            <FormControl.Feedback />
            </Col>
            <Col xs={6} md={4}>
               <select name="type"
               value={shareholder.type}
               onChange={this.handleShareholderTypeChange(idx)}>
                 <option value="str">String</option>
                 <option value="int">Entero</option>
               </select>
            </Col>
            <Col xsHidden md={4}>
            <Button bsStyle="danger" bsSize="xsmall" onClick={this.handleRemoveShareholder(idx)} >x</Button>
            </Col>
          </Row>
          </div>
        ))}
        <br />

        <Row className="show-grid">
          <Col xs={6} md={6}>
          <ControlLabel>Salida del problema:</ControlLabel>
          </Col>
          <Col xs={6} md={6}>
          <ControlLabel>Tipo:</ControlLabel>
          </Col>
        </Row>

        <Row className="show-grid">
          <Col xs={6} md={6}>
            <FormControl
              name ="output"
              type="text"
              value={this.state.output}
              placeholder="Escribe la salida del problema..."
              onChange={e => this.Change(e)}
            />
            <FormControl.Feedback />
            <HelpBlock>Una salida coherente plis :D</HelpBlock>
          </Col>
          <Col xs={6} md={6}>
             <select name="typeOutput"
             value={this.state.typeOutput}
             onChange={e => this.Change(e)}>
               <option value="str">String</option>
               <option value="int">Entero</option>
             </select>
          </Col>
        </Row>



        <br />
        <ControlLabel>Descripción</ControlLabel>
        <FormControl  name="description"
        componentClass="textarea"
        placeholder="Descripción del problema..."
        value={this.state.description}
        onChange={e => this.Change(e)}/>

        <br />
        <Button type="submit">Guardar</Button>
      </form>
    </div>
    )
  }
}

export default FormProblem;
