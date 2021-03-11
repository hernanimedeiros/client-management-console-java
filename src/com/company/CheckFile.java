package com.company;
//Import of Java package.
import java.io.File;
import java.io.IOException;

//Class CheckFile - Assure integrity of Client's data file.
public class CheckFile {

   //Method to check the Client's file integrity.
   public boolean CheckFileIntegrity(String filename){

       //Object declaration.
       File myFile = new File(filename);//Declare an object to file stream.

            //Try/catch block to test the existence of the file with Client's data.
            try{
                //Test the existence of the file.
                if (myFile.exists()){
                Message.FileExist(myFile.getName());
                return true;
                } else{
                    //Create a new file if the default one don't exist.
                    Message.FileNotExist(myFile.getName());
                    if (myFile.createNewFile()) {
                        Message.FileExist(myFile.getName());
                    } else {
                        Message.PermissionError();//Show a error message when the program don't permissions to write on the required directory.
                    }
                    return false;
                }
            } catch (IOException ex){
                Message.PermissionError();
                ex.printStackTrace();
                return false;
            }
    }

}
