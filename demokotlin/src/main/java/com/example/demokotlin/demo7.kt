package com.example.demokotlin

interface Mangeable {
    fun manger()=println("Miam")
}
class Pain(val type : String) : Mangeable{
    override fun manger() {
        super.manger()
        println("C'est super bon le pain $type")
    }
}

fun main() {
    val pain = Pain("Complet")
    pain.manger()
}
