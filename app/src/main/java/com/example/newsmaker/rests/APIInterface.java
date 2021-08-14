package com.example.newsmaker.rests;
import retrofit2.Call;
import com.example.newsmaker.models.ResponseModel;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface APIInterface {
    @GET("everything")
    Call<ResponseModel> getLatestNews(@Query("q") String source, @Query("apiKey") String apiKey);

}
