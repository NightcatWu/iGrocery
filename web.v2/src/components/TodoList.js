import React,{Component} from 'react'
import TodoItem from './TodoItem'
import {GetTodoItems} from '../libs/api'
import {Button,Input,Row,Col} from 'antd'
class TodoList extends Component {
    constructor(props){
        super(props);
        this.state = {
            todoItems : []
        }
    }


    componentDidMount(){
        console.log("load data from api")
        // GetTodoItems().then((res)=>{
        //     console.log(res)
        //     this.setState({
        //         todoList:res,
        //         newItem:""
        //     })
        // })
            this.setState({
                todoItems:[{id:1,name:"item-a",status:"todo"},
                {id:2,name:"item-b",status:"todo"},
                {id:3,name:"item-c",status:"done"},
                ],
            })
        
    }
    handleAddTodoItemInput = (e) =>{
        console.log(e.target.value)
        this.setState({
            newItem : e.target.value
        })
    }
    handleAddTodoItem = () =>{
        console.log("add a new item:", this.state.newItem)
        const items = this.state.todoItems
        items.push(this.state.newItem)
        this.setState({
            todoItems:items,
            newItem:""
        })
    }

    render(){
        return (
            <div>
                <Row>
                    <Col span={4}></Col>
                    <Col span={10}><Input placeholder="New Item" onChange={this.handleAddTodoItemInput} value={this.state.newItem}></Input></Col>
                    <Col span={10} style={{"display":"inline-flex"}}><Button type="primary" shape="round" onClick={this.handleAddTodoItem}>+++</Button></Col>
                </Row>
                <Row>
                    {this.state.todoItems.map((item,index)=>{
                        return (
                            <TodoItem key={index} item={item} />
                        )
                    })}
                </Row>
            </div>
        )
    }
}

export default TodoList