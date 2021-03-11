package com.company;

//Class Message - Message to introduce some actions, present options to the user or to request some user input.
public class Message {

    //Separator to messages.
    public static void DivStart() {
        System.out.println("***********************************************");
    }

    public static void DivEnd() {
        System.out.println("***********************************************\n");
    }


    //Greetings and goodbye message.
    public static void WelcomeMessage() {
        Message.DivStart();
        System.out.println(
                "*                                             *\n" +
                "*                  CRUD-5413                  *\n" +
                "*                                             *\n" +
                "* Client account manager software  written....*\n" +
                "*              ...in Java with love           *\n" +
                "* A simple CRUD CLI app to POO study purposes *\n" +
                "*                                             *\n" +
                "*                   WELCOME!                  *");
        Message.DivEnd();
    }

    public static void GoodbyeMessage() {
        Message.DivStart();
        System.out.println("*           Goodbye. Thank you Sir!           *");
        Message.DivEnd();
    }


    //Main menu.
    public static void MainMenu() {
        Message.DivStart();
        System.out.println(
                "*  Please choose one of the options below:    *\n" +
                "*                                             *\n" +
                "*      [0] Show welcome message               *\n" +
                "*      [1] List active Clients                *\n" +
                "*      [2] List inactive Clients              *\n" +
                "*      [3] List all Clients                   *\n" +
                "*      [4] Add Clients                        *\n" +
                "*      [5] Enable/Disable Clients             *\n" +
                "*      [6] Modify Clients data                *\n" +
                "*      [7] Check Client account information   *\n" +
                "*      [8] Add Client income value            *\n" +
                "*      [9] Add Client credit value            *\n" +
                "*     [10] Show simplified list of Clients    *\n" +
                "*     [11] Show Clients file - Current        *\n" +
                "*     [12] Show Clients file - Session Backup *\n" +
                "*     [13] Show Clients file - Auto Backup    *\n" +
                "*     [14] Restore to session Backup          *\n" +
                "*     [15] Restore to last Auto Backup        *\n" +
                "*     [16] Quit                               *\n" +
                "*                                             *");
        Message.DivEnd();
    }


    //Client info message.
    public static void ActiveClient() {
        Message.DivStart();
        System.out.println("*            List of active clients:          *");
        Message.DivEnd();
    }

    public static void InactiveClient() {
        Message.DivStart();
        System.out.println("*          List of inactive clients:          *");
        Message.DivEnd();
    }

    public static void SelectedClient(int clientNumber) {
        Message.DivStart();
        System.out.println("* You have selected the Client number "+clientNumber+"       *");
        Message.DivEnd();
    }

    public static void NumberClientShow(int sizeArrayClient) {
        Message.DivStart();
        System.out.println("*         The Program load "+sizeArrayClient+" clients         *");
        Message.DivEnd();
    }


    //Edit Client message.
    public static void EditClientIntro(String field, int clientId) {
        Message.DivStart();
        System.out.println("Edition to " + field + ": [" + clientId + "]");
        Message.DivEnd();
    }

    public static void EditMessage() {
        Message.DivStart();
        System.out.println(
                        "*  To don't change data leave the field blank *\n" +
                        "*      Confirm your inputs with [ENTER].      *\n" +
                        "* If you do some mistake you can edit it later*");
        Message.DivEnd();
    }


    //Create Client message.
    public static void CreateMessage() {
        Message.DivStart();
        System.out.println(
                        "*      Confirm your inputs with [ENTER].      *\n" +
                        "* If you do some mistake you can edit it later*");
        Message.DivEnd();
    }

    public static void EditClientInput(String field) {
        System.out.println(" > Introduce input to edit [" +  field + "]");
    }

    public static void EditClientStore(String field, int clientInfo, int mod) {
        if (mod==1){
            System.out.println("[STORED DATA]: " + field + clientInfo);
        } else{
            System.out.println("[ACTUAL DATA]: " + field + clientInfo + "\n\n");
        }
    }

    public static void EditClientStore(String field, String clientInfo, int mod) {
        if (mod==1){
            System.out.println("[STORED DATA]: " + field + clientInfo);
        } else{
            System.out.println("[ACTUAL DATA]: " + field + clientInfo + "\n\n");
        }
    }

    public static void EditClientStore(String field, Double clientInfo, int mod) {
        if (mod==1){
            System.out.println("[STORED DATA]: " + field + clientInfo);
        } else{
            System.out.println("[ACTUAL DATA]: " + field + clientInfo + "\n\n");
        }
    }


    // Modify Client message
    public static void ModifyClient(int lim, int mainMenuParameter) {
        Message.DivStart();
        System.out.println("*      Choose a client between 1 and "+lim+"       *");
        switch (mainMenuParameter) {
            case 5:
            case 6:
                System.out.println("*  Introduce the number of the client to edit *");
                break;
            case 7:
                System.out.println(
                        "* Introduce the Client number to check the    *\n" +
                        "* account information (profile and movements) *");
                break;
            case 8:
               System.out.println(
                        "* Introduce the Client number to register     *\n" +
                        "* income movement to the account log          *");
                break;
            case 9:
                System.out.println(
                        "* Introduce the Client number to register     *\n" +
                        "* credit movement to the account log          *");
                break;
            default:
                break;
        }
        Message.DivEnd();
    }


    //Movement message.
    public static void RegisterMovement(int mainMenuParameter) {
        Message.DivStart();
        if (mainMenuParameter==8){
            System.out.println(
                        "* Please introduce the income value to        *\n" +
                        "* to register (unsigned numbers, IA handle it)*");
        }
        else{
            System.out.println(
                    "* Please introduce the credit value to        *\n" +
                    "* to register (unsigned numbers, IA handle it)*");
        }
        Message.DivEnd();
    }

    public static void AccountInformation() {
        Message.DivStart();
        System.out.println(
                "*            Account information              *\n" +
                        "*      Profile and financial information      *");
        Message.DivEnd();
    }

    public static void SimpleAccountInformationHeader() {
        System.out.println("nº ->  Client Name (Maximum credit)");
    }


    //Error message.
    public static void AccessError() {
        Message.DivStart();
        System.out.println("*  Can't access file with Client information! *");
        Message.DivEnd();
    }

    public static void ClientListVoid() {
        Message.DivStart();
        System.out.println("*        There are no clients available       *");
        Message.DivEnd();
    }

    public static void DataError() {
        Message.DivStart();
        System.out.println(
                "*      Cannot read Client information...      *\n" +
                "*      ...Check the source file data          *");
        Message.DivEnd();
    }

    public static void InvalidInputMain() {
        Message.DivStart();
        System.out.println(
                "*      You introduce a incorrect input.       *\n" +
                "*               Please try again!             *");
        Message.DivEnd();
    }

    public static void InvalidInputMovement() {
        Message.DivStart();
        System.out.println(
                        "*      You introduce a incorrect input.       *\n" +
                        "*           Please try again later!           *");
        Message.DivEnd();
    }

    public static void InvalidInput() {
        Message.DivStart();
        System.out.println(
                "*      You introduce a incorrect input.       *\n" +
                "*  Edit it later in Main Menu->Modify Client  *");
        Message.DivEnd();
    }

    public static void PermissionError() {
        Message.DivStart();
        System.out.println(
                "*      Cannot access the required files!      *\n" +
                "*      Higher permission level required!      *\n" +
                "*      Please contact System Administrator.   *");
        Message.DivEnd();
    }


    //File message.
    public static void SaveChange() {
        Message.DivStart();
        System.out.println(
                "* Press [y] to save changes to the Database   *\n" +
                        "*      Press other key do discard changes     *");
        Message.DivEnd();
    }

    public static void SaveSuccess() {
        Message.DivStart();
        System.out.println("*     Client information saved with success    *");
        Message.DivEnd();
    }

    public static void FileNotExist(String path) {
        Message.DivStart();
        System.out.println(
                "* The file "+path+" don't exist!...           *\n" +
                        "* ...generating file...]                      *\n" +
                        "* ...the file was generated with success...   *\n" +
                        "*                   WELCOME!                  *");
        Message.DivEnd();
    }

    public static void FileExist(String path) {
        Message.DivStart();
        System.out.println("*         The file "+path+" exist!         *");
        Message.DivEnd();
    }

    public static void FileLoadSuccess() {
        Message.DivStart();
        System.out.println("*    Client information loaded with success    *");
        Message.DivEnd();
    }

    //Backup message.
    public static void RestoreBackup(int mainMenuParameter) {
        Message.DivStart();
        if (mainMenuParameter==14){
            System.out.println(
                            "*   Press [y] to restore Clients file to the  *\n" +
                            "*   version saved when you star this session  *\n" +
                            "*      Press other key do cancel procedure    *");
        } else{
            System.out.println(
                            "*   Press [y] to restore Clients file to the  *\n" +
                            "*   version saved automatically per data edit *\n" +
                            "*      Press other key do cancel procedure    *");
        }
        Message.DivEnd();
    }

    public static void AutoBackupSuccess() {
        Message.DivStart();
        System.out.println("*      Auto Backup created with success       *");
        Message.DivEnd();
    }


    public static void BackupSuccess() {
        Message.DivStart();
        System.out.println("*   This session Backup created with success   *");
        Message.DivEnd();
    }

}
