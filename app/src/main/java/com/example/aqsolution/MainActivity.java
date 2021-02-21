package com.example.aqsolution;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView img_news,img_fanpage,img_gopy,img_tdmunews, img_info, img_hocphi, img_kynang, img_location, img_about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        https://github.com/AnonimoDiabo/NavigationDrawer/tree/master/app/src/main/java/com/anonimodiabo/navigationdrawer

//        ẩn thanh toolbar
        drawerLayout=findViewById(R.id.drawer_layout);
//        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);

//        ánh xạ image view và view
        img_news=findViewById(R.id.im_news);
        img_fanpage=findViewById(R.id.img_fanpage);
        img_gopy=findViewById(R.id.img_gopy);
        img_tdmunews=findViewById(R.id.img_tdmunews);
        img_info=findViewById(R.id.img_info);
        img_hocphi=findViewById(R.id.img_hocphi);
        img_kynang=findViewById(R.id.img_kynang);
        img_location=findViewById(R.id.img_location);
        img_about=findViewById(R.id.img_about);

//        Gán toolbar mới thay cho toolbar mặc định
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu25x25);

       toolbar.setNavigationOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               drawerLayout.openDrawer(GravityCompat.START);
           }
       });





       img_news.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent int_news = new Intent(MainActivity.this,NewsActivity.class);
               startActivity(int_news);
           }
       });
       img_fanpage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent int_fanpage = new Intent(MainActivity.this,FanpageActivity.class);
               int_fanpage.putExtra("link_fanpage","https://www.facebook.com/CFSTDMU/");
               startActivity(int_fanpage);
           }
       });

       img_gopy.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent int_gopy = new Intent(MainActivity.this,GopyActivity.class);
               int_gopy.putExtra("link_gopy","https://tdmu.edu.vn/lien-he");
//               int_gopy.putExtra("link_gopy","https://www.facebook.com/messages/t/649079911793156");
               startActivity(int_gopy);
           }
       });
        img_tdmunews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_tdmunews = new Intent(MainActivity.this,TdmunewsActivity.class);
                int_tdmunews.putExtra("link_tdmunews","https://tdmu.edu.vn/tin-tuc");
                startActivity(int_tdmunews);
            }
        });
        img_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_info = new Intent(MainActivity.this,InfoActivity.class);
                startActivity(int_info);
            }
        });

        img_hocphi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_hocphi = new Intent(MainActivity.this,DshocphihkActivity.class);
                startActivity(int_hocphi);
            }
        });

        img_kynang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_kynang = new Intent(MainActivity.this,KynangActivity.class);
                startActivity(int_kynang);
            }
        });

        img_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_location = new Intent(MainActivity.this,LocationActivity.class);
                startActivity(int_location);
            }
        });

        img_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_about = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(int_about);
            }
        });
    }
//tạo menu và gán
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{

            super.onBackPressed();
        }
    }
    


}