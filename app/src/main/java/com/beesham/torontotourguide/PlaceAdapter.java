package com.beesham.torontotourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Beesham on 9/12/2016.
 */
public class PlaceAdapter extends ArrayAdapter<Place> {

    private int mBackgroundColorResourceId;

    public PlaceAdapter(Context context, List<Place> objects, int backgroundColorResourceId) {
        super(context, 0, objects);
        mBackgroundColorResourceId = backgroundColorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Place place = getItem(position);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.placetitle_textview);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.item_imageview);
        RelativeLayout linearLayout = (RelativeLayout) listItemView.findViewById(R.id.category_linearlayout);

        imageView.setImageResource(place.getmImageResourceId());
        titleTextView.setText(place.getmTitle());
        linearLayout.setBackgroundColor(mBackgroundColorResourceId);

        return listItemView;
    }
}
