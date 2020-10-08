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
import com.maktab.digitallibrary.mainPage.AdapterFragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    public static Context context;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView hambur;
    SQLiteDatabase database;
    String destPath;

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
  //    selectflower();

        copyAppDbToDownloadFolder();


    }


    public void onBackPressed(){

        if (drawerLayout.isDrawerOpen(Gravity.RIGHT)){
            drawerLayout.closeDrawer(Gravity.RIGHT);
        } else{
            super.onBackPressed();
        }
    }

    public void copyAppDbToDownloadFolder()  {
        try {
            File backupDB = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "md_book.db"); // for example "my_data_backup.db"
            File currentDB = getApplicationContext().getDatabasePath("md_book.db"); //databaseName=your current application database name, for example "my_data.db"
            if (currentDB.exists()) {
                FileInputStream fis = new FileInputStream(currentDB);
                FileOutputStream fos = new FileOutputStream(backupDB);
                fos.getChannel().transferFrom(fis.getChannel(), 0, fis.getChannel().size());
                // or fis.getChannel().transferTo(0, fis.getChannel().size(), fos.getChannel());
                fis.close();
                fos.close();
                Log.i("Database successfully", " copied to download folder");

            } else Log.i("Copying Database", " fail, database not found");
        } catch (IOException e) {
            Log.d("Copying Database", "fail, reason:", e);
        }
    }



    private void CopyDB(InputStream inputStream, OutputStream  outputStream) throws IOException{
        byte[] buffer=new byte[1024];
        int length;
        while ((length=inputStream.read(buffer))>0){
            outputStream.write(buffer,0,length);
        }
        inputStream.close();
        outputStream.close();
    }

    private void selectflower(){
        database=SQLiteDatabase.openOrCreateDatabase(destPath+"/md_book.db",null);
        Cursor cursor=database.rawQuery("SELECT * FROM main WHERE subject='flower'",null);
        while (cursor.moveToNext()){
            String title=cursor.getString(cursor.getColumnIndex("title"));

        }


    }

    private void setTabOption() {

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new AdapterFragment(getSupportFragmentManager()));
        TabLayout tabStrip = findViewById(R.id.tabs);
        tabStrip.setupWithViewPager(viewPager);


    }

}