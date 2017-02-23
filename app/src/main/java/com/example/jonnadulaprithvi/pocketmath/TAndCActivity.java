package com.example.jonnadulaprithvi.pocketmath;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TAndCActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private CheckBox checkBox;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_and_c);
//        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        button=(Button)findViewById(R.id.button);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        textView=(TextView)findViewById(R.id.textView);
        db=new DatabaseHelper(this);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        
        String s="Terms and Conditions\n" +
                "1. Terms\n" +
                "By accessing this mobile app, you are agreeing to be bound by these mobile app Terms and Conditions of Use, all applicable laws and regulations, and agree that you are responsible for compliance with any applicable local laws. If you do not agree with any of these terms, you are prohibited from using or accessing this site. The materials contained in this mobile app are protected by applicable copyright and trade mark law\n" +
                "2. Use License\n" +
                "a.\tPermission is granted to temporarily download one copy of the materials (information or software) on Converter mobile app for personal, non-commercial transitory viewing only. This is the grant of a license, not a transfer of title, and under this license you may not:\n" +
                "i.\tmodify or copy the materials;\n" +
                "ii.\tuse the materials for any commercial purpose, or for any public display (commercial or non-commercial);\n" +
                "iii.\tattempt to decompile or reverse engineer any software contained on Converter mobile app;\n" +
                "iv.\tremove any copyright or other proprietary notations from the materials; or\n" +
                "v.\ttransfer the materials to another person or \"mirror\" the materials on any other server.\n" +
                "b.\tThis license shall automatically terminate if you violate any of these restrictions and may be terminated by Converter at any time. Upon terminating your viewing of these materials or upon the termination of this license, you must destroy any downloaded materials in your possession whether in electronic or printed format.\n" +
                "3. Disclaimer\n" +
                "a.\tThe materials on Converter mobile app are provided \"as is\". Converter makes no warranties, expressed or implied, and hereby disclaims and negates all other warranties, including without limitation, implied warranties or conditions of merchantability, fitness for a particular purpose, or non-infringement of intellectual property or other violation of rights. Further, Converter does not warrant or make any representations concerning the accuracy, likely results, or reliability of the use of the materials on its Internet mobile app or otherwise relating to such materials or on any sites linked to this site.\n" +
                "b.\tThe rate of conversions is done according to the International System of Units.\n" +
                "4. Limitations\n" +
                "In no event shall Converter or its suppliers be liable for any damages (including, without limitation, damages for loss of data or profit, or due to business interruption,) arising out of the use or inability to use the materials on Converter app, even if Converter or a Converter authorized representative has been notified orally or in writing of the possibility of such damage. Because some jurisdictions do not allow limitations on implied warranties, or limitations of liability for consequential or incidental damages, these limitations may not apply to you.\n" +
                "5. Revisions and Errata\n" +
                "The materials appearing on Converter mobile app could include technical, typographical, or photographic errors. Converter does not warrant that any of the materials on its mobile app are accurate, complete, or current. Converter may make changes to the materials contained on its mobile app at any time without notice. Converter does not, however, make any commitment to update the materials.\n" +
                "6. Links\n" +
                "Converter has not reviewed all of the sites linked to its Internet mobile app and is not responsible for the contents of any such linked site. The inclusion of any link does not imply endorsement by Converter of the site. Use of any such linked mobile app is at the user's own risk.\n" +
                "7. Site Terms of Use Modifications\n" +
                "Converter may revise these terms of use for its mobile app at any time without notice. By using this mobile app you are agreeing to be bound by the then current version of these Terms and Conditions of Use.\n" +
                "\n";

        textView.setText(s);



        if(db.getValue()==0) {

            //For commit the changes, Use either editor.commit(); or  editor.apply();.
            db.updateValue(1);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkBox.isChecked()) {
                        Intent myIntent = new Intent(TAndCActivity.this, MainActivity.class);
                        TAndCActivity.this.startActivity(myIntent);
                        Toast.makeText(TAndCActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(TAndCActivity.this, "Please accept terms and conditions", Toast.LENGTH_SHORT).show();
                }
            });


        }
        else
        {
            Intent myIntent = new Intent(TAndCActivity.this, MainActivity.class);
            TAndCActivity.this.startActivity(myIntent);
        }

    }
    public void onBackPressed() {
        AlertDialog.Builder a_builder = new AlertDialog.Builder(TAndCActivity.this);
        a_builder.setMessage("Do you want to Close this App !!!")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.updateValue(0);
                        finish();
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
