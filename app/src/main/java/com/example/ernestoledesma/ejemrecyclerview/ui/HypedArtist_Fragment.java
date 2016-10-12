package com.example.ernestoledesma.ejemrecyclerview.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ernestoledesma.ejemrecyclerview.R;
import com.example.ernestoledesma.ejemrecyclerview.domain.Artist;
import com.example.ernestoledesma.ejemrecyclerview.ui.adapter.HypedArtitsAdapter;

import java.util.ArrayList;

/**
 * Created by ernestoledesma on 10/10/16.
 */

public class HypedArtist_Fragment extends Fragment {


    public static final int NUM_COLUMNS = 2;

   public static final String LOG_TAG = HypedArtist_Fragment.class.getName();

    //Creamos una instancia privada para insertar el RecyclerView en la vista
    private RecyclerView mHypedArtisList;

    //debmeos crear una instancia de nuestro adaptador
    private HypedArtitsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HypedArtitsAdapter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root =inflater.inflate(R.layout.fragment_hyped_artist, container, false);

        //dentro del root debemos encontrar nuestro recyclerView
        mHypedArtisList = (RecyclerView) root.findViewById(R.id.hyped_artist_list);

        setupArtistList();
        setDummyContent();
        return  root;
    }

    //creamos un metodo para generar todas las configuraciones
    //iniciales del RecylerView

    private void setupArtistList(){
        //de manera anonima creamos un gridLayoutmanager
        //le pasamos getActivity porque el fragmento convive en una actividad
        //de esta forma le pasamos las columnos y podemos setear las vistas
        mHypedArtisList.setLayoutManager(new GridLayoutManager(getActivity(), NUM_COLUMNS));
        mHypedArtisList.setAdapter(adapter);

    }

    //cramos un metodo para debug y probar los datos
    private void setDummyContent (){
        ArrayList<Artist> artists = new ArrayList<>();

        for (int i = 0 ; i < 10; i++){
            artists.add(new Artist("Artist" + i));
        }
            adapter.addAll(artists);
    }
}
