package com.cursoandroidkotlin.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {                                                        //O comando "private constructor" torna o construtor privado, garantindo assim que ninguém o instancie. Dessa forma só poderemos ter uma instância desta classe, que é justamente o que queremos. Não podemos ter 3 retrofits. O retrofit deve ser apenas um.

    companion object {

        private lateinit var retrofit: Retrofit
        private val baseURL = "http://jsonplaceholder.typicode.com/"

        private fun getRetrofitInstance(): Retrofit {                                              //Essa função cria uma instância do Retrofit

            val httpClient = OkHttpClient.Builder()
            if (!::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseURL)                                                               //Aqui vc informa a URL base da API. É só a base, sem os recursos da API que vem depois da barra
                    .client(httpClient.build())                                                     //O "client" é quem vai gerenciar as conexões HTTP. Vamos inserir aqui a classe nativa do Android que gerencia as comunicações com chamadas HTTP. É ele quem vai conseguir conectar com a internet.
                    .addConverterFactory(GsonConverterFactory.create())                             //Aqui adicionamos o conversor que converte os arquivos JSON em classes, identificando o que é Inteiro, o que é String, e etc.
                    .build()
            }
            return retrofit
        }

        fun <S> createService(serviceClass: Class<S>) : S{
            return getRetrofitInstance().create(serviceClass)
        }

    }
}