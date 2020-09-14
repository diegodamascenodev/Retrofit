package com.cursoandroidkotlin.retrofit

import com.google.gson.annotations.SerializedName

class PostModel {

    @SerializedName("id")                                                                     //"@SerializedName" serve para o GSON associar o parâmetro do JSON que corresponde a variável da classe. Neste caso, por exemplo, o parâmetro "id" que vem no JSON correponde a variavel "id" declarada na classe. Desde que façamos a correspondência, o parametro JSON não precisa ter o mesmo nome que a variavel da classe. Só por curiosidade, se o nome do parametro do JSON for igual ao da classe não é necessária a notação "@Serialized Name". Mas por uma questão de organização e evitar confusões, é aconselhável que sempre usemos a notação mesmo no caso de nomes iguais.
    var id : Int = 0

    @SerializedName("userId")
    var userId : Int = 0

    @SerializedName("title")
    var title : String = ""

    @SerializedName("body")
    var body : String = ""

}