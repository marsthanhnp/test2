package com.example.aqsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DshocphihkActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    AdapterhocphiClass adapterhocphiClass;
    ArrayList<DshocphihkClass> manghocphi;
    ListView listView;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dshocphihk);
        listView=findViewById(R.id.lv_hocphi);

        manghocphi=new ArrayList<DshocphihkClass>();



        sharedPreferences=getSharedPreferences("dataLogin",MODE_PRIVATE);
        token="Bearer " + (sharedPreferences.getString("rmb_token",""));

        Call<DshocphihkClass> call = RetrofitclientClass.getInstance().getApi().dsHPHK(token,"admin");
        call.enqueue(new Callback<DshocphihkClass>() {
            @Override
            public void onResponse(Call<DshocphihkClass> call, Response<DshocphihkClass> response) {
                DshocphihkClass dsHocphiHKClass = response.body();

                if (dsHocphiHKClass != null) {

                    manghocphi.add(new DshocphihkClass(
                            dsHocphiHKClass.getTen_nhom_ct()
                            ,dsHocphiHKClass.getTen_hoc_ky()
                            ,dsHocphiHKClass.getHoc_phi()
                            ,dsHocphiHKClass.getMien_giam()
                            ,dsHocphiHKClass.getPhai_thu()
                            ,dsHocphiHKClass.getDa_thu()
                            , dsHocphiHKClass.getCon_no()));

                    adapterhocphiClass =new AdapterhocphiClass(DshocphihkActivity.this,R.layout.support_simple_spinner_dropdown_item,manghocphi);
                    listView.setAdapter(adapterhocphiClass);

//                    Toast.makeText(DshocphihkActivity.this, dsHocphiHKClass.getTen_nhom_ct(), Toast.LENGTH_LONG).show();
//                    Toast.makeText(DshocphihkActivity.this, token, Toast.LENGTH_LONG).show();


                    }else{
                    Toast.makeText(DshocphihkActivity.this, "có lỗi gì đó ở đây rồi", Toast.LENGTH_LONG).show();
                    }
            }

            @Override
            public void onFailure(Call<DshocphihkClass> call, Throwable t) {

            }
        });
    }
}