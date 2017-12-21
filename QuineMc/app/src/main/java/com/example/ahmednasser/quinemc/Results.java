package com.example.ahmednasser.quinemc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ahmednasser on 8/2/2017.
 */

public class Results extends AppCompatActivity {
String p= "";
    String r = "";
    String c= "" ;
    String stepup = "";
    public int[] minterms;
    public int[] dontcares;
    public int k;
    public boolean check = true;
    SinglyLinkedList min = new SinglyLinkedList(), dont = new SinglyLinkedList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        p = getIntent().getStringExtra("mins");
        r = getIntent().getStringExtra("dons");
        c = getIntent().getStringExtra("novars");


        try {

            p.replaceAll(" ", "");
            String s[] = p.split(",");

            int out[] = new int[s.length];

            for (int i = 0; i < s.length; i++) {

                out[i] = Integer.parseInt(s[i]);
            }
            minterms = out;
            for (int k = 0; k < minterms.length; k++) {
                min.add(minterms[k]);
            }

        } catch (Exception e) {
            Toast.makeText(this, " Enter numbers Please!", Toast.LENGTH_SHORT).show();
        }
        try {

            r.replaceAll(" ", "");
            String y[] = r.split(",");
            int in[] = new int[y.length];

            for (int i = 0; i < y.length; i++) {

                in[i] = Integer.parseInt(y[i]);
            }
            dontcares = in;

            for (int k = 0; k < dontcares.length; k++) {
                dont.add(dontcares[k]);
            }
            for (int k = 0; k < minterms.length; k++) {
                for (int g = 0; g < dontcares.length; g++) {
                    if (minterms[k] == dontcares[g]) {
                        Toast.makeText(this, " Dublicate Numbers in both", Toast.LENGTH_SHORT).show();
                        break;
                    }

                }
            }
        } catch (Exception e) {
        }


        TabularMethode x = new TabularMethode();
        SinglyLinkedList y = new SinglyLinkedList();
        SinglyLinkedList z = new SinglyLinkedList();
        y = min;
        z = dont;
        ///////////////////////////////////////////////
        TextView textArea_2 = (TextView) findViewById(R.id.res_here);
        textArea_2.setMovementMethod(new ScrollingMovementMethod());
/////////////////////////////////////////////////////////////////////////

        try {
            int er=0;
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
            /////////////**************************************************************/////////////
            StringBuilder textArea_1 = new StringBuilder();
           // textArea_1.setMovementMethod(new ScrollingMovementMethod());

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

            stepup = textArea_1.toString();



        } catch (Exception e) {
            String g = Integer.toString(x.recommend);
            Toast.makeText(this, " Recommended : "+g, Toast.LENGTH_SHORT).show();
        }





    }

    public void getsteps (View view){
        Intent intent = new Intent(Results.this, Steps.class);
        intent.putExtra("step" , stepup);
        startActivity(intent);
    }

}
