package com.example.demokotlin

fun main60() {
    val cleChateau = Cle()
    cleChateau.ouvrirPorte()
    val cleIoniq6 = CleVoiture()
    cleIoniq6.ouvertureCoffre()
}
open class Cle() {
    open fun ouvrirPorte(){
        println("ouverture de porte")
    }
    fun fermerPorte(){
        println("fermerture de porte")
    }
}

class CleVoiture() : Cle() {
    override fun ouvrirPorte() {
        println("ouverture de toutes les portes")
    }

    fun ouvertureCoffre(){
        println("ouverture coffre uniquement")
    }
}
