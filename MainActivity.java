package com.example.dim.providerloaderasynctask;


import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener {

    CursorLoader cursorLoader;
    ListView LV;
    SimpleCursorAdapter adapter;
    Button btnInsert;
    Button btnLoad;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportLoaderManager().initLoader(1, null, this);

        btnInsert = (Button)findViewById(R.id.main_btn_insert);
        btnInsert.setOnClickListener(this);

        btnLoad = (Button)findViewById(R.id.main_btn_load);
        btnLoad.setOnClickListener(this);

        btnShow = (Button)findViewById(R.id.main_btn_show);
        btnShow.setOnClickListener(this);

    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        switch (id){
            case 1:
                cursorLoader = new CursorLoader(this,Settings.CONTENT_URI,null,null,null,null);
                break;
            case 2:
                cursorLoader = new CursorLoader(this,Settings.CONTENT_URI_USERS,null,null,null,null);
                break;
            default:
        }

        return cursorLoader;
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<Cursor> loader, Cursor data) {
        LV = (ListView)findViewById(R.id.main_list);
        adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,data,new String[]{"name","email"},new int[]{android.R.id.text1,android.R.id.text2},adapter.NO_SELECTION);
        LV.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<Cursor> loader) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_btn_insert:
            ContentValues cv = new ContentValues();
                cv.put(Settings.ROW_NAME,"name1");
                cv.put(Settings.ROW_EMAIL,"name@ukr.ua");
                Uri newUri = getContentResolver().insert(Settings.CONTENT_URI,cv);
                getSupportLoaderManager().initLoader(1,null,this);
                break;
            case R.id.main_btn_load:
                getSupportLoaderManager().initLoader(2,null,this);
                break;
        }
    }
}
