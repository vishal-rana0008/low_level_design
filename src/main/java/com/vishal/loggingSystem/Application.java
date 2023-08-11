package com.vishal.loggingSystem;

public class Application {
    public static void main(String[] args) {
        Logger logger = new InfoLogger(new DebugLogger(new ErrorLogger(null)));

        logger.log(LogLevel.DEBUG, "This is a debug msg");
        logger.log(LogLevel.ERROR, "This is an error msg");
    }
}
