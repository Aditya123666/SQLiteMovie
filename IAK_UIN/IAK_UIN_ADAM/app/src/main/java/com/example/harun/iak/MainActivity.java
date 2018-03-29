package com.example.harun.iak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);

        Button lanjut = (Button) findViewById(R.id.next);


        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, basket.class); // dari MainActivity/posisi saat ini ke SecondActivity
                startActivity(intent);

            }

        }
}
