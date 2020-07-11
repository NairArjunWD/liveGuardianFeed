package com.example.liveguardianfeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    public static final String GUARDIAN_REQUEST_URL =
            "https://content.guardianapis.com/search?q=debate&tag=politics/politics&from-date=2014-01-01&api-key=test";

    NewsAdapter mAdapter;
    TextView internetError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView newsListView = findViewById(R.id.list_feed);
//        internetError = findViewById(R.id.internet_error);
//        newsListView.setEmptyView(internetError);
        mAdapter = new NewsAdapter(this, new ArrayList<News>());


        newsListView.setAdapter(mAdapter);
        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                News mNews = mAdapter.getItem(position);
                Uri newsUri = Uri.parse(mNews.getmUrl());
                Intent guardianIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                startActivity(guardianIntent);
            }
        });

        // Network Connection

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        Network networkInfo = null;
        if (connMgr != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    networkInfo = connMgr.getActiveNetwork();
                }
            }

        } else {
            // Else display error message
            internetError.setText(R.string.internet_error);
        }
    }

    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
       return new NewsLoader(this, GUARDIAN_REQUEST_URL);

    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> data) {
        mAdapter = new NewsAdapter(this, (ArrayList<News>) data);

    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        mAdapter.clear();
    }


}