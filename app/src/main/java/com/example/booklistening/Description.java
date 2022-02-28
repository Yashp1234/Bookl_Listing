package com.example.booklistening;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Description extends AppCompatActivity {

    private TextView description;
    private ImageView thumbnail;
    private ImageButton previewButton;
    private ImageButton infoButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_description);
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        description = findViewById(R.id.tvDescription);
        thumbnail = findViewById(R.id.ivThumbnail);
        previewButton = findViewById(R.id.btnPreview);
        infoButton = findViewById(R.id.btnInfo);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String str = extras.getString("description");
            description.setText(str.toString());
            String thumbnailUrl = extras.getString("thumbnail");
            if (thumbnailUrl != null){
                Glide.with(getApplication()).load(thumbnailUrl).into(thumbnail);
                thumbnail.setVisibility(View.VISIBLE);
            }

            infoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "https" + extras.getString("info").substring(4);
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
            previewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "https" + extras.getString("preview").substring(4);
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
