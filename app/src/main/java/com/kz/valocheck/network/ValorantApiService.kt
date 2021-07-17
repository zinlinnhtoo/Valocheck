package com.kz.valocheck.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://valorant-api.com/v1/"


interface ValorantApiService {

    @GET("agents")
    suspend fun getAgentList(): Response<AgentResponse>

//    @GET("agents/{uuid}")
//    suspend fun getAgentDetail(@Path("uuid") id : String): Response<AgentDetailResponse>

    @GET("maps")
    suspend fun getMapList(): Response<MapResponse>

//    @GET("maps/{uuid}")
//    suspend fun getMapDetail(@Path("uuid") id: String) : Response<MapDetailResponse>

    @GET("weapons")
    suspend fun getWeaponList(): Response<WeaponResponse>

//    @GET("weapons/{uuid}")
//    suspend fun getWeaponDetail(@Path("uuid") id: String) : Response<WeaponDetailResponse>

}


//Dagger hilt htae yout twr pr p byr
//object ValorantApi {
//    val retrofitService: ValorantApiService by lazy { retrofit.create(ValorantApiService::class.java) }
//}