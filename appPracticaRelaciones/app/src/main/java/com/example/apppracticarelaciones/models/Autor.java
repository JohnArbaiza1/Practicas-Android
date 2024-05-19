package com.example.apppracticarelaciones.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Autor {

    @PrimaryKey(autoGenerate = true)
    public int idAutor;

    @ColumnInfo
    public String nombreAuotor;

}
