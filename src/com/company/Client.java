package com.company;


//Class Client - The base structure of Client data, to be readed, processed and stored.
public class Client {

    //Attribute declaration
    private int clientNumber;
    private boolean clientState;
    private String clientName;
    private String clientAddress;
    private String clientLocation;
    private String clientZipCode;
    private String clientCounty;
    private String clientDistrict;
    private int clientTelephone;
    private String clientEmail;
    private int clientIdNumber;
    private int clientVatNumber;
    private double clientMaximumCredit;

    //Default constructor
    public Client() {
    }

    //Constructor
    public Client(
            int clientNumber,
            boolean clientState,
            String clientName,
            String clientAddress,
            String clientLocation,
            String clientZipCode,
            String clientCounty,
            String clientDistrict,
            int clientTelephone,
            String clientEmail,
            int clientIdNumber,
            int clientVatNumber,
            double clientMaximumCredit) {
                this.clientNumber=clientNumber;
                this.clientState=clientState;
                this.clientName=clientName;
                this.clientAddress=clientAddress;
                this.clientLocation=clientLocation;
                this.clientZipCode=clientZipCode;
                this.clientCounty=clientCounty;
                this.clientDistrict=clientDistrict;
                this.clientTelephone=clientTelephone;
                this.clientEmail=clientEmail;
                this.clientIdNumber=clientIdNumber;
                this.clientVatNumber=clientVatNumber;
                this.clientMaximumCredit=clientMaximumCredit;
            }

    //Get and Set to aloud reading and editing of data
    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public boolean getClientState() {
        return clientState;
    }

    public void setClientState(boolean clientState) {
        this.clientState = clientState;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientLocation() {
        return clientLocation;
    }

    public void setClientLocation(String clientLocation) {
        this.clientLocation = clientLocation;
    }

    public String getClientZipCode() {
        return clientZipCode;
    }

    public void setClientZipCode(String clientZipCode) {
        this.clientZipCode = clientZipCode;
    }

    public String getClientCounty() {
        return clientCounty;
    }

    public void setClientCounty(String clientCounty) {
        this.clientCounty = clientCounty;
    }

    public String getClientDistrict() {
        return clientDistrict;
    }

    public void setClientDistrict(String clientDistrict) {
        this.clientDistrict = clientDistrict;
    }

    public int getClientTelephone() {
        return clientTelephone;
    }

    public void setClientTelephone(int clientTelephone) {
        this.clientTelephone = clientTelephone;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public int getClientIdNumber() {
        return clientIdNumber;
    }

    public void setClientIdNumber(int clientIdNumber) {
        this.clientIdNumber = clientIdNumber;
    }

    public int getClientVatNumber() {
        return clientVatNumber;
    }

    public void setClientVatNumber(int clientVatNumber) {
        this.clientVatNumber = clientVatNumber;
    }

    public double getClientMaximumCredit() {
        return clientMaximumCredit;
    }

    public void setClientMaximumCredit(double clientMaximumCredit) {
        this.clientMaximumCredit = clientMaximumCredit;
    }
}

