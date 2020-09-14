package com.cursoandroidkotlin.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")                                                                             //Aqui é o serviço. É o que vem depois da ultima barra da URL base da API
    fun list() : Call<List<PostModel>>                                                              //Cuidado! É o Call da biblioteca Retrofit2. O Call faz parte do Retrofit. Vc sempre terá que usar assim mesmo. Não tenho muita explicação pra dar.
}