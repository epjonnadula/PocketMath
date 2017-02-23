package com.example.jonnadulaprithvi.pocketmath;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class LinearEquationMainActivity extends AppCompatActivity {

    private Button button2variable,button3variable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_equation_main);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        button2variable=(Button)findViewById(R.id.button2variable);
        button3variable=(Button)findViewById(R.id.button3variable);

        button2variable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LinearEquationMainActivity.this, Variable2Activity.class);
                LinearEquationMainActivity.this.startActivity(myIntent);
            }
        });
        button3variable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LinearEquationMainActivity.this, Variable3Activity.class);
                LinearEquationMainActivity.this.startActivity(myIntent);
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
                Intent myIntent = new Intent(LinearEquationMainActivity.this, AboutUsActivity.class);
                LinearEquationMainActivity.this.startActivity(myIntent);
                break;
            case R.id.feedback_exe:
                Intent myIntent1 = new Intent(LinearEquationMainActivity.this, FeedbackActivity.class);
                LinearEquationMainActivity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us_exe:
                Intent myIntent2 = new Intent(LinearEquationMainActivity.this, RateUsActivity.class);
                LinearEquationMainActivity.this.startActivity(myIntent2);
                break;
            case R.id.home_exe:
                Intent myIntent4 = new Intent(LinearEquationMainActivity.this, MainActivity.class);
                LinearEquationMainActivity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(LinearEquationMainActivity.this, MainActivity.class);
        LinearEquationMainActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }

}
