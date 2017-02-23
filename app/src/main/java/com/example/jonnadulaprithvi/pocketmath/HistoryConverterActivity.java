package com.example.jonnadulaprithvi.pocketmath;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class HistoryConverterActivity extends AppCompatActivity {

    DatabaseHelper db;
    TableLayout tableLayout;
    private Context context;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_converter);
        tableLayout =(TableLayout)findViewById(R.id.tableLayout1);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        db=new DatabaseHelper(this);

        Cursor c=db.getHistory();
        if (c.getCount()==0) {
            int rows = c.getCount();
            int cols = c.getColumnCount();

            TableRow rowHeader = new TableRow(this);
            rowHeader.setBackgroundColor(Color.parseColor("#c0c0c0"));
            rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
            String[] headerText = {"Date","Time","From Unit","Input","To Unit","Result"};
            for (String i : headerText) {
                TextView tv = new TextView(this);
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(9);
                tv.setPadding(5, 5, 5, 5);
                tv.setText(i);
                rowHeader.addView(tv);
            }
            tableLayout.addView(rowHeader);
        }
        else
        {
            int rows=c.getCount();
            int cols=c.getColumnCount();

            TableRow rowHeader = new TableRow(this);
            rowHeader.setBackgroundColor(Color.parseColor("#c0c0c0"));
            rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
            String[] headerText={"Date","Time","From Unit","Input","To Unit","Result"};
            for(String i:headerText) {
                TextView tv = new TextView(this);
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(9);
                tv.setPadding(5, 5, 5, 5);
                tv.setText(i);
                rowHeader.addView(tv);
            }
            tableLayout.addView(rowHeader);
            c.moveToFirst();
            String co0=c.getString(0);
            String co1=c.getString(1);
            String co2=c.getString(2);
            String co3=c.getString(3);
            String co4=c.getString(4);
            String co5=c.getString(5);
            // dara rows
            TableRow rowp = new TableRow(this);
            rowp.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
            String[] colTextp={co0,co1,co2,co3,co4,co5};
            for(String text:colTextp) {
                TextView tv = new TextView(this);
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(9);
                tv.setPadding(5, 5, 5, 5);
                tv.setText(text);
                rowp.addView(tv);
            }
            tableLayout.addView(rowp);


            ////////////
            while (c.moveToNext()) {
                // Read columns data

                String col0=c.getString(0);
                String col1=c.getString(1);
                String col2=c.getString(2);
                String col3=c.getString(3);
                String col4=c.getString(4);
                String col5=c.getString(5);

                // dara rows
                TableRow row = new TableRow(this);
                row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));
                String[] colText={col0,col1,col2,col3,col4,col5};
                for(String text:colText) {
                    TextView tv = new TextView(this);
                    tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT));
                    tv.setGravity(Gravity.CENTER);
                    tv.setTextSize(9);
                    tv.setPadding(5, 5, 5, 5);
                    tv.setText(text);
                    row.addView(tv);
                }
                tableLayout.addView(row);

            }
        }
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.history_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.clear_history:
                db.clearHistory();
                Intent myIntent4 = new Intent(HistoryConverterActivity.this, ConverterMainActivity.class);
                HistoryConverterActivity.this.startActivity(myIntent4);
                Toast.makeText(HistoryConverterActivity.this, "History Cleared", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(HistoryConverterActivity.this, ConverterMainActivity.class);
        HistoryConverterActivity.this.startActivity(myIntent);
        //super.onBackPressed();
    }
}
