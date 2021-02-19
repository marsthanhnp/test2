package com.example.aqsolution;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterhocphiClass extends ArrayAdapter<DshocphihkClass> {


    public AdapterhocphiClass(@NonNull Context context, int resource, List<DshocphihkClass> items) {
        super(context, resource, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.layout_rowhp, null);
        }
        DshocphihkClass p = getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView txttitle = (TextView) view.findViewById(R.id.hptv_hocky);
            txttitle.setText(p.getTen_hoc_ky());

            }
        return view;

    }
}
