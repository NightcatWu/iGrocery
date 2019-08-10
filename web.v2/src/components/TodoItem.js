import React, {Component} from 'react'

class TodoItem extends Component {
    constructor(props){
        super(props);
    }

    render(){
        return (
            <div>{this.props.item}</div>
        )
    }
}

export default TodoItem