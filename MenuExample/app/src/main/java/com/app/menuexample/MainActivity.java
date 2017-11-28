package com.app.menuexample;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        Button btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        registerForContextMenu(btn);

        Button btnPopUp = findViewById(R.id.btnPopupMenu);
        btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu
                        (MainActivity.this,view);
                getMenuInflater().inflate(R.menu.main_menu
                        ,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(
                        new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.settings:
                                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }

                });
                popupMenu.show();

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
