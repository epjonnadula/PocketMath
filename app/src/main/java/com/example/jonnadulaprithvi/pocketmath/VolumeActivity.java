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

public class VolumeActivity extends AppCompatActivity {

    private RadioGroup r1,r2;
    private RadioButton radio1,radio2;
    private Button button1,button2;
    private EditText editText1,editText2;
    DatabaseHelper db;
    String unit1,unit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
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

                else if (unit1.equals("Gallon") && unit2.equals("Litre"))  //Gallon -> Litre
                    editText2.setText(Double.toString(input * 3.78541));
                else if (unit1.equals("Gallon") && unit2.equals("CubicMeter"))  //Gallon -> CubicMeter
                    editText2.setText(Double.toString(input * 0.00378541));
                else if (unit1.equals("Gallon") && unit2.equals("MilliLitre"))  //Gallon -> MilliLitre
                    editText2.setText(Double.toString(input * 3785.41));
                else if (unit1.equals("Gallon") && unit2.equals("CubicFoot"))  //Gallon -> CubicFoot
                    editText2.setText(Double.toString(input * 0.133681));
                else if (unit1.equals("Gallon") && unit2.equals("CubicInch"))  //Gallon -> CubicInch
                    editText2.setText(Double.toString(input * 231));

                else if (unit1.equals("Litre") && unit2.equals("Gallon"))  //Litre -> Gallon
                    editText2.setText(Double.toString(input * 0.264172));
                else if (unit1.equals("Litre") && unit2.equals("CubicMeter"))  //Litre -> CubicMeter
                    editText2.setText(Double.toString(input * 0.001));
                else if (unit1.equals("Litre") && unit2.equals("MilliLitre"))  //Litre -> MilliLitre
                    editText2.setText(Double.toString(input * 1000));
                else if (unit1.equals("Litre") && unit2.equals("CubicFoot"))  //Litre -> CubicFoot
                    editText2.setText(Double.toString(input * 0.0353147));
                else if (unit1.equals("Litre") && unit2.equals("CubicInch"))  //Litre -> CubicInch
                    editText2.setText(Double.toString(input * 61.0237));


                else if (unit1.equals("CubicMeter") && unit2.equals("Gallon"))  //CubicMeter -> Gallon
                    editText2.setText(Double.toString(input * 264.172));
                else if (unit1.equals("CubicMeter") && unit2.equals("Litre"))  //CubicMeter -> Litre
                    editText2.setText(Double.toString(input * 1000));
                else if (unit1.equals("CubicMeter") && unit2.equals("MilliLitre"))  //CubicMeter -> MilliLitre
                    editText2.setText(Double.toString(input * 1e+6));
                else if (unit1.equals("CubicMeter") && unit2.equals("CubicFoot"))  //CubicMeter -> CubicFoot
                    editText2.setText(Double.toString(input * 35.3147));
                else if (unit1.equals("CubicMeter") && unit2.equals("CubicInch"))  //CubicMeter -> CubicInch
                    editText2.setText(Double.toString(input * 61023.7));

                else if (unit1.equals("MilliLitre") && unit2.equals("Gallon"))  //MilliLitre -> Gallon
                    editText2.setText(Double.toString(input * 0.000264172));
                else if (unit1.equals("MilliLitre") && unit2.equals("Litre"))  //MilliLitre -> Litre
                    editText2.setText(Double.toString(input * 0.001));
                else if (unit1.equals("MilliLitre") && unit2.equals("CubicMeter"))  //MilliLitre -> CubicMeter
                    editText2.setText(Double.toString(input * 1e-6));
                else if (unit1.equals("MilliLitre") && unit2.equals("CubicFoot"))  //MilliLitre -> CubicFoot
                    editText2.setText(Double.toString(input * 3.5315e-5));
                else if (unit1.equals("MilliLitre") && unit2.equals("CubicInch"))  //MilliLitre -> CubicInch
                    editText2.setText(Double.toString(input * 0.0610237));


                else if (unit1.equals("CubicFoot") && unit2.equals("Gallon"))  //CubicFoot -> Gallon
                    editText2.setText(Double.toString(input * 7.48052));
                else if (unit1.equals("CubicFoot") && unit2.equals("Litre"))  //CubicFoot -> Litre
                    editText2.setText(Double.toString(input * 28.3168));
                else if (unit1.equals("CubicFoot") && unit2.equals("CubicMeter"))  //CubicFoot -> CubicMeter
                    editText2.setText(Double.toString(input * 0.0283168));
                else if (unit1.equals("CubicFoot") && unit2.equals("MilliLitre"))  //CubicFoot -> MilliLitre
                    editText2.setText(Double.toString(input * 28316.8));
                else if (unit1.equals("CubicFoot") && unit2.equals("CubicInch"))  //CubicFoot -> CubicInch
                    editText2.setText(Double.toString(input * 1728));

                else if (unit1.equals("CubicInch") && unit2.equals("Gallon"))  //CubicInch -> Gallon
                    editText2.setText(Double.toString(input * 0.004329));
                else if (unit1.equals("CubicInch") && unit2.equals("Litre"))  //CubicInch -> Litre
                    editText2.setText(Double.toString(input * 0.0163871));
                else if (unit1.equals("CubicInch") && unit2.equals("CubicMeter"))  //CubicInch -> CubicMeter
                    editText2.setText(Double.toString(input * 1.6387e-5));
                else if (unit1.equals("CubicInch") && unit2.equals("MilliLitre"))  //CubicInch -> MilliLitre
                    editText2.setText(Double.toString(input * 16.3871));
                else if (unit1.equals("CubicInch") && unit2.equals("CubicFoot"))  //CubicInch -> CubicFoot
                    editText2.setText(Double.toString(input * 0.000578704));


                else
                    Toast.makeText(VolumeActivity.this, "Select units to convert", Toast.LENGTH_SHORT).show();

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
                Intent myIntent = new Intent(VolumeActivity.this, AboutUsActivity.class);
                VolumeActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback:
                Intent myIntent1 = new Intent(VolumeActivity.this, FeedbackActivity.class);
                VolumeActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us:
                Intent myIntent2 = new Intent(VolumeActivity.this, RateUsActivity.class);
                VolumeActivity.this.startActivity(myIntent2);
                break;
            case R.id.history:
                Intent myIntent3 = new Intent(VolumeActivity.this, HistoryConverterActivity.class);
                VolumeActivity.this.startActivity(myIntent3);
                break;
            case R.id.home:
                Intent myIntent4 = new Intent(VolumeActivity.this, MainActivity.class);
                VolumeActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(VolumeActivity.this, ConverterMainActivity.class);
        VolumeActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }
}
