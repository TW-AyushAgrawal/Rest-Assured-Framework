package Utils;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FileHandler {
    private static FileHandler fileHandler;

//    public static FileHandler getInstance() {
//        if (fileHandler == null)
//            fileHandler = new FileHandler();
//        return fileHandler;
//    }

    public PrintStream getLogFile() throws FileNotFoundException {
        return new PrintStream(System.getProperty("user.dir") + "/log.txt");
    }
}
