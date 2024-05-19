package com.example.apppracticarelaciones.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Editorial {
    @PrimaryKey(autoGenerate = true)
    public int idEditorial;

    @ColumnInfo
    public String nombreEditorial;

}
