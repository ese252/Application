package com.example.samira.testapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        TextView  txtName = findViewById(R.id.txtname);
        TextView  txtAge = findViewById(R.id.txtage);
        final TextView  txtWebSite = findViewById(R.id.txtsite);

        Intent res=getIntent();
        String receivedName = res.getStringExtra("keyName");
        txtName.setText("Name: " + receivedName);

        String receivedAge = res.getStringExtra("keyAge");
        txtAge.setText("Age: " + receivedAge);

        String receivedWebSite = res.getStringExtra("keyWebSite");
        txtWebSite.setText(receivedWebSite);


        Button  btnYes = findViewById(R.id.btnYes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                TextView  txtName = findViewById(R.id.txtname);
                TextView  txtAge = findViewById(R.id.txtage);
                String stringToPassBack = txtName.getText().toString();
                String ToPassBack = txtAge.getText().toString();
                returnIntent.putExtra("Name", stringToPassBack);
                returnIntent.putExtra("Age", ToPassBack);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

        Button  btnNo = findViewById(R.id.btnNo);

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();

                returnIntent.putExtra("Status", "Not Successful!!!");
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });


        Button  btnOpenSite = findViewById(R.id.btnOpenSite);
        btnOpenSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Main2Activity.this,Main3Activity.class);
                String Url= String.valueOf(txtWebSite.getText());
                in.putExtra("url",Url);
                startActivity(in);
            }
        });

    }

}
