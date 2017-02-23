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

//import org.apache.commons.math3.linear.Array2DRowRealMatrix;
//import org.apache.commons.math3.linear.ArrayRealVector;
//import org.apache.commons.math3.linear.DecompositionSolver;
//import org.apache.commons.math3.linear.QRDecomposition;
//import org.apache.commons.math3.linear.RealMatrix;
//import org.apache.commons.math3.linear.RealVector;
//import org.jscience.mathematics.number.Float64;
//import org.jscience.mathematics.vector.Float64Matrix;
//import org.jscience.mathematics.vector.Float64Vector;

public class Variable2Activity extends AppCompatActivity {

    private EditText tx1,tx2,ty1,ty2,tz1,tz2,tsol_x,tsol_y;
    private Button tbutton_solve,tbutton_clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable2);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tx1=(EditText)findViewById(R.id.tx1);
        ty1=(EditText)findViewById(R.id.ty1);
        tz1=(EditText)findViewById(R.id.tz1);

        tx2=(EditText)findViewById(R.id.tx2);
        ty2=(EditText)findViewById(R.id.ty2);
        tz2=(EditText)findViewById(R.id.tz2);

        tsol_x=(EditText)findViewById(R.id.tsol_x);
        tsol_y=(EditText)findViewById(R.id.tsol_y);

        tbutton_solve=(Button)findViewById(R.id.tbutton_solve);
        tbutton_clear=(Button)findViewById(R.id.tbutton_clear);



        tbutton_solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double a= 0.0;

                if (tx1.getText().toString().equals("")||ty1.getText().toString().equals("")||tz1.getText().toString().equals("")||
                        tx2.getText().toString().equals("")||ty2.getText().toString().equals("")||tz2.getText().toString().equals("")
                        )
                {
                    Toast.makeText(Variable2Activity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {

//                    Float64Vector column0 = Float64Vector.valueOf(Double.parseDouble(tx1.getText().toString()),Double.parseDouble(tx2.getText().toString()));
//                    Float64Vector column1 = Float64Vector.valueOf(Double.parseDouble(ty1.getText().toString()),Double.parseDouble(ty2.getText().toString()));
//
//                    Float64Matrix M = Float64Matrix.valueOf(column0, column1);

//                    Toast.makeText(Variable2Activity.this, ""+M.determinant(), Toast.LENGTH_SHORT).show();


                    double mat[][]={{Double.parseDouble(tx1.getText().toString()),Double.parseDouble(ty1.getText().toString())},
                            {Double.parseDouble(tx2.getText().toString()),Double.parseDouble(ty2.getText().toString())}

                    };
                    double matx[][]={{Double.parseDouble(tz1.getText().toString()),Double.parseDouble(ty1.getText().toString())},
                            {Double.parseDouble(tz2.getText().toString()),Double.parseDouble(ty2.getText().toString())}

                    };
                    double maty[][]={{Double.parseDouble(tx1.getText().toString()),Double.parseDouble(tz1.getText().toString())},
                            {Double.parseDouble(tx2.getText().toString()),Double.parseDouble(tz2.getText().toString())}

                    };
                    if (!String.valueOf(determinantOfMatrix(mat, 2)).equals("NaN")&&determinantOfMatrix(mat, 2)!=0.0)
                    {
//                        RealMatrix coefficients =
//                                new Array2DRowRealMatrix(new double[][] { {Double.parseDouble(tx1.getText().toString()), Double.parseDouble(ty1.getText().toString())}, {Double.parseDouble(tx2.getText().toString()), Double.parseDouble(ty2.getText().toString())}} ,false);
//
//                        DecompositionSolver solver = new QRDecomposition(coefficients).getSolver();
//                        RealVector constants = new ArrayRealVector(new double[] { Double.parseDouble(tz1.getText().toString()),Double.parseDouble(tz2.getText().toString()) }, false);
//                        RealVector solution = solver.solve(constants);
//
//                        tsol_x.setText(String.valueOf(solution.getEntry(0)));
//                        tsol_y.setText(String.valueOf(solution.getEntry(1)));
                        tsol_x.setText(String.valueOf(determinantOfMatrix(matx, 2)/determinantOfMatrix(mat, 2)));
                        tsol_y.setText(String.valueOf(determinantOfMatrix(maty, 2)/determinantOfMatrix(mat, 2)));
                    }

                    else
                    {
                        tsol_x.setText("System is inconsistent");
                        tsol_y.setText("System is inconsistent");

                    }

                }


            }
        });

        tbutton_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tx1.setText("");
                ty1.setText("");
                tz1.setText("");


                tx2.setText("");
                ty2.setText("");
                tz2.setText("");

            }
        });

    }
    void getCofactor(double mat[][], double temp[][], int p, int q, int n)
    {
        int i = 0, j = 0;

        // Looping for each element of the matrix
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                //  Copying into temporary matrix only those element
                //  which are not in given row and column
                if (row != p && col != q)
                {
                    temp[i][j++] = mat[row][col];

                    // Row is filled, so increase row index and
                    // reset col index
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    double determinantOfMatrix(double mat[][], int n)
    {
        int D = 0; // Initialize result

        //  Base case : if matrix contains single element
        if (n == 1)
            return mat[0][0];

        double temp[][]={{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };; // To store cofactors

        int sign = 1;  // To store sign multiplier

        // Iterate for each element of first row
        for (int f = 0; f < n; f++)
        {
            // Getting Cofactor of mat[0][f]
            getCofactor(mat, temp, 0, f, n);
            D += sign * mat[0][f] * determinantOfMatrix(temp, n - 1);

            // terms are to be added with alternate sign
            sign = -sign;
        }

        return D;
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
                Intent myIntent = new Intent(Variable2Activity.this, AboutUsActivity.class);
                Variable2Activity.this.startActivity(myIntent);
                break;
            case R.id.feedback_exe:
                Intent myIntent1 = new Intent(Variable2Activity.this, FeedbackActivity.class);
                Variable2Activity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us_exe:
                Intent myIntent2 = new Intent(Variable2Activity.this, RateUsActivity.class);
                Variable2Activity.this.startActivity(myIntent2);
                break;
            case R.id.home_exe:
                Intent myIntent4 = new Intent(Variable2Activity.this, MainActivity.class);
                Variable2Activity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(Variable2Activity.this, LinearEquationMainActivity.class);
        Variable2Activity.this.startActivity(myIntent);
        //super.onBackPressed();
    }

}
