package sg.edu.rp.c346.id20014063.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    CheckBox smoking;
    Button confirm, reset;
    EditText name;
    EditText phone;
    EditText size;
    DatePicker date;
    TimePicker time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smoking = findViewById(R.id.checkBoxSmoking);
        confirm = findViewById(R.id.buttonconfirm);
        name = findViewById(R.id.editTextName);
        phone = findViewById(R.id.editTextPhone);
        size = findViewById(R.id.editTextSize);
        date = findViewById(R.id.datePicker);
        time = findViewById(R.id.timePicker);
        reset = findViewById(R.id.buttonReset);

        date.updateDate(2020,6,1);
        time.setCurrentHour(19);
        time.setCurrentMinute(30);

        smoking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Smoking zone selected",
                        Toast.LENGTH_SHORT).show();
            }
        });


        time.setIs24HourView(true);



        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || size.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Fill in the required field", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Name:" + name.getText() + " "
                            + " HP:" + phone.getText() + " Size:" + size.getText() + " " + " Date:"
                            + date.getDayOfMonth() + "/" + date.getMonth() + " Time:" +
                            time.getHour() + ":" + time.getMinute(), Toast.LENGTH_LONG).show();
                }

            }
        });

        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(time.getCurrentHour() > 8 && time.getCurrentHour() < 20){
                    Toast.makeText(MainActivity.this, "Time changed", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid time(Between 8AM to 8PM", Toast.LENGTH_SHORT).show();
                    time.setCurrentHour(19);
                    time.setCurrentMinute(30);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            name.setText("");
            phone.setText("");
            size.setText("");
            smoking.setChecked(false);
            date.updateDate(2020,6,1);
            time.setCurrentHour(19);
            time.setCurrentMinute(30);
            }
        });


    }
}