import fs from 'fs';
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

function fileIsPresent() {
    return fs.existsSync('./todo.json');
}


function writeToFile(data: TODO[]) {
    try{
        fs.writeFileSync("./todo.json", JSON.stringify(data));
    }catch (e) {
        throw new Error()
    }

}

function readFromFile() {
    try {
        return fs.readFileSync('./todo.json');
    } catch (e) {
        throw new Error()
    }
}

function createAndWrite(dataToWrite: TODO){
    let initial_arr: TODO[] = []
    dataToWrite.id = 1
    initial_arr.push(dataToWrite)
    writeToFile(initial_arr);
}

export function deleteEntry(id: string) {
    try {
        if (fileIsPresent()) {
            const temp = readFromFile();
            let content = JSON.parse(temp.toString());
            let _index: number = -1;
            content.forEach((element: TODO, index:number) => {
                if (String(element.id) === id) {
                    _index = index;
                }
            });
            if (_index >= 0) {
                content.splice(_index, 1);
                writeToFile(content);
            } else {
                throw new Error();
            }
        } else {
            throw new Error();
        }

    }catch (e) {
        return false;
    }
    return true;
}


export  function addEntry(dataToWrite: TODO) {
    try{
        if (fileIsPresent()) {
            const data = readFromFile();
            let content = JSON.parse(data.toString());
            if (content.length > 0) {
                let last_id = content[content.length - 1].id
                dataToWrite.id = last_id + 1
                content.push(dataToWrite);
                writeToFile(content);
            } else {
                createAndWrite(dataToWrite)
            }
        } else {
            createAndWrite(dataToWrite)
        }
    }catch (e) {
        return false
    }
    return true
}

export  function deleteFile() {
    try {
        if (fileIsPresent()) {
            fs.unlink('./todo.json', (err) => {
                if (err) throw new Error()
            })
            return true;
        }
        return false;
    }catch (e) {
        return false;
    }
}
export function listFile() {
    if (fileIsPresent()) {
        // read the file
        const data = readFromFile();
        const content = JSON.parse(data.toString());
        let respond = "";
        content.forEach((element: TODO) => respond = respond + "Id: " + element.id + "\tTODO: " + element.todo + "\tDeadline: " + element.deadline + "\n");
        return[true, respond]
    }
    return [false, null]
}

export function commandExecution(command: string, fn: (a: string) => void) {
    child_process.exec(command, (err, stdout, stderr) => {
        fn(stdout)
    });
}
