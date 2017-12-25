package com.example.shwetank.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shwetank.tictactoe.AlertDialogBox.AlertDialogBoxHelper;
import com.example.shwetank.tictactoe.AlertDialogBox.ClickEventListener;

import java.util.HashSet;

public class LauncherActivity extends AppCompatActivity implements View.OnClickListener, ClickEventListener {

    Button mb00, mb01, mb02;
    Button mb10, mb11, mb12;
    Button mb20, mb21, mb22;
    TextView mResult;
    TextView mPlayerOne, mPlayerTwo;
    int count = 0;
    HashSet<String> playerOne;
    HashSet<String> playerTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        findViewById();
        init();

    }

    private void init() {
        mb00.setOnClickListener(this);
        mb01.setOnClickListener(this);
        mb02.setOnClickListener(this);
        mb10.setOnClickListener(this);
        mb11.setOnClickListener(this);
        mb12.setOnClickListener(this);
        mb20.setOnClickListener(this);
        mb21.setOnClickListener(this);
        mb21.setOnClickListener(this);
        initialiseSet();
    }

    private void initialiseSet() {
        playerOne = new HashSet<>();
        playerTwo = new HashSet<>();
    }

    private void findViewById() {
        mb00 = findViewById(R.id.zero_zero);
        mb01 = findViewById(R.id.zero_one);
        mb02 = findViewById(R.id.zero_two);
        mb10 = findViewById(R.id.one_zero);
        mb11 = findViewById(R.id.one_one);
        mb12 = findViewById(R.id.one_two);
        mb20 = findViewById(R.id.two_zero);
        mb21 = findViewById(R.id.two_one);
        mb22 = findViewById(R.id.two_two);
        mResult = findViewById(R.id.result_box);
        mPlayerOne = findViewById(R.id.player_one);
        mPlayerTwo = findViewById(R.id.player_two);
    }

    @Override
    public void onClick(View v) {
        if (count < 8) {
            switch (v.getId()) {
                case R.id.zero_zero:
                    writeTextToBlock(mb00, "a");
                    toast("00");
                    break;
                case R.id.zero_one:
                    writeTextToBlock(mb01, "b");
                    toast("01");
                    break;
                case R.id.zero_two:
                    writeTextToBlock(mb02, "c");
                    toast("02");
                    break;
                case R.id.one_zero:
                    writeTextToBlock(mb10, "d");
                    toast("10");
                    break;
                case R.id.one_one:
                    writeTextToBlock(mb11, "e");
                    toast("11");
                    break;
                case R.id.one_two:
                    writeTextToBlock(mb12, "f");
                    toast("12");
                    break;
                case R.id.two_zero:
                    writeTextToBlock(mb20, "g");
                    toast("20");
                    break;
                case R.id.two_one:
                    writeTextToBlock(mb21, "h");
                    toast("21");
                    break;
                case R.id.two_two:
                    writeTextToBlock(mb22, "i");
                    toast("22");
                    break;
                case R.id.bottom:
                    toast("bottom");
                    break;
            }
        }else{
            showAlert(0);
        }

    }

    private void writeTextToBlock(Button button, String text) {
        if (button.getText() != null) {
            if (count % 2 == 0) {
                button.setText("O");
                playerOne.add(text);
                if (count >= 4) {
                    checkCaseStart(1);
                }
            } else {
                button.setText("X");
                playerTwo.add(text);
                if (count >= 4) {
                    checkCaseStart(2);
                }
            }
            count++;
        }
    }

    private void checkCaseStart(int i) {
        if (checkForWin("a", "b", "c", i) == i) {
            showAlert(i);
        }
        if (checkForWin("d", "e", "f", i) == i) {
            showAlert(i);
        }
        if (checkForWin("g", "h", "i", i) == i) {
            showAlert(i);
        }
        if (checkForWin("a", "d", "g", i) == i) {
            showAlert(i);
        }
        if (checkForWin("b", "e", "h", i) == i) {
            showAlert(i);
        }
        if (checkForWin("c", "f", "i", i) == i) {
            showAlert(i);
        }
        if (checkForWin("a", "e", "i", i) == i) {
            showAlert(i);
        }
        if (checkForWin("c", "e", "g", i) == i) {
            showAlert(i);
        }
    }

    private int checkForWin(String a, String b, String c, int i) {
        boolean matchOne = true;
        boolean matchTwo = true;
        boolean matchThree = true;
        if (i == 1) {
            matchOne = playerOne.contains(a);
            matchTwo = playerOne.contains(b);
            matchThree = playerOne.contains(c);
        } else {
            matchOne = playerTwo.contains(a);
            matchTwo = playerTwo.contains(b);
            matchThree = playerTwo.contains(c);
        }
        if (matchOne && matchTwo && matchThree) {
            return i;
        } else {
            return 0;
        }
    }

    private void toast(String message) {
//        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void positiveButtonClick() {
        invalidate();
    }

    private void invalidate() {
        playerOne.clear();
        playerTwo.clear();
        count = 0;
        mb00.setText(null);
        mb01.setText(null);
        mb02.setText(null);
        mb10.setText(null);
        mb11.setText(null);
        mb12.setText(null);
        mb20.setText(null);
        mb21.setText(null);
        mb22.setText(null);
        mResult.setText(null
        );
    }

    private void showAlert(int i) {
        String message = "";
        if (i == 1) {
            message = "Player 1 Wins!!!";
        } else if(i == 2) {
            message = "Player 2 Wins!!!";
        }else{
            message = "Its A Tie!!!";
        }
        mResult.setText(message);
        AlertDialogBoxHelper.showDialogBox(this, message, "Reset", "Result", this);
    }
}
