package ru.mhenro.restclient;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mhenr on 24.10.2016.
 */
public interface MhenroService {
    @GET("notes/controller/getJson")
    Call<JsonOb> getJsonOb();
}
