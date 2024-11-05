package com.example.demokotlin

//PrintLn & StringInterpolation
var test :String? = "Hello"
fun main1() {
    println("$test world")
}
//Val / Var
fun main2() {
    val valeur = 15
    //valeur = 61

    var variable = 15
    variable = 16
}
//by lazy et Propriétés déléguées
var monWebService : String? = null;
val username by lazy { /*monWebService?.getUsername() ?:*/ "" }
fun main3() {
    var mot = "World"
    val messageComplet by lazy {"Hello $mot"}
    mot = "ENI NIORT"
    println(messageComplet)
    monWebService = "WEBSERVICE"
    username
}
//SafeCall & Elvis Operator & Nullable
fun main4() {
    //var mot : String = null;
    var mot : String? = null;
    var mot2 = null
    var longueurMot = mot?.length ?: 0
}

