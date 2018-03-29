package com.example.harun.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int quantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = 0;
    }
    public void submitOrder (View view){
        EditText text = (EditText) findViewById(R.id.nama);
        String value = text.getText().toString();
        displayNama(value);
        CheckBox checkBoxWhip = (CheckBox ) findViewById(R.id.whip);
        boolean hasWhipCream = checkBoxWhip.isChecked();
        int price = calculatePrice(quantity,hasWhipCream);

        Intent intent = new Intent (Intent.ACTION_SENDTO);
        intent.setData (Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"Just have order"+value);
        intent.putEXTRA(Intent.EXTRA_TEXT, Message (value,price,hasWhipCream));
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(Intent);
        }
        displayPrice(price);
    }
    public void display (int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

}
