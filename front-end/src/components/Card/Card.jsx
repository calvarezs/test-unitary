import React, { Component } from "react";
import { Chart } from 'react-google-charts';
import {Row, Col} from "react-bootstrap";

export class Card extends Component {

  render() {

    var data = [
      ["Task","Hours per Day"],
      ["Python",11],
      ["C",5],
      ["Java",2]
    ]

    var options = {
      title:"Lenguaje utilizado",
      is3D:true,
    }


    return (
      <div className="card">
        <div className={"card-header"}>
            <h3 className="card-header-title"><small>Rendimiento del Alumno</small></h3>
        </div>
        <div className="card-body">

          <div id="chartPreferences" className="pieChart">
            <Chart
                      chartType="PieChart"
                      data={data}
                      options={options}
                      graph_id="card-pieChart"
                      height="350px"
                      width="350px"
                      />
          </div>
            <div className="body-time">
            <Row>
            <Col xs={6} md={6}>
            <h5 className="">Tiempo promedio</h5>
            </Col>
            <Col xs={6} md={6}>
            <h5 className="">25%</h5>
            </Col>
            </Row>
            </div>
          <div className="footer">
          </div>
        </div>
      </div>
    );
  }
}

export default Card;
