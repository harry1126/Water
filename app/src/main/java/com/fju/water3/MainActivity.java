package com.fju.water3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edMonth;
    private EditText edNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edMonth = findViewById(R.id.month);
        edNext = findViewById(R.id.next);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reset();
                    }
                };
                if(!TextUtils.isEmpty(edMonth.getText().toString())){
                    float num = Float.parseFloat(edMonth.getText().toString());
                    float fee = 0;
                    if(num>=1&&num<=10){
                        fee = num*7.35f;
                    }else if(num>=11&&num<=30){
                        fee = num*9.45f-21;
                    }else if(num>=31&&num<=50){
                        fee = num*11.55f-84;
                    }else if(num>51){
                        fee = num*120.75f-110.25f;
                    }
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    startActivity(intent);
//             new AlertDialog.Builder(MainActivity.this)
//                     .setTitle("每月抄表費用")
//                     .setMessage("費用:"+fee)
//                     .setPositiveButton("Ok",listener)
//                     .show();
                }
                if(!TextUtils.isEmpty(edNext.getText().toString())) {
                    float number = Float.parseFloat(edNext.getText().toString());
                    float fee = 0;
                    if (number >= 1 && number <= 20) {
                        fee = number*7.35f;
                    } else if (number >= 21 && number <= 60) {
                        fee = number*9.45f-21;
                    } else if (number >= 61 && number <= 100) {
                        fee = number*11.55f-168;
                    } else if (number > 101) {
                        fee = number*12.075f-220.5f;
                    }
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    startActivity(intent);
//            new AlertDialog.Builder(MainActivity.this)
//                    .setTitle("隔月抄表費用")
//                    .setMessage("費用:" + fee)
//                    .setPositiveButton("Ok", listener)
//                    .show();
                }
            }
        });
    }
    public void fee(){

    }
    public void reset() {
        String message = "";
        edMonth.setText(message);
        edNext.setText(message);
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
