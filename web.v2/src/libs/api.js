import axios from 'axios'

const BASE_URL = process.env.REACT_APP_API_BASE_URL

const base_url_items = BASE_URL + "/items"

export async function GetTodoItems (){
    let result
    await axios.get(base_url_items).then((res)=>{
        result = res.data
        console.log('api get',result)
    })
    return result
}

export async function UpdateTodoItem (item){
    console.log('update',item)
    await axios.put(base_url_items+"/"+item.id,item)
    .then(res=>{
        return res
    })
}

export async function AddTodoItem (itemName){
    const newItem = {name:itemName,status:"todo"}
    console.log('post',newItem)
    await axios.post(base_url_items,newItem)
    .then(res=>{
        return res
    })
}