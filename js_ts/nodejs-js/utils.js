const fs = require('fs')
const child_process = require('child_process')

class TODO {
    id
    todo
    deadline

    constructor(id, todo, deadline) {
        this.id = id;
        this.todo = todo
        this.deadline = deadline
    }
}

function fileIsPresent() {
    return fs.existsSync('./todo.json');
}


function writeToFile(data) {
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

function createAndWrite(dataToWrite){
    let initial_arr = []
    dataToWrite.id = 1
    initial_arr.push(dataToWrite)
    writeToFile(initial_arr);
}

function deleteEntry(id) {
    try {
        if (fileIsPresent()) {
            const temp = readFromFile();
            let content = JSON.parse(temp.toString());
            let _index = -1;
            content.forEach((element, index) => {
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


function addEntry(dataToWrite) {
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

function deleteFile() {
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
function listFile() {
    if (fileIsPresent()) {
        // read the file
        const data = readFromFile();
        const content = JSON.parse(data.toString());
        let respond = "";
        content.forEach((element) => respond = respond + "Id: " + element.id + "\tTODO: " + element.todo + "\tDeadline: " + element.deadline + "\n");
        return[true, respond]
    }
    return [false, null]
}

function commandExecution(command, fn) {
    child_process.exec(command, (err, stdout, stderr) => {
        fn(stdout)
    });
}

module.exports = {TODO, commandExecution, addEntry, deleteEntry, deleteFile, listFile}