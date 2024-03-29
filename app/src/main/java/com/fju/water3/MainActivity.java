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
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName() ;
    boolean isNext = false;
    private EditText edMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edMonth = findViewById(R.id.month);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Switch sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.type);
                text.setText(isNext ?getString(R.string.every_other_month):getString(R.string.monthly));
            }
        });
        //spinner
        Spinner cities = findViewById(R.id.spinner);
        cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,getResources().getStringArray(R.array.cities)[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fee();
            }
            public void fee() {
                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reset();
                    }
                };
                if (!TextUtils.isEmpty(edMonth.getText().toString())) {
                    float num = Float.parseFloat(edMonth.getText().toString());
                    float fee = 0;
                    if(isNext == false) {
                        if (num >= 1 && num <= 10) {
                            fee = num * 7.35f;
                        } else if (num >= 11 && num <= 30) {
                            fee = num * 9.45f - 21;
                        } else if (num >= 31 && num <= 50) {
                            fee = num * 11.55f - 84;
                        } else if (num > 51) {
                            fee = num * 120.75f - 110.25f;
                        }
                    }else{
                        if (num >= 1 && num <= 20) {
                            fee = num * 7.35f;
                        } else if (num >= 21 && num <= 60) {
                            fee = num * 9.45f - 21;
                        } else if (num >= 61 && num <= 100) {
                            fee = num * 11.55f - 168;
                        } else if (num > 101) {
                            fee = num * 12.075f - 220.5f;
                        }
                    }
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra(getString(R.string.extra_fee), fee);
                    startActivity(intent);
//             new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("每月抄表費用")
//                        .setMessage(getString(R.string.fee)+fee)
//                        .setPositiveButton(getString(R.string.ok),listener)
//                        .show();
        }
//        if(!TextUtils.isEmpty(edNext.getText().toString())) {
//            float number = Float.parseFloat(edNext.getText().toString());
//            float fee = 0;
//            if (number >= 1 && number <= 20) {
//                fee = number*7.35f;
//            } else if (number >= 21 && number <= 60) {
//                fee = number*9.45f-21;
//            } else if (number >= 61 && number <= 100) {
//                fee = number*11.55f-168;
//            } else if (number > 101) {
//                fee = number*12.075f-220.5f;
//            }
//            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
//            intent.putExtra(getString(R.string.extra_fee),fee);
//            startActivity(intent);
////            new AlertDialog.Builder(MainActivity.this)
////                    .setTitle("隔月抄表費用")
////                    .setMessage("費用:" + fee)
////                    .setPositiveButton("Ok", listener)
////                    .show();
//        }
    }
});
    }
    public void reset() {
        String message = "";
        edMonth.setText(message);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
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
