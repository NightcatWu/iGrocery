import React, {Component} from 'react'
import {Row,Col,Switch,Input,Button} from 'antd'
import {UpdateTodoItem} from '../libs/api'
import {todoItemStatus} from '../constants/enums'

const maxEditingCountdown = 20

class TodoItem extends Component {
    constructor(props){
        super(props);
        this.state={
            item:this.props.item,
            isEditing:false,
            editingCountdown : maxEditingCountdown
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
            isEditing:true
        })
  
        var counter = this.state.editingCountdown-1;
        var i = setInterval(function(){
            // console.log(this.state.editingCountdown)
            this.setState({
                editingCountdown: counter
            })
        
            counter--;

            if (!this.state.isEditing) {
                this.setState({
                    isEditing:false,
                    editingCountdown:maxEditingCountdown
                })
                clearInterval(i);
            }
            else {
                if(counter === 0) {
                    this.handleEditItemNameDone()
                    clearInterval(i);
                }
            }
        }.bind(this), 1000);

    }

    handleEditItemNameDone = () =>{
        this.updateTodoItem(this.state.item)
        this.setState({
            isEditing:false,
            editingCountdown:maxEditingCountdown
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
        console.log(item)
        if (item.status===todoItemStatus.done)
        {
            //if the item is done: showing line-through and cannot edit
            itemNameDOM = 
                <div 
                    style={{"textAlign":"left","textDecoration":"line-through"}}
                >{item.name}</div>
        }
        else {

            if(this.state.isEditing){
                const currentEditingCountdownRate = (maxEditingCountdown-this.state.editingCountdown+1)*(100/maxEditingCountdown)+"%"
                // console.log(currentEditingCountdownRate)
                itemNameDOM = 
                <div>
                    <Col>
                        <Input 
                        value={item.name} 
                        onChange={this.handleEditItemNameInput} 
                        allowClear 
                        onPressEnter={this.handleEditItemNameDone}
                        addonAfter={
                            <Button 
                                size="small" 
                                onClick={this.handleEditItemNameDone}
                                style={{
                                    backgroundImage:"linear-gradient(to right, LightBlue "+currentEditingCountdownRate+", white "+currentEditingCountdownRate+")",
                                }}
                            >
                                OK<span style={{fontSize:"7px"}}>{this.state.editingCountdown<10?"0":""}{this.state.editingCountdown}</span>
                            </Button>
                            }
                        >
                        </Input>
                    </Col>
                </div>
            }
            else {
                itemNameDOM = 
                    <div onClick={this.handleEditItemName}
                        style={{"textAlign":"left","textDecoration":"none"}}
                    >{item.name}</div>
            }


        }
        // console.log(item)
        return (
            <Row type="flex" align="top" style={{"marginTop":"5px"}}>
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