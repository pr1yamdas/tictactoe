package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameactive= true;
    int activeplayer = 0;
    int[] gamestate = { 2, 2, 2, 2, 2, 2, 2, 2, 2 };

    int[][] winpositions = { {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8},
                                        {0,4,8}, {2,4,6}  };
    private Button resetbutton;



    public void playertap(View view) {

        ImageView img = (ImageView) view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            gamereset(view);
        }




        if (gamestate[tappedimage] == 2 && gameactive) {
            gamestate[tappedimage] = activeplayer;
            if (activeplayer == 0) {
                img.setImageResource(R.drawable.x);
                activeplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn");
            } else {
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn");
            }

        }

        for(int[] winposition: winpositions){
            if(gamestate[winposition[0]] == gamestate[winposition[1]] && gamestate[winposition[1]] == gamestate[winposition[2]] && gamestate[winposition[0]] != 2){
                String winnerstr;
                gameactive = false;
                if (gamestate[winposition[0]] == 0){
                    winnerstr = "X is the winner";
                }
                else{
                    winnerstr= "O is the winner";
                }
                TextView status =  findViewById(R.id.status);
                status.setText(winnerstr);
            }
        }


    }



    public void gamereset(View view) {
        gameactive = true;
        activeplayer = 0;
        for (int i = 0; i < gamestate.length; i++) {
            gamestate[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}