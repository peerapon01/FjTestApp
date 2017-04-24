package peerapon.me.fjtestapp.api.client;

import java.util.List;

import peerapon.me.fjtestapp.dto.ListResult;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by peerapon01 on 4/24/2017 AD.
 */


public interface ResultClient {
    @GET("/api/seed.json")
    Call<List<ListResult>> getListResults(


    );
}

