package com.kennedygamarra.musically;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class home extends AppCompatActivity {

    private TextView textViewId;
    private String id;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.ThemeMusically);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textViewId = findViewById(R.id.textViewId);
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null){
            id = user.getEmail();
            textViewId.setText("id:" + id);
        }
    }



    public void goBack(View view) {
        AlertDialog.Builder myAlertBuilder =
                new AlertDialog.Builder(home.this);
        myAlertBuilder.setTitle("Log out");
        myAlertBuilder.setMessage("Are you sure want to log out?");
        myAlertBuilder.setPositiveButton("LOG OUT", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(home.this,
                                MainActivity.class);
                        startActivity(intent);
                    }
                });
        myAlertBuilder.setNegativeButton("CANCEL", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Log out canceled",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        myAlertBuilder.show();


    }

    public void postedBy(View v) {
        ImageView imageView = findViewById(v.getId());
        showToast("Posted by " +  imageView.getContentDescription());
    }

    public void copy(View view) {

        showToast("Link copied to clipboard");
    }

    public void showToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void postVideo(View view) {
        AlertDialog.Builder myAlertBuilder =
                new AlertDialog.Builder(home.this);
        myAlertBuilder.setTitle("Post");
        myAlertBuilder.setMessage("Click POST to post a video, or CANCEL to exit:");
        myAlertBuilder.setPositiveButton("POST", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Posting video",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        myAlertBuilder.setNegativeButton("Cancel", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Post canceled",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        myAlertBuilder.show();
    }
}

/*  1-
    2-
    8- Mensaje toast al dar click en compartir
    9- Mensaje toast onclick al tocar una imagen ej: posted by xxxxx
    13- Alerte con ok y cancelar al presionar boton post video */