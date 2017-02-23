package com.example.jonnadulaprithvi.pocketmath;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ConverterMainActivity extends AppCompatActivity {

    private ListView listView;
    private String names[] = {"Area","Digital Storage","Energy","Frequency","Length","Plane Angle","Pressure","Speed","Temperature","Time","Volume","Weight"};


    private Integer imageid[] = {
            R.mipmap.area,R.mipmap.digitalstorage,R.mipmap.energy,R.mipmap.frequency,R.mipmap.length,
            R.mipmap.planeangle,R.mipmap.pressure,R.mipmap.speed, R.mipmap.temperature,R.mipmap.time,
            R.mipmap.volume,R.mipmap.weight
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_main);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CustomList customList = new CustomList(this, names, imageid);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                String selectedFromList = (String) listView.getItemAtPosition(i);
//                Toast.makeText(ConverterMainActivity.this, selectedFromList, Toast.LENGTH_SHORT).show();
                if (i==0)
                {

                    Intent myIntent = new Intent(ConverterMainActivity.this, AreaActivity.class);
                    ConverterMainActivity.this.startActivity(myIntent);
                }
                else if (i==1)
                {
                    Intent myIntent = new Intent(ConverterMainActivity.this, DigitalStorageActivity.class);
                    ConverterMainActivity.this.startActivity(myIntent);
                }
                else if (i==2)
                {
                    Intent myIntent = new Intent(ConverterMainActivity.this, EnergyActivity.class);
                    ConverterMainActivity.this.startActivity(myIntent);
                }

                else if (i==3)
                {
                    Intent myIntent = new Intent(ConverterMainActivity.this, FrequencyActivity.class);
                    ConverterMainActivity.this.startActivity(myIntent);
                }
                else if (i==4)
                {
                    Intent myIntent = new Intent(ConverterMainActivity.this, LengthActivity.class);
                    ConverterMainActivity.this.startActivity(myIntent);
                }
                else if (i==5)
                {
                    Intent myIntent = new Intent(ConverterMainActivity.this, PlaneAngleActivity.class);
                    ConverterMainActivity.this.startActivity(myIntent);
                }
                else if (i==6)
                {
                    Intent myIntent = new Intent(ConverterMainActivity.this, PressureActivity.class);
                    ConverterMainActivity.this.startActivity(myIntent);
                }
                else if (i==7)
                {
                    Intent myIntent = new Intent(ConverterMainActivity.this, SpeedActivity.class);
                    ConverterMainActivity.this.startActivity(myIntent);
                }
                else if (i==8)
                {
                    Intent myIntent = new Intent(ConverterMainActivity.this, TemperatureActivity.class);
                    ConverterMainActivity.this.startActivity(myIntent);
                }
                else if (i==9)
                {
                    Intent myIntent = new Intent(ConverterMainActivity.this, TimeActivity.class);
                    ConverterMainActivity.this.startActivity(myIntent);
                }
                else if (i==10)
                {
                    Intent myIntent = new Intent(ConverterMainActivity.this, VolumeActivity.class);
                    ConverterMainActivity.this.startActivity(myIntent);
                }
                else if (i==11)
                {
                    Intent myIntent = new Intent(ConverterMainActivity.this, WeightActivity.class);
                    ConverterMainActivity.this.startActivity(myIntent);
                }

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
                Intent myIntent = new Intent(ConverterMainActivity.this, AboutUsActivity.class);
                ConverterMainActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback:
                Intent myIntent1 = new Intent(ConverterMainActivity.this, FeedbackActivity.class);
                ConverterMainActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us:
                Intent myIntent2 = new Intent(ConverterMainActivity.this, RateUsActivity.class);
                ConverterMainActivity.this.startActivity(myIntent2);
                break;
            case R.id.history:
                Intent myIntent3 = new Intent(ConverterMainActivity.this, HistoryConverterActivity.class);
                ConverterMainActivity.this.startActivity(myIntent3);
                break;
            case R.id.home:
                Intent myIntent4 = new Intent(ConverterMainActivity.this, MainActivity.class);
                ConverterMainActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(ConverterMainActivity.this, MainActivity.class);
        ConverterMainActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }
}
