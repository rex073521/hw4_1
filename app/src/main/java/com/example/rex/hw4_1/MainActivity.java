package com.example.rex.hw4_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    TextView editTxtH,editTxtW;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    protected void findViews(){
        editTxtH=(TextView)findViewById(R.id.editTxtH);
        editTxtW=(TextView)findViewById(R.id.editTxtW);
        btnOK=(Button)findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,BMIActivity.class);
                Bundle bundle=new Bundle();

                try{
                    double height=Double.parseDouble(editTxtH.getText().toString());
                    double weight=Double.parseDouble(editTxtW.getText().toString());
                    //比對輸入的值是否為空值
                    boolean h=editTxtH.equals("");
                    boolean w=editTxtW.equals("");
                    //若身高或體重有一個為空值則拋出例外
                    if (h || w){
                        throw new Exception();
                    }
                    bundle.putDouble("height",height);
                    bundle.putDouble("weight",weight);

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"請輸入身高體重",Toast.LENGTH_SHORT).show();
                    return;
                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
