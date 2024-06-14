package com.uniguajira.proyectofinalv2.repositories.retrofit.apiclient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    //public static final String IP = "http://108.200.198.29:8888";
    public static final String IP = "http://172.20.10.2:8888";

    public static final String BACKEND = "/movil-app/";
    public static final String BASE_URL = IP + BACKEND;

    public static final String GET_REVISTAS = BASE_URL + "views/app_get_all_revistas.php";
    public static final String GET_REVISTA = BASE_URL + "views/app_get_revista.php";
    public static final String SET_DELETE = BASE_URL + "views/app_delete_revistas.php";
    public static final String SET_UPDATE = BASE_URL + "views/app_update_revistas.php";
    public static final String SET_REVISTA = BASE_URL + "views/app_set_revistas.php";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static <S> S cteateService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
