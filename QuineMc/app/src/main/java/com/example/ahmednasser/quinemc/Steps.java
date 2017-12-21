package com.example.ahmednasser.quinemc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ahmednasser on 8/2/2017.
 */

public class Steps extends AppCompatActivity{
    cons c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.steps);
       String p = getIntent().getStringExtra("step");
        TextView v = (TextView) findViewById(R.id.this_steps);
        v.setMovementMethod(new ScrollingMovementMethod());
        v.setText(p);
        Button re = (Button) findViewById(R.id.return_back);
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Steps.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
