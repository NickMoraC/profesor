package com.uniguajira.proyectofinalv2.viewsmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.uniguajira.proyectofinalv2.repositories.retrofit.datasource.RevistasRepository;
import com.uniguajira.proyectofinalv2.repositories.retrofit.responses.RevistasResponse;
import com.uniguajira.proyectofinalv2.repositories.room.dao.RevistasDao;
import com.uniguajira.proyectofinalv2.repositories.room.database.AppDatabase;
import com.uniguajira.proyectofinalv2.repositories.room.entities.Revistas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RevistasViewModel extends AndroidViewModel {
    private RevistasRepository revistasRepository;
    private MutableLiveData<List<Revistas>> revistasListObservable;
    private MutableLiveData<Revistas> revistaListObservable;
    private MutableLiveData<RevistasResponse> revistasObservable;

    RevistasDao revistasDao;
    AppDatabase db;

    public RevistasViewModel(Application application) {
        super(application);
        db = AppDatabase.getAppDatabase(application);
        revistasDao = db.revistasDao();
        revistasListObservable = new MutableLiveData<>();
    }

    public LiveData<List<Revistas>> getRevistasListObservable() {
        revistasRepository = RevistasRepository.getInstance();
        revistasListObservable = revistasRepository.getRevistasListRepository();
        return revistasListObservable;
    }

    public LiveData<List<Revistas>> getRevistasRoomListObservable() {
        return revistasDao.findAll();
    }

    public LiveData<RevistasResponse> deleteRevistasRoomListObservable(int revistaId) {
        Revistas revista = revistasDao.findByPk(revistaId);
        revistasDao.delete(revista);
        return revistasObservable;
    }

    public LiveData<RevistasResponse> deleteRevistasListObservable(int revistaId) {
        revistasRepository = RevistasRepository.getInstance();
        revistasObservable = revistasRepository.deleteRevistasListRepository(revistaId);
        return revistasObservable;
    }
    public void setRevistasRoom(String titulo, String issn, int numero, String anio){
        Revistas revista = new Revistas();
        revista.setTitulo(titulo);
        revista.setIssn (issn);
        revista.setNumero(String.valueOf(numero));
        revista.setAnio(anio);
        revistasDao.insertOne(revista);

    }

    public LiveData<RevistasResponse> setRevistasListObservable(String titulo, String issn, int numero, String anio) {
        revistasRepository = RevistasRepository.getInstance();
        revistasObservable = revistasRepository.setRevistasListRepository(titulo, issn,numero,anio);
        return revistasObservable;
    }

    public LiveData<Revistas> getRevistaListObservable(int revistaId) {
        revistasRepository = RevistasRepository.getInstance();
        revistaListObservable = revistasRepository.getRevistaListRepository(revistaId);
        return revistaListObservable;
    }

    public void insertDummyRevistas() {
        List<Revistas> revistasList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
        Revistas revista = new Revistas();
        revista.setTitulo("Jose Luis");
        revista.setIssn ("XCVT7632-2");
        revista.setNumero(String.valueOf(i));
        revista.setAnio("2024");

        revistasList.add(revista);
        }
        //revistasDao.insertOne(revista);
        revistasDao.insertAll(revistasList);
    }
}
