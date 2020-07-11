package com.example.liveguardianfeed;

public class News {

    private String mTitle;
    private String mDate;
    private String mSection;
    private String mUrl;

    public News(String title, String date, String section, String url) {

        mTitle = title;
        mDate = date;
        mSection = section;
        mUrl = url;

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
}
