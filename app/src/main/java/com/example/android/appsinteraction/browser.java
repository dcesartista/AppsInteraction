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
public class browser extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    EditText etUrlInput;
    Uri webpage;

    public static browser newInstance(int sectionNumber) {
        browser fragment = new browser();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.browser, container, false);

        etUrlInput = (EditText) v.findViewById(R.id.urlInput);
        Button browse = (Button) v.findViewById(R.id.browseButton);
        String query = etUrlInput.getText().toString();
        webpage = Uri.parse(query);

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uri webpage = Uri.parse("http://detik.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
            }
        });

        return v;
    }
}
