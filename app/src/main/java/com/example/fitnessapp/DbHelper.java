package com.example.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private String[] exercies = {"Standing Bicycle Crunches", "Leg Raises", "Bent Leg Twist", "Mountain Climber", "Side Lunges", "Frog Press", "Bottom Leg Lift Left", "Bottom Leg Lift Right", "Triceps Dips", "Wall Push-ups", "Knee Push-ups", "Up & Down Plank", "High Stepping", "Jumping Jacks", "Butt Bridge", "Russian Twist", "Wall Push-ups", "Arm Scissors", "Arm Circle Clockwise", "Triceps Stretch Left-Right", "Squats", "Backward Lunge", "Modified Burpees", "High Stepping"};
    private String[] workout = {};

    public DbHelper(@Nullable Context context) {
        super(context, DatabaseDetails.DATABASE_NAME, null, DatabaseDetails.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseDetails.PRGMA);
        db.execSQL(Exercises.CREATE_TABLE);
        db.execSQL(Workouts.CREATE_TABLE);
        db.execSQL(WorkoutsExcercises.CREATE_TABLE);
        db.execSQL(PersonalDetails.CREATE_TABLE);
        db.execSQL(HealthDetails.CREATE_TABLE);
        db.execSQL(DailyWorkoutDetails.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+DatabaseDetails.P_TABLE_NAME+";");

        onCreate(db);
    }

    public long insertPersonalDetails(String name, String password, String phone, String gender, String birthday, String countdown, String rest){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(PersonalDetails.P_NAME, name);
        contentValues.put(PersonalDetails.P_PASSWORD, password);
        contentValues.put(PersonalDetails.P_PHONE, phone);
        contentValues.put(PersonalDetails.P_GENDER, gender);
        contentValues.put(PersonalDetails.P_BIRTHDAY, birthday);
        contentValues.put(PersonalDetails.P_REST_TIME, rest);
        contentValues.put(PersonalDetails.P_COUNTDOWN_TIME, countdown);

        long id = db.insert(DatabaseDetails.P_TABLE_NAME, null, contentValues);
        db.close();
        return id;
    }

    public void insertHealthDetails(String id, String weight, String height, String date){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(HealthDetails.H_ID_PERSON, id);
        contentValues.put(HealthDetails.H_HEIGHT, height);
        contentValues.put(HealthDetails.H_WEIGHT, weight);
        contentValues.put(HealthDetails.H_DATE_OF_RECORDING, date);

        db.insert(DatabaseDetails.H_TABLE_NAME, null, contentValues);
        db.close();
    }

    public void updatePersonalDetails(String id, String rest, String name, String password, String phone, String gender, String birthday, String countdown){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(PersonalDetails.P_NAME, name);
        contentValues.put(PersonalDetails.P_PASSWORD, password);
        contentValues.put(PersonalDetails.P_PHONE, phone);
        contentValues.put(PersonalDetails.P_GENDER, gender);
        contentValues.put(PersonalDetails.P_BIRTHDAY, birthday);
        contentValues.put(PersonalDetails.P_REST_TIME, rest);
        contentValues.put(PersonalDetails.P_COUNTDOWN_TIME, countdown);

        db.update(DatabaseDetails.P_TABLE_NAME, contentValues, PersonalDetails.P_ID+" =? ", new String[]{id});
        db.close();
    }

    public void updateHealthDetails(String id, String height, String weight, String date){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(HealthDetails.H_HEIGHT, height);
        contentValues.put(HealthDetails.H_WEIGHT, weight);
        contentValues.put(HealthDetails.H_DATE_OF_RECORDING, date);

        db.update(DatabaseDetails.H_TABLE_NAME, contentValues, HealthDetails.H_ID_PERSON+" =? ", new String[]{id});
        db.close();
    }

    public void insertExercises(String name, String count, String info){

    }
}
