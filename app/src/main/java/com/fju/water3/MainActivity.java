package com.fju.water3;

import android.content.DialogInterface;
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
    }
    public void reset(){
        String message = "";
        edMonth.setText(message);
        edNext.setText(message);
    }

    public  void Button(View view){
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            reset();
        }
    };
        if(!TextUtils.isEmpty(edMonth.getText().toString())){
            float num = Float.parseFloat(edMonth.getText().toString());
            if(num>=1&&num<=10){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:"+num*7.35)
                        .setPositiveButton("Ok",listener)
                        .show();
            }else if(num>=11&&num<=30){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:"+(num*9.45-21))
                        .setPositiveButton("Ok",listener)
                        .show();

            }else if(num>=31&&num<=50){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:"+(num*11.55-84))
                        .setPositiveButton("Ok",listener)
                        .show();
            }else if(num>51){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:"+(num*12.075-110.25))
                        .setPositiveButton("Ok",listener)
                        .show();
            }

            }
        if(!TextUtils.isEmpty(edNext.getText().toString())) {
            float number = Float.parseFloat(edNext.getText().toString());
            if (number >= 1 && number <= 20) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用:" + number * 7.35)
                        .setPositiveButton("Ok", listener)
                        .show();
            } else if (number >= 21 && number <= 60) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用:" + (number * 9.45-42))
                        .setPositiveButton("Ok", listener)
                        .show();

            } else if (number >= 61 && number <= 100) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用:" + (number * 11.55-168))
                        .setPositiveButton("Ok", listener)
                        .show();
            } else if (number > 101) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用:" +(number * 12.075-220.5))
                        .setPositiveButton("Ok", listener)
                        .show();
            }
        }
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
