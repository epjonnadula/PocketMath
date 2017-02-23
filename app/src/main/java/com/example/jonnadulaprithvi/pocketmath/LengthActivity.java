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

public class LengthActivity extends AppCompatActivity {
    private RadioGroup r1,r2;
    private RadioButton radio1,radio2;
    private Button button1,button2;
    private EditText editText1,editText2;
    String unit1,unit2;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
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

                else if (unit1.equals("MilliMeter") && unit2.equals("CentiMeter"))   //MilliMeter -> CentiMeter
                    editText2.setText(Double.toString(input * 0.1));
                else if (unit1.equals("MilliMeter") && unit2.equals("Meter"))   //MilliMeter -> Meter
                    editText2.setText(Double.toString(input * 0.001));
                else if (unit1.equals("MilliMeter") && unit2.equals("KiloMeter"))   //MilliMeter -> KiloMeter
                    editText2.setText(Double.toString(input * 1e-6));
                else if (unit1.equals("MilliMeter") && unit2.equals("Mile"))   //MilliMeter -> Mile
                    editText2.setText(Double.toString(input * 6.2137e-7));
                else if (unit1.equals("MilliMeter") && unit2.equals("Yard"))   //MilliMeter -> Yard
                    editText2.setText(Double.toString(input * 0.00109361));
                else if (unit1.equals("MilliMeter") && unit2.equals("Foot"))   //MilliMeter -> Foot
                    editText2.setText(Double.toString(input * 0.00328084));
                else if (unit1.equals("MilliMeter") && unit2.equals("Inch"))   //MilliMeter -> Inch
                    editText2.setText(Double.toString(input * 0.0393701));

                else if (unit1.equals("CentiMeter") && unit2.equals("MilliMeter"))   //CentiMeter -> MilliMeter
                    editText2.setText(Double.toString(input * 10));
                else if (unit1.equals("CentiMeter") && unit2.equals("Meter"))   //CentiMeter -> Meter
                    editText2.setText(Double.toString(input * 0.01));
                else if (unit1.equals("CentiMeter") && unit2.equals("KiloMeter"))   //CentiMeter -> KiloMeter
                    editText2.setText(Double.toString(input * 1e-5));
                else if (unit1.equals("CentiMeter") && unit2.equals("Mile"))   //CentiMeter -> Mile
                    editText2.setText(Double.toString(input * 6.2137e-6));
                else if (unit1.equals("CentiMeter") && unit2.equals("Yard"))   //CentiMeter -> Yard
                    editText2.setText(Double.toString(input * 0.0109361));
                else if (unit1.equals("CentiMeter") && unit2.equals("Foot"))   //CentiMeter -> Foot
                    editText2.setText(Double.toString(input * 0.0328084));
                else if (unit1.equals("CentiMeter") && unit2.equals("Inch"))   //CentiMeter -> Inch
                    editText2.setText(Double.toString(input * 0.393701));

                else if (unit1.equals("Meter") && unit2.equals("MilliMeter"))   //Meter -> MilliMeter
                    editText2.setText(Double.toString(input * 1000));
                else if (unit1.equals("Meter") && unit2.equals("CentiMeter"))   //Meter -> CentiMeter
                    editText2.setText(Double.toString(input * 100));
                else if (unit1.equals("Meter") && unit2.equals("KiloMeter"))   //Meter -> KiloMeter
                    editText2.setText(Double.toString(input * 0.001));
                else if (unit1.equals("Meter") && unit2.equals("Mile"))   //Meter -> Mile
                    editText2.setText(Double.toString(input * 0.000621371));
                else if (unit1.equals("Meter") && unit2.equals("Yard"))   //Meter -> Yard
                    editText2.setText(Double.toString(input * 1.09361));
                else if (unit1.equals("Meter") && unit2.equals("Foot"))   //Meter -> Foot
                    editText2.setText(Double.toString(input * 3.28084));
                else if (unit1.equals("Meter") && unit2.equals("Inch"))   //Meter -> Inch
                    editText2.setText(Double.toString(input * 39.3701));

                else if (unit1.equals("KiloMeter") && unit2.equals("MilliMeter"))   //KiloMeter -> MilliMeter
                    editText2.setText(Double.toString(input * 1e+6));
                else if (unit1.equals("KiloMeter") && unit2.equals("CentiMeter"))   //KiloMeter -> CentiMeter
                    editText2.setText(Double.toString(input * 100000));
                else if (unit1.equals("KiloMeter") && unit2.equals("Meter"))   //KiloMeter -> Meter
                    editText2.setText(Double.toString(input * 1000));
                else if (unit1.equals("KiloMeter") && unit2.equals("Mile"))   //KiloMeter -> Mile
                    editText2.setText(Double.toString(input * 0.621371));
                else if (unit1.equals("KiloMeter") && unit2.equals("Yard"))   //KiloMeter -> Yard
                    editText2.setText(Double.toString(input * 1093.61));
                else if (unit1.equals("KiloMeter") && unit2.equals("Foot"))   //KiloMeter -> Foot
                    editText2.setText(Double.toString(input * 3280.84));
                else if (unit1.equals("KiloMeter") && unit2.equals("Inch"))   //KiloMeter -> Inch
                    editText2.setText(Double.toString(input * 39370.1));

                else if (unit1.equals("Mile") && unit2.equals("MilliMeter"))   //Mile -> MilliMeter
                    editText2.setText(Double.toString(input * 1.609e+6));
                else if (unit1.equals("Mile") && unit2.equals("CentiMeter"))   //Mile -> CentiMeter
                    editText2.setText(Double.toString(input * 160934));
                else if (unit1.equals("Mile") && unit2.equals("Meter"))   //Mile -> Meter
                    editText2.setText(Double.toString(input * 1609.34));
                else if (unit1.equals("Mile") && unit2.equals("KiloMeter"))   //Mile -> KiloMeter
                    editText2.setText(Double.toString(input * 1.60934));
                else if (unit1.equals("Mile") && unit2.equals("Yard"))   //Mile -> Yard
                    editText2.setText(Double.toString(input * 1760));
                else if (unit1.equals("Mile") && unit2.equals("Foot"))   //Mile -> Foot
                    editText2.setText(Double.toString(input * 5280));
                else if (unit1.equals("Mile") && unit2.equals("Inch"))   //Mile -> Inch
                    editText2.setText(Double.toString(input * 63360));

                else if (unit1.equals("Yard") && unit2.equals("MilliMeter"))   //Yard -> MilliMeter
                    editText2.setText(Double.toString(input * 914.4));
                else if (unit1.equals("Yard") && unit2.equals("CentiMeter"))   //Yard -> CentiMeter
                    editText2.setText(Double.toString(input * 91.44));
                else if (unit1.equals("Yard") && unit2.equals("Meter"))   //Yard -> Meter
                    editText2.setText(Double.toString(input * 0.9144));
                else if (unit1.equals("Yard") && unit2.equals("KiloMeter"))   //Yard -> KiloMeter
                    editText2.setText(Double.toString(input * 0.0009144));
                else if (unit1.equals("Yard") && unit2.equals("Mile"))   //Yard -> Mile
                    editText2.setText(Double.toString(input * 0.000568182));
                else if (unit1.equals("Yard") && unit2.equals("Foot"))   //Yard -> Foot
                    editText2.setText(Double.toString(input * 3));
                else if (unit1.equals("Yard") && unit2.equals("Inch"))   //Yard -> Inch
                    editText2.setText(Double.toString(input * 36));

                else if (unit1.equals("Foot") && unit2.equals("MilliMeter"))   //Foot -> MilliMeter
                    editText2.setText(Double.toString(input * 304.8));
                else if (unit1.equals("Foot") && unit2.equals("CentiMeter"))   //Foot -> CentiMeter
                    editText2.setText(Double.toString(input * 30.48));
                else if (unit1.equals("Foot") && unit2.equals("Meter"))   //Foot -> Meter
                    editText2.setText(Double.toString(input * 0.3048));
                else if (unit1.equals("Foot") && unit2.equals("KiloMeter"))   //Foot -> KiloMeter
                    editText2.setText(Double.toString(input * 0.0003048));
                else if (unit1.equals("Foot") && unit2.equals("Mile"))   //Foot -> Mile
                    editText2.setText(Double.toString(input * 0.000189394));
                else if (unit1.equals("Foot") && unit2.equals("Yard"))   //Foot -> Yard
                    editText2.setText(Double.toString(input * 0.333333));
                else if (unit1.equals("Foot") && unit2.equals("Inch"))   //Foot -> Inch
                    editText2.setText(Double.toString(input * 12));

                else if (unit1.equals("Inch") && unit2.equals("MilliMeter"))   //Inch -> MilliMeter
                    editText2.setText(Double.toString(input * 25.4));
                else if (unit1.equals("Inch") && unit2.equals("CentiMeter"))   //Inch -> CentiMeter
                    editText2.setText(Double.toString(input * 2.54));
                else if (unit1.equals("Inch") && unit2.equals("Meter"))   //Inch -> Meter
                    editText2.setText(Double.toString(input * 0.0254));
                else if (unit1.equals("Inch") && unit2.equals("KiloMeter"))   //Inch -> KiloMeter
                    editText2.setText(Double.toString(input * 2.54e-5));
                else if (unit1.equals("Inch") && unit2.equals("Mile"))   //Inch -> Mile
                    editText2.setText(Double.toString(input * 1.5783e-5));
                else if (unit1.equals("Inch") && unit2.equals("Yard"))   //Inch -> Yard
                    editText2.setText(Double.toString(input * 0.0277778));
                else if (unit1.equals("Inch") && unit2.equals("Foot"))   //Inch -> Foot
                    editText2.setText(Double.toString(input * 0.0833333));

                else
                    Toast.makeText(LengthActivity.this, "Select units to convert", Toast.LENGTH_SHORT).show();

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
                Intent myIntent = new Intent(LengthActivity.this, AboutUsActivity.class);
                LengthActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback:
                Intent myIntent1 = new Intent(LengthActivity.this, FeedbackActivity.class);
                LengthActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us:
                Intent myIntent2 = new Intent(LengthActivity.this, RateUsActivity.class);
                LengthActivity.this.startActivity(myIntent2);
                break;
            case R.id.history:
                Intent myIntent3 = new Intent(LengthActivity.this, HistoryConverterActivity.class);
                LengthActivity.this.startActivity(myIntent3);
                break;
            case R.id.home:
                Intent myIntent4 = new Intent(LengthActivity.this, MainActivity.class);
                LengthActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(LengthActivity.this, ConverterMainActivity.class);
        LengthActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }
}
