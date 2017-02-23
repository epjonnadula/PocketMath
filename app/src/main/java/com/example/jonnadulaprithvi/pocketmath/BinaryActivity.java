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

public class BinaryActivity extends AppCompatActivity {

    private EditText editText_binary,binary_to_decimal,binary_to_octal,binary_to_hexadecimal;
    private Button button_binary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editText_binary=(EditText)findViewById(R.id.editText_binary);
        binary_to_decimal=(EditText)findViewById(R.id.binary_to_decimal);
        binary_to_octal=(EditText)findViewById(R.id.binary_to_octal);
        binary_to_hexadecimal=(EditText)findViewById(R.id.binary_to_hexadecimal);
        button_binary=(Button)findViewById(R.id.button_binary);

        button_binary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText_binary.getText().toString().equals(""))
                {
                    binary_to_decimal.setText(String.valueOf(Integer.toString(Integer.parseInt(editText_binary.getText().toString(), 2))));
                    binary_to_octal.setText(String.valueOf(Integer.toOctalString(Integer.parseInt(editText_binary.getText().toString(), 2))));
                    binary_to_hexadecimal.setText(String.valueOf(Integer.toHexString(Integer.parseInt(editText_binary.getText().toString(), 2))));
                }
                else
                    Toast.makeText(BinaryActivity.this, "Please enter value to convert", Toast.LENGTH_SHORT).show();
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
                Intent myIntent = new Intent(BinaryActivity.this, AboutUsActivity.class);
                BinaryActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback_exe:
                Intent myIntent1 = new Intent(BinaryActivity.this, FeedbackActivity.class);
                BinaryActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us_exe:
                Intent myIntent2 = new Intent(BinaryActivity.this, RateUsActivity.class);
                BinaryActivity.this.startActivity(myIntent2);
                break;
            case R.id.home_exe:
                Intent myIntent4 = new Intent(BinaryActivity.this, MainActivity.class);
                BinaryActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(BinaryActivity.this, NumberSystemMainActivity.class);
        BinaryActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }

}

