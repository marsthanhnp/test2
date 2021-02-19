package com.example.aqsolution;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class AdapternewsClass extends ArrayAdapter<DocbaoClass> {

    public AdapternewsClass(Context context, int resource, List<DocbaoClass> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.layout_rownews, null);
        }
        DocbaoClass p = getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView txttitle = (TextView) view.findViewById(R.id.textViewNewsTitle);
            txttitle.setText(p.title);

            ImageView imageView=(ImageView) view.findViewById(R.id.imageViewNewsTitle);
            Picasso.with(getContext()).load(p.image).into(imageView);
        }
        return view;
    }

}