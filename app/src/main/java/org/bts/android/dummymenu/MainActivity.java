package org.bts.android.dummymenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ActionMode.Callback, View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageViewIcon = (ImageView) findViewById(R.id.image_view_globe_icon);
        registerForContextMenu(imageViewIcon);

        final Button actionModeButton = (Button) findViewById(R.id.action_mode_button);
        actionModeButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = this.getMenuInflater();
        mMenuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.addItem:
                Log.i(MainActivity.TAG, "Add Button clicked");
                break;
            case R.id.likeItem:
                Log.i(MainActivity.TAG, "Like Button clicked");
                break;
            case R.id.dislikeItem:
                Log.i(MainActivity.TAG, "Dislike Button clicked");
                break;
            case R.id.fuegoItem:
                Log.i(MainActivity.TAG, "Fuego Button clicked");
                break;
            default:
                Log.i(MainActivity.TAG, "Other Button clicked");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View whichView, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, whichView, menuInfo);
        MenuInflater mContMenuInflater = this.getMenuInflater();
        mContMenuInflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.addItem:
                Log.d(MainActivity.TAG, "Add context Button clicked");
                break;
            case R.id.likeItem:
                Log.d(MainActivity.TAG, "Like context Button clicked");
                break;
            case R.id.dislikeItem:
                Log.d(MainActivity.TAG, "Dislike context Button clicked");
                break;
            case R.id.fuegoItem:
                Log.d(MainActivity.TAG, "Fuego context Button clicked");
                break;
            default:
                Log.d(MainActivity.TAG, "Other context Button clicked");
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch(item.getItemId()) {
            case R.id.addItem:
                Log.e(MainActivity.TAG, "Add ActionContext Button clicked");
                break;
            case R.id.likeItem:
                Log.e(MainActivity.TAG, "Like ActionContext Button clicked");
                break;
            case R.id.dislikeItem:
                Log.e(MainActivity.TAG, "Dislike ActionContext Button clicked");
                break;
            case R.id.fuegoItem:
                Log.e(MainActivity.TAG, "Fuego ActionContext Button clicked");
                break;
            default:
                Log.e(MainActivity.TAG, "Other ActionContext Button clicked");
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    @Override
    public void onClick(View whichView) {
        if (whichView.getId() == R.id.action_mode_button) {
            startSupportActionMode(this);
        }

    }
}
