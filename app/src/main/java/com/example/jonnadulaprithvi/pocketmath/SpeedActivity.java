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

public class SpeedActivity extends AppCompatActivity {
    private RadioGroup r1,r2;
    private RadioButton radio1,radio2;
    private Button button1,button2;
    private EditText editText1,editText2;
    DatabaseHelper db;
    String unit1,unit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
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

                else if (unit1.equals("Miles/Hour") && unit2.equals("Foot/Second")) //Miles/Hour -> Foot/Second
                    editText2.setText(Double.toString(input * 1.46667));
                else if (unit1.equals("Miles/Hour") && unit2.equals("Meter/Second")) //Miles/Hour -> Meter/Second
                    editText2.setText(Double.toString(input * 0.44704));
                else if (unit1.equals("Miles/Hour") && unit2.equals("Kilometer/Hour")) //Miles/Hour -> Kilometer/Hour
                    editText2.setText(Double.toString(input * 1.60934));
                else if (unit1.equals("Miles/Hour") && unit2.equals("Knot")) //Miles/Hour -> Knot
                    editText2.setText(Double.toString(input * 0.868976));

                else if (unit1.equals("Foot/Second") && unit2.equals("Miles/Hour")) //Foot/Second -> Miles/Hour
                    editText2.setText(Double.toString(input * 0.681818));
                else if (unit1.equals("Foot/Second") && unit2.equals("Meter/Second")) //Foot/Second -> Meter/Second
                    editText2.setText(Double.toString(input * 0.3048));
                else if (unit1.equals("Foot/Second") && unit2.equals("Kilometer/Hour")) //Foot/Second -> Kilometer/Hour
                    editText2.setText(Double.toString(input * 1.09728));
                else if (unit1.equals("Foot/Second") && unit2.equals("Knot")) //Foot/Second -> Knot
                    editText2.setText(Double.toString(input * 0.592484));

                else if (unit1.equals("Meter/Second") && unit2.equals("Miles/Hour")) //Meter/Second -> Miles/Hour
                    editText2.setText(Double.toString(input * 2.23694));
                else if (unit1.equals("Meter/Second") && unit2.equals("Foot/Second")) //Meter/Second -> Foot/Second
                    editText2.setText(Double.toString(input * 3.28084));
                else if (unit1.equals("Meter/Second") && unit2.equals("Kilometer/Hour")) //Meter/Second -> Kilometer/Hour
                    editText2.setText(Double.toString(input * 3.6));
                else if (unit1.equals("Meter/Second") && unit2.equals("Knot")) //Meter/Second -> Knot
                    editText2.setText(Double.toString(input * 1.94384));

                else if (unit1.equals("Kilometer/Hour") && unit2.equals("Miles/Hour")) //Kilometer/Hour -> Miles/Hour
                    editText2.setText(Double.toString(input * 0.621371));
                else if (unit1.equals("Kilometer/Hour") && unit2.equals("Foot/Second")) //Kilometer/Hour -> Foot/Second
                    editText2.setText(Double.toString(input * 0.911344));
                else if (unit1.equals("Kilometer/Hour") && unit2.equals("Meter/Second")) //Kilometer/Hour -> Meter/Second
                    editText2.setText(Double.toString(input * 0.277778));
                else if (unit1.equals("Kilometer/Hour") && unit2.equals("Knot")) //Kilometer/Hour -> Knot
                    editText2.setText(Double.toString(input * 0.539957));

                else if (unit1.equals("Knot") && unit2.equals("Miles/Hour")) //Knot -> Miles/Hour
                    editText2.setText(Double.toString(input * 1.15078));
                else if (unit1.equals("Knot") && unit2.equals("Foot/Second")) //Knot -> Foot/Second
                    editText2.setText(Double.toString(input * 1.68781));
                else if (unit1.equals("Knot") && unit2.equals("Meter/Second")) //Knot -> Meter/Second
                    editText2.setText(Double.toString(input * 0.514444));
                else if (unit1.equals("Knot") && unit2.equals("Kilometer/Hour")) //Knot -> Kilometer/Hour
                    editText2.setText(Double.toString(input * 1.852));

                else
                    Toast.makeText(SpeedActivity.this, "Select units to convert", Toast.LENGTH_SHORT).show();

                if (db.insertHistory(date,time,unit1, editText1.getText().toString(), unit2, editText2.getText().toString()))
                    ;
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
                Intent myIntent = new Intent(SpeedActivity.this, AboutUsActivity.class);
                SpeedActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback:
                Intent myIntent1 = new Intent(SpeedActivity.this, FeedbackActivity.class);
                SpeedActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us:
                Intent myIntent2 = new Intent(SpeedActivity.this, RateUsActivity.class);
                SpeedActivity.this.startActivity(myIntent2);
                break;
            case R.id.history:
                Intent myIntent3 = new Intent(SpeedActivity.this, HistoryConverterActivity.class);
                SpeedActivity.this.startActivity(myIntent3);
                break;
            case R.id.home:
                Intent myIntent4 = new Intent(SpeedActivity.this, MainActivity.class);
                SpeedActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(SpeedActivity.this, ConverterMainActivity.class);
        SpeedActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }
}
