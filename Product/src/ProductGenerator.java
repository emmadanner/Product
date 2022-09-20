import javax.swing.*;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ProductGenerator
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Boolean moreProducts = true;
        String ID = "" ;
        String name = "";
        String description = "";
        Double cost = 0.0;
        ArrayList<String> products = new ArrayList<String>();
        moreProducts = SafeInput.getYNConfirm(in, "Do you have a product to add to the list?");
        while(moreProducts == true)
        {
            ID = genIDNum();
            name = SafeInput.getNonZeroLenString(in, "What is the product's name?");
            description = SafeInput.getNonZeroLenString(in, "What is the product's description?");
            cost = SafeInput.getDouble(in, "What is the product's cost?");
            products.add(ID + ", " + name + ", " + description + ", " + cost);
            System.out.print(products);
            ProductGenerator product = new ProductGenerator(ID, name, description, cost);
            moreProducts = SafeInput.getYNConfirm(in, "Do you have another product to add to the list?");
        }
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");
        try
        {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            Files.write(file, products);
            writer.newLine();
            writer.close();
            System.out.print("New product added successfully");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private String IDNum;
    private String name;
    private String description;
    private double cost;
    private static int startSeed = 1;

    public static int getStartSeed()
    {
        return startSeed;
    }

    public static void setStartSeed(int startSeed)
    {
        ProductGenerator.startSeed = startSeed;
    }

    public ProductGenerator(String IDNum, String name, String description, double cost)
    {
        this.IDNum = IDNum;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public ProductGenerator(String name, String description, double cost)
    {
        this.IDNum = this.genIDNum();
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getIDNum()
    {
        return IDNum;
    }
    private static String genIDNum()
    {
        String newID = "" + startSeed;
        while(newID.length() < 6)
        {
            newID = "0" + newID;
        }
        startSeed++;

        return newID;
    }

    public void setIDNum(String IDNum)
    {
        this.IDNum = IDNum;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getCost()
    {
        return cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    @Override
    public String toString()
    {
        return "PersonGenerator{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + name + '\'' +
                ", lastName='" + description + '\'' +
                ", yearOfBirth='" + cost + '\'' +
                '}';
    }
}