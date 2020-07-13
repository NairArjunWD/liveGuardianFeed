package com.example.liveguardianfeed;

import java.util.ArrayList;

public class News {

    private String mTitle;
    private String mDate;
    private String mSection;
    private String mUrl;
    private String mAuthor;

    public News(String title, String date, String section, String url, String author ) {

        mTitle = title;
        mDate = date;
        mSection = section;
        mUrl = url;
        mAuthor = author;

    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmSection() {
        return mSection;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmAuthor() { return mAuthor;}
}
