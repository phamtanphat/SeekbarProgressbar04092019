package com.example.seekbarprogressbar04092019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton imgStart;
    CheckBox cbOne,cbTwo,cbThree;
    SeekBar skOne,skTwo,skThree;
    Random random = new Random();
    int randomskOne = 0;
    int randomskTwo = 0;
    int randomskThree = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        singleCheckedCheckbox();
        setEnableView();
        eventClick();
    }

    private void setEnableView() {
        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);
    }


    private void singleCheckedCheckbox() {
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);
                }
            }
        });
    }

    private void eventClick() {
        imgStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()){
                    randomSeekbar();
                }else{
                    Toast.makeText(MainActivity.this, "Hãy đặt cược!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void randomSeekbar() {

        CountDownTimer countDownTimer = new CountDownTimer(100000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                randomskOne = random.nextInt(15);
                randomskTwo = random.nextInt(15);
                randomskThree = random.nextInt(15);

                skOne.setProgress(skOne.getProgress() + randomskOne);
                skTwo.setProgress(skTwo.getProgress() + randomskTwo);
                skThree.setProgress(skThree.getProgress() + randomskThree);
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();

    }


    private void init() {
        imgStart = findViewById(R.id.imagebuttonStart);
        cbOne = findViewById(R.id.checkboxOne);
        cbTwo = findViewById(R.id.checkboxTwo);
        cbThree = findViewById(R.id.checkboxThree);
        skOne = findViewById(R.id.seekbarOne);
        skTwo = findViewById(R.id.seekbarTwo);
        skThree = findViewById(R.id.seekbarThree);
    }
}
