package com.example.fitnessapp;

public class HealthDetails {
    public static final String H_ID_PERSON = "ID";
    public static final String H_HEIGHT = "HEIGHT";
    public static final String H_WEIGHT = "WEIGHT";
    public static final String H_DATE_OF_RECORDING = "DATE_OF_RECORDING";

    public static final String CREATE_TABLE = "CREATE TABLE "+DatabaseDetails.H_TABLE_NAME+"( "
            +H_ID_PERSON+" INTEGER, "
            +H_HEIGHT+" TEXT, "
            +H_WEIGHT+" TEXT, "
            +H_DATE_OF_RECORDING+" TEXT, "
            +"FOREIGN KEY("+H_ID_PERSON+") REFERENCES "+DatabaseDetails.P_TABLE_NAME+"("+PersonalDetails.P_ID+")"
            +";";
}
