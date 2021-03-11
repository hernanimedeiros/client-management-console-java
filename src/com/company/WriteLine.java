package com.company;
//Import of Java package.
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Objects;
import java.util.Scanner;

//Class WriteLine - Write in file operations.
class WriteLine extends ReadLine {

    //Attribute declaration.
    File file;
    private static final String filenameSave = ReadLine.getFilenameSave();
    private static final String filenameBackup = ReadLine.getFilenameBackup();
    private static final String filenameBackupAuto = ReadLine.getFilenameBackupAuto();
    private static final String delimiterClient = ReadLine.getDelimiterClient();
    private static final String movementDirectory = ReadLine.getMovementDirectory();
    private static final String movementFileExtension = ReadLine.getMovementFileExtension();

    //Write to file: Client, Backup and Auto Backup.
    public void WriteFile(String type) {

        //Identify the save type.
        try {
            switch (type) {
                case "regular":
                    file = new File(filenameSave);
                    break;
                case "backup":
                    file = new File(filenameBackup);
                    break;
                case "autobackup":
                    file = new File(filenameBackupAuto);
                    break;
                default:
                    Message.PermissionError();//Just for control purposes.
                    break;
            }

            //Object declaration.
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            getLoadClient().forEach(Client -> {
                printWriter.println(
                        Client.getClientNumber() + delimiterClient +
                                Client.getClientState() + delimiterClient +
                                Client.getClientName() + delimiterClient +
                                Client.getClientAddress() + delimiterClient +
                                Client.getClientLocation() + delimiterClient +
                                Client.getClientZipCode() + delimiterClient +
                                Client.getClientCounty() + delimiterClient +
                                Client.getClientDistrict() + delimiterClient +
                                Client.getClientTelephone() + delimiterClient +
                                Client.getClientEmail() + delimiterClient +
                                Client.getClientIdNumber() + delimiterClient +
                                Client.getClientVatNumber() + delimiterClient +
                                Client.getClientMaximumCredit()
                );
            });
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            Message.PermissionError();
        }

        //Exhibit success message based on type save selected before.
        switch (type) {
            case "regular":
                Message.SaveSuccess();
                break;
            case "backup":
                Message.BackupSuccess();
                break;
            case "autobackup":
                Message.AutoBackupSuccess();
                break;
            default:
                Message.PermissionError();//Just for control purposes.
                break;
        }
    }

    //Write on the movement file.
    public void WriteFileMovement(String filenameMovement, double movement) {
        try {
            file = new File(movementDirectory + filenameMovement + movementFileExtension);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println(movement);
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            Message.PermissionError();
        }
    }

    //Restore Client File to a previously saved state (backup).
    public static void WriteFileRestore(int mainMenuParameter) throws IOException {

        //Attribute declaration.
        String tempString;
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        File sourceFile;

        //Object declaration.
        File destinyFile = new File(filenameSave);
        Scanner myObj = new Scanner(System.in); // Create a Scanner object.

        //Restore backup versions - Request.
        Message.RestoreBackup(mainMenuParameter);
        tempString = myObj.nextLine();

        //Restore backup versions - Process.
        if (Objects.equals(tempString, "y") || Objects.equals(tempString, "Y")) {
            if (mainMenuParameter == 14) {
                sourceFile = new File(filenameBackup);
            } else {
                sourceFile = new File(filenameBackupAuto);
            }
            try {
                sourceChannel = new FileInputStream(sourceFile).getChannel();
                destChannel = new FileOutputStream(destinyFile).getChannel();
                destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            } finally {
                sourceChannel.close();
                destChannel.close();
            }
        }
    }

}
