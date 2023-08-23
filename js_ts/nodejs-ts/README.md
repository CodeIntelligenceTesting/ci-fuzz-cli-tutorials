# NodeJS demo application

## Functionality

It is simple nodeJS express TODO application, which has several functionalities, such as, adding, 
deleting single TODOs, and listing TODOs. Additional functionality includes, deleting the whole TODO list json file and command execution on the server. The application creates a `todo.json` file in the root folder of the application as a database to save all added TODOs.

Available endpoints: 
    
`/api/add?todo=&deadline=`
    
`/api/delete?id=`

`/api/list`

`/api/deleteList`

`/api/server?command=`