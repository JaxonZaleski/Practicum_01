import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProductWriter {
    public static void main(String[] args) {

        Scanner in = new Scanner (System.in);
        boolean done = false;
        String ID = "";
        String name = "";
        String description = "";
        double cost = 0;
        String rec = "";

        ArrayList <String> items = new ArrayList<>();


        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the item's ID {000001}");
            name = SafeInput.getNonZeroLenString(in, "Enter the item's name");
            description = SafeInput.getNonZeroLenString(in, "Enter the item's description");
            cost = SafeInput.getRangedDouble(in, "Enter the item's cost", 0, 9999);

            rec = ID + ", " + name + ", " + description + ", " + cost;

            System.out.println(rec);

            items.add(rec);

            done = SafeInput.getYNConfirm(in, "Are you done? [Y/N]");
        } while (!done);


        // uses a fixed known path:
        //  Path file = Paths.get("c:\\My Documents\\data.txt");

        // use the toolkit to get the current working directory of the IDE
        // will create the file within the IntelliJ project src folder
        // (may need to adjust for other IDE)
        // Not sure if the toolkit is thread safe...
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\itemData.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile())))
        {

            // Finally can write the file LOL!

            for(String item : items)
            {
                writer.write(item, 0, item.length());  // stupid syntax for write rec
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