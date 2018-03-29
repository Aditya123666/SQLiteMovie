package com.example.harun.voting_fix;



import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Harun on 27/04/2017.
 * Modified by Medvedev 6/5/2017.
 */

public class votenext1 extends AppCompatActivity {
    String URL_VOTE = "http://musikkeras.hol.es/vote.php";
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextvote1);
        Button vote = (Button) findViewById(R.id.btnvote);
        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        SharedPreferences prefs = getSharedPreferences("userdetail", MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        final String id = prefs.getString("id", null);//"No name defined" is the default value.
        String voting = prefs.getString("voting", null); //0 is the default value.

        vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vote(id);
                //setContentView(R.layout.finish_main);
            }
        });
    }

    public void vote(final String id){

        pDialog.setMessage("Menunggu ...");
        showDialog();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.POST,URL_VOTE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    if (!error) {
                        String Msg = jObj.getString("msg");
                        Toast.makeText(getApplicationContext(),
                                Msg, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(votenext1.this,
                                Home.class);
                        startActivity(intent);
                        finish();
                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("userid",id);
                params.put("pilihan","2");

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };
        queue.add(sr);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}

