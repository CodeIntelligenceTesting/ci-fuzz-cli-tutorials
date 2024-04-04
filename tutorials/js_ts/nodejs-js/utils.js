const fs = require('fs')
const child_process = require('child_process')

class TODO {
    constructor(id, todo, deadline) {
        this.id = id;
        this.todo = todo
        this.deadline = deadline
    }
}

const filePath = './todo.json'

function fileIsPresent() {
    return fs.existsSync(filePath);
}


function writeToFile(data) {
    fs.writeFileSync(filePath, JSON.stringify(data));
}

function readFromFile() {
    return JSON.parse(fs.readFileSync(filePath).toString());
}

function createAndWrite(dataToWrite){
    dataToWrite.id = 1
    writeToFile([dataToWrite]);
}

function deleteEntry(id) {
    try {
        if (fileIsPresent()) {
            let content = readFromFile();
            let id_to_delete = -1
            if (content.length > 0) {
                let index = content.find((element, _index) => {
                    if (String(element.id) === id) {
                        id_to_delete = _index
                    }
                })
                if (id_to_delete >= 0) {
                    content.splice(id_to_delete, 1);
                    console.log(content)
                    writeToFile(content);
                    return true
                }
            }else {
                return false
            }
        }
    }catch (e) {
        return false;
    }
}


function addEntry(dataToWrite) {
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

function deleteFile() {
    try {
        if (fileIsPresent()) {
            fs.unlink(filePath, ()=>{});
            return true;
        }
        return false
    }catch (e) {
        return false;
    }
}
function listFile() {
    if (fileIsPresent()) {
        const content = readFromFile();
        if (content){
            return content.map(element => `Id: ${element.id}\tTODO: ${element.todo}\tDeadline: ${element.deadline}`).join('\n');
        }
    }
    return null
}

function commandExecution(command, fn) {
    child_process.exec(command, (err, stdout, stderr) => {
        fn(stdout)
    });
}

module.exports = {TODO, commandExecution, addEntry, deleteEntry, deleteFile, listFile}