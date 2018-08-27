import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {Link} from 'react-router-dom';

// Material
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import AccountCircle from '@material-ui/icons/AccountCircle';
import MenuItem from '@material-ui/core/MenuItem';
import Menu from '@material-ui/core/Menu';
import Drawer from '@material-ui/core/Drawer';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import HomeIcon from '@material-ui/icons/Home';
import InboxIcon from '@material-ui/icons/Inbox';
import DraftsIcon from '@material-ui/icons/Drafts';
import Divider from '@material-ui/core/Divider';
import Assignment from '@material-ui/icons/Assignment';
import Home from '@material-ui/icons/Home';

// Css
import '../styles/layout/MenuAppBar.css';

class MenuAppBar extends Component {
  constructor() {
    super();
    this.state = {
      anchorEl: null,
      drawer: false
    }
  }

  handleMenu = event => {
    this.setState({ anchorEl: event.currentTarget });
  };

  handleClose = () => {
    this.setState({ anchorEl: null });
  };

  toggleDrawer = () => {
    this.setState({ drawer: !this.state.drawer });
  }

  render() {
    const { auth, anchorEl } = this.state;
    const open = Boolean(anchorEl);

    return (
      <div className="root">
        <AppBar position="static">
          <Toolbar>
            <IconButton className="menuButton" color="inherit" aria-label="Menu" onClick={this.toggleDrawer}>
              <MenuIcon />
            </IconButton>

            <Drawer open={this.state.drawer} onClose={this.toggleDrawer}>
              <List component="nav" className="list">
              <Link to="/">
                  <ListItem button>
                    <ListItemIcon>
                      <HomeIcon />
                    </ListItemIcon>
                    <ListItemText primary="Página Principal" />
                  </ListItem>
                </Link>
                
                <Link to="/Estudiante">
                  <ListItem button>
                    <ListItemIcon>
                      <InboxIcon />
                    </ListItemIcon>
                    <ListItemText primary="Estudiante" />
                  </ListItem>
                </Link>
                <Link to="/Profesor">
                  <ListItem button>
                    <ListItemIcon>
                      <DraftsIcon />
                    </ListItemIcon>
                    <ListItemText primary="Profesores" />
                  </ListItem>
                </Link>
              </List>
            </Drawer>

            <Typography variant="title" color="inherit" className="flex">
              Mingeso App
            </Typography>
            
            <div>
              <IconButton
                aria-owns={open ? 'menu-appbar' : null}
                aria-haspopup="true"
                onClick={this.handleMenu}
                color="inherit"
              >
                <AccountCircle />
              </IconButton>
              <Menu
                id="menu-appbar"
                anchorEl={anchorEl}
                anchorOrigin={{
                  vertical: 'top',
                  horizontal: 'right',
                }}
                transformOrigin={{
                  vertical: 'top',
                  horizontal: 'right',
                }}
                open={open}
                onClose={this.handleClose}
              >
                <MenuItem onClick={this.handleClose}>Profile</MenuItem>
                <MenuItem onClick={this.handleClose}>My account</MenuItem>
                <MenuItem onClick={this.handleClose}>Log out</MenuItem>
              </Menu>
            </div>
          </Toolbar>
        </AppBar>
      </div>
    );
  }
}

export default MenuAppBar;