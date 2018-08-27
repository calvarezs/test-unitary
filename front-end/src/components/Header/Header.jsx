import React, { Component } from "react";
import { Navbar } from "react-bootstrap";

import HeaderLinks from "./HeaderLinks.jsx";

import dashboardRoutes from "./dashboard.jsx";

class Header extends Component {
  constructor(props) {
    super(props);
    this.mobileSidebarToggle = this.mobileSidebarToggle.bind(this);
    this.state = {
      sidebarExists: false
    };
  }
  mobileSidebarToggle(e) {
    if (this.state.sidebarExists === false) {
      this.setState({
        sidebarExists: true
      });
    }
    e.preventDefault();
    document.documentElement.classList.toggle("nav-open");
    var node = document.createElement("div");
    node.id = "bodyClick";
    node.onclick = function() {
      this.parentElement.removeChild(this);
      document.documentElement.classList.toggle("nav-open");
    };
    document.body.appendChild(node);
  }

  getBrand() {
    var name;
    dashboardRoutes.map((prop, key) => {

      return null;
    });

  }
  render() {
    return (
      <Navbar className="Navbar" fluid>
        <Navbar.Header>
          <Navbar.Toggle onClick={this.mobileSidebarToggle} />
        </Navbar.Header>
        <Navbar.Collapse>
          <HeaderLinks />
        </Navbar.Collapse>
      </Navbar>
    );
  }
}

export default Header;
