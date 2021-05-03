package com.kennedygamarra.musically;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.ThemeMusically);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Login(View v) {
        EditText email = findViewById(R.id.editTextTextEmailAddress);
        EditText password = findViewById(R.id.editTextTextPassword);

        if( !email.getText().toString().isEmpty()
                || !password.getText().toString().isEmpty()){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }else{
            Toast.makeText(getApplicationContext(), "Please, complete all fields!",
                    Toast.LENGTH_LONG).show();
        }
    }

    public  void Register(View v){
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
}

