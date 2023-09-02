package com.example.fitnessapp;

public class DailyWorkoutDetails {
    public static final String D_PERSON = "PERSON";
    public static final String D_WORKOUT = "WORKOUT";
    public static final String D_EXERCISE = "EXERCISE";
    public static final String D_COUNT = "COUNT";
    public static final String D_DATE = "DATE";

    public static final String CREATE_TABLE = "CREATE TABLE "+DatabaseDetails.D_TABLE_NAME+"( "
            +D_PERSON+" INTEGER, "
            +D_WORKOUT+" INTEGER, "
            +D_EXERCISE+" INTEGER, "
            +D_COUNT+" INTEGER, "
            +D_DATE+" TEXT, "
            +"FOREIGN KEY("+D_PERSON+") REFERENCES "+DatabaseDetails.P_TABLE_NAME+"("+PersonalDetails.P_ID+"), "
            +"FOREIGN KEY("+D_WORKOUT+") REFERENCES "+DatabaseDetails.W_TABLE_NAME+"("+Workouts.W_ID+"), "
            +"FOREIGN KEY("+D_EXERCISE+") REFERENCES "+DatabaseDetails.E_TABLE_NAME+"("+Exercises.E_ID+")"
            +";";
}
