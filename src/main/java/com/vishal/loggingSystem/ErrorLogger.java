package com.vishal.loggingSystem;

public class ErrorLogger extends Logger {
    public ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(LogLevel logLevel, String msg) {
        if (logLevel == LogLevel.ERROR) {
            System.out.println("ERROR : " + msg);
        } else {
            super.log(logLevel, msg);
        }
    }
}
