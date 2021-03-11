package com.company;
//Import of Java package
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

//Class ReadClient - Read file and feed the Array List.
public class ReadLine {

    //Attribute declaration.
    private static String filenameClient;
    private static String filenameSave;
    private static String filenameBackup;
    private static String filenameBackupAuto;
    private static String delimiterClient;
    private static String movementDirectory;
    private static String movementFileExtension;

    //Constructor.
    public ReadLine(String filenameClient, String filenameSave, String filenameBackup, String filenameBackupAuto, String delimiterClient, String movementDirectory, String movementFileExtension) {
        ReadLine.filenameClient = filenameClient;
        ReadLine.filenameSave = filenameSave;
        ReadLine.filenameBackup = filenameBackup;
        ReadLine.filenameBackupAuto = filenameBackupAuto;
        ReadLine.delimiterClient = delimiterClient;
        ReadLine.movementDirectory = movementDirectory;
        ReadLine.movementFileExtension = movementFileExtension;
    }

    //Default constructor.
    public ReadLine() {
    }

    private static ArrayList<Client> loadClient = new ArrayList<Client>();//I choose ArrayList instead of other methods because of performance reasons in this Use Case

    public static ArrayList<Client> getLoadClient() {
        return loadClient;
    }

    public static void setLoadClient(ArrayList<Client> loadClient) {
        ReadLine.loadClient = loadClient;
    }

    public static String getFilenameSave() {
        return filenameSave;
    }

    public static String getFilenameBackup() {
        return filenameBackup;
    }

    public static String getFilenameBackupAuto() {
        return filenameBackupAuto;
    }

    public static String getDelimiterClient() {
        return delimiterClient;
    }

    public static String getMovementDirectory() {
        return movementDirectory;
    }

    public static String getMovementFileExtension() {
        return movementFileExtension;
    }

    //Read Client file and load the information in a Array List.
    public void ReadFile() {

        //Attribute declaration.
        String readNumber,
        readState,
        readName,
        readAddress,
        readLocation,
        readZipCode,
        readCounty,
        readDistrict,
        readTelephone,
        readEmail,
        readIdNumber,
        readVatNumber,
        readMaximumCredit,
        line;

        //Object declaration.
        WriteLine writeLine = new WriteLine(); //Create an instance (objet) of the class WriteLine.

        try {
            //Object declaration.
            File file = new File(filenameClient); //Create a new file instance(convert pathname string to an abstract pathname).
            FileReader fileReader = new FileReader(file); //Convenience class for reading character file.
            BufferedReader bufferedReader = new BufferedReader(fileReader); // Read text form character-input stream provide by fileReader. Buffering character provide efficient reading.
            loadClient.clear();//Reset Arraylist

            //Read each token on each line of Client's data raw file.
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line,ReadLine.delimiterClient);

                readNumber = st.nextToken();
                readState = st.nextToken();
                readName = st.nextToken();
                readAddress = st.nextToken();
                readLocation = st.nextToken();
                readZipCode = st.nextToken();
                readCounty = st.nextToken();
                readDistrict = st.nextToken();
                readTelephone = st.nextToken();
                readEmail = st.nextToken();
                readIdNumber = st.nextToken();
                readVatNumber = st.nextToken();
                readMaximumCredit = st.nextToken();

                try {
                    //Casting.
                    int readNumberConv = Integer.parseInt(readNumber);
                    boolean readStateConv = Boolean.parseBoolean(readState);
                    int readTelephoneConv = Integer.parseInt(readTelephone);
                    int readIdNumberConv = Integer.parseInt(readIdNumber);
                    int readVatNumberConv = Integer.parseInt(readVatNumber);
                    double readMaximumCreditConv = Double.parseDouble(readMaximumCredit);


                    ReadLine.loadClient.add(new Client(
                            readNumberConv,
                            readStateConv,
                            readName,
                            readAddress,
                            readLocation,
                            readZipCode,
                            readCounty,
                            readDistrict,
                            readTelephoneConv,
                            readEmail,
                            readIdNumberConv,
                            readVatNumberConv,
                            readMaximumCreditConv));
                } catch (NumberFormatException e) {
                Message.DataError();
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch(IOException e){
            e.printStackTrace();
            Message.AccessError();
        }
        Message.FileLoadSuccess();
    }

    public void ReadFileRaw(int mainMenuParameter) {

        //Attribute declaration.
        String filenameRead;
        String line;

        //Define path to read.
        switch (mainMenuParameter) {
            case 11:
                filenameRead=filenameClient;
                break;
            case 12:
                filenameRead=filenameBackup;
                break;
            case 13:
                filenameRead=filenameBackupAuto;
                break;
            default:
                filenameRead=filenameClient;
                break;
        }

        try {

            //Attribute declaration.
            double gigabyte= Math.pow(10,9);
            double megabyte= Math.pow(10,6);
            double kilobyte= Math.pow(10,3);

            //Object declaration.
            File file = new File(filenameRead); //Create a new file instance(convert pathname string to an abstract pathname)
            FileReader fileReader = new FileReader(file); //Convenience class for reading character file
            BufferedReader bufferedReader = new BufferedReader(fileReader); // Read text form character-input stream provide by fileReader. Buffering character provide efficient reading

            //File info.
            System.out.println("\n[File]" +
                               "\nFile ----------> " + file.getName() +
                               "\nFile size -----> " + Math.round(file.length()/kilobyte) + " kB (" + file.length() + " B)" +
                               "\nPath of file --> " + file.getAbsolutePath() + "\n");

            //Line reader.
            System.out.println("[File content]");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            //System info.
            System.out.println("\n[System info]" +
                               "\nTotal Space ----> " + Math.round(file.getTotalSpace()/gigabyte) +" GB (" + Math.round(file.getTotalSpace()/megabyte) +" MB)" +
                               "\nFree Space -----> " + Math.round(file.getFreeSpace()/gigabyte) +" GB (" + Math.round(file.getFreeSpace()/megabyte) +" MB)" +
                               "\nUsable Space ---> " + Math.round(file.getUsableSpace()/gigabyte) +" GB ("+ Math.round(file.getUsableSpace()/megabyte)+" MB)\n");

            bufferedReader.close();
            fileReader.close();
        } catch(IOException e){
            e.printStackTrace();
            Message.AccessError();
        }
        Message.FileLoadSuccess();
    }
}