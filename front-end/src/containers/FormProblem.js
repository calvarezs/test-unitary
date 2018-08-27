import React, { Component } from "react";
import {Row, Col} from "react-bootstrap";
import {ButtonToolbar,Button, FormGroup, ControlLabel, FormControl, HelpBlock} from "react-bootstrap";
import Cancel from "../images/cancel-button.png";

const examples = problem => {
  const newInputs = problem.inputs.map((input, i) => {
    return {'inputType': input.inputType, 'inputValue': input.inputValue}
  });
  return newInputs;
}

const addProblem = problem => {
  const inputs = examples(problem);
  console.log(inputs);
  fetch('http://localhost:8082/problems', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        "problemTitle": problem.title,
        "problemStatement": problem.description,
        "problemExamples": [
          {
            "exampleTitle": problem.title,
            "result":{
              "resultType": problem.output,
              "resultValue": problem.typeOutput
            },
            "exampleInputs": problem.inputs
          }
        ],
        "language": problem.language,
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
   fetch('http://localhost:8082/users', {
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
      typeOutput: 'String',
      description: '',
      inputs: [{ inputValue: '', inputType: 'String' }],
      language: 'Python',
    };
  }

  getValidationState() {
    const length = this.state.title.length;
    if (length > 0) return 'success';
    else if  (length === 0) return 'error';
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
    // addUser(this.state);
    addProblem(this.state);
    console.log(this.state);
  }

  handleAddShareholder = () => {
    this.setState({ inputs: this.state.inputs.concat([{ inputValue: '', inputType: 'String' }]) });
  }

  handleRemoveShareholder = (idx) => () => {
    this.setState({ inputs: this.state.inputs.filter((s, sidx) => idx !== sidx) });
  }

  render() {
    return (

      <div className="problem">
      <h2 className="problem-title">Añadir problema</h2>
      <form className="problem-form" onSubmit={this.handleSubmit}>
      <Row className="show-grid">
      <Col xs={12} md={12}>
        <h4>Titulo del problema</h4>
      </Col>
        <Col xs={12} md={12}>
        <FormGroup
            controlId="formBasicText"
            validationState={this.getValidationState()}
          >
            <FormControl
              name = "title"
              type="text"
              value={this.state.title}
              placeholder="Escribe el titulo del problema..."
              onChange={e => this.Change(e)}
            />
            <FormControl.Feedback />
            <HelpBlock>Campo obligatorio.</HelpBlock>
          </FormGroup>
        </Col>
      </Row>


        <Row className="row-btn-add">
          <Col xs={8} md={8}>
            <h4>Entradas del problema</h4>
          </Col>
        </Row>

        <Row className="problem-inputs">
          <Col xs={12} md={12}>
            {this.state.inputs.map((shareholder, idx) => (
              <div className="shareholder">
              <Row className="problem-row-inputs">
                <Col xs={9} md={8}>
                <FormGroup
                    controlId="formBasicText"
                    validationState={this.getValidationState()}
                  >
                  <FormControl
                    name = "inputValue"
                    type= "text"
                    value={shareholder.name}
                    placeholder={`Entrada #${idx + 1}`}
                    onChange={this.handleShareholderNameChange(idx)}
                  />
                  <FormControl.Feedback />
                  <HelpBlock>Campo obligatorio.</HelpBlock>
                </FormGroup>
                </Col>
                <Col xs={2} md={2}>
                   <FormControl
                   componentClass="select"
                   placeholder="select"
                   name="inputType"
                   value={shareholder.type}
                   onChange={this.handleShareholderTypeChange(idx)}>
                     <option value="String">String</option>
                     <option value="Integer">Entero</option>
                   </FormControl>
                </Col>
                {idx === 0 ? <Col xs={2} md={2}>
                          <Button className="btn-add" onClick={this.handleAddShareholder}><span>Agregar</span></Button>
                          <Button className="btn-icon-delete"  onClick={this.handleRemoveShareholder(1)}>  Eliminar</Button>
                          </Col> : null}
              </Row>
              </div>
            ))}
          </Col>
        </Row>

        <br />
        <Row className="show-grid">
          <Col xs={8} md={8}>
          <h4>Salida del problema</h4>
          </Col>
        </Row>

        <Row className="show-grid2adas">
          <Col xs={8} md={8}>
          <FormGroup
              controlId="formBasicText"
              validationState={this.getValidationState()}
            >
              <FormControl
                name ="output"
                type="text"
                value={this.state.output}
                placeholder="Escribe la salida del problema..."
                onChange={e => this.Change(e)}
              />
              <FormControl.Feedback />
              <HelpBlock>Campo obligatorio.</HelpBlock>
            </FormGroup>
          </Col>
          <Col xs={2} md={2}>
              <FormControl
              componentClass="select"
              placeholder="select"
              name="typeOutput"
              value={this.state.typeOutput}
              onChange={e => this.Change(e)}>
                <option value="String">String</option>
                <option value="Integer">Entero</option>
              </FormControl>
          </Col>
        </Row>
        <Row>
        <Col xs={12} md={12}>
          <h4>Descripcion del problema</h4>
        </Col>
        <Col xs={12} md={12}>
        <FormGroup
            controlId="formBasicText"
            validationState={this.getValidationState()}
          >
            <FormControl
              componentClass="textarea"
              name = "description"
              type="text"
              value={this.state.description}
              placeholder="Descripcion del problema..."
              onChange={e => this.Change(e)}
            />
            <FormControl.Feedback />
            <HelpBlock>Campo obligatorio.</HelpBlock>
          </FormGroup>
          </Col>
        <br />

          <ButtonToolbar n>
            <Button  onClick={e => this.handleSubmit(e)} bsStyle="success">Guardar</Button>
          </ButtonToolbar>
        </Row>
      </form>
    </div>
    )
  }
}

export default FormProblem;
