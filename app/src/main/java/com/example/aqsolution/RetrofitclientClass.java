package com.example.aqsolution;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitclientClass {
    private static final String BASE_URL = "http://edusoft.net.vn:8091/api/";
    private  static  RetrofitclientClass mInstance;
    private Retrofit retrofit;




    private RetrofitclientClass(){
//        đăng nhập auth bearer token không thành công

//        sharedPreferences=getSharedPreferences("dataLogin",MODE_PRIVATE);
//        token="Bearer " + (sharedPreferences.getString("rmb_token",""));
//


//        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request newRequest  = chain.request().newBuilder()
//                        .addHeader("Authorization", "Bearer " + token)
//                        .build();
//                return chain.proceed(newRequest);
//            }
//        }).build();
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized RetrofitclientClass getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitclientClass();
        }
        return mInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}

