package com.example.ernestoledesma.ejemrecyclerview.io.deserializer;

import com.example.ernestoledesma.ejemrecyclerview.domain.Artist;
import com.example.ernestoledesma.ejemrecyclerview.io.model.HypedArtistResponse;
import com.example.ernestoledesma.ejemrecyclerview.io.model.JsonKeys;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by ernestoledesma on 30/10/16.
 */

public class HypedArtistsDeserializer implements JsonDeserializer<HypedArtistResponse> {
    @Override
    public HypedArtistResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        HypedArtistResponse response = gson.fromJson(json, HypedArtistResponse.class);

        //le pasamos el objeto Artist
        JsonObject artistResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.ARTISTS_RESULTS);
        //obtenmos el array de artist
        JsonArray artistsArray = artistResponseData.getAsJsonArray(JsonKeys.ARTISTS_ARRAY);

        //convertir el JsonArray de artist a objetos la clase Artist
        //para poder manipularlos
        response.setArtists(extractArtistsFromJsonArray(artistsArray));

        return response;
    }

    private ArrayList<Artist> extractArtistsFromJsonArray(JsonArray array) {
        ArrayList<Artist> artists = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            JsonObject artistData = array.get(i).getAsJsonObject();

            Artist currentArtist = new Artist();

            String name = artistData.get(JsonKeys.ARTISTS_NAME).getAsString();

            JsonArray imagesArray = artistData.getAsJsonArray(JsonKeys.ARTIST_IMAGE);
            String[]images = extractArtistsImageFromJsonArray(imagesArray);

            currentArtist.setName(name);
            currentArtist.setUrlMediumImage(images[0]);
            currentArtist.setUrlLargeImage(images[1]);

            artists.add(currentArtist);

        }

        return artists;
    }

    private String[] extractArtistsImageFromJsonArray(JsonArray imageArray) {
        String[] images = new String[2];

        for (int i = 0; i < imageArray.size(); i++) {
            JsonObject imageData = imageArray.get(i).getAsJsonObject();

            String size = imageData.get(JsonKeys.IMAGE_SIZE).getAsString();
            String url = imageData.get(JsonKeys.IMAGE_URL).getAsString();



            if (url.isEmpty())
                url = null;

            else
                url = url.replaceAll("\\/", "/");

            if (size.matches(JsonKeys.IMAGE_MEDIUM)) {

                images[0] = url;

            }

            else if (size.matches(JsonKeys.IMAGE_LARGE)) {

                images[1] = url;

            }


        }
        return images;
    }
}
