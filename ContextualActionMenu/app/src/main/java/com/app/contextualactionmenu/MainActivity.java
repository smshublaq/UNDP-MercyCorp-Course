package com.app.contextualactionmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Button btnActionMode = findViewById(R.id.btnActionMode);
        btnActionMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                startActionMode(callback);
                return true;
            }
        });
    }

    ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            getMenuInflater().inflate(R.menu.menu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.delete:
                    Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.edit:
                    Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_SHORT).show();
                    break;
            }
            actionMode.finish();
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

        }
    };
}
