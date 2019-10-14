package com.example.artist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="User.info";
    public DBHandler(Context context){super(context,DATABASE_NAME,null,1);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String photo_sql= "CREATE TABLE "+ArtistMaster.Final.PhotographDetails_TABLE+
                "( "+ ArtistMaster.Final._ID+ " INTEGER PRIMARY KEY,"+
                ArtistMaster.Final.Photograph_COL_name+" TEXT,"+
                ArtistMaster.Final.Photograph_COL_ArtistID+" TEXT,"+
                ArtistMaster.Final.Photograph_COL_Category+" TEXT,"+
                ArtistMaster.Final.Photograph_COL_Image+" BLOB)";

        String artist ="CREATE TABLE "+ ArtistMaster.Final.ArtistDetails_TABLE+
                "( "+ArtistMaster.Final._ID+" INTEGER PRIMARY KEY,"+
                ArtistMaster.Final.ArtistDetails_COL_name+" TEXT)";

        sqLiteDatabase.execSQL(photo_sql);
        sqLiteDatabase.execSQL(artist);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addphoto(PhotoModel photo){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ArtistMaster.Final.Photograph_COL_name,photo.name);
        values.put(ArtistMaster.Final.Photograph_COL_ArtistID,photo.artistName);
        values.put(ArtistMaster.Final.Photograph_COL_Image,photo.image);

        Long id = db.insert(
                ArtistMaster.Final.PhotographDetails_TABLE,
                null,
                values
        );
    }

    public List<PhotoModel> readAllPhoto(){
        SQLiteDatabase db = getReadableDatabase();

        List<PhotoModel> list = new ArrayList<>();
        String[] col = {ArtistMaster.Final.Photograph_COL_Image};

        Cursor cursor = db.query(
                ArtistMaster.Final.PhotographDetails_TABLE,
                col,
                null,
                null,null,null,null
        );

        PhotoModel photo;

        while (cursor.moveToNext()){
            photo= new PhotoModel();

            photo.setImage(cursor.getBlob(cursor.getColumnIndexOrThrow(ArtistMaster.Final.Photograph_COL_Image)));
            list.add(photo);
        }

        return list;
    }


}
