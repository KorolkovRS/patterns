package behavioral.command;

import java.util.ArrayList;
import java.util.List;

interface TextFileOperation {
    void execute();
}

class OpenTextFileOperation implements TextFileOperation {
    private TextFile textFile;

    public OpenTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public void execute() {
        textFile.open();
    }
}

class SaveTextFileOperation implements TextFileOperation {
    private TextFile textFile;

    public SaveTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public void execute() {
        textFile.save();
    }
}

class TextFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println("Open file: " + name);
    }

    public void save() {
        System.out.println("Save file: " + name);
    }
}

class TextFileOperationExecutor {
    private List<TextFileOperation> textFileOperationList = new ArrayList<>();

    public void executeOperation(TextFileOperation textFileOperation) {
        textFileOperationList.add(textFileOperation);
        textFileOperation.execute();
    }

    public void repeatLastCommand() {
        textFileOperationList.get(textFileOperationList.size() - 1).execute();
    }
}

class Solution {
    public static void main(String[] args) {
        TextFile textFile1 = new TextFile("File1.txt");
        TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
        textFileOperationExecutor.executeOperation(new OpenTextFileOperation(textFile1));
        textFileOperationExecutor.executeOperation(new SaveTextFileOperation(textFile1));
        textFileOperationExecutor.executeOperation(new OpenTextFileOperation(textFile1));
        textFileOperationExecutor.repeatLastCommand();
    }
}


