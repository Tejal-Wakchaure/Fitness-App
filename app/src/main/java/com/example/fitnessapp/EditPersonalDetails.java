package com.example.fitnessapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class EditPersonalDetails extends AppCompatActivity {

    ActionBar actionBar;
    private Button saveBt, setDBt;
    private String name, phone, gender, bdate;
    private EditText nameT, phoneT;

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView bdateT;
    private int year, month, day;

    private RadioGroup rg;
    private RadioButton rb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_personal_details);

        Intent intent = getIntent();


        actionBar = getSupportActionBar();
        actionBar.setTitle("Edit Personal Data");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        saveBt = findViewById(R.id.saveBt);
        nameT = findViewById(R.id.nameEt);
        phoneT = findViewById(R.id.phoneEt);
        bdateT = findViewById(R.id.brithDateEt);
        setDBt = findViewById(R.id.setBdateBt);
        bdateT = findViewById(R.id.brithDateEt);
        calendar = Calendar.getInstance();
        rg = findViewById(R.id.genderRg);


        setDBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(999);
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
            }
        });

        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameT.getText().toString();
                phone = phoneT.getText().toString();
                bdate = bdateT.getText().toString();

                int selected = rg.getCheckedRadioButtonId();
                rb = (RadioButton) findViewById(selected);
                gender = rb.getText().toString();

                Toast.makeText(getApplicationContext(), "Saved Successfully...", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    private void setDate(int year, int month, int day) {
        bdateT.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    setDate(arg1, arg2+1, arg3);
                }
            };

}