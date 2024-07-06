package com.example.dacn;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiService {
    @Multipart
    @POST("upload")
    Call<UploadResponse> uploadImage(
            @Part("description") RequestBody description,
            @Part MultipartBody.Part image
    );
}
