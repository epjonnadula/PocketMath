package com.example.jonnadulaprithvi.pocketmath;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WeightActivity extends AppCompatActivity {

    private RadioGroup r1,r2;
    private RadioButton radio1,radio2;
    private Button button1,button2;
    private EditText editText1,editText2;
    DatabaseHelper db;
    String unit1,unit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
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

                else if (unit1.equals("Tonne") && unit2.equals("Kilogram"))  //Tonne -> Kilogram
                    editText2.setText(Double.toString(input * 1000));
                else if (unit1.equals("Tonne") && unit2.equals("Gram"))  //Tonne -> Gram
                    editText2.setText(Double.toString(input * 1e+6));
                else if (unit1.equals("Tonne") && unit2.equals("Pound"))  //Tonne -> Pound
                    editText2.setText(Double.toString(input * 2204.62));
                else if (unit1.equals("Tonne") && unit2.equals("Ounce"))  //Tonne -> Ounce
                    editText2.setText(Double.toString(input * 35274));

                else if (unit1.equals("Kilogram") && unit2.equals("Tonne"))  //Kilogram -> Tonne
                    editText2.setText(Double.toString(input * 0.001));
                else if (unit1.equals("Kilogram") && unit2.equals("Gram"))  //Kilogram -> Gram
                    editText2.setText(Double.toString(input * 1000));
                else if (unit1.equals("Kilogram") && unit2.equals("Pound"))  //Kilogram -> Pound
                    editText2.setText(Double.toString(input * 2.20462));
                else if (unit1.equals("Kilogram") && unit2.equals("Ounce"))  //Kilogram -> Ounce
                    editText2.setText(Double.toString(input * 35.274));


                else if (unit1.equals("Gram") && unit2.equals("Tonne"))  //Gram -> Tonne
                    editText2.setText(Double.toString(input * 1e-6));
                else if (unit1.equals("Gram") && unit2.equals("Kilogram"))  //Gram -> Kilogram
                    editText2.setText(Double.toString(input * 0.001));
                else if (unit1.equals("Gram") && unit2.equals("Pound"))  //Gram -> Pound
                    editText2.setText(Double.toString(input * 0.00220462));
                else if (unit1.equals("Gram") && unit2.equals("Ounce"))  //Gram -> Ounce
                    editText2.setText(Double.toString(input * 0.035274));


                else if (unit1.equals("Pound") && unit2.equals("Tonne"))  //Pound -> Tonne
                    editText2.setText(Double.toString(input * 0.000453592));
                else if (unit1.equals("Pound") && unit2.equals("Kilogram"))  //Pound -> Kilogram
                    editText2.setText(Double.toString(input * 0.453592));
                else if (unit1.equals("Pound") && unit2.equals("Gram"))  //Pound -> Gram
                    editText2.setText(Double.toString(input * 453.592));
                else if (unit1.equals("Pound") && unit2.equals("Ounce"))  //Pound -> Ounce
                    editText2.setText(Double.toString(input * 16));


                else if (unit1.equals("Ounce") && unit2.equals("Tonne"))  //Ounce -> Tonne
                    editText2.setText(Double.toString(input * 2.835e-5));
                else if (unit1.equals("Ounce") && unit2.equals("Kilogram"))  //Ounce -> Kilogram
                    editText2.setText(Double.toString(input * 0.0283495));
                else if (unit1.equals("Ounce") && unit2.equals("Gram"))  //Ounce -> Gram
                    editText2.setText(Double.toString(input * 28.3495));
                else if (unit1.equals("Ounce") && unit2.equals("Pound"))  //Ounce -> Pound
                    editText2.setText(Double.toString(input * 0.0625));

                else
                    Toast.makeText(WeightActivity.this, "Select units to convert", Toast.LENGTH_SHORT).show();
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
                Intent myIntent = new Intent(WeightActivity.this, AboutUsActivity.class);
                WeightActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback:
                Intent myIntent1 = new Intent(WeightActivity.this, FeedbackActivity.class);
                WeightActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us:
                Intent myIntent2 = new Intent(WeightActivity.this, RateUsActivity.class);
                WeightActivity.this.startActivity(myIntent2);
                break;
            case R.id.history:
                Intent myIntent3 = new Intent(WeightActivity.this, HistoryConverterActivity.class);
                WeightActivity.this.startActivity(myIntent3);
                break;
            case R.id.home:
                Intent myIntent4 = new Intent(WeightActivity.this, MainActivity.class);
                WeightActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(WeightActivity.this, ConverterMainActivity.class);
        WeightActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }
}
