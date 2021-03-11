package com.company;
//Import of Java package.
import java.util.Objects;
import java.util.Scanner;

//Class EditClient - Modify and store a Client present on database.
class EditClient extends ReadLine {

    //Method to modify Client data.
    public static void ModifyClient(int mainMenuParameter) {

        //Attribute declaration.
        boolean tempBoolean;
        int commonIndex = 0;//Reset the Index.
        int tempInt;//Temporary Integer for some functions below.
        int lim = ReadLine.getLoadClient().size();//Size of the Array List loaded with Client's data.
        int stateCounter =0;
        double tempDouble;//Temporary Double for some functions below.
        String tempString; //Temporary String for some functions below.

        //Object declaration.
        WriteLine writeLine = new WriteLine();//New instance of class WriteLine.
        writeLine.WriteFile("autobackup"); //Create an autobackup before edition
        String[] modClient = new String[ArrList.fieldClient.length];//Initialize Array List that will receive Clients data before store operations.
        Scanner myObj = new Scanner(System.in);//New instance of class Scanner.

        //Check if the Clients List is empty.
        if (lim > 0) {
            Message.EditMessage();
            Message.ModifyClient(lim,mainMenuParameter);
        } else {
            Message.ClientListVoid();
            return;
        }

        // Client Number
        Client modifyClient = null;//Initialize object.
        do {
            try {
                modClient[commonIndex] = myObj.nextLine();//Store in an array element the input from the user.
                tempInt = Integer.parseInt(modClient[commonIndex]);//Convert String to Integer.
                modifyClient = ReadLine.getLoadClient().get(tempInt - 1);//Adjust index position.
                Message.EditClientIntro(ArrList.fieldClient[commonIndex],modifyClient.getClientNumber());
            } catch (NumberFormatException e) {
                Message.InvalidInputMain();
                return;
            }
        }while(tempInt<1||tempInt>lim);//Accepts all numbers that exist on the list and are positive
        commonIndex++;//Go to next index(next field).

        //Client State
        tempBoolean = modifyClient.getClientState();//Initialize process to show human friendly language rather than boolean
        if (!tempBoolean) {
            tempString = "inactive";//Show human friendly language.
        } else {
            tempString = "active";//Show human friendly language.
        }
        //stateCounter =0;//Reset counter.DELETE IT LATER
        //Conversion from String from user input to boolean
        do {
            Message.EditClientStore(ArrList.headerClient[commonIndex], tempString,1);
            Message.EditClientInput(ArrList.fieldClient[commonIndex]);
            modClient[commonIndex] = myObj.nextLine();
            if (modClient[commonIndex].equals("inactive") || modClient[commonIndex].equals("Inactive")) {
                tempBoolean = false;
                modifyClient.setClientState(tempBoolean);
                Message.EditClientStore(ArrList.headerClient[commonIndex], "Inactive", 2);
                stateCounter++;
            } else if (modClient[commonIndex].equals("active") || modClient[commonIndex].equals("Active")) {
                tempBoolean = true;
                modifyClient.setClientState(tempBoolean);
                Message.EditClientStore(ArrList.headerClient[commonIndex], "Active", 2);
                stateCounter++;
            } else if (modClient[commonIndex].equals("")){
                if(!tempBoolean) {
                    Message.EditClientStore(ArrList.headerClient[commonIndex], "Inactive", 2);
                }else{
                    Message.EditClientStore(ArrList.headerClient[commonIndex], "Active", 2);
                }
                stateCounter++;
            }
        }while(stateCounter!=1);//Need a correct answer (one point) to go to the next question.
        commonIndex++;

        //If the user just want to edit the Client State (previously selected in main menu)
        if(mainMenuParameter==5){
            Message.SaveChange();
            tempString = myObj.nextLine();
            if (Objects.equals(tempString, "y") || Objects.equals(tempString, "Y")){
                writeLine.WriteFile("regular");
            }
                return;
        }

        //Client Name
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientName(),1);
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if (!modClient[commonIndex].equals("")){
            modifyClient.setClientName(modClient[commonIndex]);
        }
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientName(),2);
        commonIndex++;

        //Client Address
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientAddress(),1);
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if (!modClient[commonIndex].equals("")){
            modifyClient.setClientAddress(modClient[commonIndex]);
        }
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientAddress(),2);
        commonIndex++;

        //Client Location
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientLocation(),1);
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if (!modClient[commonIndex].equals("")) {
            modifyClient.setClientLocation(modClient[commonIndex]);
        }
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientLocation(),2);
        commonIndex++;

        //Client Zip Code
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientZipCode(),1);
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if (!modClient[commonIndex].equals("")){
            modifyClient.setClientZipCode(modClient[commonIndex]);
        }
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientZipCode(),2);
        commonIndex++;

        //Client County
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientCounty(),1);
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if (!modClient[commonIndex].equals("")){
            modifyClient.setClientCounty(modClient[commonIndex]);
        }
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientCounty(),2);
        commonIndex++;

        //Client District
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientDistrict(),1);
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if (!modClient[commonIndex].equals("")){
            modifyClient.setClientDistrict(modClient[commonIndex]);
        }
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientDistrict(),2);
        commonIndex++;

        //Client Telephone
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientTelephone(),1);
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if (!modClient[commonIndex].equals("")){
            try {
                tempInt = Integer.parseInt(modClient[commonIndex]);
                modifyClient.setClientTelephone(tempInt);
            } catch (NumberFormatException e) {
                Message.InvalidInput();
                modifyClient.setClientTelephone(0);
            }
        }
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientTelephone(),2);
        commonIndex++;

        //Client E-mail
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientEmail(),1);
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if (!modClient[commonIndex].equals("")){
            modifyClient.setClientEmail(modClient[commonIndex]);
        }
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientEmail(),2);
        commonIndex++;

        //Client ID Number
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientIdNumber(),1);
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if (!modClient[commonIndex].equals("")){
            try {
                tempInt = Integer.parseInt(modClient[commonIndex]);
                modifyClient.setClientIdNumber(tempInt);
            } catch (NumberFormatException e) {
                Message.InvalidInput();
                modifyClient.setClientIdNumber(0);
            }
        }
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientIdNumber(),2);
        commonIndex++;

        //Client VAT Number
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientVatNumber(),1);
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if (!modClient[commonIndex].equals("")){
            try {
                tempInt = Integer.parseInt(modClient[commonIndex]);
                modifyClient.setClientVatNumber(tempInt);
            } catch (NumberFormatException e) {
                Message.InvalidInput();
                modifyClient.setClientVatNumber(0);
            }
        }
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientVatNumber(),2);
        commonIndex++;

        //Client Maximum credit
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientMaximumCredit(),1);
        Message.EditClientInput(ArrList.fieldClient[commonIndex]);
        modClient[commonIndex] = myObj.nextLine();
        if (!modClient[commonIndex].equals("")){
            try {
                tempDouble = Double.parseDouble(modClient[commonIndex]);
                modifyClient.setClientMaximumCredit(tempDouble);
            } catch (NumberFormatException e) {
                Message.InvalidInput();
                modifyClient.setClientMaximumCredit(0);
            }
        }
        Message.EditClientStore(ArrList.headerClient[commonIndex], modifyClient.getClientMaximumCredit(),2);

        //Show data inserted.
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
            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        }

        //Show inputs
        System.out.println("\n" + "Data inserted:");
        int headersElements = 0;
        for (String elements : modClient) {
            System.out.println(ArrList.headerClient[headersElements] + elements);
            headersElements++;
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");

        //Confirmation to store data inserted.
        Message.SaveChange();
        tempString = myObj.nextLine();
        if (Objects.equals(tempString, "y") || Objects.equals(tempString, "Y")){
            writeLine.WriteFile("regular");
        }
    }

}
