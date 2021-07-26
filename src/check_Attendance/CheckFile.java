package check_Attendance;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class CheckFile {
    public void checkAttendanceFile() throws IOException {
        File file = new File("D:\\Attendance\\a.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        PrintStream o = new PrintStream(new File("D:\\Attendance\\newList2.txt"));
        PrintStream console = System.out;
        System.setOut(o);
        TreeMap<Long, String> tmap = new TreeMap<>();
        TreeMap<Long, String> tmap2 = new TreeMap<>();

        for (long roll = 10800118076L; roll <= 10800118137L; ++roll)
            tmap.put(roll, "NoName");

        for (long roll = 10800119127L; roll <= 10800119135L; ++roll)
            tmap.put(roll, "NoName");

        String line;
        while ((line = br.readLine()) != null) {
            String rollNo = "";
            boolean isSpace = false;
            line += "A";
            for (int i = 0; i < line.length(); ++i) {
                if (line.charAt(i) == ' ' || line.charAt(i) == '\t') {
                    isSpace = true;
                }

                if (!isSpace && rollNo.length() < 5 && (line.charAt(i) >= '0' && line.charAt(i) <= '9')) {
                    rollNo += (line.charAt(i) + "");
                } else if (rollNo.length() > 3) {
                    rollNo = "1080011" + rollNo.substring(rollNo.length() - 4);
                    if (tmap.containsKey(Long.parseLong(rollNo)))
                        tmap2.put(Long.parseLong(rollNo), "P");
                    isSpace = false;
                    rollNo = "";

                }
            }
        }

        for (Map.Entry e : tmap.entrySet()) {
            if (!tmap2.containsKey(e.getKey()))
                tmap2.put((Long) e.getKey(), "A");
        }
        for (Map.Entry e : tmap2.entrySet()) {
            System.out.println(e.getKey() + " , " + e.getValue());
        }

    }
}
