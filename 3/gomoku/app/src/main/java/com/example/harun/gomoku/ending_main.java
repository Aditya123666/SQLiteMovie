package com.example.harun.gomoku;

/**
 * Created by Harun on 20/10/2017.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.text.InputType;




public class ending_main extends AppCompatActivity{
    String get_nama,var_nama;
    TextView nama;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ending);
        nama = (TextView) findViewById(R.id.nama1);
        //Bundle b = getIntent().getExtras();
        //get_nama = b.getString("parse_nama");
        //nama.setText("Nama : "+get_nama);
//        Bundle b = getIntent().getExtras();
//
//        get_nama = b.getString("parse_nama");
//
//        var_nama = nama.getText().toString();
//        nama.setText("nama"+var_nama);


        //get_nama = b.getString("parse_nama");

        //nama.setText("Nama : "+get_nama);


    }

}
