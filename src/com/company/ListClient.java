package com.company;

//Class ListClient - List Client data.
class ListClient extends ReadLine {

    //Method to list Clients.
    public void StateListClient(boolean state){

        //Attribute declaration.
        int counter=0;

        //Access all the Client's data in loaded in Array List.
        for (Client client : ReadLine.getLoadClient()) {
            if(client.getClientState()==state) {
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
                System.out.println("\n"+ ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+"\n");
                counter++;
            }
        }
        Message.NumberClientShow(counter);//Count the number of Clients showed.
    }

    //Method to list Clients with less information (just number, name and maximum credit).
    public void SimpleListClient(boolean state){

        //Just show active Clients
        Message.SimpleAccountInformationHeader();
        for (Client client : ReadLine.getLoadClient()) {
            if(client.getClientState()) {
                System.out.println(client.getClientNumber()+"  ->  "+client.getClientName()+" ("+client.getClientMaximumCredit()+"€)");
            }
        }
    }

}
