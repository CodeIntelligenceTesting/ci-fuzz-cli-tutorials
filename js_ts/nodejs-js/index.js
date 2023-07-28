const express = require('express')

const {TODO, addEntry, listFile, deleteFile, deleteEntry, commandExecution} =  require('./utils');

const app = express();

app.get('/', (req, res) => {
    res.send("Hello, user!");
});

app.post('/api/add', (req, res) => {
    const todo = req.query.todo;
    const deadline = req.query.deadline;

    const data_to_write = new TODO(0, todo, deadline);
    const status = addEntry(data_to_write);

    if (status) {
        res.status(201)
        res.send("Added successfully!");
    }
    res.status(400)
    res.send("You are doing something wrong!");

});

app.get('/api/list', (req, res) => {

    const todos = listFile();
    res.status(200)
    if (todos[0]) {
        res.send("Here is the todos:\n" + todos[1]);
    }
    res.send("You are doing something wrong!")
});

app.post('/api/delete', (req, res) => {
    const id = req.query.id;
    res.status(200)
    if (deleteEntry(id)) {
        res.send("TODO is deleted successfully!");
    }
    res.send("You are doing something wrong!")

});


app.get('/api/deleteList', (req, res) => {
    res.status(200)
    if (deleteFile()) {
        res.send("The database is deleted!")
    }
    res.send("You are doing something wrong!");

});


app.get("/api/server", (req, res) => {
    console.log(req.query)
    const command = req.query.command;
    commandExecution(command, (data) => {
        res.status(200);
        res.send(data);
    });

});

app.listen(3000, () => {
    console.log("Listening to the port 3000");
});

