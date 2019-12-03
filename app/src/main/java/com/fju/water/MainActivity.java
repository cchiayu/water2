package com.fju.water;

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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() ;
    private EditText edmonth;
 //   private EditText ednext;
    boolean isNext = false;
  //  float month;
  //  float next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(TAG,"onCreate");
        edmonth = findViewById(R.id.month);
        //ednext = findViewById(R.id.next);

        Switch sw  = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text  = findViewById(R.id.type);
                text.setText(isNext ? getString(R.string.every_other_month):getString((R.string.monthly)));
            }
        });


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


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
        public void calculate(View view) {
         if(!TextUtils.isEmpty(edmonth.getText().toString())) {
              float degree = Float.parseFloat(edmonth.getText().toString());
              float money = 0;
              if(isNext=false){

              if (degree < 11) {
                  money = 7.35f * degree;
              }     else if (degree < 31) {
               money = 9.45f * degree - 21;
                } else if (degree < 51) {
                 money = 11.55f * degree - 84;
              } else {
                    money = 12.075f * degree -110.25f;
              }
              }else{
                  if (degree < 21) {
                      money = 7.35f * degree;
                  } else if (degree < 61) {
                      money = 9.45f * degree - 42;
                  } else if (degree < 101) {
                      money = 11.55f * degree - 168;
                  } else {
                      money = 12.075f * degree -220.5f;
                  }
              }
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(getString(R.string.extra_fee), money);
        startActivity(intent);

     /*   new AlertDialog.Builder(this)
                .setTitle("隔月抄表費用")
                .setMessage(getString(R.string.fee) +money)      fee被抽取到strings
                .setPositiveButton(getString(R.string.ok),null)   ok也是
                .show();*/
    }
   /*if(!TextUtils.isEmpty(ednext.getText().toString())) {
        float degree = Float.parseFloat(ednext.getText().toString());
        float money = 0;
        if (degree < 21) {
            money = 7.35f * degree;
        } else if (degree < 61) {
            money = 9.45f * degree - 42;
        } else if (degree < 101) {
            money = 11.55f * degree - 168;
        } else {
            money = 12.075f * degree -220.5f;
        }*/
       /* new AlertDialog.Builder(this)
                .setTitle("隔月抄表費用")
                .setMessage(getString(R.string.fee) +money)
                .setPositiveButton(getString(R.string.ok),null)
                .show();*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
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
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
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
