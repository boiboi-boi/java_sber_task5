import java.io.*;
import java.sql.SQLOutput;

public class main {
    public static void main(String[] args) {
        LogParser lp1 = new LogParser();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("log.log"));
            String line = reader.readLine();
            while (line != null) {
                Log l1 = new Log();
                String[] object = line.split("\t");

                l1.setIp(object[0]);
                l1.setUser(object[1]);
                l1.setDate(object[2]);
                l1.setEvent(object[3]);
                l1.setStatus(object[4]);

                line = reader.readLine();
                lp1.loggers.add(l1);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Log log: lp1.loggers){

            if (log.getEvent().contains("DONE_TASK") && log.getStatus().equals("OK")) {
                try  (BufferedWriter writter = new BufferedWriter(new FileWriter("done_task_log.log",true)))
                {
                    writter.write(log.getIp() + "\t");
                    writter.write(log.getUser() + "\t");
                    writter.write(log.getDate() + "\t");
                    writter.write(log.getEvent() + "\t");
                    writter.write(log.getStatus() + "\n");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
