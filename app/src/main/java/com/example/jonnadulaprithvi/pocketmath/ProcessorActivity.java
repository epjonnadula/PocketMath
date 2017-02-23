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

public class ProcessorActivity extends AppCompatActivity {

    private EditText mclk,cpi,mips;
    private Button button_processor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processor);

        mclk=(EditText)findViewById(R.id.mclk);
        cpi=(EditText)findViewById(R.id.cpi);
        mips=(EditText)findViewById(R.id.mips);
        button_processor=(Button)findViewById(R.id.button_processor);

        button_processor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mclk.getText().toString().equals("")||cpi.getText().toString().equals(""))
                {
                    Toast.makeText(ProcessorActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Double ans=Double.parseDouble(mclk.getText().toString())/(Double.parseDouble(cpi.getText().toString())*1000000);
                    mips.setText(String.valueOf(ans));
                }
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
                Intent myIntent = new Intent(ProcessorActivity.this, AboutUsActivity.class);
                ProcessorActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback_exe:
                Intent myIntent1 = new Intent(ProcessorActivity.this, FeedbackActivity.class);
                ProcessorActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us_exe:
                Intent myIntent2 = new Intent(ProcessorActivity.this, RateUsActivity.class);
                ProcessorActivity.this.startActivity(myIntent2);
                break;
            case R.id.home_exe:
                Intent myIntent4 = new Intent(ProcessorActivity.this, MainActivity.class);
                ProcessorActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(ProcessorActivity.this, MainActivity.class);
        ProcessorActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }

}
