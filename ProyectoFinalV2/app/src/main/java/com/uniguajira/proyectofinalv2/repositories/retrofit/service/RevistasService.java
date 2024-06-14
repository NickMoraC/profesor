package com.uniguajira.proyectofinalv2.repositories.retrofit.service;

import com.uniguajira.proyectofinalv2.repositories.retrofit.apiclient.RetrofitService;
import com.uniguajira.proyectofinalv2.repositories.retrofit.responses.RevistasResponse;
import com.uniguajira.proyectofinalv2.repositories.room.entities.Revistas;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RevistasService {
    @Headers("Content-Type: application/json")
    @POST(RetrofitService.GET_REVISTAS)
    Call<RevistasResponse> getRevistasService(@Body Map<String, String> params);

    @Headers("Content-Type: application/json")
    @POST(RetrofitService.SET_DELETE)
    Call<RevistasResponse> deleteRevistaService(@Body Map<String, String> params);

    @Headers("Content-Type: application/json")
    @POST(RetrofitService.SET_UPDATE)
    Call<RevistasResponse> updateRevistaService(@Body Map<String, String> params);

    @Headers("Content-Type: application/json")
    @POST(RetrofitService.SET_REVISTA)
    Call<RevistasResponse> setRevistaService(@Body Map<String, String> params);

    @Headers("Content-Type: application/json")
    @POST(RetrofitService.GET_REVISTA)
    Call<Revistas> getRevistaService(@Body Map<String, String> params);
}
