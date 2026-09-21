package com.loggingframework;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{
    private String filePath;

    public FileAppender(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public synchronized void append(LogMessage logMessage) {
        try(FileWriter writer = new FileWriter(filePath,true)){
            writer.write(logMessage.getFormattedMessage() + "\n");
        }
        catch(IOException e){
            System.out.println("Failed to write log to file " + filePath);
        }
    }
}
