package com.example.booklistening;

public class Book {
    private String title;
    private String author;
    private String mRating;
    private String mPagesCount;
    private String mPublisher;
    private String mPublishedDate;
    private String mDesription;
    private String mThumbnailurl;
    private String mPreviewUrl;
    private String minfoUrl;

    public Book(String title, String description,String rating, String pagesCount,String publisher,String desription,String thumbnailurl,String publishedDate,String preview,String info) {
        this.title = title;
        this.author = description;
        this.mRating = rating;
        this.mPagesCount = pagesCount;
        this.mPublisher = publisher;
        this.mPublishedDate = publishedDate;
        this.mDesription = desription;
        this.mThumbnailurl = thumbnailurl;
        this.minfoUrl = info;
        this.mPreviewUrl = preview;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getmRating() {
        return mRating;
    }

    public void setmRating(String mRating) {
        this.mRating = mRating;
    }

    public String getmPagesCount() {
        return mPagesCount;
    }

    public void setmPagesCount(String mPagesCount) {
        this.mPagesCount = mPagesCount;
    }

    public String getmPublisher() {
        return mPublisher;
    }

    public void setmPublisher(String mPublisher) {
        this.mPublisher = mPublisher;
    }

    public String getmDesription() {
        return mDesription;
    }

    public void setmDesription(String mDesription) {
        this.mDesription = mDesription;
    }

    public String getmThumbnailurl() {
        return mThumbnailurl;
    }

    public void setmThumbnailurl(String mThumbnailurl) {
        this.mThumbnailurl = mThumbnailurl;
    }

    public String getmPublishedDate() {
        return mPublishedDate;
    }

    public void setmPublishedDate(String mPublishedDate) {
        this.mPublishedDate = mPublishedDate;
    }

    public String getmPreviewUrl() {
        return mPreviewUrl;
    }

    public void setmPreviewUrl(String mPreviewUrl) {
        this.mPreviewUrl = mPreviewUrl;
    }

    public String getMinfoUrl() {
        return minfoUrl;
    }

    public void setMinfoUrl(String minfoUrl) {
        this.minfoUrl = minfoUrl;
    }
}
