import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
/**
 * @Author Danylo Mirin
 * @Copyright 2018
 * @Date 4/3/18 (d/m/y)
 * @Version 1
 * @Purpose: to escape the need to write the same error codes everywhere
 */
public class ErrorLogger {
    private HashMap<Integer, String> codes;
    private ArrayList<String> text;
    private ArrayList<Exception> exceptions;
    public ErrorLogger() {
        text = new ArrayList<>();
        codes = new HashMap<>();
        codes.put(1,"Writing access denied");
        
    }
    
    public void log() {
        File log = new File("log.txt");
        try {
            log.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(log));
            while(!text.isEmpty())
                writer.write(text.remove(0));
            writer.flush();
            writer.close();
        } catch(FileNotFoundException ex) {
            //Should never run
            JOptionPane.showMessageDialog(new JFrame(), "log file not found, cannot write the log. Potential cause: read & write access denied");
        } catch(IOException ex) {
            //Implies lack of reading/writing access
            JOptionPane.showMessageDialog(new JFrame(), "Read & write access denied");
        }
        //Since this is a log and not a crucial step of the application, it is not necessary to autoexit
    }
    
    public static void addException(Exception e) {
        
    }
}