package com.example.booklistening;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class BooksAdapter extends ArrayAdapter<Book> {
    private static final String DEBUG_TAG = "HttpExample";
    public BooksAdapter(Context context, ArrayList<Book> book) {
        super(context, 0, book);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.books_item, parent, false);
        }

        Book book = getItem(position);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        tvTitle.setText(book.getTitle());

        TextView tvAuthor = (TextView) convertView.findViewById(R.id.tvAuthor);
        tvAuthor.setText("Author - " + book.getAuthor());

        TextView tvRating = (TextView) convertView.findViewById(R.id.tvRating);
        String rating = book.getmRating();

        TextView tvPublishedDate = (TextView) convertView.findViewById(R.id.tvPublishedDate);
        tvPublishedDate.setText("Published Date - " + book.getmPublishedDate());

        TextView tvPagesCount = (TextView) convertView.findViewById(R.id.tvPagesCount);
        String pagesCount = "Total no. of pages - " + book.getmPagesCount();
        tvPagesCount.setText(pagesCount);

        TextView tvPublisher = (TextView) convertView.findViewById(R.id.tvPublisher);
        String publisher = "Publisher - " + book.getmPublisher();
        tvPublisher.setText(publisher);

        if (rating == "NA") {
            tvRating.setText(book.getmRating() + " (Average Rating)");
        }
        else{
            tvRating.setText(book.getmRating() + "/5 (Average Rating)");
        }

        return convertView;
    }

}