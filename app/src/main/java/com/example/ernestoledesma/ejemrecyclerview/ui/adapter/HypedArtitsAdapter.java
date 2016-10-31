package com.example.ernestoledesma.ejemrecyclerview.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ernestoledesma.ejemrecyclerview.R;
import com.example.ernestoledesma.ejemrecyclerview.domain.Artist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by ernestoledesma on 11/10/16.
 */
//tiene una estructura de diamante, aqui creamos nuestro ViewHolder
public class HypedArtitsAdapter extends RecyclerView.Adapter<HypedArtitsAdapter.HypedArtistViewHolder> {
    //el adaptador debera tenr una estructura de arreglos de vistas
    ArrayList<Artist> artists;


    //tenemos que pasarle los parametros del contexto
    //y agragamos los contructores
    // cuando se crea el constructor tenemos que pasarl una instancia del contexto
    Context context;

    public HypedArtitsAdapter(Context context) {
        this.context = context;
        //aqui inicializamos nuestro constructor de Array
        this.artists =  new ArrayList<>();
    }

    @Override
    public HypedArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //una vez generado el constructo del context
        //tenemos que inflar la vista , a travez de un contexto, o sea la actividad
        //la vista que se infla es la vista del item.(item_hyped_artist
       View itemView = LayoutInflater.from(context)
               .inflate(R.layout.item_hyped_artist, parent, false);
        // si no le ponemos el false, la gerarquia de vista se va a ver afectada, ya que convivimos
        //con los items de los viewHolder
        return new HypedArtistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HypedArtistViewHolder holder, int position) {

        //este es el paso mas importante, donde conectamos nuestras vistas
        //llamamos a mandar a utilizar el metodo artisName
        //creamos un objeto temporal para instanciar el metodo
        Artist currentArtist = artists.get(position);
        holder.setArtistName(currentArtist.getName());

        if (currentArtist.getUrlMediumImage() != null)
        holder.setArtistImage(currentArtist.getUrlMediumImage());

        else holder.setArtistDefaultImage();


    }

    @Override
    public int getItemCount() {
        //aqui le pasamos cuantos items del array hay que pasarles
        return artists.size();
    }

    //creamos los metodos para añadir los objetos
    public  void addAll( @NonNull ArrayList<Artist> artists){
        if (artists == null)
            throw  new NullPointerException("Los items no pueden ser nulos");
        //le pasamos la coleccion de datos
        this.artists.addAll(artists);
        //le notificamos al recyclerView que los items han cambiado
       notifyDataSetChanged();

    }

    //lleva una estructura anidada
    public class HypedArtistViewHolder extends RecyclerView.ViewHolder{
        //hay que crear un constructor

        //le pasamos los parametros de los atributos de nuestro ViewHolder
        TextView artistName;
        ImageView artistImage;

        public  HypedArtistViewHolder(View itemView) {
            super(itemView);
            artistName = (TextView) itemView.findViewById(R.id.txt_name);
            artistImage = (ImageView) itemView.findViewById(R.id.img_artist);
        }

        //generamos una clase para pasarles los parametros del array
        public  void setArtistName (String name ){
            artistName.setText(name);
        }

        public void setArtistImage (String url){
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.drawable.artist_place_holder)
                    .into(artistImage);
        }
        public void setArtistDefaultImage(){
            Picasso.with(context)
                    .load(R.drawable.artist_place_holder)
                    .into(artistImage);
        }

    }
}
