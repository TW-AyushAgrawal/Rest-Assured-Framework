package Utils;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FileHandler {


    public static PrintStream getLogFile() throws FileNotFoundException {
        return new PrintStream(System.getProperty("user.dir") + "/log.txt");
    }
}
