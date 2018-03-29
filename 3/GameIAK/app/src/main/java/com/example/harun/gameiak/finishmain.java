package com.example.harun.gameiak;

import android.os.Bundle;

import java.util.Random;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class finishmain extends AppCompatActivity {
   // private int mScore ;
    TextView view1;
    //TextView scoreakhir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish);
        view1 = (TextView) findViewById(R.id.scoreakhir);

//        scoreakhir = (TextView) findViewById(R.id.score);
//        scoreakhir.setText(""+mScore);
    }
}