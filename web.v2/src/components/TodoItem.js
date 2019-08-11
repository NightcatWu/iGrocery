import React, {Component} from 'react'
import {Row,Col,Switch,Input} from 'antd'
import {UpdateTodoItem} from '../libs/api'

class TodoItem extends Component {
    constructor(props){
        super(props);
        this.state={
            item:this.props.item,
            editable : false
        }
    }

    handleSwitchChange = (checked)=>{
        // console.log(checked)
        let item = this.state.item
        item.status = checked?"done":"todo"
        UpdateTodoItem(item).then(res=>{
            this.setState({
                item:item
            })
        })
    }

    handleEditItemName = () =>{
        this.setState({
            editable:true
        })
    }

    handleEditItemNameDone = () =>{
        UpdateTodoItem(this.state.item)
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
            itemNameDOM = 

            <div onClick={this.handleEditItemName}>{item.name}</div>
        }
        // console.log(item)
        return (
            <Row type="flex" align="middle">
                <Col span={4}>
                    
                </Col>
                <Col span={4}>
                    <Switch 
                        onChange={this.handleSwitchChange}
                        checked={item.status==="done"?true:false}
                    />
                    
                </Col>
                <Col span={10} style={{"display":"inline-flex","fontSize":"22px"}}>
                    {itemNameDOM}
                </Col>
            </Row>
            
        )
    }
}

export default TodoItem