package com.example.ernestoledesma.ejemrecyclerview.io;


import com.example.ernestoledesma.ejemrecyclerview.io.model.HypedArtistResponse;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by ernestoledesma on 30/10/16.
 */

public interface LastFmApiService {

    @GET(ApiConstants.URL_HYPED_ARTISTS)
    void getHypedArtists(Callback<HypedArtistResponse>serverResponse);

}
