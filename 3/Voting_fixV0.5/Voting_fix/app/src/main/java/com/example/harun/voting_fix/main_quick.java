package com.example.harun.voting_fix;

/**
 * Created by Harun on 27/04/2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

public class main_quick extends AppCompatActivity {
    Timer timer;
    TimerTask timerTask;
    TextView view1;
    TextView view2;
    int time = 20;
    Timer t;
    TimerTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quick_main);

        view1 = (TextView) findViewById(R.id.no1);
        view2 = (TextView) findViewById(R.id.no2);
        ceksuara();
        startTimer();
//        //Button quick = (Button) findViewById(R.id.btnquick);
//
//Timer timer;

//        //Set on CLick si Button Back
//        tutor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Home.this, tutormain.class);
//                //Intent intent = new Intent(Home.this, vottingmain.class);
//
//                //Intent intent = new Intent(Home.this, vottingmain.class);
//                startActivity(intent);
//                /*
//                kalo untuk memanggil activity baru (yang sifatnya maju) kita pakai Intent
//                tapi, kalau kita memanggil Activity yang sebelumnya (1 ACTIVITY DIBELAKANG POSISI SAAT INI) gunakan saja
//                onBackPressed()
//                 */
//
//            }
//        });
    }


    public void startTimer(){
        t = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        ceksuara();
                    }
                });
            }
        };
        t.scheduleAtFixedRate(task, 0, 5000);
    }

    public void ceksuara(){
        String url = "http://musikkeras.hol.es/cekcount.php";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONArray jArr = new JSONArray(response);
                            JSONObject obj = jArr.getJSONObject(0);
                            String satu = obj.getString("jumlah");
                            JSONObject obj2 = jArr.getJSONObject(1);
                            String dua = obj2.getString("jumlah");
                            view1.setText(satu+" %");
                            view2.setText(dua+" %");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),
                            error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
// Add the request to the RequestQueue.
        stringRequest.setShouldCache(false);
        queue.add(stringRequest);
    }
}