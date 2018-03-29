package com.example.harun.voting_fix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by Harun on 06/06/2017.
 */
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class admin_login extends ActionBarActivity {

    private EditText editUsername;
    private EditText editPassword;
    private Button btnLogin;
    private TextView txtStatus;
    String username,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_admin);
        initUI();
    }

    private void initUI(){
        editUsername = (EditText)findViewById(R.id.edtUsername);
        editUsername.getText();
        editPassword = (EditText)findViewById(R.id.edtPassword);
        editPassword.getText();
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(v == btnLogin){
                    if(editUsername.getText().toString().equals(username) && editPassword.getText().toString().equals(pass)){
                        txtStatus.setText("Login Berhasil");
                        Intent intent = new Intent(admin_login.this,regismain.class);
                        startActivity(intent);
                        finish();
                    }else{
                        txtStatus.setText("Login Gagal");
                    }
                }
            }
        });
        txtStatus = (TextView) findViewById(R.id.txtStatus);

        username = "adminapk";
        pass = "adminapk";
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//// Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//// Handle action bar item clicks here. The action bar will
//// automatically handle clicks on the Home/Up button, so long
//// as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

//noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}