package com.loggingframework;

public class Main {
    public static void main(String[] args){
        Logger logger = Logger.getInstance();
        logger.setLevel(LogLevel.DEBUG);
        logger.addAppender(new FileAppender("application.log"));

        logger.debug("This is a detailed DEBUG message for troubleshooting.");
        logger.info("Application initialized successfully on port 8080.");
        logger.warn("Database connection pool utilization reached 85%.");
        logger.error("Unhandled exception occurred while processing payment transaction.");
    }
}
