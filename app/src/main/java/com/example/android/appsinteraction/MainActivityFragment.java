package com.example.android.appsinteraction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    String text;

    public static MainActivityFragment newInstance(int sectionNumber) {
        MainActivityFragment fragment = new MainActivityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //EditText etNumInput = (EditText) rootView.findViewById(R.id.numInput);
        //text = etNumInput.getText().toString();
        Button callButton = (Button) rootView.findViewById(R.id.callButton);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uri number	=	Uri.parse("tel:"+text);
                Uri number = Uri.parse("tel:08157977555");
                Intent callIntent	=	new Intent(Intent.ACTION_DIAL,	number);
                startActivity(callIntent);

            }
        });


        return rootView;
    }
}
