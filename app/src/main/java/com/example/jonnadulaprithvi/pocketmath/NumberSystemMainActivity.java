package com.example.jonnadulaprithvi.pocketmath;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
public class NumberSystemMainActivity extends AppCompatActivity {

    private Button binary,decimal,octal,hexadecimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_system_main);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binary=(Button)findViewById(R.id.binary);
        decimal=(Button)findViewById(R.id.decimal);
        octal=(Button)findViewById(R.id.octal);
        hexadecimal=(Button)findViewById(R.id.hexadecimal);

        binary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(NumberSystemMainActivity.this, BinaryActivity.class);
                NumberSystemMainActivity.this.startActivity(myIntent);
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(NumberSystemMainActivity.this, DecimalActivity.class);
                NumberSystemMainActivity.this.startActivity(myIntent);
            }
        });
        octal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(NumberSystemMainActivity.this, OctalActivity.class);
                NumberSystemMainActivity.this.startActivity(myIntent);
            }
        });
        hexadecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(NumberSystemMainActivity.this, HexadecimalActivity.class);
                NumberSystemMainActivity.this.startActivity(myIntent);
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.optio_menu_exe, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.about_us_exe:
                Intent myIntent = new Intent(NumberSystemMainActivity.this, AboutUsActivity.class);
                NumberSystemMainActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback_exe:
                Intent myIntent1 = new Intent(NumberSystemMainActivity.this, FeedbackActivity.class);
                NumberSystemMainActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us_exe:
                Intent myIntent2 = new Intent(NumberSystemMainActivity.this, RateUsActivity.class);
                NumberSystemMainActivity.this.startActivity(myIntent2);
                break;
            case R.id.home_exe:
                Intent myIntent4 = new Intent(NumberSystemMainActivity.this, MainActivity.class);
                NumberSystemMainActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(NumberSystemMainActivity.this, MainActivity.class);
        NumberSystemMainActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }

}
