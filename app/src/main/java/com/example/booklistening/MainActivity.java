package com.example.booklistening;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BooksAdapter adapter;
    private EditText topicTV;
    private ImageButton buttonSearch;
    private ArrayList<Book> books;
    private ProgressBar progressBar;
    private SearchView searchView;
    private static final String DEBUG_TAG = "HttpExample";
    private TextView emptyView,bestResultsTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topicTV = findViewById(R.id.tvEdtTopic);
        buttonSearch = findViewById(R.id.btnSearch);
        progressBar = findViewById(R.id.progress);
        emptyView = findViewById(R.id.empty_view);
        bestResultsTV = findViewById(R.id.idTVBestResults);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView bookListView = (ListView) findViewById(R.id.bookslist);

                adapter = new BooksAdapter(MainActivity.this, new ArrayList<Book>());

                bookListView.setAdapter(adapter);

                bookListView.setEmptyView(emptyView);

                bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        // Find the current earthquake that was clicked on
                        Book currentBook = adapter.getItem(position);

                        Intent descriptionIntent = new Intent(MainActivity.this, Description.class);
                        descriptionIntent.putExtra("description", currentBook.getmDesription());
                        descriptionIntent.putExtra("thumbnail", currentBook.getmThumbnailurl());
                        descriptionIntent.putExtra("preview", currentBook.getmPreviewUrl());
                        descriptionIntent.putExtra("info", currentBook.getMinfoUrl());
                        startActivity(descriptionIntent);
                    }
                });

                // Start the AsyncTask to fetch the earthquake data
                BookAsyncTask task = new BookAsyncTask();
                task.execute("https://www.googleapis.com/books/v1/volumes?q=" + topicTV.getText().toString() + "&key=AIzaSyBCYqLfqCZ76SEddf2SDZqLQXfs5jq4Ey8");
            }
        });

    }

    private class BookAsyncTask extends AsyncTask<String, Void, List<Book>> {
        @Override
        protected List<Book> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<Book> result = null;
            try {
                result = QueryUtils.fetchBookData(urls[0]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return result;
        }
        @Override
        protected void onPostExecute(List<Book> data) {
            adapter.clear();
            progressBar.setVisibility(View.GONE);
//            bestResultsTV.setVisibility(View.VISIBLE);
            if (data != null && !data.isEmpty()) {
                adapter.addAll(data);
            }
        }
        @Override
        protected void onPreExecute() {
            emptyView.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }
    }
}