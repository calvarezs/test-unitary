import React, { Component } from "react";

const addProblem2 = problem =>{
  console.log(problem.problemName);
  fetch('http://localhost:8082/problems', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        "problemTitle": problem.problemName,
        "problemStatement": problem.description,
        "user":{
          "userId": 1,
        },
        "language": "Python"
      })
  })
    .then(response => {
        alert(response.data);
    })
    .catch(error => {
        console.error(error);
    });
 }
 const addProblem = problem =>{
   console.log(problem.problemName);
   fetch('http://localhost:8082/problems', {
       method: 'POST',
       headers: {
         'Content-Type': 'application/json'
       },
       body: JSON.stringify({
         "problemTiltle": problem.problemName,
         "problemStatement": problem.description,
         "example": {
           "input":{
             "type": "str",
             "value": problem.input
           },
           "result":{
             "type": "str",
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
         alert(response.data);
     })
     .catch(error => {
         console.error(error);
     });
  }


class Form extends Component {
  state = {
    problemName: "",
    input: "",
    inputType: "str",
    output: "",
    outputType: "str",
    description: ""
  };


  change = e => {
    // ACTUALIZA EL STATE DEL COMPONENTE FORM
    this.setState({
      [e.target.name]: e.target.value
    });
  };

  onSubmit = e => {
    e.preventDefault();
    alert(this.state.inputType);
    // this.props.onSubmit(this.state);
    //addProblem2(this.state);
    this.setState({
      problemName: "",
      input: "",
      inputType: "str",
      output: "",
      outputType: "str",
      description: ""
    });
  };

  render() {
    return (
      <div className="form-problem">
      <h1 className="title">Añadir un nuevo problema</h1>
      <h3 className="sub-section">Aqui puedes añadir un problema a la plataforma</h3>
      <br />
      <br />
      <form>
        <label>
        Nombre del problema:
        <input
          name="problemName"
          placeholder="Name of the problem"
          value={this.state.problemName}
          onChange={e => this.change(e)}
        />
        </label>
        <br />
        <label>
        Entrada del algoritmo:
          <input
            name="input"
            placeholder="input of the problem"
            value={this.state.input}
            onChange={e => this.change(e)}
          />
        </label>
         Tipo
         <select name="inputType"
         value={this.state.inputType}
         onChange={e => this.change(e)}>
           <option value="str">String</option>
           <option value="int">Entero</option>
         </select>
        <br />
        <label>
        Salida del algoritmo:
        <input
          name="output"
          placeholder="output of the problem"
          value={this.state.output}
          onChange={e => this.change(e)}
        />
        </label>
        <label>
         Tipo
         <select name="outputType"
         value={this.state.outputType}
         onChange={e => this.change(e)}>
           <option value="str">String</option>
           <option value="int">Entero</option>
         </select>
       </label>
        <br />
        <label>
          Descripción del problema:
          <textarea name="description"
          placeholder="Description of the problem"
          value={this.state.description}
          onChange={e => this.change(e)} />
        </label>
        <br />
        <button onClick={e => this.onSubmit(e)}>Submit</button>
      </form>
      </div>
    );
  }
}

export default Form;
