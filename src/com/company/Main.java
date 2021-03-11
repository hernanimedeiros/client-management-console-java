package com.company;
//Welcome to CRUD-5413, an client account manager software  written in Java.
//This program is a simple CRUD CLI app to POO study purposes.
//Things to improve in another versions:
//[1]-> Validation to values inserted by user in certain field like VAT number or telephone. The validation for this parameters need to be adapted for each country!
//[2]-> DRY and KISS principles can be improved in future versions. This work was a study of POOP in Java and I fell need to explore some varied concepts, sometimes harming some good programing practices.
//[3]-> If this exercise were real or the use case were more precise the Java modifiers could be adapted to "hide" more information.
//[4]-> I think in produce an automatic update of maximum credit (when available credit > maximum credit) or warning messages and leave it commented but I don't want to break YAGNI principles.


import java.io.IOException;

//Class Main - Orchestrate the program routes from the inputs from user in Main Menu.
public class Main {

    //Constants to diverse use case in program.
    private static final class Constants {

        //Attribute declaration.
        private static final String filenameClient = "./db/client/clients.csv";
        private static final String filenameSave = "./db/client/clients.csv";//can be useful to define a different path in tests
        private static final String filenameBackup = "./db/backup/clients_backup.csv";
        private static final String filenameBackupAuto = "./db/backup/clients_backup_auto.csv";
        private static final String movementDirectory = "./db/movement/";
        private static final String delimiterClient = ";";
        private static final String movementFileExtension = ".csv";
    }

    //Orchestrate the program routes.
    public static void main(String[] args) {

        //Attribute declaration.
        int mainMenuAnswer;

        //Object declaration.
        CheckFile checkFile = new CheckFile(); //Create an instance (objet) of the class WriteLine
        ReadLine readLine = new ReadLine(Constants.filenameClient, Constants.filenameSave, Constants.filenameBackup, Constants.filenameBackupAuto, Constants.delimiterClient, Constants.movementDirectory,Constants.movementFileExtension);
        WriteLine writeLine = new WriteLine(); //Create an instance (objet) of the class WriteLine
        ListClient listClient = new ListClient(); //Create an instance (objet) of the class ListClient
        Movement movement = new Movement(); //Create an instance (objet) of the class Movement

        //Call the method to check program integrity.
        boolean check=checkFile.CheckFileIntegrity(Constants.filenameClient); //Check file integrity
        if(check){
            readLine.ReadFile();//Load data to create session backup.
            writeLine.WriteFile("backup");//Create an backup everytime the program start and the Clients file exist (session backup).
            Message.WelcomeMessage();//Call method for show welcome message.
        }

        //Main Menu routine. User pick an option and this function define a route for methods calling.
        do{
            Message.MainMenu();
            mainMenuAnswer=Answer.MainMenuAnswer();
            switch (mainMenuAnswer){
                case 0:
                    Message.WelcomeMessage();
                    break;
                case 1:
                    readLine.ReadFile();
                    Message.ActiveClient();
                    listClient.StateListClient(true);
                    break;
                case 2:
                    readLine.ReadFile();
                    Message.InactiveClient();
                    listClient.StateListClient(false);
                    break;
                case 3:
                    readLine.ReadFile();
                    Message.ActiveClient();
                    listClient.StateListClient(true);
                    Message.InactiveClient();
                    listClient.StateListClient(false);
                    break;
                case 4:
                    CreateClient.AddClient();
                    break;
                case 5:
                case 6:
                    Message.ActiveClient();
                    listClient.StateListClient(true);
                    Message.InactiveClient();
                    listClient.StateListClient(false);
                    EditClient.ModifyClient(mainMenuAnswer);
                    break;
                case 7:
                case 8:
                case 9:
                    movement.ReadLineMovement(mainMenuAnswer);
                    break;
                case 10:
                    readLine.ReadFile();
                    Message.ActiveClient();
                    listClient.SimpleListClient(true);
                    break;
                case 11:
                case 12:
                case 13:
                    readLine.ReadFileRaw(mainMenuAnswer);
                    break;
                case 14:
                case 15:
                    try {
                        writeLine.WriteFileRestore(mainMenuAnswer);
                    } catch (IOException e) {
                        e.printStackTrace();
                        Message.PermissionError();
                    }
                    break;
                case 16:
                    System.out.println("[...turning off the lights :) ...]");
                    Message.GoodbyeMessage();
                    return;
                default:
                    Message.InvalidInputMain();
                    Message.WelcomeMessage();
                    break;
            }
        }while(true); //Accepts and validate all inputs but the user can only quit by introducing the correct option
    }
}