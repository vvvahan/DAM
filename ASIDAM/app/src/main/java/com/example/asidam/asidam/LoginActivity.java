package com.example.asidam.asidam;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{

    // UI references.
    private EditText Email;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int contar = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        Email = (EditText) findViewById(R.id.etemail);
        Password = (EditText) findViewById(R.id.etpassword);
        Info = (TextView) findViewById(R.id.tvinfo);
        Login = (Button) findViewById(R.id.btnlogin);
        Info.setText("Number of attemps remaining: 5");
        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view) {
                Validate(Email.getText().toString(), Password.getText().toString());
            }
        });
        }

    private void Validate(String userEmail, String userPassword) {
        if ((userEmail.equals("Admin@pt.pt")) && (userPassword.equals("12345"))) {
            Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
            startActivity(intent);
        }else {
            contar--;

            Info.setText("Number of attemps remaining: " + String.valueOf(contar));
            if(contar == 0){
                Login.setEnabled(false);
            }
        }
    }}
