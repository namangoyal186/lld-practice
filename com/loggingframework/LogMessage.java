package com.loggingframework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogMessage {
    private LocalDateTime timestamp;
    private LogLevel level;
    private String message;
    private String threadName;

    public LogMessage(LogLevel level, String message) {
        this.timestamp = LocalDateTime.now();
        this.level = level;
        this.message = message;
        this.threadName = Thread.currentThread().getName();
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getFormattedMessage(){
        String time = timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        return String.format("[%s] [%s] [%s] - %s", time, threadName, level, message);
    }
}
