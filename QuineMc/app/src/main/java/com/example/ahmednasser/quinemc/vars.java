package com.example.ahmednasser.quinemc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ahmednasser on 8/2/2017.
 */

public class vars extends AppCompatActivity {
    String min="";
    String dont ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbervar);
        min = getIntent().getStringExtra("minterms");
        dont = getIntent().getStringExtra("dont");


    }

    public void addvars (View view) {
        EditText  getvar = (EditText) findViewById(R.id.mnumber_var);
        String x = getvar.getText().toString();
        Intent intent = new Intent(vars.this, Results.class);
        intent.putExtra("novars",x);
        intent.putExtra("mins",min);
        intent.putExtra("dons",dont);
        startActivity(intent);
       /* Log.v("1","as");

        SinglyLinkedList y =c.min();
        Log.v("2","as"+y.get(1));

        SinglyLinkedList z =c.dont();
        Log.v("f1","as");

        TabularMethode x = new TabularMethode();
        StringBuilder textArea_2 = null;
       // TextView textArea_2 = null;
        Log.v("3","as");

        // TextView textArea_2 = (TextView) findViewById(R.id.result_u);
      //  textArea_2.setMovementMethod(new ScrollingMovementMethod());
        Log.v("4","as");

        try {
            int er=0;
            EditText vas = (EditText) findViewById(R.id.mnumber_var);
            String c = vas.getText().toString();
            if (c.length()==0){
                er=0;

            }else{
                er = Integer.parseInt(c);

            }
            x.program(y, z, er);
            MinTerm primeImplicants[][] = x.patric(x.MinTermA());
            String[] d = x.getSolution(primeImplicants);
            if (d[0].length() == 0) {
                textArea_2.append("Solution (1) : 1");
            } else {
                textArea_2.append(" these variables will be used in Expression : ");
                textArea_2.append("\n");
                for (int i = 0; i < x.variables; i++) {
                    textArea_2.append(" " + (char) (65 + i));

                }
                textArea_2.append(".");
                textArea_2.append("\n");

                for (int i = 0; i < d.length; i++) {
                    textArea_2.append(" Solution Number ( " + (i + 1) + " )");
                    textArea_2.append("\n");
                    textArea_2.append(" " + d[i]);
                    textArea_2.append("\n");
                    textArea_2.append("\n");

                }
            }
           // TextView textArea_1 = null;
            StringBuilder textArea_1 = null;
            // TextView textArea_1  = (TextView) findViewById(R.id.step_group);
          //  textArea_1.setMovementMethod(new ScrollingMovementMethod());

            // ********************************************************************************************************\\
            for (int i = 0; i < x.group.length; i++) {
                if (!x.group[i].isEmpty()){
                    textArea_1.append(" Group(" + i + ") :");
                    textArea_1.append("\n");
                }

                for (int j = 0; j < x.group[i].size(); j++) {
                    MinTerm temp = (MinTerm) x.group[i].get(j);
                    textArea_1.append(" " + temp.index + "(");
                    for (int k = 0; k < temp.minimizations.size(); k++) {
                        int pi = (int) temp.minimizations.get(k);
                        String di = Integer.toString(pi);

                        textArea_1.append(" " + di);
                        if (k < temp.minimizations.size() - 1) {
                            textArea_1.append(",");
                        }

                    }
                    textArea_1.append(")");
                    textArea_1.append(" >>> Covering : ");

                    for (int l = 0; l < temp.covering.size(); l++) {
                        int pi = (int) temp.covering.get(l);
                        String di = Integer.toString(pi);

                        textArea_1.append(" " + di + " ");

                    }
                    String exp = x.getValueOfPrime(temp);
                    textArea_1.append(">> Expression : ");
                    textArea_1.append(exp);
                    textArea_1.append(".");
                    textArea_1.append("\n");

                }

            }
            textArea_1.append("=================================");
            textArea_1.append("\n\n");

            MinTerm a[];
            a = x.MinTermA();
            int ed = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i].ifessintial == true) {
                    ed++;
                }
            }
            if (ed > 0) {
                textArea_1.append(" Essential prime Implicants ");
                textArea_1.append("\n");
            }

            for (int i = 0; i < a.length; i++) {
                if (a[i].ifessintial == true) {
                    int r = a[i].index;
                    String p = Integer.toString(r);

                    textArea_1.append(" " + x.getValueOfPrime(a[i]));
                    textArea_1.append("\n");
                }
            }
            Log.v("ahln","hi");
            String aca = textArea_1.toString();
            String bs = textArea_2.toString();
            cons as = new cons(aca,bs);
            Intent intent = new Intent(vars.this, Results.class);
            startActivity(intent);
        }catch (Exception e){
            String g = Integer.toString(x.recommend);
            Toast.makeText(vars.this, " Recommended : "+g, Toast.LENGTH_SHORT).show();
        }*/

    }



}
