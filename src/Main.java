//todo start going through the menu options.
//todo inport from file line by line

import jdk.dynalink.StandardOperation;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;
//

//
public class Main {
    //
    public static void main(String[] args) {
        Patrons.patrons.add(new Patrons(0,"start name","Start address",0));
        Patrons.patrons.add(new Patrons(9999999,"end name","End address",0));
        System.out.println("..............Program Start................");
        int input;
        Scanner inputInt = new Scanner(System.in);
        boolean loop = true;
        loadApp();
        //
        do{ //looping menue option to take input and excute the
            menu();
            //todo the menue input crashes when a non int is entered fix that
            switch(inputInt.nextInt()){
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

        }while(loop);
    }//End of main function

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
                //System.out.println(Files.readString(path));
                System.out.println(fileReader.readLine());
                System.out.println(fileReader.readLine());

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
    } // end of load app function
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

    static void addFromFile(){System.out.println("add from file");
        //input text file location and read from it line by line added the value to the arrays.
        Scanner fileLocation = new Scanner(System.in);
        try{
            BufferedReader fileSource = new BufferedReader(new FileReader(fileLocation.nextLine()));
            //The file expects a path that does not include the quotation marks.
            while(fileSource.ready()){
                Patrons.patrons.add(new Patrons(fileSource.readLine())); //sends a string to the constructor
                //the constructor must parse through the string
                //the expected file format is
            }

            //todo how to catch multiple exceptions.

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
    }
    static void addIndividualPatron(){System.out.println("add individual patron");
        //use a blank constructor to confirm
        Patrons.patrons.add(new Patrons());
    }
    static void removePatron(){System.out.println("<---->remove patron by entering a user id<>");
        System.out.print(">");
        Scanner input = new Scanner(System.in);
        //todo input validation
        Patrons.patrons.remove(input.nextInt());
    }
    static void listAllPatrons(){System.out.println("<---->list all patrons<>");
        for(Patrons p: Patrons.patrons){
            System.out.println(p.toString());
        }
    }
    static void quit(){System.out.println("quit");
        //todo add the updated array to the text file.
    }
} //End of main class
