import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
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
        //add a try catch and loop if there is an incorrect entry.
        setId();
        setName();
        setAddress();
        setOverdueFine();
    }

    Patrons(String entry){
        System.out.println("This is the string that was passed : " + entry);
    }

    public void acceptFileByline(String file) {
        //todo add protector again bad file inputs
        //todo catch the exception int the calling function


    }

    public int getId() {
        return id;
    }
    public String getIdFormated(){
        return String.format("%07d", id);
    }

    public void setId() {
        boolean flag = false;
        for(int i = 1; i < 9999999; i++){
            for(Patrons p : patrons){
                if(p.getId() == i){
                    //the id is taken
                }else{
                    //the id is free
                    this.id = i;
                    flag = true;
                    //how far does break break out of the loop
                    break;
                     }
            }//the break in the "if else" handles this
            if(flag){break;}
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
        this.overdueFine = input.nextDouble();
    }

    @Override
    public String toString() {
        return getIdFormated() + "-"+name+"-"+address+"-"+overdueFine;
    }
}
