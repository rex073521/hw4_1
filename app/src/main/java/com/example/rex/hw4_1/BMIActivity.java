package com.example.rex.hw4_1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by REX on 2015/4/4.
 */
public class BMIActivity extends ActionBarActivity{
    private TextView result;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        findViews();
        showResult();
    }

    public void findViews(){
        result=(TextView)findViewById(R.id.result);
        btnBack=(Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BMIActivity.this.finish();
            }
        });
    }

    public void showResult(){
        Bundle bundle=this.getIntent().getExtras();
        double height=bundle.getDouble("height");
        double weight=bundle.getDouble("weight");
        double bmi = weight/((height*height)/10000);
        //將計算出的bmi數值取至小數點兩位數
        DecimalFormat df=new DecimalFormat();
        bmi=Double.parseDouble(df.format(bmi));
        if(bmi<18.5){
            result.setText(bmi+"\n"+getString(R.string.bmiThin));
        }else if(bmi>24){
            result.setText(bmi+"\n"+getString(R.string.bmiFat));
        }else{
            result.setText(bmi+"\n"+getString(R.string.bmiOK));
        }

    }
}
