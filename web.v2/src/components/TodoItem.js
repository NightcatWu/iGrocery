import React, {Component} from 'react'
import {Row,Col,Switch,Input} from 'antd'
import {UpdateTodoItem} from '../libs/api'
import {todoItemStatus} from '../constants/enums'

class TodoItem extends Component {
    constructor(props){
        super(props);
        this.state={
            item:this.props.item,
            editable : false
        }
    }

    async updateTodoItem(item){
        await UpdateTodoItem(item).then(res=>{
            this.setState({
                item:item
            })
        })
    }
    handleSwitchChange = (checked)=>{
        //first make sure exit item editor
        this.handleEditItemNameDone()

        let item = this.state.item
        item.status = checked?todoItemStatus.done:todoItemStatus.todo
        this.updateTodoItem(item)

        this.props.handleGetTodoItems()

    }

    handleEditItemName = () =>{
        this.setState({
            editable:true
        })
    }

    handleEditItemNameDone = () =>{
        this.updateTodoItem(this.state.item)
        this.setState({
            editable:false
        })
    }    
    handleEditItemNameInput = (e) =>{
        let item = this.state.item
        item.name = e.target.value
        this.setState({
            item:item
        })
    }
    render(){
        const {item} = this.state

        let itemNameDOM

        if (this.state.editable)
        {
            itemNameDOM = 
                <div>
                    <Col>
                        <Input value={item.name} onChange={this.handleEditItemNameInput} onMouseLeave={this.handleEditItemNameDone} onPressEnter={this.handleEditItemNameDone}></Input>
                    </Col>
                </div>
        }
        else {
            const isDone = item.status===todoItemStatus.done?"line-through":"none"
            itemNameDOM = 
                <div onClick={this.handleEditItemName}
                    style={{"textAlign":"left","textDecoration":isDone}}
                >{item.name}</div>
        }
        // console.log(item)
        return (
            <Row type="flex" align="top" style={{"marginTop":"5px"}}>
                <Col span={2}>
                </Col>
                <Col span={4}>
                    <Switch 
                        onChange={this.handleSwitchChange}
                        checked={item.status===todoItemStatus.done?true:false}
                    />
                    
                </Col>
                <Col span={18} style={{"fontSize":"18px"}}>
                    {itemNameDOM}
                </Col>
            </Row>
            
        )
    }
}

export default TodoItem