package com.company;

//Import of Java package.
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

//Class CreateClient - Add and store new Client.
public class CreateClient extends ReadLine{

    //Method to add a Client.
    public static void AddClient() {

        //Attribute declaration.
        int commonIndex = 0;//Reset the Index.
        int tempInt;//Temporary Integer for some functions below.
        double tempDouble;//Temporary Double for some functions below.
        String tempString;//Temporary String for some functions below.
        String filenameMovement;//Temporary String for some functions below.

        //Objects declaration.
        WriteLine writeLine = new WriteLine();//New instance of class WriteLine.
        writeLine.WriteFile("autobackup"); //Create an autobackup before edition
        String[] modClient = new String[ArrList.fieldClient.length];//Initialize Array List that will receive Clients data before store operations.
        Scanner myObj = new Scanner(System.in);//New instance of class Scanner.
        ArrayList<Client> modifyClient = null;//Initialize ArrayList with Client data.
        modifyClient = ReadLine.getLoadClient();//Initialize ArrayList with Client data (load).
        Client addClient = new Client();//New instance of class Client.

        //Add new Client to Array List
        modifyClient.add(addClient);

        //Request to user.
        Message.CreateMessage();

        //Client Number.
        tempInt = ReadLine.getLoadClient().size();//Attribute Client number position.
        filenameMovement= String.valueOf(tempInt);//Convert Integer to String to compose a filename (used later in creation of file for Client's movements).
        addClient.setClientNumber(tempInt);//Edit field.
        commonIndex++;//Go to next index(next field).

        // Client State.
        addClient.setClientState(true);//By default set client as active.
        commonIndex++;//Go to next index(next field).

        //Client Name.
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();//Store in an array element the input from the user.
        if(modClient[commonIndex].equals("")){
            modClient[commonIndex]="Missing data";
        }
        addClient.setClientName(modClient[commonIndex]);
        commonIndex++;

        //Client Address.
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if(modClient[commonIndex].equals("")){
            modClient[commonIndex]="Missing data";
        }
        addClient.setClientAddress(modClient[commonIndex]);
        commonIndex++;

        //Client Location.
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if(modClient[commonIndex].equals("")){
            modClient[commonIndex]="Missing data";
        }
        addClient.setClientLocation(modClient[commonIndex]);
        commonIndex++;

        //Client Zip Code.
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if(modClient[commonIndex].equals("")){
            modClient[commonIndex]="Missing data";
        }
        addClient.setClientZipCode(modClient[commonIndex]);
        commonIndex++;

        //Client County.
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if(modClient[commonIndex].equals("")){
            modClient[commonIndex]="Missing data";
        }
        addClient.setClientCounty(modClient[commonIndex]);
        commonIndex++;

        //Client District.
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if(modClient[commonIndex].equals("")){
            modClient[commonIndex]="Missing data";
        }
        addClient.setClientDistrict(modClient[commonIndex]);
        commonIndex++;

        //Client Telephone.
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        //Try catch block to check integrity of the input inserted.
        try {
            tempInt = Integer.parseInt(modClient[commonIndex]);//Convert String to Integer.
            addClient.setClientTelephone(tempInt);//Edit field.
        //Execute some integrity procedures if the user introduce an incorrect input
        } catch (NumberFormatException e) {
            Message.InvalidInput();
            addClient.setClientTelephone(0);//Set o by default if an incorrect input is inserted.
        }
        commonIndex++;//Go to next index(next field).

        //Client E-mail.
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if(modClient[commonIndex].equals("")){
            modClient[commonIndex]="Missing data";
        }
        addClient.setClientEmail(modClient[commonIndex]);
        commonIndex++;

        //Client ID Number.
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        try {
            tempInt = Integer.parseInt(modClient[commonIndex]);
            addClient.setClientIdNumber(tempInt);
        } catch (NumberFormatException e) {
            Message.InvalidInput();
            addClient.setClientIdNumber(0);
        }
        commonIndex++;

        //Client VAT Number.
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        try {
            tempInt = Integer.parseInt(modClient[commonIndex]);
            addClient.setClientVatNumber(tempInt);
        } catch (NumberFormatException e) {
            Message.InvalidInput();
            addClient.setClientVatNumber(0);
        }
        commonIndex++;

        //Client Maximum credit.
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        try {
            tempDouble = Double.parseDouble(modClient[commonIndex]);
            addClient.setClientMaximumCredit(tempDouble);
        } catch (NumberFormatException e) {
            Message.InvalidInput();
            addClient.setClientMaximumCredit(0);
        }

        //Show Client data and data inserted as the last Client of the list
        for (Client client : ReadLine.getLoadClient()) {
            System.out.println(ArrList.headerClient[0] + client.getClientNumber());
            //System.out.println(ArrList.headerClient[1] + client.getClientState());
            System.out.println(ArrList.headerClient[2] + client.getClientName());
            System.out.println(ArrList.headerClient[3] + client.getClientAddress());
            System.out.println(ArrList.headerClient[4] + client.getClientLocation());
            System.out.println(ArrList.headerClient[5] + client.getClientZipCode());
            System.out.println(ArrList.headerClient[6] + client.getClientCounty());
            System.out.println(ArrList.headerClient[7] + client.getClientDistrict());
            System.out.println(ArrList.headerClient[8] + client.getClientTelephone());
            System.out.println(ArrList.headerClient[9] + client.getClientEmail());
            System.out.println(ArrList.headerClient[10] + client.getClientIdNumber());
            System.out.println(ArrList.headerClient[11] + client.getClientVatNumber());
            System.out.println(ArrList.headerClient[12] + client.getClientMaximumCredit() + "€");
            System.out.println("\n" + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + "\n");
        }

        //Confirmation to store data inserted.
        Message.SaveChange();
        tempString = myObj.nextLine();
        if (Objects.equals(tempString, "y") || Objects.equals(tempString, "Y") ){
            writeLine.WriteFile("regular");//Call the method to store array content to file
            writeLine.WriteFileMovement(filenameMovement,0);//Fill the first movement with zero.
        }
    }

}
