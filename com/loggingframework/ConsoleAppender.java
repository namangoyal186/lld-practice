package com.loggingframework;

public class ConsoleAppender implements LogAppender{
    @Override
    public void append(LogMessage logMessage) {
        if(logMessage.getLevel()==LogLevel.ERROR){
            System.err.println(logMessage.getFormattedMessage());
        }
        else{
            System.out.println(logMessage.getFormattedMessage());
        }
    }
}
