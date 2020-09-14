package com.cursoandroidkotlin.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val remote = RetrofitClient.createService(PostService::class.java)                          //Criando o serviço a partir da Service (eu tbm nunca tinha visto uma inerface ser passada por parâmetro)
        val call : Call<List<PostModel>> = remote.list()                                            //Preparando a chamada

        val responde = call.enqueue(object : Callback<List<PostModel>> {                            //Essa é uma chamada assíncrona. Mesmo não terminando este processo ele já vai executar a próxima linha. Para fazer uma chamada síncrona substitua o metodo "enqueue()" pelo "execute()". Toda chamada assíncrona exige um callback, para saber o que fazer quando a chamada terminar com sucesso ou com fracasso.
            override fun onResponse(call: Call<List<PostModel>>, res: Response<List<PostModel>>) {
                val s = res.body()
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                val s = t.message
            }

        })

    }
}