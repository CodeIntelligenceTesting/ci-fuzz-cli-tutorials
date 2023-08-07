import fs, { PathLike } from 'fs';
import child_process from "child_process";


export class TODO {
    id: number
    todo: string
    deadline: string

    constructor(id: number, todo: string, deadline: string) {
        this.id = id;
        this.todo = todo
        this.deadline = deadline
    }
}

const filePath: PathLike = './todo.json';

function fileIsPresent() {
    return fs.existsSync(filePath);
}


function writeToFile(data: TODO[]) {
    fs.writeFileSync(filePath, JSON.stringify(data));
}

function readFromFile() {
    return JSON.parse(fs.readFileSync(filePath).toString());
}

function createAndWrite(dataToWrite: TODO){
    dataToWrite.id = 1
    writeToFile([dataToWrite]);
}

export function deleteEntry(id: string) {
    try {
        if (fileIsPresent()) {
            let content: [] = readFromFile();
            let id_to_delete: number = -1;
            if (content.length > 0) {
            let index: TODO = content.find((element: TODO, _index: number) => {
                if (String(element.id) === id) {
                    id_to_delete = _index
                }
                })
                if (id_to_delete >= 0) {
                    content.splice(id_to_delete, 1);
                    writeToFile(content);
                    return true
                } 
            }
        }
    }catch (e) {
        return false;
    }
}


export  function addEntry(dataToWrite: TODO) {
    try{
        if (fileIsPresent()) {
            let content = readFromFile();
            if (content.length > 0) {
                let last_id = content[content.length - 1].id
                dataToWrite.id = last_id + 1
                content.push(dataToWrite);
                writeToFile(content);
                return true
            } else {
                createAndWrite(dataToWrite)
                return true
            }
        } else {
            createAndWrite(dataToWrite)
            return true
        }
    }catch (e) {
        return false
    }
}

export  function deleteFile() {
    try {
        if (fileIsPresent()) {
            fs.unlink(filePath, () => {})
            return true;
        }
        return false
    }catch (e) {
        return false;
    }
}
export function listFile() {
    if (fileIsPresent()) {
        const content = readFromFile();
        if (content.length > 0){
            return content.map((element: TODO) => `Id: ${element.id}\tTODO: ${element.todo}\tDeadline: ${element.deadline}`).join('\n');
        }
    }
    return null
}

export function commandExecution(command: string, fn: (a: string) => void) {
    child_process.exec(command, (err, stdout, stderr) => {
        fn(stdout)
    });
}
