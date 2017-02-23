package com.example.jonnadulaprithvi.pocketmath;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PressureActivity extends AppCompatActivity {


    private RadioGroup r1,r2;
    private RadioButton radio1,radio2;
    private Button button1,button2;
    private EditText editText1,editText2;
    DatabaseHelper db;
    String unit1,unit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        db=new DatabaseHelper(this);
        onConvertClick();
    }
    private void onConvertClick() {
        r1=(RadioGroup)findViewById(R.id.group1);
        r2=(RadioGroup)findViewById(R.id.group2);
        button1=(Button)findViewById(R.id.button);
        editText1=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat d=new SimpleDateFormat("HH:mm");
                String time= String.valueOf(d.format(c.getTime()));
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy");
                String date = df.format(c.getTime());
                int selected1 = r1.getCheckedRadioButtonId();
                int selected2 = r2.getCheckedRadioButtonId();
                radio1 = (RadioButton) findViewById(selected1);
                radio2 = (RadioButton) findViewById(selected2);
                String unit1 = radio1.getText().toString();
                String unit2 = radio2.getText().toString();
                double input = Double.valueOf(editText1.getText().toString());
                if (unit1.equals(unit2))
                    editText2.setText(Double.toString(input));

                else if (unit1.equals("Atmosphere") && unit2.equals("Bar")) //Atmosphere ->Bar
                    editText2.setText(Double.toString(input * 1.01325));
                else if (unit1.equals("Atmosphere") && unit2.equals("Pascal")) //Atmosphere ->Pascal
                    editText2.setText(Double.toString(input * 101325));
                else if (unit1.equals("Atmosphere") && unit2.equals("Torr")) //Atmosphere ->Torr
                    editText2.setText(Double.toString(input * 760));

                else if (unit1.equals("Bar") && unit2.equals("Atmosphere")) //Bar ->Atmosphere
                    editText2.setText(Double.toString(input * 0.986923));
                else if (unit1.equals("Bar") && unit2.equals("Pascal")) //Bar ->Pascal
                    editText2.setText(Double.toString(input * 100000));
                else if (unit1.equals("Bar") && unit2.equals("Torr")) //Bar ->Torr
                    editText2.setText(Double.toString(input * 750.062));

                else if (unit1.equals("Pascal") && unit2.equals("Atmosphere")) //Pascal ->Atmosphere
                    editText2.setText(Double.toString(input * 9.8692e-6));
                else if (unit1.equals("Pascal") && unit2.equals("Bar")) //Pascal ->Bar
                    editText2.setText(Double.toString(input * 1e-5));
                else if (unit1.equals("Pascal") && unit2.equals("Torr")) //Pascal ->Torr
                    editText2.setText(Double.toString(input * 0.00750062));

                else if (unit1.equals("Torr") && unit2.equals("Atmosphere")) //Torr ->Atmosphere
                    editText2.setText(Double.toString(input * 0.00131579));
                else if (unit1.equals("Torr") && unit2.equals("Bar")) //Torr ->Bar
                    editText2.setText(Double.toString(input * 0.00133322));
                else if (unit1.equals("Torr") && unit2.equals("Pascal")) //Torr ->Pascal
                    editText2.setText(Double.toString(input * 133.322));
                

                else
                    Toast.makeText(PressureActivity.this, "Select units to convert", Toast.LENGTH_SHORT).show();

                if (db.insertHistory(date,time,unit1, editText1.getText().toString(), unit2, editText2.getText().toString()));


            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.about_us:
                Intent myIntent = new Intent(PressureActivity.this, AboutUsActivity.class);
                PressureActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback:
                Intent myIntent1 = new Intent(PressureActivity.this, FeedbackActivity.class);
                PressureActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us:
                Intent myIntent2 = new Intent(PressureActivity.this, RateUsActivity.class);
                PressureActivity.this.startActivity(myIntent2);
                break;
            case R.id.history:
                Intent myIntent3 = new Intent(PressureActivity.this, HistoryConverterActivity.class);
                PressureActivity.this.startActivity(myIntent3);
                break;
            case R.id.home:
                Intent myIntent4 = new Intent(PressureActivity.this, MainActivity.class);
                PressureActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(PressureActivity.this, ConverterMainActivity.class);
        PressureActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }

}
