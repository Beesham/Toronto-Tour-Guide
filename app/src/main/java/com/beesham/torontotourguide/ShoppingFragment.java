package com.beesham.torontotourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment {


    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.points_of_interest_list, container, false);

        //Names of the places
        ArrayList<String> placeNameArrayList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.shopping)));

        //Location query
        ArrayList<String> placeLocationArrayList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.shopping_locations)));
        final ArrayList<Place> places = new ArrayList<>();

        for(int i = 0; i < placeNameArrayList.size(); i++) {
            places.add(new Place(getContext(),
                    placeNameArrayList.get(i),
                    placeLocationArrayList.get(i),
                    getResources().getIdentifier(placeNameArrayList.get(i)  //Instead of creating another array list, re-use the names and replaces the special characters
                            .replace(" ","_")
                            .replace("'","")
                            .toLowerCase(), "drawable", getActivity().getPackageName())));
        }

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), places, R.color.category_attractions);

        listView.setAdapter(placeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri geoLocation = Uri.parse(places.get(i).getmGeoLocation());

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoLocation);
                if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });


        return rootView;
    }

}
