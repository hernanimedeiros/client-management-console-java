package com.company;
//Import of Java package.
import java.util.Scanner;

//Class Answer - Manage response of user in Main Menu.
public class Answer{

    //Method to collect input from user in main menu.
    public static int MainMenuAnswer() {

        //Attribute declaration.
        String mainMenuAnswerStr;
        int mainMenuAnswer;

        //Object declaration.
        Scanner myObj = new Scanner(System.in);//Create a Scanner object.

        //Request to user.
        System.out.println("Introduce your option");

        //Try/catch block to receive input from user (Main menu answer).
        try {
            mainMenuAnswerStr = myObj.nextLine();//Read user input and store to a attribute.
            mainMenuAnswer = Integer.parseInt(mainMenuAnswerStr);//String to Integer conversion.
            System.out.println("You has choose: " + mainMenuAnswer);//Output user input.
            return mainMenuAnswer;//Return answer. This parameter will be use often in this program.
        } catch(NumberFormatException e){
            //e.printStackTrace();//Test purposes. Ignore this!
            Message.InvalidInputMain();
            return 0;//Force to show Welcome Screen again when return to main menu.
        }
    }

}
