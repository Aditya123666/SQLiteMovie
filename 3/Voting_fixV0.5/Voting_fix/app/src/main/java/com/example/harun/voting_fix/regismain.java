package com.example.harun.voting_fix;

/**
 * Created by Harun on 27/04/2017.
 * Modified by Medvedev 6/5/2017.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class regismain extends AppCompatActivity {

    final static String URL_REGISTER = "http://musikkeras.hol.es/register.php";
    private ProgressDialog pDialog;
    private Button btndaftar;
    private EditText namafld;
    private EditText usernamefld;
    private EditText passwordfld;
    private EditText passwordfldre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regis);
        namafld = (EditText) findViewById(R.id.innama);
        usernamefld = (EditText) findViewById(R.id.inuser);
        passwordfld = (EditText) findViewById(R.id.inpass);
        passwordfldre = (EditText) findViewById(R.id.inrepass);
        btndaftar = (Button) findViewById(R.id.btndftr);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);




        // Register Button Click event
        btndaftar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String nama = namafld.getText().toString().trim();
                String username = usernamefld.getText().toString().trim();
                String password = passwordfld.getText().toString().trim();
                String passwordre = passwordfldre.getText().toString().trim();

                if (!nama.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
                    if (password.equals(passwordre)) {
                        registrasi(nama, username, password);
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "Masukan password yang sesuai", Toast.LENGTH_LONG)
                                .show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }

                }
            }
        );
    }

    public void registrasi(final String nama, final String username, final String password){

        pDialog.setMessage("Mendaftarkan ...");
        showDialog();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.POST,URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    if (!error) {

                        // Inserting row in users table

                        Toast.makeText(getApplicationContext(), "Pendaftaran Selesai!", Toast.LENGTH_LONG).show();

                        // Launch login activity
                        Intent intent = new Intent(regismain.this,
                                first_main.class);
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
                params.put("nama", nama);

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