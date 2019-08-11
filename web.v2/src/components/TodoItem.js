import React, {Component} from 'react'
import {Button,Input,Row,Col,Switch} from 'antd'
import Item from 'antd/lib/list/Item';

class TodoItem extends Component {
    constructor(props){
        super(props);
        this.state={
            item:this.props.item
        }
    }

    handleSwitchChange (checked){
        console.log(checked)
        console.log("put [item] to api")
    }

    render(){
        const {item} = this.state
        console.log(item)
        return (
            <Row type="flex" align="middle">
                <Col span={4}>
                    
                </Col>
                <Col span={4}>
                    <Switch 
                        onChange={this.handleSwitchChange}
                        checked={item.status=="done"?true:false}
                    />
                    
                </Col>
                <Col span={16} style={{"display":"inline-flex","fontSize":"22px"}}>
                    <div>{item.name}</div>
                </Col>
            </Row>
            
        )
    }
}

export default TodoItem