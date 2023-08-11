package com.vishal.loggingSystem;

public class InfoLogger extends Logger {
    public InfoLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void log(LogLevel logLevel, String msg) {
        if (logLevel == LogLevel.INFO) {
            System.out.println("INFO : " + msg);
        } else {
            super.log(logLevel, msg);
        }
    }
}
