package com.example.jonnadulaprithvi.pocketmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RateUsActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button button;
    private EditText name;
    String rating1="0";
    RequestQueue requestQueue;
    ConnectionDetector cd;

    String insertUrl = "http://www.convert.16mb.com/insert_rating.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        cd=new ConnectionDetector(this);
        ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        button=(Button)findViewById(R.id.button2variable);
        name=(EditText)findViewById(R.id.rating_name);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rating1 = String.valueOf(ratingBar.getRating());
            }
        });

        if (cd.isConnected())
        {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd.isConnected())
                    {
                        if (!name.getText().toString().equals(""))
                        {
                            StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    System.out.println(response.toString());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }) {

                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> parameters  = new HashMap<String, String>();
                                    parameters.put("name",name.getText().toString());
                                    parameters.put("rating",rating1);


                                    return parameters;
                                }
                            };
                            requestQueue.add(request);
                            Intent myIntent = new Intent(RateUsActivity.this, MainActivity.class);
                            RateUsActivity.this.startActivity(myIntent);
                            Toast.makeText(RateUsActivity.this, "Thank you for submitting rating.", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(RateUsActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else
                    {
                        button.setEnabled(false);
                        Toast.makeText(RateUsActivity.this, "Please check your internet connection and try again.", Toast.LENGTH_SHORT).show();
                        Intent myIntent = new Intent(RateUsActivity.this, MainActivity.class);
                        RateUsActivity.this.startActivity(myIntent);
                    }

                }

            });
        }
        else
        {
            button.setEnabled(false);
            Toast.makeText(RateUsActivity.this, "Please check your internet connection and try again.", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(RateUsActivity.this, MainActivity.class);
            RateUsActivity.this.startActivity(myIntent);
        }


    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(RateUsActivity.this, MainActivity.class);
        RateUsActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }
}
