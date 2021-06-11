package com.rhappdeveloper.inventoryapp.api;


import com.rhappdeveloper.inventoryapp.model.PartObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET
    Call<List<PartObject>> getParts();

    @POST
    Call<PartObject> createPart(@Body PartObject partObject);

    @PUT("{id}")
    Call<PartObject> UpdatePart(@Path ("id") int id,@Body PartObject partObject);

    @PUT("{id}/receive")
    Call<PartObject> ReceivePart(@Path ("id") int id, @Body PartObject partObject);

    @PUT("{id}/consume")
    Call<PartObject> ConsumePart(@Path ("id") int id, @Body PartObject partObject);
}
