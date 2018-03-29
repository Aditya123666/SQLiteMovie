package com.example.harun.voting_fix;

/**
 * Created by Harun on 27/04/2017.
 * Modified by Medvedev 6/5/2017.
 */
        import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class vottingmain extends AppCompatActivity {//extends MainActivity
    ImageButton ib;
    ImageButton ibsatu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.votting);
        ib = (ImageButton) findViewById(R.id.imageButton);
        ibsatu = (ImageButton) findViewById(R.id.imageButton1);
        //membuat listener ketika objek di-klik
        ib.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vottingmain.this, votenext.class);
                startActivity(intent);
                // TODO Auto-generated method stub
              //   Toast.makeText(vottingmain.this,
              //          "Anda meng-klik ImageButton",
                //         Toast.LENGTH_SHORT).show();
            }
        });
        ibsatu.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vottingmain.this, votenext1.class);
                startActivity(intent);
                // TODO Auto-generated method stub
               // Toast.makeText(vottingmain.this,
               //         "Anda meng-klik ImageButton",
               //         Toast.LENGTH_SHORT).show();
            }
        //ibsatu.setOnClickListener(new View.OnClickListener(){
          //  public  void  OnClick(View v) {
            //    Intent intent = new Intent(vottingmain.this, votenext1.class);
              //  startActivity(intent);
                //Toast.makeText(vottingmain.this,
                  //      "Anda meng-klik No 2",
                    //    Toast.LENGTH_LONG).show();
            //}
        });
        //menerapkan listener pada objek ib
        //ib.setOnClickListener(listener);
    }
}
