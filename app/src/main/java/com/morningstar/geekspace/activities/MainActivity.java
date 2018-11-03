/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
 */

package com.morningstar.geekspace.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.morningstar.geekspace.Managers.ConstantsManager;
import com.morningstar.geekspace.R;
import com.morningstar.geekspace.Utility.DrawerUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.dashboard_toolbar)
    Toolbar toolbar;
    @BindView(R.id.textViewUsername)
    TextView textView_username;
    @BindView(R.id.textViewUserEmail)
    TextView textView_useremail;
    @BindView(R.id.dashboard_lineChart)
    LineChart lineChart;

    private SharedPreferences sharedPreferences;
    private String username;
    private String useremail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setTitle(getResources().getString(R.string.dashboard));
        setSupportActionBar(toolbar);

        DrawerUtils.getDrawer(this, toolbar);

        sharedPreferences = getSharedPreferences(String.valueOf(R.string.sharedPref_file_name), MODE_PRIVATE);
        username = sharedPreferences.getString(ConstantsManager.SHARED_PREF_USERNAME, "UserName");
        useremail = sharedPreferences.getString(ConstantsManager.SHARED_PREF_EMAIL, "User Email");

        textView_username.setText(username);
        textView_useremail.setText(useremail);
    }
}
