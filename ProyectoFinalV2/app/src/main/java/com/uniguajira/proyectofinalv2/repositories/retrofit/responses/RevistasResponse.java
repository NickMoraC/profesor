package com.uniguajira.proyectofinalv2.repositories.retrofit.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.uniguajira.proyectofinalv2.repositories.room.entities.Revistas;

import java.util.List;

public class RevistasResponse {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private List<Revistas> revistas = null;

    public RevistasResponse(String status, String message, List<Revistas> revistas) {
        this.status = status;
        this.message = message;
        this.revistas = revistas;
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

    public List<Revistas> getRevistas() {
        return revistas;
    }

    public void setRevistas(List<Revistas> revistas) {
        this.revistas = revistas;
    }
}
