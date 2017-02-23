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

public class DigitalStorageActivity extends AppCompatActivity {

    private RadioGroup r1,r2;
    private RadioButton radio1,radio2;
    private Button button1,button2;
    private EditText editText1,editText2;
    String unit1,unit2;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_storage);
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

                else if (unit1.equals("Bit") && unit2.equals("Byte")) //Bit -> Byte
                    editText2.setText(Double.toString(input * 0.125));
                else if (unit1.equals("Bit") && unit2.equals("Kilobyte")) //Bit -> Kilobyte
                    editText2.setText(Double.toString(input * 0.0001220703125));
                else if (unit1.equals("Bit") && unit2.equals("Megabyte")) //Bit -> Megabyte
                    editText2.setText(Double.toString(input * 1.1920928955078E-7));
                else if (unit1.equals("Bit") && unit2.equals("Gigabyte")) //Bit -> Gigabyte
                    editText2.setText(Double.toString(input * 1.1641532182693E-10));
                else if (unit1.equals("Bit") && unit2.equals("Terabyte")) //Bit -> Terabyte
                    editText2.setText(Double.toString(input * 1.1368683772162E-13));
                else if (unit1.equals("Bit") && unit2.equals("Petabyte")) //Bit -> Petabyte
                    editText2.setText(Double.toString(input * 1.1102230246252E-16));


                else if (unit1.equals("Byte") && unit2.equals("Bit")) //Byte -> Bit
                    editText2.setText(Double.toString(input * 8));
                else if (unit1.equals("Byte") && unit2.equals("Kilobyte")) //Byte -> Kilobyte
                    editText2.setText(Double.toString(input * 0.0009765625));
                else if (unit1.equals("Byte") && unit2.equals("Megabyte")) //Byte -> Megabyte
                    editText2.setText(Double.toString(input * 9.5367431640625E-7));
                else if (unit1.equals("Byte") && unit2.equals("Gigabyte")) //Byte -> Gigabyte
                    editText2.setText(Double.toString(input * 9.3132257461548E-10));
                else if (unit1.equals("Byte") && unit2.equals("Terabyte")) //Byte -> Terabyte
                    editText2.setText(Double.toString(input * 9.0949470177293E-13));
                else if (unit1.equals("Byte") && unit2.equals("Petabyte")) //Byte -> Petabyte
                    editText2.setText(Double.toString(input * 8.8817841970013E-16));

                else if (unit1.equals("Kilobyte") && unit2.equals("Bit")) //Kilobyte -> Bit
                    editText2.setText(Double.toString(input * 8192));
                else if (unit1.equals("Kilobyte") && unit2.equals("Byte")) //Kilobyte -> Byte
                    editText2.setText(Double.toString(input * 1024));
                else if (unit1.equals("Kilobyte") && unit2.equals("Megabyte")) //Kilobyte -> Megabyte
                    editText2.setText(Double.toString(input * 0.0009765625));
                else if (unit1.equals("Kilobyte") && unit2.equals("Gigabyte")) //Kilobyte -> Gigabyte
                    editText2.setText(Double.toString(input * 9.5367431640625E-7));
                else if (unit1.equals("Kilobyte") && unit2.equals("Terabyte")) //Kilobyte -> Terabyte
                    editText2.setText(Double.toString(input * 9.3132257461548E-10));
                else if (unit1.equals("Kilobyte") && unit2.equals("Petabyte")) //Kilobyte -> Petabyte
                    editText2.setText(Double.toString(input * 9.0949470177293E-13));

                else if (unit1.equals("Megabyte") && unit2.equals("Bit")) //Megabyte -> Bit
                    editText2.setText(Double.toString(input * 8388608));
                else if (unit1.equals("Megabyte") && unit2.equals("Byte")) //Megabyte -> Byte
                    editText2.setText(Double.toString(input * 1048576));
                else if (unit1.equals("Megabyte") && unit2.equals("Kilobyte")) //Megabyte -> Kilobyte
                    editText2.setText(Double.toString(input * 1024));
                else if (unit1.equals("Megabyte") && unit2.equals("Gigabyte")) //Megabyte -> Gigabyte
                    editText2.setText(Double.toString(input * 0.0078125));
                else if (unit1.equals("Megabyte") && unit2.equals("Terabyte")) //Megabyte -> Terabyte
                    editText2.setText(Double.toString(input * 9.5367431640625E-7));
                else if (unit1.equals("Megabyte") && unit2.equals("Petabyte")) //Megabyte -> Petabyte
                    editText2.setText(Double.toString(input * 9.3132257461548E-10));

                else if (unit1.equals("Gigabyte") && unit2.equals("Bit")) //Gigabyte -> Bit
                    editText2.setText(Double.toString(input * 85.89934592E8));
                else if (unit1.equals("Gigabyte") && unit2.equals("Byte")) //Gigabyte -> Byte
                    editText2.setText(Double.toString(input * 1073741824));
                else if (unit1.equals("Gigabyte") && unit2.equals("Kilobyte")) //Gigabyte -> Kilobyte
                    editText2.setText(Double.toString(input * 1048576));
                else if (unit1.equals("Gigabyte") && unit2.equals("Megabyte")) //Gigabyte -> Megabyte
                    editText2.setText(Double.toString(input * 1024));
                else if (unit1.equals("Gigabyte") && unit2.equals("Terabyte")) //Gigabyte -> Terabyte
                    editText2.setText(Double.toString(input * 0.0078125));
                else if (unit1.equals("Gigabyte") && unit2.equals("Petabyte")) //Gigabyte -> Petabyte
                    editText2.setText(Double.toString(input * 7.62939453125E-6));

                else if (unit1.equals("Terabyte") && unit2.equals("Bit")) //Terabyte -> Bit
                    editText2.setText(Double.toString(input * 87.96093022208E11));
                else if (unit1.equals("Terabyte") && unit2.equals("Byte")) //Terabyte -> Byte
                    editText2.setText(Double.toString(input * 10.99511627776E11));
                else if (unit1.equals("Terabyte") && unit2.equals("Kilobyte")) //Terabyte -> Kilobyte
                    editText2.setText(Double.toString(input * 1073741824));
                else if (unit1.equals("Terabyte") && unit2.equals("Megabyte")) //Terabyte -> Megabyte
                    editText2.setText(Double.toString(input * 1048576));
                else if (unit1.equals("Terabyte") && unit2.equals("Gigabyte")) //Terabyte -> Gigabyte
                    editText2.setText(Double.toString(input * 1024));
                else if (unit1.equals("Terabyte") && unit2.equals("Petabyte")) //Terabyte -> Petabyte
                    editText2.setText(Double.toString(input * 0.0078125));

                else if (unit1.equals("Petabyte") && unit2.equals("Bit")) //Petabyte -> Bit
                    editText2.setText(Double.toString(input * 90.07199254740992E14));
                else if (unit1.equals("Petabyte") && unit2.equals("Byte")) //Petabyte -> Byte
                    editText2.setText(Double.toString(input * 11.25899906842624E14));
                else if (unit1.equals("Petabyte") && unit2.equals("Kilobyte")) //Petabyte -> Kilobyte
                    editText2.setText(Double.toString(input * 10.99511627776E11));
                else if (unit1.equals("Petabyte") && unit2.equals("Megabyte")) //Petabyte -> Megabyte
                    editText2.setText(Double.toString(input * 1073741824));
                else if (unit1.equals("Petabyte") && unit2.equals("Gigabyte")) //Petabyte -> Gigabyte
                    editText2.setText(Double.toString(input * 1048576));
                else if (unit1.equals("Petabyte") && unit2.equals("Terabyte")) //Petabyte -> Terabyte
                    editText2.setText(Double.toString(input * 8192));

                else
                    Toast.makeText(DigitalStorageActivity.this, "Select units to convert", Toast.LENGTH_SHORT).show();

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
                Intent myIntent = new Intent(DigitalStorageActivity.this, AboutUsActivity.class);
                DigitalStorageActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback:
                Intent myIntent1 = new Intent(DigitalStorageActivity.this, FeedbackActivity.class);
                DigitalStorageActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us:
                Intent myIntent2 = new Intent(DigitalStorageActivity.this, RateUsActivity.class);
                DigitalStorageActivity.this.startActivity(myIntent2);
                break;
            case R.id.history:
                Intent myIntent3 = new Intent(DigitalStorageActivity.this, HistoryConverterActivity.class);
                DigitalStorageActivity.this.startActivity(myIntent3);
                break;
            case R.id.home:
                Intent myIntent4 = new Intent(DigitalStorageActivity.this, MainActivity.class);
                DigitalStorageActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(DigitalStorageActivity.this, ConverterMainActivity.class);
        DigitalStorageActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }
}
