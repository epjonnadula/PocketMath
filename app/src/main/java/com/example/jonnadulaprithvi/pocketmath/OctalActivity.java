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
import android.widget.Toast;

public class OctalActivity extends AppCompatActivity {

    private EditText editText_octal,octal_to_binary,octal_to_decimal,octal_to_hexadecimal;
    private Button button_octal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_octal);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editText_octal=(EditText)findViewById(R.id.editText_octal);
        octal_to_binary=(EditText)findViewById(R.id.octal_to_binary);
        octal_to_decimal=(EditText)findViewById(R.id.octal_to_decimal);
        octal_to_hexadecimal=(EditText)findViewById(R.id.octal_to_hexadecimal);
        button_octal=(Button)findViewById(R.id.button_octal);

        button_octal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText_octal.getText().toString().equals(""))
                {
                    octal_to_binary.setText(String.valueOf(Integer.toBinaryString(Integer.parseInt(editText_octal.getText().toString(), 8))));
                    octal_to_decimal.setText(String.valueOf(Integer.toString(Integer.parseInt(editText_octal.getText().toString(), 8))));
                    octal_to_hexadecimal.setText(String.valueOf(Integer.toHexString(Integer.parseInt(editText_octal.getText().toString(), 8))));
                }
                else
                    Toast.makeText(OctalActivity.this, "Please enter value to convert", Toast.LENGTH_SHORT).show();

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
                Intent myIntent = new Intent(OctalActivity.this, AboutUsActivity.class);
                OctalActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback_exe:
                Intent myIntent1 = new Intent(OctalActivity.this, FeedbackActivity.class);
                OctalActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us_exe:
                Intent myIntent2 = new Intent(OctalActivity.this, RateUsActivity.class);
                OctalActivity.this.startActivity(myIntent2);
                break;
            case R.id.home_exe:
                Intent myIntent4 = new Intent(OctalActivity.this, MainActivity.class);
                OctalActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(OctalActivity.this, NumberSystemMainActivity.class);
        OctalActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }

}
