package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Objects;

public class AddDetails extends AppCompatActivity {


    MaterialButton btnSelectDate;
    MaterialButton btnSelectTime;
    MaterialButton btnAdd;
    TextInputEditText etTitle;
    TextInputEditText etDesc;
    String time,date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        btnSelectDate=findViewById(R.id.btnSelectDate);
        btnSelectTime=findViewById(R.id.btnSelectTime);
        btnAdd=findViewById(R.id.btnAdd);
        etTitle=findViewById(R.id.etTitle);
        etDesc = findViewById(R.id.etDesc);


        btnSelectDate.setOnClickListener(view -> {
            MaterialDatePicker<Long> datePicker =
                    MaterialDatePicker.Builder.datePicker()
                            .setTitleText("Select date")
                            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                            .build();


            datePicker.addOnPositiveButtonClickListener(selection -> {
                date=datePicker.getHeaderText();
                btnSelectDate.setText(date);
            });

            datePicker.show(getSupportFragmentManager(),"DATE_PICKER");
        });

        btnSelectTime.setOnClickListener(view -> {
            MaterialTimePicker picker =
                    new MaterialTimePicker.Builder()
                            .setTimeFormat(TimeFormat.CLOCK_12H)
                            .setHour(12)
                            .setMinute(10)
                            .setTitleText("Select time")
                            .build();

            picker.addOnPositiveButtonClickListener(view1 -> {
                String time = picker.getHour()+" : "+picker.getMinute();
                btnSelectTime.setText(time);
                this.time=time;
            });

            picker.show(getSupportFragmentManager(),"TIME_PICKER");
        });

        btnAdd.setOnClickListener(view -> {
            Intent intent = new Intent(this,AddedItemsActivity.class);
            String title , desc;
            title  = Objects.requireNonNull(etTitle.getText()).toString();
            desc = Objects.requireNonNull(etDesc.getText()).toString();
            intent.putExtra("EXTRA_TITLE",title);
            intent.putExtra("EXTRA_DESC",desc);
            intent.putExtra("EXTRA_TIME",time);
            intent.putExtra("EXTRA_DATE",date);

            startActivity(intent);
        });

    }
}