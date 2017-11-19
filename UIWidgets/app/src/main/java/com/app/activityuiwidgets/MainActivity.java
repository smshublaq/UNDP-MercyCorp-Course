package com.app.activityuiwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

// implements View.OnClickListener
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etNum1 = findViewById(R.id.etNumber1);
        final EditText etNum2 = findViewById(R.id.etNumber2);
        final TextView tvResult = findViewById(R.id.tvResult);
        Button btn = findViewById(R.id.btnShow);
        SeekBar seekBar = findViewById(R.id.seekBar);
        CheckBox checkBox2 = findViewById(R.id.checkbox2);
        CheckBox checkBox = findViewById(R.id.checkbox);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        Switch switchS = findViewById(R.id.switchS);

        RadioGroup rdnGroup = findViewById(R.id.rdnGroup);


        rdnGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton radioButton = radioGroup.findViewById(id);
                Toast.makeText(MainActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });






        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!etNum1.getText().toString().isEmpty() && !etNum2.getText().toString().isEmpty()) {
                    int num1 = Integer.parseInt(etNum1.getText().toString());
                    int num2 = Integer.parseInt(etNum2.getText().toString());
                    int sum = num1 + num2;

                    tvResult.setText(sum+"");
                    Toast.makeText(MainActivity.this, (num1+num2)+"", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //btn.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"onStartTrackingTouch", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean isUser) {
                tvResult.setText(progress+"");
                tvResult.setTextSize(progress);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"onStopTrackingTouch", Toast.LENGTH_SHORT).show();
            }
        });


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, compoundButton.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean isUser) {
                Toast.makeText(MainActivity.this, v+"", Toast.LENGTH_SHORT).show();
            }
        });

        switchS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



    public void showName(View v){
        Toast.makeText(this, "Ahmed", Toast.LENGTH_SHORT).show();
    }

    /*
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnShow:
                Toast.makeText(this, "Ahmed", Toast.LENGTH_SHORT).show();
        }
    }
    */
}
