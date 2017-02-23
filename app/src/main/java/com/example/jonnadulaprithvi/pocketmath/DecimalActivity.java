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

public class DecimalActivity extends AppCompatActivity {

    private EditText editText_decimal,decimal_to_binary,decimal_to_octal,decimal_to_hexadecimal;
    private Button button_decimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editText_decimal=(EditText)findViewById(R.id.editText_decimal);
        decimal_to_binary=(EditText)findViewById(R.id.decimal_to_binary);
        decimal_to_octal=(EditText)findViewById(R.id.decimal_to_octal);
        decimal_to_hexadecimal=(EditText)findViewById(R.id.decimal_to_hexadecimal);
        button_decimal=(Button)findViewById(R.id.button_decimal);

        button_decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText_decimal.getText().toString().equals(""))
                {
                    decimal_to_binary.setText(String.valueOf(Integer.toBinaryString(Integer.parseInt(editText_decimal.getText().toString()))));
                    decimal_to_octal.setText(String.valueOf(Integer.toOctalString(Integer.parseInt(editText_decimal.getText().toString()))));
                    decimal_to_hexadecimal.setText(String.valueOf(Integer.toHexString(Integer.parseInt(editText_decimal.getText().toString()))));


                }
                else
                    Toast.makeText(DecimalActivity.this, "Please enter value to convert", Toast.LENGTH_SHORT).show();

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
                Intent myIntent = new Intent(DecimalActivity.this, AboutUsActivity.class);
                DecimalActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback_exe:
                Intent myIntent1 = new Intent(DecimalActivity.this, FeedbackActivity.class);
                DecimalActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us_exe:
                Intent myIntent2 = new Intent(DecimalActivity.this, RateUsActivity.class);
                DecimalActivity.this.startActivity(myIntent2);
                break;
            case R.id.home_exe:
                Intent myIntent4 = new Intent(DecimalActivity.this, MainActivity.class);
                DecimalActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(DecimalActivity.this, NumberSystemMainActivity.class);
        DecimalActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }

}
