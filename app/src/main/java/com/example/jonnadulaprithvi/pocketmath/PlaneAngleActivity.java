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

public class PlaneAngleActivity extends AppCompatActivity {

    private RadioGroup r1,r2;
    private RadioButton radio1,radio2;
    private Button button1,button2;
    private EditText editText1,editText2;
    DatabaseHelper db;
    String unit1,unit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane_angle);
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

                else if (unit1.equals("Degree") && unit2.equals("Gradian")) //Degree ->Gradian
                    editText2.setText(Double.toString(input * 1.11111));
                else if (unit1.equals("Degree") && unit2.equals("Milliradian")) //Degree ->Milliradian
                    editText2.setText(Double.toString(input * 17.4533));
                else if (unit1.equals("Degree") && unit2.equals("Minutes of arc")) //Degree ->Minutes of arc
                    editText2.setText(Double.toString(input * 60));
                else if (unit1.equals("Degree") && unit2.equals("Radian")) //Degree ->Radian
                    editText2.setText(Double.toString(input * 0.0174533));
                else if (unit1.equals("Degree") && unit2.equals("Seconds of arc")) //Degree ->Seconds of arc
                    editText2.setText(Double.toString(input * 3600));

                else if (unit1.equals("Gradian") && unit2.equals("Degree")) //Gradian ->Degree
                    editText2.setText(Double.toString(input * 0.9));
                else if (unit1.equals("Gradian") && unit2.equals("Milliradian")) //Gradian ->Milliradian
                    editText2.setText(Double.toString(input * 15.708));
                else if (unit1.equals("Gradian") && unit2.equals("Minutes of arc")) //Gradian ->Minutes of arc
                    editText2.setText(Double.toString(input * 54));
                else if (unit1.equals("Gradian") && unit2.equals("Radian")) //Gradian ->Radian
                    editText2.setText(Double.toString(input * 0.015708));
                else if (unit1.equals("Gradian") && unit2.equals("Seconds of arc")) //Gradian ->Seconds of arc
                    editText2.setText(Double.toString(input * 3240));

                else if (unit1.equals("Milliradian") && unit2.equals("Degree")) //Milliradian ->Degree
                    editText2.setText(Double.toString(input * 0.0572958));
                else if (unit1.equals("Milliradian") && unit2.equals("Gradian")) //Milliradian ->Gradian
                    editText2.setText(Double.toString(input * 0.063662));
                else if (unit1.equals("Milliradian") && unit2.equals("Minutes of arc")) //Milliradian ->Minutes of arc
                    editText2.setText(Double.toString(input * 3.43775));
                else if (unit1.equals("Milliradian") && unit2.equals("Radian")) //Milliradian ->Radian
                    editText2.setText(Double.toString(input * 0.001));
                else if (unit1.equals("Milliradian") && unit2.equals("Seconds of arc")) //Milliradian ->Seconds of arc
                    editText2.setText(Double.toString(input * 206.265));

                else if (unit1.equals("Minutes of arc") && unit2.equals("Degree")) //Minutes of arc ->Degree
                    editText2.setText(Double.toString(input * 0.0166667));
                else if (unit1.equals("Minutes of arc") && unit2.equals("Gradian")) //Minutes of arc ->Gradian
                    editText2.setText(Double.toString(input * 0.0185185));
                else if (unit1.equals("Minutes of arc") && unit2.equals("Milliradian")) //Minutes of arc ->Milliradian
                    editText2.setText(Double.toString(input * 0.290888));
                else if (unit1.equals("Minutes of arc") && unit2.equals("Radian")) //Minutes of arc ->Radian
                    editText2.setText(Double.toString(input * 0.000290888));
                else if (unit1.equals("Minutes of arc") && unit2.equals("Seconds of arc")) //Minutes of arc ->Seconds of arc
                    editText2.setText(Double.toString(input * 60));

                else if (unit1.equals("Radian") && unit2.equals("Degree")) //Radian ->Degree
                    editText2.setText(Double.toString(input * 57.2958));
                else if (unit1.equals("Radian") && unit2.equals("Gradian")) //Radian ->Gradian
                    editText2.setText(Double.toString(input * 63.662));
                else if (unit1.equals("Radian") && unit2.equals("Milliradian")) //Radian ->Milliradian
                    editText2.setText(Double.toString(input * 1000));
                else if (unit1.equals("Radian") && unit2.equals("Minutes of arc")) //Radian ->Minutes of arc
                    editText2.setText(Double.toString(input * 3437.75));
                else if (unit1.equals("Radian") && unit2.equals("Seconds of arc")) //Radian ->Seconds of arc
                    editText2.setText(Double.toString(input * 206265));

                else if (unit1.equals("Seconds of arc") && unit2.equals("Degree")) //Seconds of arc ->Degree
                    editText2.setText(Double.toString(input * 0.000277778));
                else if (unit1.equals("Seconds of arc") && unit2.equals("Gradian")) //Seconds of arc ->Gradian
                    editText2.setText(Double.toString(input * 0.000308642));
                else if (unit1.equals("Seconds of arc") && unit2.equals("Milliradian")) //Seconds of arc ->Milliradian
                    editText2.setText(Double.toString(input * 0.00484814));
                else if (unit1.equals("Seconds of arc") && unit2.equals("Minutes of arc")) //Seconds of arc ->Minutes of arc
                    editText2.setText(Double.toString(input * 0.0166667));
                else if (unit1.equals("Seconds of arc") && unit2.equals("Radian")) //Seconds of arc ->Radian
                    editText2.setText(Double.toString(input * 4.8481e-6));


                else
                    Toast.makeText(PlaneAngleActivity.this, "Select units to convert", Toast.LENGTH_SHORT).show();

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
                Intent myIntent = new Intent(PlaneAngleActivity.this, AboutUsActivity.class);
                PlaneAngleActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback:
                Intent myIntent1 = new Intent(PlaneAngleActivity.this, FeedbackActivity.class);
                PlaneAngleActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us:
                Intent myIntent2 = new Intent(PlaneAngleActivity.this, RateUsActivity.class);
                PlaneAngleActivity.this.startActivity(myIntent2);
                break;
            case R.id.history:
                Intent myIntent3 = new Intent(PlaneAngleActivity.this, HistoryConverterActivity.class);
                PlaneAngleActivity.this.startActivity(myIntent3);
                break;
            case R.id.home:
                Intent myIntent4 = new Intent(PlaneAngleActivity.this, MainActivity.class);
                PlaneAngleActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(PlaneAngleActivity.this, ConverterMainActivity.class);
        PlaneAngleActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }

}
