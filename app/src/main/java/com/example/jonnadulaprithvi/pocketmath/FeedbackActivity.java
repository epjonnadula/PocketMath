package com.example.jonnadulaprithvi.pocketmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class FeedbackActivity extends AppCompatActivity {

    private EditText name1,email1,feedback1;
    private Button button;
    RequestQueue requestQueue;
    ConnectionDetector cd;

    String insertUrl = "http://www.convert.16mb.com/insert_feedback.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        cd=new ConnectionDetector(this);

        name1=(EditText)findViewById(R.id.feedback_name);
        email1=(EditText)findViewById(R.id.feedback_email);
        feedback1=(EditText)findViewById(R.id.feedback_feedback);
        button=(Button)findViewById(R.id.feedback_button);

        if (cd.isConnected())
        {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cd.isConnected())
                    {
                        if (!name1.getText().toString().equals("")&& !email1.getText().toString().equals("")&& !feedback1.getText().toString().equals(""))
                        {
                            if (!TextUtils.isEmpty(email1.getText().toString()) && Patterns.EMAIL_ADDRESS.matcher(email1.getText().toString()).matches())
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
                                        parameters.put("name",name1.getText().toString());
                                        parameters.put("email",email1.getText().toString());
                                        parameters.put("feedback",feedback1.getText().toString());

                                        return parameters;
                                    }
                                };
                                requestQueue.add(request);
                                Intent myIntent = new Intent(FeedbackActivity.this, MainActivity.class);
                                FeedbackActivity.this.startActivity(myIntent);
                                Toast.makeText(FeedbackActivity.this, "Thank you for submitting feedback.", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(FeedbackActivity.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(FeedbackActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                        }


                    }
                    else
                    {
                        button.setEnabled(false);
                        Toast.makeText(FeedbackActivity.this, "Please check your internet connection and try again.", Toast.LENGTH_SHORT).show();
                        Intent myIntent = new Intent(FeedbackActivity.this, MainActivity.class);
                        FeedbackActivity.this.startActivity(myIntent);
                    }

                }

            });

        }
        else
        {
            button.setEnabled(false);
            Toast.makeText(FeedbackActivity.this, "Please check your internet connection and try again.", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(FeedbackActivity.this, MainActivity.class);
            FeedbackActivity.this.startActivity(myIntent);
        }

    }

    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(FeedbackActivity.this, MainActivity.class);
        FeedbackActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }
}
