package com.maktab.digitallibrary.mainPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.maktab.digitallibrary.R;
import com.maktab.digitallibrary.database.DatabaseAccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static Context context;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView hambur;
    SQLiteDatabase database;
    String destPath;
    public static ArrayList<Structure> flower = new ArrayList<Structure>();
    public static ArrayList<Structure> tree = new ArrayList<Structure>();
    public static ArrayList<Structure> favorite = new ArrayList<Structure>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity_main);

        context = getApplicationContext();
        setTabOption();

        drawerLayout = findViewById(R.id.navigation_drawer);
        navigationView = findViewById(R.id.navigation_view);
        hambur = findViewById(R.id.ham);
        hambur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.setting) {
                    Log.i("mylog", "hello!");
                }
                return true;
            }
        });

        /*
      try {
            destPath= Environment.getExternalStorageDirectory().getAbsolutePath()+"/book-database/";
            Log.i("my",destPath);
           File file=new File(destPath);
            if (!file.exists()){
                file.mkdirs();
                file.createNewFile();
                Log.i("my","create");
                CopyDB(getBaseContext().getAssets().open("md_book.db"),new FileOutputStream(destPath+"/md_book.db"));
                Log.i("my","create2");
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            Log.i("my","notcreate");
        }catch (IOException e){
            e.printStackTrace();
          Log.i("my","create2");
        }
*/
        selectFlower();
        selectTree();
        selectFav();


    }


    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            drawerLayout.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }
    }


    /* private void CopyDB(InputStream inputStream, OutputStream  outputStream) throws IOException{
         byte[] buffer=new byte[1024];
         int length;
         while ((length=inputStream.read(buffer))>0){
             outputStream.write(buffer,0,length);
         }
         inputStream.close();
         outputStream.close();
     }

     */
    private void selectFlower() {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        flower = databaseAccess.getFlower();
        databaseAccess.close();
    }

    private void selectTree() {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        tree = databaseAccess.getTree();
        databaseAccess.close();
    }

    private void selectFav() {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        favorite = databaseAccess.getFav();
        databaseAccess.close();
    }



    private void setTabOption() {

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new AdapterFragment(getSupportFragmentManager()));
        TabLayout tabStrip = findViewById(R.id.tabs);
        tabStrip.setupWithViewPager(viewPager);


    }

}