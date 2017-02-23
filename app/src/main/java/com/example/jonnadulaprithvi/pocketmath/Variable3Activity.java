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
//
//import org.apache.commons.math3.linear.QRDecomposition;
//import org.apache.commons.math3.linear.RealMatrix;
//import org.apache.commons.math3.linear.RealVector;
//import org.jscience.mathematics.number.Float64;
//import org.jscience.mathematics.vector.Float64Matrix;
//import org.jscience.mathematics.vector.Float64Vector;

public class Variable3Activity extends AppCompatActivity {

    private EditText x1,x2,x3,y1,y2,y3,z1,z2,z3,w1,w2,w3,sol_x,sol_y,sol_z;
    private Button button_solve,button_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable3);
        x1=(EditText)findViewById(R.id.x1);
        y1=(EditText)findViewById(R.id.y1);
        z1=(EditText)findViewById(R.id.z1);
        w1=(EditText)findViewById(R.id.w1);

        x2=(EditText)findViewById(R.id.x2);
        y2=(EditText)findViewById(R.id.y2);
        z2=(EditText)findViewById(R.id.z2);
        w2=(EditText)findViewById(R.id.w2);

        x3=(EditText)findViewById(R.id.x3);
        y3=(EditText)findViewById(R.id.y3);
        z3=(EditText)findViewById(R.id.z3);
        w3=(EditText)findViewById(R.id.w3);

        sol_x=(EditText)findViewById(R.id.sol_x);
        sol_y=(EditText)findViewById(R.id.sol_y);
        sol_z=(EditText)findViewById(R.id.sol_z);

        button_solve=(Button)findViewById(R.id.tbutton_solve);
        button_clear=(Button)findViewById(R.id.button_clear);



        button_solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double a= 0.0;
                if (x1.getText().toString().equals("")||y1.getText().toString().equals("")||z1.getText().toString().equals("")||w1.getText().toString().equals("")||
                        x2.getText().toString().equals("")||y2.getText().toString().equals("")||z2.getText().toString().equals("")||w2.getText().toString().equals("")||
                        x3.getText().toString().equals("")||y3.getText().toString().equals("")||z3.getText().toString().equals("")||w3.getText().toString().equals("")
                        )
                {
                    Toast.makeText(Variable3Activity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    double mat[][] = {{Double.parseDouble(x1.getText().toString()),Double.parseDouble(y1.getText().toString()) , Double.parseDouble(z1.getText().toString())},
                            {Double.parseDouble(x2.getText().toString()),Double.parseDouble(y2.getText().toString()) , Double.parseDouble(z2.getText().toString())},
                            {Double.parseDouble(x3.getText().toString()),Double.parseDouble(y3.getText().toString()) , Double.parseDouble(z3.getText().toString())}

                    };
                    double matx[][] = {{Double.parseDouble(w1.getText().toString()),Double.parseDouble(y1.getText().toString()) , Double.parseDouble(z1.getText().toString())},
                            {Double.parseDouble(w2.getText().toString()),Double.parseDouble(y2.getText().toString()) , Double.parseDouble(z2.getText().toString())},
                            {Double.parseDouble(w3.getText().toString()),Double.parseDouble(y3.getText().toString()) , Double.parseDouble(z3.getText().toString())}

                    };
                    double maty[][] = {{Double.parseDouble(x1.getText().toString()),Double.parseDouble(w1.getText().toString()) , Double.parseDouble(z1.getText().toString())},
                            {Double.parseDouble(x2.getText().toString()),Double.parseDouble(w2.getText().toString()) , Double.parseDouble(z2.getText().toString())},
                            {Double.parseDouble(x3.getText().toString()),Double.parseDouble(w3.getText().toString()) , Double.parseDouble(z3.getText().toString())}

                    };
                    double matz[][] = {{Double.parseDouble(x1.getText().toString()),Double.parseDouble(y1.getText().toString()) , Double.parseDouble(w1.getText().toString())},
                            {Double.parseDouble(x2.getText().toString()),Double.parseDouble(y2.getText().toString()) , Double.parseDouble(w2.getText().toString())},
                            {Double.parseDouble(x3.getText().toString()),Double.parseDouble(y3.getText().toString()) , Double.parseDouble(w3.getText().toString())}

                    };



//
                    if (!String.valueOf(determinantOfMatrix(mat, 3)).equals("NaN")&&determinantOfMatrix(mat, 3)!=0.0)
                    {
//                        RealMatrix coefficients =
//                                new Array2DRowRealMatrix(new double[][] { {Double.parseDouble(x1.getText().toString()), Double.parseDouble(y1.getText().toString()), Double.parseDouble(z1.getText().toString())}, {Double.parseDouble(x2.getText().toString()), Double.parseDouble(y2.getText().toString()), Double.parseDouble(z2.getText().toString())}, {Double.parseDouble(x3.getText().toString()), Double.parseDouble(y3.getText().toString()),Double.parseDouble(z3.getText().toString())}} ,false);
//
//                        DecompositionSolver solver = new QRDecomposition(coefficients).getSolver();
//                        RealVector constants = new ArrayRealVector(new double[] { Double.parseDouble(w1.getText().toString()),Double.parseDouble(w2.getText().toString()),Double.parseDouble(w3.getText().toString()) }, false);
//                        RealVector solution = solver.solve(constants);
//
//                        sol_x.setText(String.valueOf(solution.getEntry(0)));
//                        sol_y.setText(String.valueOf(solution.getEntry(1)));
//                        sol_z.setText(String.valueOf(solution.getEntry(2)));
//                        sol_x.setText(String.valueOf(Mx.determinant().doubleValue()/M.determinant().doubleValue()));
//                        sol_y.setText(String.valueOf(My.determinant().doubleValue()/M.determinant().doubleValue()));
//                        sol_z.setText(String.valueOf(Mz.determinant().doubleValue()/M.determinant().doubleValue()));


                       // Toast.makeText(Variable3Activity.this, ""+determinantOfMatrix(mat, 3), Toast.LENGTH_SHORT).show();
                        sol_x.setText(String.valueOf(determinantOfMatrix(matx, 3)/determinantOfMatrix(mat, 3)));
                        sol_y.setText(String.valueOf(determinantOfMatrix(maty, 3)/determinantOfMatrix(mat, 3)));
                        sol_z.setText(String.valueOf(determinantOfMatrix(matz, 3)/determinantOfMatrix(mat, 3)));



                    }
                    else
                    {
                        sol_x.setText("System is inconsistent");
                        sol_y.setText("System is inconsistent");
                        sol_z.setText("System is inconsistent");
                    }

                }


            }
        });

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x1.setText("");
                y1.setText("");
                z1.setText("");
                w1.setText("");

                x2.setText("");
                y2.setText("");
                z2.setText("");
                w2.setText("");

                x3.setText("");
                y3.setText("");
                z3.setText("");
                w3.setText("");

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
                Intent myIntent = new Intent(Variable3Activity.this, AboutUsActivity.class);
                Variable3Activity.this.startActivity(myIntent);
                break;
            case R.id.feedback_exe:
                Intent myIntent1 = new Intent(Variable3Activity.this, FeedbackActivity.class);
                Variable3Activity.this.startActivity(myIntent1);
                break;
            case R.id.rate_us_exe:
                Intent myIntent2 = new Intent(Variable3Activity.this, RateUsActivity.class);
                Variable3Activity.this.startActivity(myIntent2);
                break;
            case R.id.home_exe:
                Intent myIntent4 = new Intent(Variable3Activity.this, MainActivity.class);
                Variable3Activity.this.startActivity(myIntent4);
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(Variable3Activity.this, LinearEquationMainActivity.class);
        Variable3Activity.this.startActivity(myIntent);
        //super.onBackPressed();
    }


}
