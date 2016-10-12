package com.example.ernestoledesma.ejemrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ernestoledesma.ejemrecyclerview.ui.HypedArtist_Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, new HypedArtist_Fragment())
                .commit();


    }
}
