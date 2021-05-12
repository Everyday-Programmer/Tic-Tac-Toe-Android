package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button btn_00, btn_01, btn_02, btn_10, btn_11, btn_12, btn_20, btn_21, btn_22;
    private boolean player1Turn = true;
    private int roundCount;
    private int player1;
    private int player2;
    private TextView player1Score;
    private TextView player2Score;
    private RelativeLayout root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1Score = findViewById(R.id.tv_p1);
        player2Score = findViewById(R.id.tv_p2);

        root = findViewById(R.id.root);

        btn_00 = findViewById(R.id.btn_00);
        btn_01 = findViewById(R.id.btn_01);
        btn_02 = findViewById(R.id.btn_02);
        btn_10 = findViewById(R.id.btn_10);
        btn_11 = findViewById(R.id.btn_11);
        btn_12 = findViewById(R.id.btn_12);
        btn_20 = findViewById(R.id.btn_20);
        btn_21 = findViewById(R.id.btn_21);
        btn_22 = findViewById(R.id.btn_22);

        btn_00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    btn_00.setText("X");
                }else{
                    btn_00.setText("O");
                }
                check();
            }
        });

        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    btn_01.setText("X");
                }else{
                    btn_01.setText("O");
                }
                check();
            }
        });

        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    btn_02.setText("X");
                }else{
                    btn_02.setText("O");
                }
                check();
            }
        });

        btn_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    btn_10.setText("X");
                }else{
                    btn_10.setText("O");
                }
                check();
            }
        });

        btn_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    btn_11.setText("X");
                }else{
                    btn_11.setText("O");
                }
                check();
            }
        });

        btn_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    btn_12.setText("X");
                }else{
                    btn_12.setText("O");
                }
                check();
            }
        });

        btn_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    btn_20.setText("X");
                }else{
                    btn_20.setText("O");
                }
                check();
            }
        });

        btn_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    btn_21.setText("X");
                }else{
                    btn_21.setText("O");
                }
                check();
            }
        });

        btn_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player1Turn){
                    btn_22.setText("X");
                }else{
                    btn_22.setText("O");
                }
                check();
            }
        });

        ImageView reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    public void check(){
        roundCount++;

        if (checkforWin()){
            if (player1Turn){
                player1Wins();
            }else{
                player2Wins();
            }
        }else if (roundCount == 9){
            tie();
        }else{
            player1Turn = !player1Turn;
        }
    }

    /*@Override
    public void onClick(View v){
        if (!((Button) v).getText().toString().equals("")){
            return;
        }

        if (player1Turn){
            ((Button)v).setText("X");
        }else {
            ((Button)v).setText("O");
        }

        roundCount++;

        if (checkforWin()){
            if (player1Turn){
                player1Wins();
            }else{
                player2Wins();
            }
        }else if (roundCount == 9){
            tie();
        }else{
            player1Turn = !player1Turn;
        }
    }*/

    public boolean checkforWin(){
        String[][] field = new String[3][3];

        /*for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                field[i][j] = buttons[i][j].getText().toString();
            }
        }*/

        field[0][0] = btn_00.getText().toString();
        field[0][1] = btn_01.getText().toString();
        field[0][2] = btn_02.getText().toString();
        field[1][0] = btn_10.getText().toString();
        field[1][1] = btn_11.getText().toString();
        field[1][2] = btn_12.getText().toString();
        field[2][0] = btn_20.getText().toString();
        field[2][1] = btn_21.getText().toString();
        field[2][2] = btn_22.getText().toString();

        for (int i = 0; i < 3; i++){
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals("")){
                return true;
            }
        }

        for (int i = 0; i < 3; i++){
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals("")){
                return true;
            }
        }

        if (field[0][0].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("")){
            return true;
        }

        if (field[0][2].equals(field[1][2]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("")){
            return true;
        }

        return false;
    }


    public void player1Wins(){
        player1++;
        Snackbar.make(root,"Player 1 Wins", Snackbar.LENGTH_SHORT).show();
        updateScore();
        resetBoard();
    }

    public void player2Wins(){
        player2++;
        Snackbar.make(root,"Player 2 Wins", Snackbar.LENGTH_SHORT).show();
        updateScore();
        resetBoard();
    }

    public void tie(){
        resetBoard();
        Snackbar.make(root,"Draw !",Snackbar.LENGTH_SHORT).show();
    }

    public void resetBoard(){
        /*for (int i = 0; i < 3; i++){
            for (int j = 0; i < 3; j++){
                buttons[i][j].setText("");
            }
        }*/

        btn_00.setText("");
        btn_01.setText("");
        btn_02.setText("");
        btn_10.setText("");
        btn_11.setText("");
        btn_12.setText("");
        btn_20.setText("");
        btn_21.setText("");
        btn_22.setText("");

        roundCount = 0;
        player1Turn = true;
    }

    public void updateScore(){
        player2Score.setText("Player 2: " + player2);
        player1Score.setText("Player 1: " + player1);
    }

    public void resetGame(){
        player1 = 0;
        player2 = 0;
        updateScore();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", roundCount);
        outState.putInt("player1", player1);
        outState.putInt("player2", player2);
        outState.putBoolean("player1turn", player1Turn);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        roundCount = savedInstanceState.getInt("roundCount");
        player1 = savedInstanceState.getInt("player1");
        player2 = savedInstanceState.getInt("player2");
        player1Turn = savedInstanceState.getBoolean("player1turn");
    }
}