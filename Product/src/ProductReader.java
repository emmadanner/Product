import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.ArrayList;

public class ProductReader
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());
        try
        {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();
                BufferedReader inFile = new BufferedReader(new FileReader(target.toFile()));
                String line = inFile.readLine();
                System.out.println("ID#                       Product Name              Description               Cost");
                System.out.println("==================================================================================");
                while ((line = inFile.readLine()) != null)
                {
                    ArrayList<String> products = new ArrayList(Arrays.asList(line.split(",[ ]*")));
                    int spacingSeparation = 3;
                    int longest = "                       ".length();
                    int spacing = longest + spacingSeparation;
                    System.out.print(String.format("%-" + spacing + "s%-" + spacing + "s%-" + spacing + "s%-" + spacing + "s\n", products.get(0), products.get(1), products.get(2), products.get(3)));
                }
                inFile.close();
            }
            else
            {
                System.out.println("You must select a file.  The program will now close.");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found error");
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
