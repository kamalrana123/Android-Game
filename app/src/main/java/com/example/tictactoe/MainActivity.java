package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        //player representation
        //0--x
        //1--O
    boolean gameActive=true;
    int gametime=1;
        int activePlayer=0;
        int[] gameState={2,2,2,2,2,2,2,2,2};
        int[][] winPositions= { {0,1,2}, {3,4,5}, {6,7,8},
                                {0,3,6}, {1,4,7}, {2,5,8},
                                {0,4,8}, {2,4,6}};


    public void playerTap(View view)
    {
        ImageView img=(ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(gametime>9)
        {
            gameReset(view);
        }
        if(!gameActive)
        {
            gameReset(view);
        }
        if(gameState[tappedImage]==2)
        {
            gameState[tappedImage]=activePlayer;
           img.setTranslationY(-1000f);
            if(activePlayer==0)
            {
                TextView status=findViewById(R.id.status);
                status.setText("O's turn tap to play");
                img.setImageResource(R.drawable.x);
                activePlayer=1;
                gametime++;

            }
            else
            {TextView status=findViewById(R.id.status);
                status.setText("X's turn tap to play");

                img.setImageResource(R.drawable.o);
                activePlayer=0;
                gametime++;

            }
            img.animate().translationYBy(1000f).setDuration(300);
            for(int[] winposition: winPositions)
            {
                if(gameState[winposition[0]]==gameState[winposition[1]]&&gameState[winposition[1]]==gameState[winposition[2]]&&gameState[winposition[0]]!=2)
                {
                    String winner;
                    if(gameState[winposition[0]]==0)
                    {
                        winner="X has won Tap to restart";
                        TextView text=findViewById(R.id.status);
                        text.setText(winner);
                        gameActive=false;

                    }
                    else
                    {
                        winner="O has won Tap to restart";
                        TextView text=findViewById(R.id.status);
                        text.setText(winner);
                        gameActive=false;
                    }
                }
            }
        }
    }
    public void gameReset(View view)
    {
        gameActive=true;
        gametime=1;
        activePlayer=0;
        for(int i=0; i<gameState.length; i++)
        {
            gameState[i]=2;

        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
