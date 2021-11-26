package com.example.chatapp.Fragments;

import com.example.chatapp.Notifications.MyResponse;
import com.example.chatapp.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAWEzpa7I:APA91bGv8wwS8MRZMz_M1FU9JTGb3IfsRpA-1RGhQoeQlDTdZCrj-rWwETHHBROTZwKLXKVVAuBJLafq12ZB4CufkIfHGIaysn74kNoebnd0RmACVTeBdHKJGip1yrWhvEe17cepM6p1"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
