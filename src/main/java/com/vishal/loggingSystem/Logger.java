package com.vishal.loggingSystem;

public abstract class Logger {
    protected Logger nextLogger;

    public Logger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(LogLevel logLevel, String msg) {
        if (nextLogger != null) {
            nextLogger.log(logLevel, msg);
        } else {
            System.out.println("Invalid logging request !!");
        }
    }
}
