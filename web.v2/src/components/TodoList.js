import React,{Component} from 'react'
import TodoItem from './TodoItem'
import {GetTodoItems} from '../libs/api'
import {Button,Input} from 'antd'
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
                todoItems:["item-a","item-b","item-c"],
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
                <Input placeholder="New Item" onChange={this.handleAddTodoItemInput} value={this.state.newItem}></Input>
                <Button type="primary" onClick={this.handleAddTodoItem}>+++</Button>
                {this.state.todoItems.map((item,index)=>{
                    return (
                        <TodoItem key={index} item={item} />
                    )
                })}
            </div>
        )
    }
}

export default TodoList