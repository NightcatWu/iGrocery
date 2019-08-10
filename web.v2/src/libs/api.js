import axios from 'axios'

const BASE_URL = "http://192.168.1.230:6101"

export function GetTodoItems (){
    const url = BASE_URL+"/items"
    axios.get(url)
    .then(res=>{
        const result = ["item-a","item-b","item-c"]
        console.log('then',result)
        return result
    })
    .catch(error=>{
        const result = ["item-a","item-b","item-c"]
        console.log('error',result)
        return result
    })

}