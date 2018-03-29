package com.example.harun.voting_fix;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DigitalClock;
//import android.text.format.Time;
/**
 * Created by putuguna on 17/06/16.
 * Modified by Medvedev 6/5/2017.
 */
public class Home extends AppCompatActivity{
//    Time mtime;
//    Handler handler;
//    Runnable r;
    private Button mBtnBack;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
//        DigitalClock digitalClock = (DigitalClock) findViewById(R.id.digitalClock);
//        mTime = new Time();
//        r = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };
//        handler = new Handler();
//        handler.postDelayed(r, 1000);
//    }
  //  public class drawingView extends View{
        String id2="Tidak ADA";
        String username2="Tidak ADA";
        String nama2="Tidak ADA";

        //Ambil ID si Button Back
        Button tutor = (Button) findViewById(R.id.btntutor);
        Button votting = (Button) findViewById(R.id.btnvotting);
        Button quick = (Button) findViewById(R.id.btnquick);
        Button logout = (Button) findViewById(R.id.btnlog);
        //Set on CLick si Button Back
        tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, tutormain.class);
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
        votting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Home.this,vottingmain.class);
                startActivity(intent);
            }
        });
        quick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Home.this,main_quick.class);
                startActivity(intent);
            }
        });
//        logout.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                moveTaskToBack(true);
//            }
//        });
        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Home.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
