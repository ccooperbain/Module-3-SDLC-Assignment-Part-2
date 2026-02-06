/**
Name: Christopher Bain
Course: 202620-CEN-3024C-23585
Date: 02/03/2026
Class Name: Main

This class contains the main method and controls the overall execution
of the Library Management System. The program allows a user to
load patron data from a file, manually add new patrons, remove patrons,
display all patrons, and save updated data back to a text file.
 */


//todo start going through the menu options. (done)
//todo inport from file line by line (done)


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
//


public class Main {
    //
    /**
     * Method Name: main
     *
     * Purpose:
     * Entry point for the program. Starts the application,
     * loads existing patron data, displays the menu, and processes user input
     * until the user chooses to exit the program.
     *
     * Arguments:
     * None
     *
     * Return Value:
     * None
     */

    public static void main(String[] args) {
        Patrons.patrons.add(new Patrons(0,"start name","Start address",0));
        Patrons.patrons.add(new Patrons(9999999,"end name","End address",0));
        System.out.println("..............Program Start................");
        int input;
        Scanner inputInt = new Scanner(System.in);
        boolean loop = true;
        loadApp();

        //
        do{ //looping menue option to take input and excute the function
            try {
                menu();
                //todo the menue input crashes when a non int is entered fix that (done)

                switch (inputInt.nextInt()) {
                    case 1:
                        addFromFile();
                        break;
                    case 2:
                        addIndividualPatron();
                        break;
                    case 3:
                        removePatron();
                        break;
                    case 4:
                        listAllPatrons();
                        break;
                    case 0:
                        quit();
                        loop = false;
                        break;
                    default:
                        System.out.println("Invalid input try again");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid input try again");
                inputInt.nextLine();
            }

        }while(loop);
    }//End of main function

    /**
     * Method Name: loadApp
     *
     * Purpose:
     * Loads patron data from the default text file if it exists. If the file
     * does not exist, the method creates it and writes default records.
     * This method ensures that patron data is available when the program starts.
     *
     * Arguments:
     * None
     *
     * Return Value:
     * None
     */

    public static void loadApp(){

        //test file creation
        String fileName = "lms.txt"; //setting the file name
        try{
            Path path = Path.of(fileName);//the file should exist in the current directory of the running application.
            if(Files.exists(path)){
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                System.out.println("The text file lms.txt exists");
                //output the 2 lines of the text file
                //todo get only the first 2 lines fo the text file. (done)
                //todo load text file into array (later)
                //System.out.println(Files.readString(path)); //reads the whole file
                //System.out.println(fileReader.readLine()); //read line progresses the reader buffer
                //System.out.println(fileReader.readLine());
                int i = 0;
                String line;
                while ((line = fileReader.readLine()) != null ) {
                    if(i==0 || i==1){
                        System.out.println(line);
                        i++;
                    }else{
                        Patrons.patrons.add(new Patrons(line));
                    }
                }


                //load the text file into the array

            }else{
                System.out.println("The text file lms.txt does not exist... creating file ");
                Files.createFile(path);// creates the file
                //this is where we would create the file and add the 2 dummy entries
                Files.writeString(path,Patrons.patrons.get(0).toString()+"\n");
                Files.writeString(path,Patrons.patrons.get(1).toString(),StandardOpenOption.APPEND);
                //Files.writeString(path,"Hello 2", StandardOpenOption.APPEND); //overwrites the text in the file.
                // members and output them successfully.
                System.out.println("Written to file");

            }
        } catch (Exception e){
            System.out.println("Error loading app");
        }
    } // end of load app

    /**
     * Method Name: menu
     *
     * Purpose:
     * Displays the main menu options to the user allowing them to choose
     * between loading data adding patrons removing patrons listing patrons
     * or exiting the application.
     *
     * Arguments:
     * None
     *
     * Return Value:
     * None
     */

    public static void menu(){
        System.out.println("<.........Menu...........>");
        System.out.println("Enter the corresponding number to make your selection");
        System.out.println("[1] Add Patrons From File ");
        System.out.println("[2] Add Individual Patron");
        System.out.println("[3] Remove Patron");
        System.out.println("[4] List all Patrons");
        System.out.println("[0] Exit Application");
        System.out.print("Please enter your choice >");
    }// end of menu function

    /**
     * Method Name: addFromFile
     *
     * Purpose:
     * Prompts the user to enter the location of a text file containing patron
     * data. Reads the file line by line and adds each patron record to the
     * programs Arraylist of patrons.
     *
     * Arguments:
     * None
     *
     * Return Value:
     * None
     */

    static void addFromFile(){System.out.println("add from file remember to remove the quotes");
        System.out.print(">");
        //input text file location and read from it line by line added the value to the arrays.
        Scanner fileLocation = new Scanner(System.in);
        try{
            BufferedReader fileSource = new BufferedReader(new FileReader(fileLocation.nextLine()));
            //The file expects a path that does not include the quotation marks.
            while(fileSource.ready()){

                try{
                    Patrons.patrons.add(new Patrons(fileSource.readLine())); //sends a string to the constructor
                }catch(Exception e){
                    System.out.println("Invalid patron entry from file. ");
                }

                //Patrons.patrons.add(new Patrons(fileSource.readLine())); //sends a string to the constructor
                //the constructor must parse through the string
                //the expected file format is
            }

            //todo how to catch multiple exceptions. (done)

        } catch (FileNotFoundException e) {
            System.out.println("Error loading file try again");
        }catch (IOException f){
            System.out.println("Could not read line from file.");
        }

        //for every line in the text file
        //have the getter functions validate the input grabbed
        //parse through and get the number move to the next with each dash
        Scanner input = new Scanner(System.in);
        //test by taking in a text location and outputting the document
        listAllPatrons();
    }

    /**
     * Method Name: addIndividualPatron
     *
     * Purpose:
     * Allows the user to manually enter a new patron record by prompting
     * for patron details and adding the new patron to the Arraylist.
     *
     * Arguments:
     * None
     *
     * Return Value:
     * None
     */

    static void addIndividualPatron(){System.out.println("add individual patron");
        //use a blank constructor to confirm
        Patrons.patrons.add(new Patrons());
        listAllPatrons();
    }

    /**
     * Method Name: removePatron
     *
     * Purpose:
     * Prompts the user to enter a patron ID and removes the matching patron
     * record from the collection if it exists.
     *
     * Arguments:
     * None
     *
     * Return Value:
     * None
     */

    static void removePatron(){System.out.println("<---->remove patron by entering a user id<>");
        System.out.print(">");
        Scanner input = new Scanner(System.in);
        Iterator<Patrons> iterator = Patrons.patrons.iterator();
        int id;
        try{
            id = input.nextInt();
            while(iterator.hasNext()){
                if(iterator.next().getId() == id){
                    iterator.remove();
                }
            }

        }catch(InputMismatchException e){
            System.out.println("Invalid input try again");
        }

        listAllPatrons();
    }

    /**
     * Method Name: listAllPatrons
     *
     * Purpose:
     * Displays all patron records currently stored in the program to the screen.
     *
     * Arguments:
     * None
     *
     * Return Value:
     * None
     */

    static void listAllPatrons(){System.out.println("<---->list all patrons<>");
        for(Patrons p: Patrons.patrons){
            System.out.println(p.toString());
        }
    }

    /**
     * Method Name: quit
     *
     * Purpose:
     * Saves all current patron data to the text file and exits the program.
     *
     * Arguments:
     * None
     *
     * Return Value:
     * None
     */

    static void quit(){System.out.println("quit");
        //todo add the updated array to the text file.
        try {
            Path path = Paths.get("lms.txt");
            Files.writeString(path,"",StandardOpenOption.TRUNCATE_EXISTING);
            for (Patrons p : Patrons.patrons) {
                Files.writeString(path,p.toString() + "\n",StandardOpenOption.APPEND);
            }

            System.out.println("Written out ");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
} //End of main class
