package com.example.deals;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import java.util.Map;

public interface jsonplaceholderapi {


    @Headers("content-type:application/json")
    @GET("/api/{api_version}/compare/search/")
    Call<search>getsearch(@Path ("api_version") String version,@Query("api_key") String api_key,@Query("product") String product, @Query("filter") String brand, @Query("price_start") String price_start, @Query("price_end") String price_end, @Query("page") String page);
    //@Query("product") String product, @Query("filter") String brand, @Query("price_start") String price_start, @Query("price_end") String price_end, @Query("page") String page

}
