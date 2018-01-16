package com.example.mohamedabdelaziz.movieapp.DetailActivity.Presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mohamedabdelaziz.movieapp.DetailActivity.Model.ResultItem;
import com.example.mohamedabdelaziz.movieapp.R;

import java.util.ArrayList;

/**
 * Created by Mohamed Abd Elaziz on 9/15/2017.
 */

public class GridAdapter extends BaseAdapter {
    ArrayList<ResultItem> resultItems;
    Context context;

    public GridAdapter(Context context, ArrayList<ResultItem> resultItems) {
        this.resultItems = resultItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return resultItems.size();
    }

    @Override
    public Object getItem(int position) {
        return resultItems.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.grid_item, null);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        if (resultItems.get(position).getName().length() < 20)
            textView.setText(resultItems.get(position).getName());
        else
            textView.setText(resultItems.get(position).getName().substring(0, 20) + ".....");
        return view;
    }
}
