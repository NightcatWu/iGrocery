import axios from 'axios'

const BASE_URL = "http://192.168.1.230:6101/api/"
//const BASE_URL = "http://localhost:4000/"

const base_url_items = BASE_URL + "items"

export async function GetTodoItems (){
    let result
    await axios.get(base_url_items).then((res)=>{
        result = res.data
        console.log('api get',result)
    })
    return result
}

export async function UpdateTodoItem (item){
    console.log('put',item)
    await axios.put(base_url_items+"/"+item.id,item)
    .then(res=>{
        return res
    })
}

export async function AddTodoItem (itemName){
    const newItem = {name:itemName,status:"todo"}
    // console.log('api add',newItem)
    await axios.post(base_url_items,newItem)
    .then(res=>{
        return res
    })
}