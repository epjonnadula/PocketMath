package com.example.jonnadulaprithvi.pocketmath;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AreaActivity extends AppCompatActivity {

    private RadioGroup r1,r2;
    private RadioButton radio1,radio2;
    private Button button1,button2;
    private EditText editText1,editText2;
    DatabaseHelper db;
    String unit1,unit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
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

                else if (unit1.equals("Sq KM") && unit2.equals("Sq M")) //Sq Km ->Sq M
                    editText2.setText(Double.toString(input * 1000000));
                else if (unit1.equals("Sq KM") && unit2.equals("Sq Mile")) //Sq Km ->Sq Mile
                    editText2.setText(Double.toString(input * 0.386102));
                else if (unit1.equals("Sq KM") && unit2.equals("Sq Yard")) //Sq Km ->Sq Yard
                    editText2.setText(Double.toString(input * 1195989.555203648));
                else if (unit1.equals("Sq KM") && unit2.equals("Sq Foot")) //Sq Km ->Sq Foot
                    editText2.setText(Double.toString(input * 1.076e+7));
                else if (unit1.equals("Sq KM") && unit2.equals("Sq Inch")) //Sq Km ->Sq Inch
                    editText2.setText(Double.toString(input * 1549440000));
                else if (unit1.equals("Sq KM") && unit2.equals("Hectare")) //Sq Km ->Hectare
                    editText2.setText(Double.toString(input * 100));
                else if (unit1.equals("Sq KM") && unit2.equals("Acre")) //Sq Km ->Acre
                    editText2.setText(Double.toString(input * 247.105));

                else if (unit1.equals("Sq M") && unit2.equals("Sq KM")) //Sq M ->Sq KM
                    editText2.setText(Double.toString(input * 1e-6));
                else if (unit1.equals("Sq M") && unit2.equals("Sq Mile")) //Sq M ->Sq Mile
                    editText2.setText(Double.toString(input * 3.861e-7));
                else if (unit1.equals("Sq M") && unit2.equals("Sq Yard")) //Sq M ->Sq Yard
                    editText2.setText(Double.toString(input * 1.195983360717));
                else if (unit1.equals("Sq M") && unit2.equals("Sq Foot")) //Sq M ->Sq Foot
                    editText2.setText(Double.toString(input * 10.763850246452999926));
                else if (unit1.equals("Sq M") && unit2.equals("Sq Inch")) //Sq M ->Sq Inch
                    editText2.setText(Double.toString(input * 1549.9944354892320462));
                else if (unit1.equals("Sq M") && unit2.equals("Hectare")) //Sq M ->Hectare
                    editText2.setText(Double.toString(input * 1e-4));
                else if (unit1.equals("Sq M") && unit2.equals("Acre")) //Sq M ->Acre
                    editText2.setText(Double.toString(input * 0.000247105));

                else if (unit1.equals("Sq Mile") && unit2.equals("Sq KM")) //Sq Mile ->Sq KM
                    editText2.setText(Double.toString(input * 2.58999));
                else if (unit1.equals("Sq Mile") && unit2.equals("Sq M")) //Sq Mile ->Sq M
                    editText2.setText(Double.toString(input * 2.59e+6));
                else if (unit1.equals("Sq Mile") && unit2.equals("Sq Yard")) //Sq Mile ->Sq Yard
                    editText2.setText(Double.toString(input * 3097614.2210816));
                else if (unit1.equals("Sq Mile") && unit2.equals("Sq Foot")) //Sq Mile ->Sq Foot
                    editText2.setText(Double.toString(input * 27878527.989734400064));
                else if (unit1.equals("Sq Mile") && unit2.equals("Sq Inch")) //Sq Mile ->Sq Inch
                    editText2.setText(Double.toString(input * 4014508030.521753788));
                else if (unit1.equals("Sq Mile") && unit2.equals("Hectare")) //Sq Mile ->Hectare
                    editText2.setText(Double.toString(input * 258.999));
                else if (unit1.equals("Sq Mile") && unit2.equals("Acre")) //Sq Mile ->Acre
                    editText2.setText(Double.toString(input * 640));

                else if (unit1.equals("Sq Yard") && unit2.equals("Sq KM")) //Sq Yard ->Sq KM
                    editText2.setText(Double.toString(input * 8.3613e-7));
                else if (unit1.equals("Sq Yard") && unit2.equals("Sq M")) //Sq Yard ->Sq M
                    editText2.setText(Double.toString(input * 0.8361300021625));
                else if (unit1.equals("Sq Yard") && unit2.equals("Sq Mile")) //Sq Yard ->Sq Mile
                    editText2.setText(Double.toString(input * 3.2283e-7));
                else if (unit1.equals("Sq Yard") && unit2.equals("Sq Foot")) //Sq Yard ->Sq Foot
                    editText2.setText(Double.toString(input * 9));
                else if (unit1.equals("Sq Yard") && unit2.equals("Sq Inch")) //Sq Yard ->Sq Inch
                    editText2.setText(Double.toString(input * 1296));
                else if (unit1.equals("Sq Yard") && unit2.equals("Hectare")) //Sq Yard ->Hectare
                    editText2.setText(Double.toString(input * 8.3613e-5));
                else if (unit1.equals("Sq Yard") && unit2.equals("Acre")) //Sq Yard ->Acre
                    editText2.setText(Double.toString(input * 0.000206612));

                else if (unit1.equals("Sq Foot") && unit2.equals("Sq KM")) //Sq Foot ->Sq KM
                    editText2.setText(Double.toString(input * 9.2903e-8));
                else if (unit1.equals("Sq Foot") && unit2.equals("Sq M")) //Sq Foot ->Sq M
                    editText2.setText(Double.toString(input * 0.092903));
                else if (unit1.equals("Sq Foot") && unit2.equals("Sq Mile")) //Sq Foot ->Sq Mile
                    editText2.setText(Double.toString(input * 3.587e-8));
                else if (unit1.equals("Sq Foot") && unit2.equals("Sq Yard")) //Sq Foot ->Sq Yard
                    editText2.setText(Double.toString(input * 0.111111));
                else if (unit1.equals("Sq Foot") && unit2.equals("Sq Inch")) //Sq Foot ->Sq Inch
                    editText2.setText(Double.toString(input * 144));
                else if (unit1.equals("Sq Foot") && unit2.equals("Hectare")) //Sq Foot ->Hectare
                    editText2.setText(Double.toString(input * 9.2903e-6));
                else if (unit1.equals("Sq Foot") && unit2.equals("Acre")) //Sq Foot ->Acre
                    editText2.setText(Double.toString(input * 2.2957e-5));

                else if (unit1.equals("Sq Inch") && unit2.equals("Sq KM")) //Sq Inch ->Sq KM
                    editText2.setText(Double.toString(input * 6.45164464507e-10));
                else if (unit1.equals("Sq Inch") && unit2.equals("Sq M")) //Sq Inch ->Sq M
                    editText2.setText(Double.toString(input * 0.0006451644645069999672));
                else if (unit1.equals("Sq Inch") && unit2.equals("Sq Mile")) //Sq Inch ->Sq Mile
                    editText2.setText(Double.toString(input * 2.49099392361033844e-10));
                else if (unit1.equals("Sq Inch") && unit2.equals("Sq Yard")) //Sq Inch ->Sq Yard
                    editText2.setText(Double.toString(input * 0.00077161027777753832344));
                else if (unit1.equals("Sq Inch") && unit2.equals("Sq Foot")) //Sq Inch ->Sq Foot
                    editText2.setText(Double.toString(input * 0.0069444924999978443689));
                else if (unit1.equals("Sq Inch") && unit2.equals("Hectare")) //Sq Inch ->Hectare
                    editText2.setText(Double.toString(input * 6.451644645069998109e-8));
                else if (unit1.equals("Sq Inch") && unit2.equals("Acre")) //Sq Inch ->Acre
                    editText2.setText(Double.toString(input * 1.594236111110616138e-7));

                else if (unit1.equals("Hectare") && unit2.equals("Sq KM")) //Hectare ->Sq KM
                    editText2.setText(Double.toString(input * 0.01));
                else if (unit1.equals("Hectare") && unit2.equals("Sq M")) //Hectare ->Sq M
                    editText2.setText(Double.toString(input * 10000));
                else if (unit1.equals("Hectare") && unit2.equals("Sq Mile")) //Hectare ->Sq Mile
                    editText2.setText(Double.toString(input * 0.00386102));
                else if (unit1.equals("Hectare") && unit2.equals("Sq Yard")) //Hectare ->Sq Yard
                    editText2.setText(Double.toString(input * 11959.9));
                else if (unit1.equals("Hectare") && unit2.equals("Sq Foot")) //Hectare ->Sq Foot
                    editText2.setText(Double.toString(input * 107639));
                else if (unit1.equals("Hectare") && unit2.equals("Sq Inch")) //Hectare ->Sq Inch
                    editText2.setText(Double.toString(input * 15500015.996032));
                else if (unit1.equals("Hectare") && unit2.equals("Acre")) //Hectare ->Acre
                    editText2.setText(Double.toString(input * 2.47105));

                else if (unit1.equals("Acre") && unit2.equals("Sq KM")) //Acre ->Sq KM
                    editText2.setText(Double.toString(input * 0.00404686));
                else if (unit1.equals("Acre") && unit2.equals("Sq M")) //Acre ->Sq M
                    editText2.setText(Double.toString(input * 4046.86));
                else if (unit1.equals("Acre") && unit2.equals("Sq Mile")) //Acre ->Sq Mile
                    editText2.setText(Double.toString(input * 0.00156250138125));
                else if (unit1.equals("Acre") && unit2.equals("Sq Yard")) //Acre ->Sq Yard
                    editText2.setText(Double.toString(input * 4840));
                else if (unit1.equals("Acre") && unit2.equals("Sq Foot")) //Acre ->Sq Foot
                    editText2.setText(Double.toString(input * 43560));
                else if (unit1.equals("Acre") && unit2.equals("Sq Inch")) //Acre ->Sq Inch
                    editText2.setText(Double.toString(input * 6.273e+6));
                else if (unit1.equals("Acre") && unit2.equals("Hectare")) //Acre ->Hectare
                    editText2.setText(Double.toString(input * 0.404686));

                else
                    Toast.makeText(AreaActivity.this, "Select units to convert", Toast.LENGTH_SHORT).show();

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
                Intent myIntent = new Intent(AreaActivity.this, AboutUsActivity.class);
                AreaActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback:
                Intent myIntent1 = new Intent(AreaActivity.this, FeedbackActivity.class);
                AreaActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us:
                Intent myIntent2 = new Intent(AreaActivity.this, RateUsActivity.class);
                AreaActivity.this.startActivity(myIntent2);
                break;
            case R.id.history:
                Intent myIntent3 = new Intent(AreaActivity.this, HistoryConverterActivity.class);
                AreaActivity.this.startActivity(myIntent3);
                break;
            case R.id.home:
                Intent myIntent4 = new Intent(AreaActivity.this, MainActivity.class);
                AreaActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(AreaActivity.this, ConverterMainActivity.class);
        AreaActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }

}
