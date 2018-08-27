import React, {Component} from 'react';

//Material
import {Table, TableHead, TableBody, TableRow, TableCell} from '@material-ui/core';
import '../../styles/containers/Student/ExercisesTable.css';

class ExercisesTable extends Component {
    constructor(props) {
        super(props);
        this.state = {
            type: ''
        }
    }

    componentDidMount() {

    };

    render() {
        // let content;

        // if(type === 'Java') {

        // } else if (type === 'C') {

        // } else {

        // }

        return(
            <div className="table">
                {console.log(this.props.type)}
                <Table>
                    <TableHead className="table-head">
                        <TableRow className="table-head-row">
                            <TableCell className="table-head-cell">Título</TableCell>
                            <TableCell className="table-head-cell">Tipo</TableCell>
                            <TableCell className="table-head-cell">Fecha</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody className="table-body">
                        <TableRow>
                            <TableCell>titulo 1</TableCell>
                            <TableCell>java</TableCell>
                            <TableCell>16 jun 2018</TableCell>
                        </TableRow>

                        <TableRow>
                            <TableCell>titulo 1</TableCell>
                            <TableCell>java</TableCell>
                            <TableCell>16 jun 2018</TableCell>
                        </TableRow>

                        <TableRow>
                            <TableCell>titulo 1</TableCell>
                            <TableCell>java</TableCell>
                            <TableCell>16 jun 2018</TableCell>
                        </TableRow>
                    </TableBody>
                </Table>
            </div>
        );
    }
}

export default ExercisesTable;