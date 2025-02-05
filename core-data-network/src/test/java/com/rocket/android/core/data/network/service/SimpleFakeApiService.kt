package com.rocket.android.core.data.network.service

import com.rocket.android.core.data.network.model.ApiRequest
import com.rocket.android.core.data.network.model.ApiResponse
import com.rocket.android.core.data.network.model.BaseNetworkApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

internal interface SimpleFakeApiService {
    @GET(value = "/all")
    suspend fun getAllSuspend(): Response<ApiResponse.SimpleListFake>

    @GET(value = "/all")
    fun getAll(): Call<ApiResponse.SimpleListFake>

    @GET(value = "/all")
    suspend fun getAllSuspendGeneric(): Response<List<ApiResponse.SimpleFake>>

    @GET(value = "/all")
    fun getAllGeneric(): Call<List<ApiResponse.SimpleFake>>

    @GET(value = "/element/{id}")
    fun getById(@Path("id") id: String): Call<ApiResponse.SimpleFake>

    @POST("/all")
    fun saveElement(@Body data: ApiRequest.SimpleFake): Call<BaseNetworkApiResponse>

    @PUT("/element/{id}")
    fun updateById(
        @Path("id") id: String,
        @Body data: ApiRequest.SimpleFake
    ): Call<ApiResponse.SimpleFake>

    @DELETE("/all")
    fun removeAll(): Call<ApiResponse.SimpleFake>

    @HTTP(path = "/all", method = "DELETE", hasBody = true)
    fun removeByElement(@Body data: ApiRequest.SimpleFake): Call<ApiResponse.SimpleFake>

    @DELETE("/all/{id}")
    fun removeById(@Path("id") id: String): Call<ApiResponse.SimpleFake>
}
