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

public class TimeActivity extends AppCompatActivity {

    private RadioGroup r1,r2;
    private RadioButton radio1,radio2;
    private Button button1,button2;
    private EditText editText1,editText2;
    DatabaseHelper db;
    String unit1,unit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
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

                else if (unit1.equals("Second") && unit2.equals("Minute"))  //Second -> Minute
                    editText2.setText(Double.toString(input * 0.0166667));
                else if (unit1.equals("Second") && unit2.equals("Hour"))  //Second -> Hour
                    editText2.setText(Double.toString(input * 0.000277778));
                else if (unit1.equals("Second") && unit2.equals("Day"))  //Second -> Day
                    editText2.setText(Double.toString(input * 1.1574e-5));
                else if (unit1.equals("Second") && unit2.equals("Week"))  //Second -> Week
                    editText2.setText(Double.toString(input * 1.6534e-6));
                else if (unit1.equals("Second") && unit2.equals("Month"))  //Second -> Month
                    editText2.setText(Double.toString(input * 3.8052e-7));
                else if (unit1.equals("Second") && unit2.equals("Year"))  //Second -> Year
                    editText2.setText(Double.toString(input * 3.171e-8));
                else if (unit1.equals("Second") && unit2.equals("Decade"))  //Second -> Decade
                    editText2.setText(Double.toString(input * 3.171e-9));
                else if (unit1.equals("Second") && unit2.equals("Century"))  //Second -> Century
                    editText2.setText(Double.toString(input * 3.171e-10));


                else if (unit1.equals("Minute") && unit2.equals("Second"))  //Minute -> Second
                    editText2.setText(Double.toString(input * 60));
                else if (unit1.equals("Minute") && unit2.equals("Hour"))  //Minute -> Hour
                    editText2.setText(Double.toString(input * 0.0166667));
                else if (unit1.equals("Minute") && unit2.equals("Day"))  //Minute -> Day
                    editText2.setText(Double.toString(input * 0.000694444));
                else if (unit1.equals("Minute") && unit2.equals("Week"))  //Minute -> Week
                    editText2.setText(Double.toString(input * 9.9206e-5));
                else if (unit1.equals("Minute") && unit2.equals("Month"))  //Minute -> Month
                    editText2.setText(Double.toString(input * 2.2831e-5));
                else if (unit1.equals("Minute") && unit2.equals("Year"))  //Minute -> Year
                    editText2.setText(Double.toString(input * 1.9026e-6));
                else if (unit1.equals("Minute") && unit2.equals("Decade"))  //Minute -> Decade
                    editText2.setText(Double.toString(input * 1.9026e-7));
                else if (unit1.equals("Minute") && unit2.equals("Century"))  //Minute -> Century
                    editText2.setText(Double.toString(input * 1.9026e-8));


                else if (unit1.equals("Hour") && unit2.equals("Second"))  //Hour -> Second
                    editText2.setText(Double.toString(input * 3600));
                else if (unit1.equals("Hour") && unit2.equals("Minute"))  //Hour -> Minute
                    editText2.setText(Double.toString(input * 60));
                else if (unit1.equals("Hour") && unit2.equals("Day"))  //Hour -> Day
                    editText2.setText(Double.toString(input * 0.0416667));
                else if (unit1.equals("Hour") && unit2.equals("Week"))  //Hour -> Week
                    editText2.setText(Double.toString(input * 0.00595238));
                else if (unit1.equals("Hour") && unit2.equals("Month"))  //Hour -> Month
                    editText2.setText(Double.toString(input * 0.00136986));
                else if (unit1.equals("Hour") && unit2.equals("Year"))  //Hour -> Year
                    editText2.setText(Double.toString(input * 0.000114155));
                else if (unit1.equals("Hour") && unit2.equals("Decade"))  //Hour -> Decade
                    editText2.setText(Double.toString(input * 1.1416e-5));
                else if (unit1.equals("Hour") && unit2.equals("Century"))  //Hour -> Century
                    editText2.setText(Double.toString(input * 1.1416e-6));


                else if (unit1.equals("Day") && unit2.equals("Second"))  //Day -> Second
                    editText2.setText(Double.toString(input * 86400));
                else if (unit1.equals("Day") && unit2.equals("Minute"))  //Day -> Minute
                    editText2.setText(Double.toString(input * 1440));
                else if (unit1.equals("Day") && unit2.equals("Hour"))  //Day -> Hour
                    editText2.setText(Double.toString(input * 24));
                else if (unit1.equals("Day") && unit2.equals("Week"))  //Day -> Week
                    editText2.setText(Double.toString(input * 0.142857));
                else if (unit1.equals("Day") && unit2.equals("Month"))  //Day -> Month
                    editText2.setText(Double.toString(input * 0.0328767));
                else if (unit1.equals("Day") && unit2.equals("Year"))  //Day -> Year
                    editText2.setText(Double.toString(input * 0.00273973));
                else if (unit1.equals("Day") && unit2.equals("Decade"))  //Day -> Decade
                    editText2.setText(Double.toString(input * 0.000273973));
                else if (unit1.equals("Day") && unit2.equals("Century"))  //Day -> Century
                    editText2.setText(Double.toString(input * 2.7397e-5));


                else if (unit1.equals("Week") && unit2.equals("Second"))  //Week -> Second
                    editText2.setText(Double.toString(input * 604800));
                else if (unit1.equals("Week") && unit2.equals("Minute"))  //Week -> Minute
                    editText2.setText(Double.toString(input * 10080));
                else if (unit1.equals("Week") && unit2.equals("Hour"))  //Week -> Hour
                    editText2.setText(Double.toString(input * 168));
                else if (unit1.equals("Week") && unit2.equals("Day"))  //Week -> Day
                    editText2.setText(Double.toString(input * 7));
                else if (unit1.equals("Week") && unit2.equals("Month"))  //Week -> Month
                    editText2.setText(Double.toString(input * 0.230137));
                else if (unit1.equals("Week") && unit2.equals("Year"))  //Week -> Year
                    editText2.setText(Double.toString(input * 0.0191781));
                else if (unit1.equals("Week") && unit2.equals("Decade"))  //Week -> Decade
                    editText2.setText(Double.toString(input * 0.00191781));
                else if (unit1.equals("Week") && unit2.equals("Century"))  //Week -> Century
                    editText2.setText(Double.toString(input * 0.000191781));

                else if (unit1.equals("Month") && unit2.equals("Second"))  //Month -> Second
                    editText2.setText(Double.toString(input * 2.628e+6));
                else if (unit1.equals("Month") && unit2.equals("Minute"))  //Month -> Minute
                    editText2.setText(Double.toString(input * 43800));
                else if (unit1.equals("Month") && unit2.equals("Hour"))  //Month -> Hour
                    editText2.setText(Double.toString(input * 730.001));
                else if (unit1.equals("Month") && unit2.equals("Day"))  //Month -> Day
                    editText2.setText(Double.toString(input * 30.4167));
                else if (unit1.equals("Month") && unit2.equals("Week"))  //Month -> Week
                    editText2.setText(Double.toString(input * 4.34524));
                else if (unit1.equals("Month") && unit2.equals("Year"))  //Month -> Year
                    editText2.setText(Double.toString(input * 0.0833334));
                else if (unit1.equals("Month") && unit2.equals("Decade"))  //Month -> Decade
                    editText2.setText(Double.toString(input * 0.00833334));
                else if (unit1.equals("Month") && unit2.equals("Century"))  //Month -> Century
                    editText2.setText(Double.toString(input * 0.000833334));

                else if (unit1.equals("Year") && unit2.equals("Second"))  //Year -> Second
                    editText2.setText(Double.toString(input * 3.154e+7));
                else if (unit1.equals("Year") && unit2.equals("Minute"))  //Year -> Minute
                    editText2.setText(Double.toString(input * 525600));
                else if (unit1.equals("Year") && unit2.equals("Hour"))  //Year -> Hour
                    editText2.setText(Double.toString(input * 8760));
                else if (unit1.equals("Year") && unit2.equals("Day"))  //Year -> Day
                    editText2.setText(Double.toString(input * 365));
                else if (unit1.equals("Year") && unit2.equals("Week"))  //Year -> Week
                    editText2.setText(Double.toString(input * 52.1429));
                else if (unit1.equals("Year") && unit2.equals("Month"))  //Year -> Month
                    editText2.setText(Double.toString(input * 12));
                else if (unit1.equals("Year") && unit2.equals("Decade"))  //Year -> Decade
                    editText2.setText(Double.toString(input * 0.1));
                else if (unit1.equals("Year") && unit2.equals("Century"))  //Year -> Century
                    editText2.setText(Double.toString(input * 0.01));


                else if (unit1.equals("Decade") && unit2.equals("Second"))  //Decade -> Second
                    editText2.setText(Double.toString(input * 3.154e+8));
                else if (unit1.equals("Decade") && unit2.equals("Minute"))  //Decade -> Minute
                    editText2.setText(Double.toString(input * 5.256e+6));
                else if (unit1.equals("Decade") && unit2.equals("Hour"))  //Decade -> Hour
                    editText2.setText(Double.toString(input * 87600));
                else if (unit1.equals("Decade") && unit2.equals("Day"))  //Decade -> Day
                    editText2.setText(Double.toString(input * 3650));
                else if (unit1.equals("Decade") && unit2.equals("Week"))  //Decade -> Week
                    editText2.setText(Double.toString(input * 521.429));
                else if (unit1.equals("Decade") && unit2.equals("Month"))  //Decade -> Month
                    editText2.setText(Double.toString(input * 120));
                else if (unit1.equals("Decade") && unit2.equals("Year"))  //Decade -> Year
                    editText2.setText(Double.toString(input * 10));
                else if (unit1.equals("Decade") && unit2.equals("Century"))  //Decade -> Century
                    editText2.setText(Double.toString(input * 0.1));


                else if (unit1.equals("Century") && unit2.equals("Second"))  //Century -> Second
                    editText2.setText(Double.toString(input * 3.154e+9));
                else if (unit1.equals("Century") && unit2.equals("Minute"))  //Century -> Minute
                    editText2.setText(Double.toString(input * 5.256e+7));
                else if (unit1.equals("Century") && unit2.equals("Hour"))  //Century -> Hour
                    editText2.setText(Double.toString(input * 876000));
                else if (unit1.equals("Century") && unit2.equals("Day"))  //Century -> Day
                    editText2.setText(Double.toString(input * 36500));
                else if (unit1.equals("Century") && unit2.equals("Week"))  //Century -> Week
                    editText2.setText(Double.toString(input * 5214.29));
                else if (unit1.equals("Century") && unit2.equals("Month"))  //Century -> Month
                    editText2.setText(Double.toString(input * 1200));
                else if (unit1.equals("Century") && unit2.equals("Year"))  //Century -> Year
                    editText2.setText(Double.toString(input * 100));
                else if (unit1.equals("Century") && unit2.equals("Decade"))  //Century -> Decade
                    editText2.setText(Double.toString(input * 10));

                else
                    Toast.makeText(TimeActivity.this, "Select units to convert", Toast.LENGTH_SHORT).show();

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
                Intent myIntent = new Intent(TimeActivity.this, AboutUsActivity.class);
                TimeActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback:
                Intent myIntent1 = new Intent(TimeActivity.this, FeedbackActivity.class);
                TimeActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us:
                Intent myIntent2 = new Intent(TimeActivity.this, RateUsActivity.class);
                TimeActivity.this.startActivity(myIntent2);
                break;
            case R.id.history:
                Intent myIntent3 = new Intent(TimeActivity.this, HistoryConverterActivity.class);
                TimeActivity.this.startActivity(myIntent3);
                break;
            case R.id.home:
                Intent myIntent4 = new Intent(TimeActivity.this, MainActivity.class);
                TimeActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(TimeActivity.this, ConverterMainActivity.class);
        TimeActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }
}
