package com.example.jonnadulaprithvi.pocketmath;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button_converter_main,button_calculator_main,button_linear_main,button_number_main,button_processor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_converter_main=(Button)findViewById(R.id.button_converter_main);
        button_calculator_main=(Button)findViewById(R.id.button_calculator_main);
        button_linear_main=(Button)findViewById(R.id.button_linear_main);
        button_number_main=(Button)findViewById(R.id.button_number_main);
        button_processor=(Button)findViewById(R.id.button_processor);


        button_converter_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ConverterMainActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        button_calculator_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CalculatorMainActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        button_linear_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, LinearEquationMainActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        button_number_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, NumberSystemMainActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        button_processor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ProcessorActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });


    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.options_menu_home, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.about_us_home:
                Intent myIntent = new Intent(MainActivity.this, AboutUsActivity.class);
                MainActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback_home:
                Intent myIntent1 = new Intent(MainActivity.this, FeedbackActivity.class);
                MainActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us_home:
                Intent myIntent2 = new Intent(MainActivity.this, RateUsActivity.class);
                MainActivity.this.startActivity(myIntent2);
                break;
            case R.id.home:
                Intent myIntent4 = new Intent(MainActivity.this, ConverterMainActivity.class);
                MainActivity.this.startActivity(myIntent4);
                break;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        final Activity activity=new Activity();
        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
        a_builder.setMessage("Do you want to Close this App !!!")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            finishAffinity();
                        }
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.setTitle("Alert");
        alert.show();
        //super.onBackPressed();
    }
}

