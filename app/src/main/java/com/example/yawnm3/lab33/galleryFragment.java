package com.example.yawnm3.lab33;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class galleryFragment extends Fragment {

    private static final int REQUEST_PHOTO = 1;
    private ImageView imageViewPhoto;

    public galleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_gallery, container, false);
        //Linking UI to program
        imageViewPhoto = (ImageView)v.findViewById(R.id.imageViewPhoto);
        Button buttonGetPhoto = (Button)v.findViewById(R.id.buttonGetPhoto);

        buttonGetPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

                //Filter to only show results that can be opened
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                //Filter to only show images, using the image MIME data
                intent.setType("image/*");

                startActivityForResult(intent, REQUEST_PHOTO);
            }
        });


        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_PHOTO && requestCode == RESULT_OK)
        {
            if(data != null)
            {
                Uri uri;

                uri = data.getData();
                imageViewPhoto.setImageURI(uri);
            }
        }
    }

}
