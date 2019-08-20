import React,{Component} from 'react'
import TodoItem from './TodoItem'
import {GetTodoItems,AddTodoItem} from '../libs/api'
import {Button,Input,Row,Col,Divider, message} from 'antd'
var _ = require('lodash/core');

class TodoList extends Component {
    constructor(props){
        super(props);
        this.state = {
            todoItems : [],
            newItem:""
        }
    }

    getTodoItems(){
        GetTodoItems().then((res)=>{
            this.setState({
                todoItems:res,
            })
        })
    }

    componentDidMount(){
        // console.log("load data from api")
        this.getTodoItems();
    }
    
    handleGetTodoItems=()=>{
        this.getTodoItems();
    }
    handleAddTodoItemInput = (e) =>{
        // console.log(e.target.value)
        this.setState({
            newItem : e.target.value
        })
    }
    handleAddTodoItem = () =>{
        const unDoneItems = _.filter(this.state.todoItems,function(item){return item.status!=="done"})
        console.log('unDoneItems',unDoneItems)
        if (unDoneItems.length>10){
            console.log('current undoItems',_.filter(this.state.todoItems,function(item){return item.status!=="done"}))
            message.error("Life is short, too many to overwhelm!",5)
        }
        else {
            const newItem = this.state.newItem
            this.setState({
                newItem:""
            })
            console.log("add a new item:", newItem)
            AddTodoItem(newItem).then((res)=>{
                this.getTodoItems();
            })
        }
    }

    render(){
        if(this.state.todoItems === []) {return ""}
        
        return (
            <div>
                <Row style={{marginTop:"5%"}}>
                    <Col span={2}></Col>
                    <Col span={16}>
                        <Input placeholder={"New Item: "+window.innerWidth} onChange={this.handleAddTodoItemInput} value={this.state.newItem}></Input>
                    </Col>
                    <Col span={6} style={{"display":"inline-flex"}}>
                        <Button type="primary" shape="circle" onClick={this.handleAddTodoItem} disabled={this.state.newItem===""}>+</Button>
                    </Col>
                </Row>
                <Row style={{marginTop:"5%"}}>
                    { 
                        this.state.todoItems.map((item,index)=>{
                        return (
                            <TodoItem key={index} item={item} handleGetTodoItems={this.handleGetTodoItems}/>
                        )
                    })}
                </Row>                
            </div>
        )
    }
}

export default TodoList