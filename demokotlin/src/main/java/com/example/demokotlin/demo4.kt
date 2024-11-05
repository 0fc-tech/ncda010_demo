package com.example.demokotlin

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.swing.text.DateFormatter

fun main40() {
    print("La date est  " +
            LocalDateTime.now().showDateTimeInFrench()
    )
}
fun demarrageVehicule(): Boolean {
    val vitesseMoteur = 0
    val SoCVehicule = 98
    if(SoCVehicule > 2)
        return true
    return false
}
fun LocalDateTime.showDateTimeInFrench() : String{
    val formatter = DateTimeFormatter.ofPattern(
        "'le' d MMMM 'à' HH'h'mm", Locale.FRENCH)
    return this.format(formatter)
}