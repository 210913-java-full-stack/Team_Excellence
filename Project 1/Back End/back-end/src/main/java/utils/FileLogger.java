package utils;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {

    private static FileLogger fileLogger;

    //Gets the file logger and sets up the file path
    public static FileLogger getFileLogger(){
        if(fileLogger == null){
            fileLogger = new FileLogger();
            File file = new File("Team_Excellence/Project 1/Back End/logs/"
                    + getLogFileName());
            OutputStream outputStream;
            try {
                outputStream = new FileOutputStream(file);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileLogger;
    }

    //Adds the exception data to the log file
    public void writeLog(int level) {

        try(FileWriter fileWriter = new FileWriter(getLogFileName(), true)){

            String logEntry;
            if(level == 1) {
                logEntry = formatLogEntry("Info: ");
                fileWriter.write(logEntry);
            } else if(level == 2){
                logEntry = formatLogEntry("Warn: ");
            } else if(level == 3){
                logEntry = formatLogEntry("Moderate: ");
            } else if(level == 4){
                logEntry = formatLogEntry("Severe: ");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //Gets the log file name
    private static String getLogFileName() {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return today + ".log";
    }

    //Formats the entries that are saved to the log file
    private  String formatLogEntry(String message){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String stackInfo = stackTraceElements[3].toString();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return String.format("%s [%s] %s", timestamp, stackInfo, message);
    }
}
