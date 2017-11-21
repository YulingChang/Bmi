package com.ling.bmi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String s = new String("abc");
    private EditText edWeight;
    private EditText edHeight;
    /*View.OnClickListener listener = new View.OnClickListener() {*/

    public MainActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity","OnCrate");
        setContentView(R.layout.activity_main);
        Button bHelp = findViews();
        bHelp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("解釋")
                        .setMessage("BMI的設計是一個用於公眾健康研究的統計工具。")
                        .setPositiveButton("OK",null)
                        .show();
            }
        });
                                 }

    private Button findViews() {
        edWeight = (EditText) findViewById(R.id.ed_weight);   /*ctrl+alt+f 變屬性 (跑到16行)*/
        edHeight = (EditText) findViewById(R.id.ed_height);
        return (Button) findViewById(R.id.b_help);
    }/*快捷ctrl+alt+m */

    //getResources().getString(R.string.app_name);

    public void bmi(View view){
      //  System.out.println("What???");     (快捷 sout+tab)

        Log.d("MainActivity","testing bmi method");

        float weight = Float.parseFloat(edWeight.getText().toString());
        float height = Float.parseFloat(edHeight.getText().toString());
        float bmi = weight / (height * height);

        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra(getString(R.string.extrabmi),bmi);
        startActivity(intent);

        /*if(height>3){
            new AlertDialog.Builder(this)
                    .setMessage("身高單位應為公尺")
                    .setTitle("提醒")
                    .setPositiveButton("ok", null)
                    .show();
        }
        if (bmi<20) {
            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.your_bmi_is) + bmi + "   請多吃點")
                    .setTitle(getString(R.string.the_title))
                    .setPositiveButton(getString(R.string.ok), null)
                    .show();
        }
        else
            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.your_bmi_is) + bmi)
                    .setTitle(getString(R.string.the_title))
                    .setPositiveButton(getString(R.string.ok), null)
                    .show();*/




        /*Log.d("MainActivity","Your BMI is:"+bmi);
        Toast.makeText(this,"Your BMI is"+bmi,ToastLENGTH_SHORT)
                .show();
*/
    }}

