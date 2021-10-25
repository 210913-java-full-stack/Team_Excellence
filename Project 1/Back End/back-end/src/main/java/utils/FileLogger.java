package utils;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {

    private static FileLogger fileLogger;

    public static FileLogger getFileLogger(){
        if(fileLogger == null){
            fileLogger = new FileLogger();
            File file = new File("C:/Revature/Training/Repos/Team_Excellence/logs/" + getLogFileName());
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

    private static String getLogFileName() {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return today + ".log";
    }

    private  String formatLogEntry(String message){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String stackInfo = stackTraceElements[3].toString();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return String.format("%s [%s] %s", timestamp, stackInfo, message);
    }
}
