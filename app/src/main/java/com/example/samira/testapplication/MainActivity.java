package com.example.samira.testapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtName = findViewById(R.id.edtname);
        final EditText edtAge = findViewById(R.id.edtage);
        final EditText  edtSite= findViewById(R.id.edtsite);

        String prefName= PreferenceManager.getDefaultSharedPreferences(MainActivity.this) .getString("name","");
        edtName.setText(prefName);
        String prefAge=PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("age","");
        edtAge.setText(prefAge);
        String   prefWeb=PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("web","");
        edtSite.setText(prefWeb);


        Button buttonsave=findViewById(R.id.btnsave);
        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(MainActivity.this, Main2Activity.class);
                String sendName = String.valueOf(edtName.getText());
                String sendAge = String.valueOf(edtAge.getText());
                String sendWebSite = String.valueOf(edtSite.getText());
                in.putExtra("keyName", sendName);
                in.putExtra("keyAge", sendAge);
                in.putExtra("keyWebSite", sendWebSite);
                startActivityForResult(in, 10);


            }
        });



        Button button=findViewById(R.id.btnexit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog=new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Warning");
                alertDialog.setMessage("Exit from  Program?");
                alertDialog.setButton(alertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        onDestroy();
                        onStop();
                        //Intent intent =new  Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                       // startActivity(intent);
                       //dialog.dismiss();
                    }
                });
                alertDialog.setButton(alertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });
                alertDialog.show();
            }
        });
    }
}
