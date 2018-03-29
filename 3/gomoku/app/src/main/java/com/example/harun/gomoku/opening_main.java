package com.example.harun.gomoku;

/**
 * Created by Harun on 19/10/2017.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


public class opening_main extends AppCompatActivity {
    EditText nama;
    String var_nama;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening);
        nama = (EditText) findViewById(R.id.setname);

        Button mulai = (Button) findViewById(R.id.btnmulai);
        //final EditText textname = (EditText) findViewById(R.id.setname);

        mulai.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                        nama.setText("");
                     //   Intent intent = new Intent(opening_main.this,MainActivity.class);
                       // startActivity(intent);
                        //nama.setText("");
                        var_nama = nama.getText().toString();
                Intent i = null;

                i = new Intent(opening_main.this, MainActivity.class);

                Bundle b = new Bundle();

                b.putString("parse_nama", var_nama);
                i.putExtras(b);

                startActivity(i);

                //Bundle b = new Bundle();

                        //b.putString("parse_nama", var_nama);





            }

        });

    }


}
