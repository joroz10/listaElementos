package com.example.listaelementos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listaelementos.R;

public class ElementActivity extends AppCompatActivity {

    TextView name;
    TextView desc;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);

        name = (TextView) findViewById(R.id.txtElementName);
        desc = (TextView) findViewById(R.id.txtEkementDesc);
        img = (ImageView) findViewById(R.id.img);
        Bundle bundle = getIntent().getExtras();
        img.setImageDrawable(getDrawable(bundle.getInt("img")));
        name.setText(bundle.getString("name"));
        desc.setText(bundle.getString("desc"));
    }
}