import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonGenerator {
    public static void main(String[] args) {

        Scanner in = new Scanner (System.in);
        boolean done = false;
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        String rec = "";
        int YOB = 0;

        ArrayList <String> people = new ArrayList<>();


        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter your ID {000001}");
            firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
            title = SafeInput.getNonZeroLenString(in, "Enter your title [Dr. Mrs. Mr etc");
            YOB = SafeInput.getRangedInt(in, "Enter your year of birth", 1000, 9999);

            rec = ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;

            System.out.println(rec);

            people.add(rec);

            done = SafeInput.getYNConfirm(in, "Are you done? [Y/N]");
        } while (!done);


        // uses a fixed known path:
        //  Path file = Paths.get("c:\\My Documents\\data.txt");

        // use the toolkit to get the current working directory of the IDE
        // will create the file within the IntelliJ project src folder
        // (may need to adjust for other IDE)
        // Not sure if the toolkit is thread safe...
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile())))
        {

            // Finally can write the file LOL!

            for(String person : people)
            {
                writer.write(person, 0, person.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}