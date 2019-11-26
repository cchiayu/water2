package com.fju.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class ResultActivity extends AppCompatActivity { ;

    private static final String TAG = ResultActivity.class.getSimpleName();
    private static final float DEFAULT_FEE = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        float money = intent.getFloatExtra(getString(R.string.extra_fee),DEFAULT_FEE);
        Log.d(TAG, money +" ");
        TextView moneyText = findViewById(R.id.money);
        int n = (int)(money + 0.5f);//四捨五入取到整數的作法
        moneyText.setText(n + "");
    }
}
