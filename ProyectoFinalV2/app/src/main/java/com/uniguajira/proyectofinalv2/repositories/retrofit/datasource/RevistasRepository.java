package com.uniguajira.proyectofinalv2.repositories.retrofit.datasource;

import androidx.lifecycle.MutableLiveData;

import com.uniguajira.proyectofinalv2.repositories.retrofit.apiclient.RetrofitService;
import com.uniguajira.proyectofinalv2.repositories.retrofit.responses.RevistasResponse;
import com.uniguajira.proyectofinalv2.repositories.retrofit.service.RevistasService;
import com.uniguajira.proyectofinalv2.repositories.room.entities.Revistas;
import com.uniguajira.proyectofinalv2.views.utils.ToastUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RevistasRepository {
    private static RevistasRepository revistasRepository;
    private RevistasService revistasService;

    public RevistasRepository(){
        revistasService = RetrofitService.cteateService(RevistasService.class);
    }

    public static RevistasRepository getInstance(){
        if (revistasRepository == null){
            revistasRepository = new RevistasRepository();
        }
        return revistasRepository;
    }

    public MutableLiveData<List<Revistas>> getRevistasListRepository() {
        final MutableLiveData<List<Revistas>> data = new MutableLiveData<>();

        final Map<String, String> params = new HashMap<>();
        //params.put("page", String.valueOf(1));

        Call<RevistasResponse> call = revistasService.getRevistasService(params);
        call.enqueue(new Callback<RevistasResponse>() {
            @Override
            public void onResponse(Call<RevistasResponse> call, Response<RevistasResponse> response) {
                //ToastUtils.shortToast("R: " + response.body().getMessage());

                if(response.body().getStatus().equals("success")){
                    data.setValue(response.body().getRevistas());
                }else {
                    data.setValue(null);
                }
            }
            @Override
            public void onFailure(Call<RevistasResponse> call, Throwable t) {
                data.setValue(null);
                //ToastUtils.shortToast("E: " + t.getMessage());
            }
        });
        return data;
    }

    public MutableLiveData<RevistasResponse> deleteRevistasListRepository(long revistaId) {
        final MutableLiveData<RevistasResponse> data = new MutableLiveData<>();

        final Map<String, String> params = new HashMap<>();
        params.put("revistaId", String.valueOf(revistaId));

        Call<RevistasResponse> call = revistasService.deleteRevistaService(params);
        call.enqueue(new Callback<RevistasResponse>() {
            @Override
            public void onResponse(Call<RevistasResponse> call, Response<RevistasResponse> response) {
                ToastUtils.shortToast(response.body().getMessage());
                data.setValue(response.body());
            }
            @Override
            public void onFailure(Call<RevistasResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<RevistasResponse> setRevistasListRepository(String titulo, String issn, int numero, String anio) {
        final MutableLiveData<RevistasResponse> data = new MutableLiveData<>();

        final Map<String, String> params = new HashMap<>();
        params.put("titulo", String.valueOf(titulo));
        params.put("issn", String.valueOf(issn));
        params.put("numero", String.valueOf(numero));
        params.put("anio", String.valueOf(anio));

        Call<RevistasResponse> call = revistasService.setRevistaService(params);
        call.enqueue(new Callback<RevistasResponse>() {
            @Override
            public void onResponse(Call<RevistasResponse> call, Response<RevistasResponse> response) {
                ToastUtils.shortToast(response.body().getMessage());
                data.setValue(response.body());
            }
            @Override
            public void onFailure(Call<RevistasResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<Revistas> getRevistaListRepository(int revistaId) {
        final MutableLiveData<Revistas> data = new MutableLiveData<>();

        final Map<String, String> params = new HashMap<>();
        params.put("revistaId", String.valueOf(revistaId));

        Call<Revistas> call = revistasService.getRevistaService(params);
        call.enqueue(new Callback<Revistas>() {
            @Override
            public void onResponse(Call<Revistas> call, Response<Revistas> response) {
                if(response.body().getStatus().equals("success")){
                    data.setValue(response.body());
                }else {
                    data.setValue(null);
                }
            }
            @Override
            public void onFailure(Call<Revistas> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
