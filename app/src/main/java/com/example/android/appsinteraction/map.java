package com.example.android.appsinteraction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ACER on 11/19/2015.
 */
public class map extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    EditText etCoorInput;

    public static map newInstance(int sectionNumber) {
        map fragment = new map();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.map, container, false);

        etCoorInput = (EditText) v.findViewById(R.id.coorInput);
        Button showMap = (Button) v.findViewById(R.id.showMapButton);

        showMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = etCoorInput.getText().toString();
                //Uri coordinate = Uri.parse("geo:0,0?q=" + query);
                Uri coordinate = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, coordinate);
                startActivity(mapIntent);
            }
        });

        return v;
    }
}
