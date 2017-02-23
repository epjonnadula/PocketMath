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

public class EnergyActivity extends AppCompatActivity {

    private RadioGroup r1,r2;
    private RadioButton radio1,radio2;
    private Button button1,button2;
    private EditText editText1,editText2;
    DatabaseHelper db;
    String unit1,unit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy);
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

                else if (unit1.equals("Joule") && unit2.equals("KiloJoule")) //Joule -> KiloJoule
                    editText2.setText(Double.toString(input * 0.001));
                else if (unit1.equals("Joule") && unit2.equals("Calorie")) //Joule -> Calorie
                    editText2.setText(Double.toString(input * 0.239006));
                else if (unit1.equals("Joule") && unit2.equals("KiloCalorie")) //Joule -> KiloCalorie
                    editText2.setText(Double.toString(input * 0.000239006));
                else if (unit1.equals("Joule") && unit2.equals("WattHour")) //Joule -> WattHour
                    editText2.setText(Double.toString(input * 0.000277778));
                else if (unit1.equals("Joule") && unit2.equals("KiloWattHour")) //Joule -> KiloWattHour
                    editText2.setText(Double.toString(input * 2.7778e-7));
                else if (unit1.equals("Joule") && unit2.equals("ElectronVolt")) //Joule -> ElectronVolt
                    editText2.setText(Double.toString(input * 6.242e+18));

                else if (unit1.equals("KiloJoule") && unit2.equals("Joule")) //KiloJoule -> Joule
                    editText2.setText(Double.toString(input * 1000));
                else if (unit1.equals("KiloJoule") && unit2.equals("Calorie")) //KiloJoule -> Calorie
                    editText2.setText(Double.toString(input * 239.006));
                else if (unit1.equals("KiloJoule") && unit2.equals("KiloCalorie")) //KiloJoule -> KiloCalorie
                    editText2.setText(Double.toString(input * 0.239006));
                else if (unit1.equals("KiloJoule") && unit2.equals("WattHour")) //KiloJoule -> WattHour
                    editText2.setText(Double.toString(input * 0.277778));
                else if (unit1.equals("KiloJoule") && unit2.equals("KiloWattHour")) //KiloJoule -> KiloWattHour
                    editText2.setText(Double.toString(input * 0.000277778));
                else if (unit1.equals("KiloJoule") && unit2.equals("ElectronVolt")) //KiloJoule -> ElectronVolt
                    editText2.setText(Double.toString(input * 6.242e+21));

                else if (unit1.equals("Calorie") && unit2.equals("Joule")) //Calorie -> Joule
                    editText2.setText(Double.toString(input * 4.184));
                else if (unit1.equals("Calorie") && unit2.equals("KiloJoule")) //Calorie -> KiloJoule
                    editText2.setText(Double.toString(input * 0.004184));
                else if (unit1.equals("Calorie") && unit2.equals("KiloCalorie")) //Calorie -> KiloCalorie
                    editText2.setText(Double.toString(input * 0.001));
                else if (unit1.equals("Calorie") && unit2.equals("WattHour")) //Calorie -> WattHour
                    editText2.setText(Double.toString(input * 0.00116222));
                else if (unit1.equals("Calorie") && unit2.equals("KiloWattHour")) //Calorie -> KiloWattHour
                    editText2.setText(Double.toString(input * 1.1622e-6));
                else if (unit1.equals("Calorie") && unit2.equals("ElectronVolt")) //Calorie -> ElectronVolt
                    editText2.setText(Double.toString(input * 2.611e+19));

                else if (unit1.equals("KiloCalorie") && unit2.equals("Joule")) //KiloCalorie -> Joule
                    editText2.setText(Double.toString(input * 4184));
                else if (unit1.equals("KiloCalorie") && unit2.equals("KiloJoule")) //KiloCalorie -> KiloJoule
                    editText2.setText(Double.toString(input * 4.184));
                else if (unit1.equals("KiloCalorie") && unit2.equals("Calorie")) //KiloCalorie -> Calorie
                    editText2.setText(Double.toString(input * 1000));
                else if (unit1.equals("KiloCalorie") && unit2.equals("WattHour")) //KiloCalorie -> WattHour
                    editText2.setText(Double.toString(input * 1.16222));
                else if (unit1.equals("KiloCalorie") && unit2.equals("KiloWattHour")) //KiloCalorie -> KiloWattHour
                    editText2.setText(Double.toString(input * 0.00116222));
                else if (unit1.equals("KiloCalorie") && unit2.equals("ElectronVolt")) //KiloCalorie -> ElectronVolt
                    editText2.setText(Double.toString(input * 2.611e+22));

                else if (unit1.equals("WattHour") && unit2.equals("Joule")) //WattHour -> Joule
                    editText2.setText(Double.toString(input * 3600));
                else if (unit1.equals("WattHour") && unit2.equals("KiloJoule")) //WattHour -> KiloJoule
                    editText2.setText(Double.toString(input * 3.6));
                else if (unit1.equals("WattHour") && unit2.equals("Calorie")) //WattHour -> Calorie
                    editText2.setText(Double.toString(input * 860.421));
                else if (unit1.equals("WattHour") && unit2.equals("KiloCalorie")) //WattHour -> KiloCalorie
                    editText2.setText(Double.toString(input * 0.860421));
                else if (unit1.equals("WattHour") && unit2.equals("KiloWattHour")) //WattHour -> KiloWattHour
                    editText2.setText(Double.toString(input * 0.001));
                else if (unit1.equals("WattHour") && unit2.equals("ElectronVolt")) //WattHour -> ElectronVolt
                    editText2.setText(Double.toString(input * 2.247e+22));

                else if (unit1.equals("KiloWattHour") && unit2.equals("Joule")) //KiloWattHour -> Joule
                    editText2.setText(Double.toString(input * 3.6e+6));
                else if (unit1.equals("KiloWattHour") && unit2.equals("KiloJoule")) //KiloWattHour -> KiloJoule
                    editText2.setText(Double.toString(input * 3600));
                else if (unit1.equals("KiloWattHour") && unit2.equals("Calorie")) //KiloWattHour -> Calorie
                    editText2.setText(Double.toString(input * 860421));
                else if (unit1.equals("KiloWattHour") && unit2.equals("KiloCalorie")) //KiloWattHour -> KiloCalorie
                    editText2.setText(Double.toString(input * 860.421));
                else if (unit1.equals("KiloWattHour") && unit2.equals("WattHour")) //KiloWattHour -> WattHour
                    editText2.setText(Double.toString(input * 1000));
                else if (unit1.equals("KiloWattHour") && unit2.equals("ElectronVolt")) //KiloWattHour -> ElectronVolt
                    editText2.setText(Double.toString(input * 2.247e+25));

                else if (unit1.equals("ElectronVolt") && unit2.equals("Joule")) //ElectronVolt -> Joule
                    editText2.setText(Double.toString(input * 1.6022e-19));
                else if (unit1.equals("ElectronVolt") && unit2.equals("KiloJoule")) //ElectronVolt -> KiloJoule
                    editText2.setText(Double.toString(input * 1.6022e-22));
                else if (unit1.equals("ElectronVolt") && unit2.equals("Calorie")) //ElectronVolt -> Calorie
                    editText2.setText(Double.toString(input * 3.8293e-20));
                else if (unit1.equals("ElectronVolt") && unit2.equals("KiloCalorie")) //ElectronVolt -> KiloCalorie
                    editText2.setText(Double.toString(input * 3.8293e-23));
                else if (unit1.equals("ElectronVolt") && unit2.equals("WattHour")) //ElectronVolt -> WattHour
                    editText2.setText(Double.toString(input * 4.4505e-23));
                else if (unit1.equals("ElectronVolt") && unit2.equals("KiloWattHour")) //ElectronVolt -> KiloWattHour
                    editText2.setText(Double.toString(input * 4.4505e-26));


                else
                    Toast.makeText(EnergyActivity.this, "Select units to convert", Toast.LENGTH_SHORT).show();

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
                Intent myIntent = new Intent(EnergyActivity.this, AboutUsActivity.class);
                EnergyActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback:
                Intent myIntent1 = new Intent(EnergyActivity.this, FeedbackActivity.class);
                EnergyActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us:
                Intent myIntent2 = new Intent(EnergyActivity.this, RateUsActivity.class);
                EnergyActivity.this.startActivity(myIntent2);
                break;
            case R.id.history:
                Intent myIntent3 = new Intent(EnergyActivity.this, HistoryConverterActivity.class);
                EnergyActivity.this.startActivity(myIntent3);
                break;
            case R.id.home:
                Intent myIntent4 = new Intent(EnergyActivity.this, MainActivity.class);
                EnergyActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(EnergyActivity.this, ConverterMainActivity.class);
        EnergyActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }
}
