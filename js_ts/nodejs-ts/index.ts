import express, {Request, Response} from 'express';

import {TODO, addEntry, listFile, deleteFile, deleteEntry, commandExecution} from './utils';

const app = express();

app.get('/', (req: Request, res: Response) => {
    res.send("Hello, user!");
});

app.post('/api/add', (req: Request, res: Response) => {
    const todo = req.query.todo;
    const deadline = req.query.deadline;

    const data_to_write: TODO = new TODO(0, todo, deadline);
    const status: boolean = addEntry(data_to_write);

    if (status) {
        res.status(201)
        res.send("Added successfully!\n");
    }
    res.status(400)
    res.send("You are doing something wrong!\n");

});

app.get('/api/list', (req: Request, res: Response) => {

    const todos = listFile();
    res.status(200)
    if (todos !== null && todos.length > 0) {
        res.send("Here is the todos:\n" + todos);
    }
    res.send("There is nothing to list!\n")
});

app.post('/api/delete', (req: Request, res: Response) => {
    const id: string = req.query.id;
    res.status(200)
    if (deleteEntry(id)) {
        res.send("TODO is deleted successfully!\n");
    }
    res.send("You should enter valid id...\n")

});


app.get('/api/deleteList', (req: Request, res: Response) => {
    res.status(200)
    if (deleteFile()) {
        res.send("The database is deleted!\n")
    }
    res.send("There is not a database to delete...\n");

});


app.get("/api/server", (req: Request, res: Response) => {
    console.log(req.query)
    const command: string = req.query.command;
    commandExecution(command, (data) => {
        res.status(200);
        res.send(data);
    });

});

app.listen(3000, () => {
    console.log("Listening to the port 3000");
});

