package com.example.aqsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button mLogin, mExit;
    EditText mEmail, mPass;
    String txEmail, txPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        mLogin=findViewById(R.id.btLogin);
        mExit=findViewById(R.id.btExit);
        mEmail=findViewById(R.id.edtemail);
        mPass=findViewById(R.id.edtpass);



        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                System.exit(0);

            }

        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txEmail=mEmail.getText().toString();
                txPass=mPass.getText().toString();
                checkNull();
                if(checkLogin()){
                    Intent main_menu = new Intent(LoginActivity.this,MainActivity.class)    ;
                    startActivity(main_menu);
                }

            }
        });
    }
    public boolean checkLogin(){

        if (txEmail.equals("admin") && txPass.equals("123")){
            return true;
        }else{
            Toast.makeText(this, "Email and password not valid", Toast.LENGTH_SHORT).show();
            return false;
        }

    };
    public void checkNull(){
        if(txEmail.equals("") && txPass.equals("")){
            Toast.makeText(this,"Please Input Email and password", Toast.LENGTH_LONG).show();
        }
        else if (txEmail.equals("") && txPass.length()!=0){
            Toast.makeText(this, "Please input Email", Toast.LENGTH_SHORT).show();
        }else if (txEmail.length()!=0 && txPass.equals("")){
            Toast.makeText(this, "Please input Password", Toast.LENGTH_SHORT).show();
        }

    }
}