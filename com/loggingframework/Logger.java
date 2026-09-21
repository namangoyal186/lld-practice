package com.loggingframework;
import java.util.*;

public class Logger {
    private static Logger loggerInstance;
    private LogLevel currentLevel = LogLevel.INFO;
    private List<LogAppender> appenders = new ArrayList<>();

    private Logger(){
        appenders.add(new ConsoleAppender());
    }

    public static synchronized Logger getInstance(){
        if(loggerInstance==null){
            synchronized (Logger.class){
                if(loggerInstance==null){
                    loggerInstance=new Logger();
                }
            }
        }
        return loggerInstance;
    }

    public void setLevel(LogLevel level){
        this.currentLevel=level;
    }

    public void addAppender(LogAppender appender){
        synchronized (appenders){
            appenders.add(appender);
        }
    }

    //Core Dispatch Method
    public void log(LogLevel logLevel, String message){
        if(logLevel.greaterThanOrEqual(currentLevel)){
            LogMessage logMessage = new LogMessage(logLevel,message);
            synchronized (appenders){
                for(LogAppender appender:appenders){
                    appender.append(logMessage);
                }
            }
        }
    }

    public void debug(String message){
        log(LogLevel.DEBUG,message);
    }

    public void info(String message){
        log(LogLevel.INFO,message);
    }

    public void warn(String message){
        log(LogLevel.WARN,message);
    }

    public void error(String message){
        log(LogLevel.ERROR,message);
    }
}
