package com.example.harun.basket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Harun on 20/08/2017.
 */

public class secondmain extends AppCompatActivity {
    private int scoreA,scoreB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        scoreA=0;
        scoreB=0;

    }

    public void plusthreeA(View view) {
        scoreA += 3;
        displayteamA(scoreA);

    }

    public void plustwoA(View view) {
        scoreA += 2;
        displayteamA(scoreA);

    }

    public void plussatuA(View view) {
        scoreA += 1;
        displayteamA(scoreA);
    }
    public void displayteamA (int number) {
        TextView teamAscoreview = (TextView) findViewById(R.id.teamA);
        teamAscoreview.setText(""+number);
    }

    public void plusthreeB(View view) {
        scoreB += 3;
        displayteamB(scoreB);

    }

    public void plustwoB(View view) {
        scoreB += 2;
        displayteamB(scoreB);

    }

    public void plussatuB(View view) {
        scoreB += 1;
        displayteamA(scoreA);
    }
    public void displayteamB (int number) {
        TextView teamBscoreview = (TextView) findViewById(R.id.teamB);
        teamBscoreview.setText(""+number);
    }
    public void reset (View view){
        scoreA=0;
        scoreB=0;
    }
}