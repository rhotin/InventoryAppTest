package com.rhappdeveloper.inventoryapp.api;


import com.rhappdeveloper.inventoryapp.model.PartObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET
    Call<List<PartObject>> getParts();

    @POST
    Call<PartObject> createPart(@Body PartObject partObject);

}
