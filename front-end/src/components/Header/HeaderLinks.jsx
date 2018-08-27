import React, { Component } from "react";
import { NavItem, Nav, NavDropdown, MenuItem } from "react-bootstrap";

class HeaderLinks extends Component {
  render() {
    const notification = (
      <div>
        <i className="fa fa-globe" />
        <b className="caret" />
        <span className="notification">Universidad de Santiago</span>
      </div>
    );
    return (
      <div className>
        <Nav>
          <NavDropdown
            eventKey={2}
            title={notification}
            noCaret
            id="basic-nav-dropdown"
          >
            <MenuItem  href="https://www.youtube.com/watch?v=LYEzNBXytaE" eventKey={2.1}>Viajo sin ver</MenuItem>
            <MenuItem eventKey={2.2}>Notification 2</MenuItem>
            <MenuItem eventKey={2.3}>Notification 3</MenuItem>
            <MenuItem eventKey={2.4}>Notification 4</MenuItem>
            <MenuItem eventKey={2.5}>Another notifications</MenuItem>
          </NavDropdown>
        </Nav>
        <Nav pullRight>
          <NavItem eventKey={1} >
            Profesor: Alcides Quispe
          </NavItem>
          <NavDropdown
            eventKey={2}
            title="Opciones"
            id="basic-nav-dropdown-right"
          >
            <MenuItem eventKey={2.1}>Action</MenuItem>
            <MenuItem eventKey={2.2}>Another action</MenuItem>
            <MenuItem eventKey={2.3}>Something</MenuItem>
            <MenuItem eventKey={2.4}>Another action</MenuItem>
            <MenuItem eventKey={2.5}>Something</MenuItem>
            <MenuItem divider />
            <MenuItem eventKey={2.5}>Separated link</MenuItem>
          </NavDropdown>
          <NavItem eventKey={3} href="#">
            Salir
          </NavItem>
        </Nav>
      </div>
    );
  }
}

export default HeaderLinks;
