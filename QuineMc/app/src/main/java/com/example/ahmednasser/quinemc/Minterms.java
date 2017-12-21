package com.example.ahmednasser.quinemc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ahmednasser on 8/2/2017.
 */

public class Minterms  extends AppCompatActivity{
    public int[] minterms;
    public int[] dontcares;
    public int k;
    public boolean check = true;
    String nl = System.getProperty("line.separator");
    SinglyLinkedList min = new SinglyLinkedList(), dont = new SinglyLinkedList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minterms);
        Toast.makeText(Minterms.this,"Enter Number Like this \n 1,2,3,...", Toast.LENGTH_LONG).show();


    }
    public void addminterms (View view){
        EditText b= (EditText) findViewById(R.id.min_term);
        String p =b.getText().toString();
        EditText c = (EditText) findViewById(R.id.dont_c);
        String r = c.getText().toString();


       /* try {
            EditText b= (EditText) findViewById(R.id.min_term);
            String p =b.getText().toString();
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
            EditText c = (EditText) findViewById(R.id.dont_c);
            String r = c.getText().toString();
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
        cons c = new cons(y,z);*/

        Intent intent = new Intent(Minterms.this, vars.class);
        intent.putExtra("minterms",p);
        intent.putExtra("dont",r);
        startActivity(intent);
    }
}
