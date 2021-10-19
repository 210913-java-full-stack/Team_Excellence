package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {

    private static FileLogger fileLogger;
    private static boolean printToConsole;
    private static boolean printToConsoleTemp;

    private FileLogger() {
        printToConsole = false;
    }
    public static FileLogger getFileLogger(){
        if(fileLogger == null){
            fileLogger = new FileLogger();
        }
        return fileLogger;
    }

    public void writeLog(String message, String level) {
        try(FileWriter fileWriter = new FileWriter(getLogFileName(), true)){
            String logEntry = formatLogEntry(message);
            //TODO: Write logic for different levels of logging?

            fileWriter.write((logEntry));

            if(printToConsole || printToConsoleTemp){
                System.out.println(logEntry);
                printToConsoleTemp = false;
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private String getLogFileName() {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return today + ".log";
    }

    private  String formatLogEntry(String message){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String stackInfo = stackTraceElements[3].toString();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return String.format("%s [%s] %s", timestamp, stackInfo, message);
    }

    public static boolean isPrintToConsole(){
        return printToConsole;
    }

    public static void setPrintToConsole(boolean printToConsole) {
        FileLogger.printToConsole = printToConsole;
    }

    public FileLogger console() {
        printToConsoleTemp = true;
        return fileLogger;
    }
}
