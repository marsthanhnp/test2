package com.example.aqsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    Button mLogin, mExit;
    EditText mEmail, mPass;
    String txEmail, txPass;
    CheckBox checkBox;
    SharedPreferences sharedPreferences;
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
        sharedPreferences=getSharedPreferences("dataLogin",MODE_PRIVATE);
        checkBox=findViewById(R.id.cb_rememberLogin);

//        lấy giá trị nếu có nhớ, không nhớ thì gán rỗng
        mEmail.setText(sharedPreferences.getString("rmb_username",""));
        mPass.setText(sharedPreferences.getString("rmb_password",""));
        checkBox.setChecked(sharedPreferences.getBoolean("rmb_checked",false));


//        nút thoát
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
                checkLogin();
                }
                });
            }

    private void checkLogin() {
        String grant_type="password";
        String email = mEmail.getText().toString().trim();
        String password = mPass.getText().toString().trim();
                if (email.isEmpty()) {
                    mEmail.setError("Username is required");
                    mPass.requestFocus();
                    return;
                }

                if (password.isEmpty()) {
                    mPass.setError("Password required");
                    mPass.requestFocus();
                    return;
                }

                if (password.length() < 6) {
                    mPass.setError("Password should be atleast 6 character long");
                    mPass.requestFocus();
                    return;
                }



        Call<TokenClass> call = RetrofitclientClass.getInstance().getApi().userLogin(grant_type, email, password);
        call.enqueue(new Callback<TokenClass>() {
            @Override
            public void onResponse(Call<TokenClass> call, Response<TokenClass> response) {
                TokenClass tokenClass = response.body();

                if (tokenClass != null) {

//                    toast cái token nhận được xem thử
//                    Toast.makeText(LoginActivity.this, tokenClass.getAccess_token(), Toast.LENGTH_LONG).show();

//                    nếu có check thì nhớ các giá trị đăng nhập
                    if(checkBox.isChecked()){
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("rmb_token",tokenClass.getAccess_token());
                        editor.putString("rmb_username",email);
                        editor.putString("rmb_password",password);
                        editor.putString("rmb_name",tokenClass.getName());
                        editor.putString("rmb_principal",tokenClass.getPrincipal());
                        editor.putBoolean("rmb_checked",true);
                        editor.commit();
                    }else{
//                    nếu không check nhớ thì xóa luôn, khỏi phải nhớ nữa
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.remove("rmb_username");
                        editor.remove("rmb_password");
                        editor.remove("rmb_checked");
                        editor.commit();
                    }

                    Intent main_menu = new Intent(LoginActivity.this,MainActivity.class)    ;
                    startActivity(main_menu);

                } else {

//                    nếu đăng nhập sai thì xóa luôn, khỏi phải nhớ nữa
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.remove("rmb_token");
                    editor.remove("rmb_username");
                    editor.remove("rmb_password");
                    editor.remove("rmb_checked");
                    editor.commit();

                    Toast.makeText(LoginActivity.this, "Tài khoản không đúng, vui lòng liên hệ quản trị viên!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<TokenClass> call, Throwable t) {

            }
        });
            }

            ;

            public void checkNull() {
                if (txEmail.equals("") && txPass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please Input Email and password", Toast.LENGTH_LONG).show();
                } else if (txEmail.equals("") && txPass.length() != 0) {
                    Toast.makeText(LoginActivity.this, "Please input Email", Toast.LENGTH_SHORT).show();
                } else if (txEmail.length() != 0 && txPass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please input Password", Toast.LENGTH_SHORT).show();
                }

            }
        }
