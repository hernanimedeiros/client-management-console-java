package com.company;
//Import of Java package.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

//Class Movement - Manage account Client data.
public class Movement extends ReadLine{

    //Attribute declaration.
    private static final String movementDirectory = ReadLine.getMovementDirectory();//Declare attribute to store the directory to save movement file
    private static final String movementFileExtension = ReadLine.getMovementFileExtension(); //Extension to save

    //Object declaration.
    private ArrayList<Double> movementRegister = new ArrayList<Double>();

    //Method to read and add a movement for a Client.
    public void ReadLineMovement(int mainMenuParameter) {

        //Attribute declaration.
        String line;
        String clientNumberString;
        String registerMovementString;
        String tempString;
        double registerMovement;
        double tempDouble;
        double creditAvailable;
        double creditMaximum;
        double sumMovement = 0;
        int clientNumberInt;
        int lim = ReadLine.getLoadClient().size();//Client number

        //Object declaration.
        WriteLine writeLine = new WriteLine(); //Create an instance (objet) of the class WriteLine
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        Client accessClient = null;


        //Check if the Clients List is void.
        if (lim > 0) {
            Message.ModifyClient(lim,mainMenuParameter);
        } else {
            Message.ClientListVoid();
            return;
        }

        //Client Number.
        do{
            try {
                clientNumberString = myObj.nextLine();
                clientNumberInt = Integer.parseInt(clientNumberString);
                Message.SelectedClient (clientNumberInt);
            } catch (NumberFormatException e) {
                Message.InvalidInputMovement();
                return;
            }
            if(clientNumberInt>lim){
                Message.ModifyClient(lim,mainMenuParameter);
            }
        }while(clientNumberInt<1||clientNumberInt>lim);

        //Register new movements.
        if(mainMenuParameter==8||mainMenuParameter==9) {
            Message.RegisterMovement(mainMenuParameter);
            try {
                registerMovementString = myObj.nextLine();
                registerMovement = Double.parseDouble(registerMovementString);
            } catch (NumberFormatException e) {
                Message.InvalidInputMovement();
                return;
            }
            registerMovement = Math.abs(registerMovement);
            //Credit routine.
            if (mainMenuParameter == 9) {
                registerMovement = registerMovement*-1;
            }
            Message.SaveChange();
            tempString = myObj.nextLine();
            if (Objects.equals(tempString, "y") ||Objects.equals(tempString, "Y")){
                writeLine.WriteFileMovement(clientNumberString,registerMovement);
            } else{
                return;
            }
        }
        //Read Client data.
        accessClient = ReadLine.getLoadClient().get(clientNumberInt-1);
        creditMaximum=accessClient.getClientMaximumCredit();

        //Read of Client's movements file.
        try{
            File file = new File(movementDirectory + clientNumberString + movementFileExtension);//Create a new file instance(convert pathname string to an abstract pathname).
            FileReader fileReader = new FileReader(file);//Convenience class for reading character file.
            BufferedReader bufferedReader = new BufferedReader(fileReader);// Read text form character-input stream provide by fileReader. Buffering character provide efficient reading.

            //Read all lines, check if that string is possible to convert in a number and store that number in a a Array List to math operations.
            movementRegister.clear();//Reset Arraylist.
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    tempDouble=Double.parseDouble(line);
                    movementRegister.add(tempDouble);
                } catch (NumberFormatException e) {
                    Message.DataError();
                    return;
                }
            }
            for (double elements : movementRegister) {
                sumMovement+=elements;
            }

            //Account information.
            Message.AccountInformation();
            System.out.println("Profile of the Client number [" + accessClient.getClientNumber() + "]");
            if (accessClient.getClientState()){
                System.out.println(ArrList.headerClient[1] + "Active");
            } else{
                System.out.println(ArrList.headerClient[1] + "Inactive");
            }
            System.out.println(ArrList.headerClient[2] + accessClient.getClientName());
            System.out.println(ArrList.headerClient[3] + accessClient.getClientAddress());
            System.out.println(ArrList.headerClient[4] + accessClient.getClientLocation());
            System.out.println(ArrList.headerClient[5] + accessClient.getClientZipCode());
            System.out.println(ArrList.headerClient[6] + accessClient.getClientCounty());
            System.out.println(ArrList.headerClient[7] + accessClient.getClientDistrict());
            System.out.println(ArrList.headerClient[8] + accessClient.getClientTelephone());
            System.out.println(ArrList.headerClient[9] + accessClient.getClientEmail());
            System.out.println(ArrList.headerClient[10] + accessClient.getClientIdNumber());
            System.out.println(ArrList.headerClient[11] + accessClient.getClientVatNumber());
            System.out.println("\nFinancial information:");
            creditAvailable=creditMaximum+sumMovement;
            System.out.println("Maximum credit: " + creditMaximum+"€");
            System.out.println("Available credit: " + creditAvailable+"€\n");
            System.out.println("Movements:");
            for (double move : movementRegister) {
                System.out.println(move+"€");
            }
            bufferedReader.close();
            fileReader.close();
        } catch(IOException e){
            e.printStackTrace();
            Message.AccessError();
        }
        Message.FileLoadSuccess();
    }
}
