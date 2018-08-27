import React from 'react';
import ChartistGraph from "react-chartist";
import ReactSvgPieChart from "react-svg-piechart";
import {Row, Col} from "react-bootstrap";
import { Chart } from 'react-google-charts';
import {Card} from '../Card/Card.jsx';


const Home = () => {


  var data = [
    ["Task","Hours per Day"],
    ["Python",11],
    ["C",5],
    ["Java",2]
  ]

  var options = {
    title:"Lenguaje utilizado",
    pieHole:0.4,
    is3D:true,
  }

    return(
      <div>
      <h2 className="problem-title">Dashboard</h2>
      <Row className="show-grid">
        <Col className="col-pieChart" xs={10} md={6}>
          <div id="chartPreferences" className="pieChart">
            <Chart
                      chartType="PieChart"
                      data={data}
                      options={options}
                      graph_id="ScatterChart"
                      height="400px"
                      width="400px"
                      />
          </div>
        </Col>
        <Col className="col-pieChart2" xs={10} md={6}>
        <div id="chartPreference2s" className="piasdeChart">
          <Card {...this.props}/>
        </div>
        </Col>
      </Row>
      </div>
    );
};


export default Home;
