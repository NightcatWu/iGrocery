import axios from 'axios'

const BASE_URL = "http://192.168.1.230:6101"

let mock_items = 
[
    {id:1,name:"item-a",status:"todo"},
    {id:2,name:"item-b",status:"todo"},
    {id:3,name:"item-c",status:"done"},
]

export function GetTodoItems (){
    const url = BASE_URL+"/items"
    const result = Promise.resolve(mock_items)
    return result

    axios.get(url)
    .then(res=>{
  
    })
}

export function UpdateTodoItem (item){
    const url = BASE_URL+"/items"

    const index = mock_items.findIndex(item=>item.id === item.id)
    const result = Promise.resolve(mock_items[index] = item)
    return result

    axios.put(url,item)
    .then(res=>{
  
    })
}

export function AddTodoItem (itemName){
    const url = BASE_URL+"/items"
    const item = {id:mock_items.length+1,name:itemName,status:"todo"}
    const result = Promise.resolve(mock_items.push(item))
    return result

    axios.post(url,itemName)
    .then(res=>{
  
    })
}