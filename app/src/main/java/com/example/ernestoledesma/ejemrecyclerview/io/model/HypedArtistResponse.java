package com.example.ernestoledesma.ejemrecyclerview.io.model;

import com.example.ernestoledesma.ejemrecyclerview.domain.Artist;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ernestoledesma on 30/10/16.
 */

public class HypedArtistResponse {

     @SerializedName(JsonKeys.ARTISTS_RESULTS)
    HypedArtistsResults results;

    public ArrayList<Artist>getArtists(){
        return results.artists;
    }

    public void setArtists(ArrayList<Artist> artists){
        this.results.artists = artists;
    }
    private class HypedArtistsResults {


        ArrayList<Artist>artists;


    }
}
