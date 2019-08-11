import React,{Component} from 'react'
import TodoItem from './TodoItem'
import {GetTodoItems,AddTodoItem} from '../libs/api'
import {Button,Input,Row,Col,Divider} from 'antd'
class TodoList extends Component {
    constructor(props){
        super(props);
        this.state = {
            todoItems : []
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
        console.log("load data from api")
        this.getTodoItems();
    }
    
    handleAddTodoItemInput = (e) =>{
        // console.log(e.target.value)
        this.setState({
            newItem : e.target.value
        })
    }
    handleAddTodoItem = () =>{
        console.log("add a new item:", this.state.newItem)
        AddTodoItem(this.state.newItem).then((res)=>{
            this.getTodoItems();
            this.setState({
                newItem:""
            })
        })
    }

    render(){
        return (
            <div>
                <Divider></Divider>
                <Row>
                    <Col span={4}></Col>
                    <Col span={10}>
                        <Input placeholder={"New Item: example-"+window.innerWidth} onChange={this.handleAddTodoItemInput} value={this.state.newItem}></Input>
                    </Col>
                    <Col span={10} style={{"display":"inline-flex"}}>
                        <Button type="primary" shape="round" onClick={this.handleAddTodoItem}>+++</Button>
                    </Col>
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