package com.iheartraddio.festivalApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kkim on 4/6/15.
 */
public class EventAdapter extends ArrayAdapter {

    private static class ViewHolder {
        TextView name;
    }

    public EventAdapter(Context context, List<String> events) {
        super(context, R.layout.item_event, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String event = (String)getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_event, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(event);
        return convertView;
    }
}
