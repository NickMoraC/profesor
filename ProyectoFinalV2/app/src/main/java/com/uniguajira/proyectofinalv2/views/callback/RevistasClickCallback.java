package com.uniguajira.proyectofinalv2.views.callback;

import com.uniguajira.proyectofinalv2.repositories.room.entities.Revistas;

public interface RevistasClickCallback {
    void onClick(Revistas revistas);
    void onDelete(Revistas revistas);
    void onUpdate(Revistas revistas);
}
