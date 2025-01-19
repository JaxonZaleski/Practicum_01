import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class PersonReader
{

    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> lines = new ArrayList<>();


        final int FIELDS_LENGTH = 5;

        String ID, firstName, lastName, title;
        int YOB;

        try {

            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                try (InputStream in = new BufferedInputStream(Files.newInputStream(file));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
                {

                    int line = 0;
                    while (reader.ready()) {
                        rec = reader.readLine();
                        line++;
                        // echo to screen
                        System.out.printf("\nLine %4d %-60s ", line, rec);
                    }
                    reader.close();
                    System.out.println("\n\nData file read!");

                    String[] fields;
                    for (String l: lines) {

                        fields = l.split(",");

                        if (fields.length == FIELDS_LENGTH) {
                            ID         = fields[0].trim();
                            firstName  = fields[1].trim();
                            lastName   = fields[2].trim();
                            title      = fields[3].trim();
                            YOB        = Integer.parseInt(fields[4].trim());

                            System.out.printf("\n%-8s%-25s%-25s%-6s%6d", ID, firstName, lastName, title, YOB);
                        } else {
                            System.out.println("Found a record that may be corrupt.");
                            System.out.println(l);
                        }
                    }
                }
            }
            else
            {
                System.out.println("No file selected.\nRun the program again and select a file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

