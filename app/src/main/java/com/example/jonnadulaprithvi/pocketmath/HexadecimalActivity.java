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

public class HexadecimalActivity extends AppCompatActivity {

    private EditText editText_hexadecimal,hexadecimal_to_binary,hexadecimal_to_decimal,hexadecimal_to_octal;
    private Button button_hexadecimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexadecimal);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editText_hexadecimal=(EditText)findViewById(R.id.editText_hexadecimal);
        hexadecimal_to_binary=(EditText)findViewById(R.id.hexadecimal_to_binary);
        hexadecimal_to_decimal=(EditText)findViewById(R.id.hexadecimal_to_decimal);
        hexadecimal_to_octal=(EditText)findViewById(R.id.hexadecimal_to_octal);
        button_hexadecimal=(Button)findViewById(R.id.button_hexadecimal);

        button_hexadecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText_hexadecimal.getText().toString().equals(""))
                {
                    hexadecimal_to_binary.setText(String.valueOf(Integer.toBinaryString(Integer.parseInt(editText_hexadecimal.getText().toString(), 16))));
                    hexadecimal_to_decimal.setText(String.valueOf(Integer.toString(Integer.parseInt(editText_hexadecimal.getText().toString(), 16))));
                    hexadecimal_to_octal.setText(String.valueOf(Integer.toOctalString(Integer.parseInt(editText_hexadecimal.getText().toString(), 16))));


                }
                else
                    Toast.makeText(HexadecimalActivity.this, "Please enter value to convert ", Toast.LENGTH_SHORT).show();

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
                Intent myIntent = new Intent(HexadecimalActivity.this, AboutUsActivity.class);
                HexadecimalActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback_exe:
                Intent myIntent1 = new Intent(HexadecimalActivity.this, FeedbackActivity.class);
                HexadecimalActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us_exe:
                Intent myIntent2 = new Intent(HexadecimalActivity.this, RateUsActivity.class);
                HexadecimalActivity.this.startActivity(myIntent2);
                break;
            case R.id.home_exe:
                Intent myIntent4 = new Intent(HexadecimalActivity.this, MainActivity.class);
                HexadecimalActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(HexadecimalActivity.this, NumberSystemMainActivity.class);
        HexadecimalActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }

}
