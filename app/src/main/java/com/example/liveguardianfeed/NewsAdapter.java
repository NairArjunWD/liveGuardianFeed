package com.example.liveguardianfeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News mNews = getItem(position);

        TextView newsTitle = listItemView.findViewById(R.id.news_title);
        String title = mNews.getmTitle();
        newsTitle.setText(title);

        TextView newsDate = listItemView.findViewById(R.id.news_date);
        String date = mNews.getmDate();
        newsDate.setText(date);

        TextView newsSection = listItemView.findViewById(R.id.news_section);
        String section = mNews.getmSection();
        newsSection.setText(section);

        return listItemView;
    }
}


