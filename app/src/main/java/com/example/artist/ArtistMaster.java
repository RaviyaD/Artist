package com.example.artist;

import android.provider.BaseColumns;

public final class ArtistMaster {
    private ArtistMaster(){}

    public static class Final implements BaseColumns{
        //table 1
        public static final String PhotographDetails_TABLE="photo";
        public static final String Photograph_COL_name="name";
        public static final String Photograph_COL_ArtistID="id";
        public static final String Photograph_COL_Category="category";
        public static final String Photograph_COL_Image="image";

        //table 2
        public static final String ArtistDetails_TABLE = "artist";
        public static final String ArtistDetails_COL_name =  "name";


    }
}
