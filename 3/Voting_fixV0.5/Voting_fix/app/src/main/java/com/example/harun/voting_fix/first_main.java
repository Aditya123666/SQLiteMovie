package com.example.harun.voting_fix;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Harun on 06/06/2017.
 */

public class first_main extends AppCompatActivity {
    private Button mBtnBack;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_main);
        //Ambil ID si Button Back
        Button loginuser = (Button) findViewById(R.id.btnlogus);
        Button loginadmin = (Button) findViewById(R.id.btnlogad);

        //Set on CLick si Button Back
        loginuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(first_main.this, MainActivity.class);
                //Intent intent = new Intent(Home.this, vottingmain.class);

                //Intent intent = new Intent(Home.this, vottingmain.class);
                startActivity(intent);
                /*
                kalo untuk memanggil activity baru (yang sifatnya maju) kita pakai Intent
                tapi, kalau kita memanggil Activity yang sebelumnya (1 ACTIVITY DIBELAKANG POSISI SAAT INI) gunakan saja
                onBackPressed()
                 */

            }
        });
        loginadmin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (first_main.this,admin_login.class);
                startActivity(intent);
            }
        });

    }


}
