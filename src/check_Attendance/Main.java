package check_Attendance;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        CheckFile file = new CheckFile();
        try {
            file.checkAttendanceFile();
        } catch (IOException ex) {
            System.out.println("File not Found");
        }
    }
}