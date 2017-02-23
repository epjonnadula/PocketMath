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

public class FrequencyActivity extends AppCompatActivity {

    private RadioGroup r1,r2;
    private RadioButton radio1,radio2;
    private Button button1,button2;
    private EditText editText1,editText2;
    DatabaseHelper db;
    String unit1,unit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequency);
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


                else if (unit1.equals("Hertz") && unit2.equals("KiloHertz")) //Hertz ->KiloHertz
                    editText2.setText(Double.toString(input * 0.001));
                else if (unit1.equals("Hertz") && unit2.equals("MegaHertz")) //Hertz ->MegaHertz
                    editText2.setText(Double.toString(input * 1e-6));
                else if (unit1.equals("Hertz") && unit2.equals("GigaHertz")) //Hertz ->GigaHertz
                    editText2.setText(Double.toString(input * 1e-9));

                else if (unit1.equals("KiloHertz") && unit2.equals("Hertz")) //KiloHertz ->Hertz
                    editText2.setText(Double.toString(input * 1000));
                else if (unit1.equals("KiloHertz") && unit2.equals("MegaHertz")) //KiloHertz ->MegaHertz
                    editText2.setText(Double.toString(input * 0.001));
                else if (unit1.equals("KiloHertz") && unit2.equals("GigaHertz")) //KiloHertz ->GigaHertz
                    editText2.setText(Double.toString(input * 1e-6));

                else if (unit1.equals("MegaHertz") && unit2.equals("Hertz")) //MegaHertz ->Hertz
                    editText2.setText(Double.toString(input * 1e+6));
                else if (unit1.equals("MegaHertz") && unit2.equals("KiloHertz")) //MegaHertz ->KiloHertz
                    editText2.setText(Double.toString(input * 1000));
                else if (unit1.equals("MegaHertz") && unit2.equals("GigaHertz")) //MegaHertz ->GigaHertz
                    editText2.setText(Double.toString(input * 0.001));

                else if (unit1.equals("GigaHertz") && unit2.equals("Hertz")) //GigaHertz ->Hertz
                    editText2.setText(Double.toString(input * 1e+9));
                else if (unit1.equals("GigaHertz") && unit2.equals("KiloHertz")) //GigaHertz ->KiloHertz
                    editText2.setText(Double.toString(input * 1e+6));
                else if (unit1.equals("GigaHertz") && unit2.equals("MegaHertz")) //GigaHertz ->MegaHertz
                    editText2.setText(Double.toString(input * 1000));

                else
                    Toast.makeText(FrequencyActivity.this, "Select units to convert", Toast.LENGTH_SHORT).show();

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
                Intent myIntent = new Intent(FrequencyActivity.this, AboutUsActivity.class);
                FrequencyActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback:
                Intent myIntent1 = new Intent(FrequencyActivity.this, FeedbackActivity.class);
                FrequencyActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us:
                Intent myIntent2 = new Intent(FrequencyActivity.this, RateUsActivity.class);
                FrequencyActivity.this.startActivity(myIntent2);
                break;
            case R.id.history:
                Intent myIntent3 = new Intent(FrequencyActivity.this, HistoryConverterActivity.class);
                FrequencyActivity.this.startActivity(myIntent3);
                break;
            case R.id.home:
                Intent myIntent4 = new Intent(FrequencyActivity.this, MainActivity.class);
                FrequencyActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(FrequencyActivity.this, ConverterMainActivity.class);
        FrequencyActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }

}
