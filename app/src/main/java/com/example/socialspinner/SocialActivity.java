package com.example.socialspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.socialspinner.adapter.SocialAdapter;
import com.example.socialspinner.model.Social;

import java.util.ArrayList;
import java.util.List;

public class SocialActivity extends AppCompatActivity {

    private Spinner spSocial;
    private SocialAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vista
        spSocial = findViewById(R.id.spSocial);

        //Se crea el origen de datos en la clase principal
        List<Social> items = new ArrayList<>();
        items.add(new Social(R.drawable.facebook, getString(R.string.facebook)));
        items.add(new Social(R.drawable.android, getString(R.string.android)));
        items.add(new Social(R.drawable.instagram, getString(R.string.instagram)));
        items.add(new Social(R.drawable.linkedin, getString(R.string.linkedin)));
        items.add(new Social(R.drawable.twitter, getString(R.string.twitter)));
        items.add(new Social(R.drawable.whatsapp, getString(R.string.whatsapp)));

        //Se crea elñ adapter
        adapter = new SocialAdapter(this,items);
        //Se define el diseño de la lista que aparece cuando se selecciona un elemento
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSocial.setAdapter(adapter);

        spSocial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SocialAdapter socialAdapter = (SocialAdapter) parent.getAdapter();
                Social social = (Social) socialAdapter.getItem(position);
                Toast.makeText(parent.getContext(),((Social)parent.getItemIdAtPosition(position)).getName(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}