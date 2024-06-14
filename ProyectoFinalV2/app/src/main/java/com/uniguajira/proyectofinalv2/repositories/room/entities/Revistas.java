package com.uniguajira.proyectofinalv2.repositories.room.entities;

import android.provider.BaseColumns;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "revistas")
public class Revistas {
    @SerializedName("status")
    @Expose
    @Ignore
    private String status;

    @SerializedName("message")
    @Expose
    @Ignore
    private String message;

    /** The name of the ID column. */
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = "id")
    public int id;

    @SerializedName("titulo")
    @ColumnInfo(name = "titulo")
    public String titulo;

    @SerializedName("issn")
    @ColumnInfo(name = "issn")
    public String issn;

    @SerializedName("numero")
    @ColumnInfo(name = "numero")
    public String numero;

    @SerializedName("anio")
    @ColumnInfo(name = "anio")
    public String anio;

    @SerializedName("logo")
    @ColumnInfo(name = "logo")
    public String logo;

    public Revistas() {
    }

    public Revistas(int id, String titulo, String issn, String numero, String anio, String logo) {
        this.id = id;
        this.titulo = titulo;
        this.issn = issn;
        this.numero = numero;
        this.anio = anio;
        this.logo = logo;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
