
/**
 * Name: Christopher Bain
 * Course: 202620-CEN-3024C-23585
 * Date: 02/03/2026
 *
 * Class Name: Patrons
 *
 * This class represents a patron in the Library Management System.
 * It stores patron information such as ID, name, address, and overdue
 * fine amount.
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Patrons {
    private int id;
    private String name;
    private String address;
    private double overdueFine;
    public static ArrayList<Patrons> patrons = new ArrayList<>();


    Patrons(int id, String name, String address, double overdueFine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.overdueFine = overdueFine;
    }

    Patrons() {
        //add a try catch and loop if there is an incorrect entry. added inside
        setId();
        System.out.print("Enter the name of the patron >");
        setName();
        System.out.println();
        System.out.print("Enter the address of the patron >");
        setAddress();
        System.out.println();
        System.out.print("Enter the overdue fine of the patron >");
        setOverdueFine();
    }

    Patrons(String entry){
        System.out.println("This is the string that was passed : " + entry);
        try {
            String[] parts = entry.split("-"); //apart of the string class that can take an argument to split the string with
            //https://www.w3schools.com/java/ref_string_split.asp

            this.id = Integer.parseInt(parts[0]);
            //https://www.geeksforgeeks.org/java/integer-valueof-vs-integer-parseint-with-examples/
            this.name = parts[1];
            this.address = parts[2];
            this.overdueFine = Double.parseDouble(parts[3]);
            //https://www.geeksforgeeks.org/java/double-parsedouble-method-in-java-with-examples/

        } catch (Exception e) {
            System.out.println("Invalid patron entry: " + entry);
        }
    }//todo does this try the same incorrect input or does it try a new line


    public int getId() {
        return id;
    }
    public String getIdFormated(){
        return String.format("%07d", id);
    }

    public void setId() {
        for (int i = 1; i <= 9999999; i++) {
            boolean taken = false;
            for (Patrons p : patrons) {
                if (p.getId() == i) {
                    taken = true;
                    break;
                }
            }//parses through all objects in the array
            if (!taken) {
                this.id = i;
                return;
            }
        }
    }//end of setId Function

    public String getName() {
        return name;
    }

    public void setName() {
        Scanner input = new Scanner(System.in);
        //todo add safety and validation checks to the input.
        this.name = input.nextLine();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        Scanner input = new Scanner(System.in);
        //todo add validation to confirm correct input.
        this.address = input.nextLine();
    }

    public double getOverdueFine() {
        return overdueFine;
    }

    public void setOverdueFine() {
        Scanner input = new Scanner(System.in);
        //todo add validation to protect input.
        while (true) {
            try {
                this.overdueFine = Double.parseDouble(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    @Override
    public String toString() {
        return getIdFormated() + "-"+name+"-"+address+"-"+overdueFine;
    }
}//End of patrons class
