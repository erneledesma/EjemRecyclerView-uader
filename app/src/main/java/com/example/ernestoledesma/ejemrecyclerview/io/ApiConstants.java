package com.example.ernestoledesma.ejemrecyclerview.io;


/**
 * Created by ernestoledesma on 30/10/16.
 */

public class ApiConstants {

    public static final String BASE_URL = "http://ws.audioscrobbler.com";

    public static final String PATH_VERSION = "/2.0/";

    public static final String API_KEY = "112f09c4b1f826116700e47961eea6f8";
    public static final String PARAM_METHOD = "method";
    public static final String PARAM_FORMAT = "format";
    public static final String PARAM_ARTIST = "artist";
    public static final String PARAM_API_KEY = "api_key";

    public static final String VALUE_JSON = "json";
    public static final String VALUE_HYPED_ARTISTS_METHOD = "chart.gethypedartists";
    public static final String VALUE_TOP_ARTISTS_METHOD = "chart.gettopartists";
    public static final String VALUE_ARTIST_INFO_METHOD = "artist.getinfo";

    public static final String URL_HYPED_ARTISTS = PATH_VERSION + "?"

             + PARAM_METHOD + "=" + VALUE_TOP_ARTISTS_METHOD

            + "&" + PARAM_API_KEY + "=" + API_KEY  + "&" + PARAM_FORMAT + "=" + VALUE_JSON;

    public static final String URL_ARTIST_INFO = PATH_VERSION + "?"
            + "&" + PARAM_FORMAT + "=" + VALUE_JSON
            + "&" + PARAM_METHOD + "=" + VALUE_ARTIST_INFO_METHOD;

    public static final String URL_TOP_ARTIST = PATH_VERSION + "?"
            + "&" + PARAM_FORMAT + "=" + VALUE_JSON
            + "&" + PARAM_METHOD + "=" + VALUE_TOP_ARTISTS_METHOD;
}
//http://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=112f09c4b1f826116700e47961eea6f8&format=json


