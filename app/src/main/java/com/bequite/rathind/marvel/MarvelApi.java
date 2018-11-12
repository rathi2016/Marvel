package com.bequite.rathind.marvel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MarvelApi {
    private static final String apikey = "68149?ts=2&apikey=737b19ce5cafc869648f144419b7a9be&hash=bc52e0dbdf40882047e28711efcb30e0";
    private static final String url = "https://gateway.marvel.com/v1/public/comics/";

    public static ResultService resultService = null;

    public static ResultService getResultService() {
        if (resultService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            resultService = retrofit.create(ResultService.class);

        }
        return resultService;
    }

    public interface ResultService {
        @GET(apikey)
        Call<ResulList> getResultList();

        void showProgressDialog(boolean enableProgressDialog);
    }
}
