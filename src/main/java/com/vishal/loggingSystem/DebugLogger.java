package com.vishal.loggingSystem;

public class DebugLogger extends Logger {
    public DebugLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(LogLevel logLevel, String msg) {
        if (logLevel == LogLevel.DEBUG) {
            System.out.println("DEBUG : " + msg);
        } else {
            super.log(logLevel, msg);
        }
    }
}
