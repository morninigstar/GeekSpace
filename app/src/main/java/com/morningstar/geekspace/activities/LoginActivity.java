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
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.dd.processbutton.iml.ActionProcessButton;
import com.morningstar.geekspace.Managers.ConstantsManager;
import com.morningstar.geekspace.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_SignUp)
    ActionProcessButton button_signUp;
    @BindView(R.id.editText_username)
    EditText editText_userName;
    @BindView(R.id.editText_email)
    EditText editText_email;
    @BindView(R.id.editText_phone)
    EditText editText_phone;

    private String username, useremail;
    private long usermobile;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        button_signUp.setMode(ActionProcessButton.Mode.ENDLESS);
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

                    editor.putString(ConstantsManager.SHARED_PREF_USERNAME, username);
                    editor.putString(ConstantsManager.SHARED_PREF_EMAIL, useremail);
                    editor.putLong(ConstantsManager.SHARED_PREF_MOBILE, usermobile);
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
