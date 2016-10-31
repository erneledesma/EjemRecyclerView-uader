package com.example.ernestoledesma.ejemrecyclerview.io;

import com.example.ernestoledesma.ejemrecyclerview.io.deserializer.HypedArtistsDeserializer;
import com.example.ernestoledesma.ejemrecyclerview.io.model.HypedArtistResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by ernestoledesma on 30/10/16.
 */

public class LastFmApiAdapter {

    public static LastFmApiService API_SERVICE;

    public static LastFmApiService getApiService(){

        if (API_SERVICE ==  null){

            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstants.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .setConverter(buildLastFmApiConverter())
                    .build();

            API_SERVICE = adapter.create(LastFmApiService.class);


        }

        return API_SERVICE;

    }


    private static GsonConverter buildLastFmApiConverter(){
        Gson gsonConf = new GsonBuilder()
                .registerTypeAdapter(HypedArtistResponse.class, new HypedArtistsDeserializer())
                .create();

        return new GsonConverter(gsonConf);

    }




}
