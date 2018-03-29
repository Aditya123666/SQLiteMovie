package com.example.harun.voting_fix;

/**
 * Created by Harun on 27/04/2017.
 * Modified by Medvedev 6/5/2017.
 */


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {

    String URL_LOGIN = "http://musikkeras.hol.es/login.php";
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText usernamefld = (EditText) findViewById(R.id.innama);
        final EditText passwordfld = (EditText) findViewById(R.id.inpass);
        Button login = (Button) findViewById(R.id.btnlgn);
        Button daftar = (Button) findViewById(R.id.btndftr);


        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernamefld.getText().toString().trim();
                String password = passwordfld.getText().toString().trim();
                if (!username.isEmpty() && !password.isEmpty()) {

                        login(username, password);

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Mohon Masukkan Username Dan Password", Toast.LENGTH_LONG)
                            .show();
                }

            }
        });
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, regismain.class);
                startActivity(intent);
            }
        });
    }

    public void login( final String username, final String password){

        pDialog.setMessage("Menunggu ...");
        showDialog();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.POST,URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");



                    if (!error) {
                        JSONObject detail = jObj.getJSONObject("user");
                        String id2 = detail.getString("id");
                        String username2 = detail.getString("username");
                        String nama2 = detail.getString("nama");
                        int voting = detail.getInt("vote");


                        SharedPreferences details = getSharedPreferences("userdetail", MODE_PRIVATE);
                        SharedPreferences.Editor editor = details.edit();
                        editor.putString("id", id2);
                        editor.putString("username", username2);
                        editor.putString("name", nama2);
                        editor.putString("voting", Integer.toString(voting));
                        editor.commit();
                        Log.d("ADebugTag1", "Value id: " + Integer.toString(voting));
                        Intent intent = new Intent(MainActivity.this,
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
                params.put("username",username);
                params.put("password",password);

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

