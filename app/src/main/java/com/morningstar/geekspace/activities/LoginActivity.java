/*
 * Created by Sujoy Datta. Copyright (c) 2018. All rights reserved.
 *
 * To the person who is reading this..
 * When you finally understand how this works, please do explain it to me too at sujoydatta26@gmail.com
 * P.S.: In case you are planning to use this without mentioning me, you will be met with mean judgemental looks and sarcastic comments.
 */

package com.morningstar.geekspace.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.morningstar.geekspace.Managers.ConstantsManager;
import com.morningstar.geekspace.R;

public class LoginActivity extends AppCompatActivity {

    private Button button_signUp;
    private EditText editText_userName, editText_email, editText_phone;

    private String username, useremail;
    private long usermobile;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        button_signUp = findViewById(R.id.btn_SignUp);

        editText_userName = findViewById(R.id.editText_username);
        editText_email = findViewById(R.id.editText_email);
        editText_phone = findViewById(R.id.editText_phone);

        button_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editText_userName.getText()) &&
                        !TextUtils.isEmpty(editText_email.getText()) &&
                        (editText_phone.getText().length() == 10)) {

                    sharedPreferences = getSharedPreferences(String.valueOf(R.string.sharedPref_file_name), Context.MODE_PRIVATE);
                    editor = sharedPreferences.edit();

                    username = editText_userName.getText().toString().trim();
                    useremail = editText_email.getText().toString().trim();
                    usermobile = Long.parseLong(editText_phone.getText().toString());

                    editor.putString(ConstantsManager.shared_pref_username, username);
                    editor.putString(ConstantsManager.shared_pref_email, useremail);
                    editor.putLong(ConstantsManager.shared_pref_mobile, usermobile);
                    editor.apply();

//                    ProfileModel profileModel = new ProfileModel();
//                    profileModel.setUserName(username);
//                    profileModel.setUserEmail(useremail);
//                    profileModel.setMob(usermobile);

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    editText_userName.setError("All fields are required");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
