package com.example.demokotlin

//Démo Structure de classe
data class Travail(
    val intitulePoste : String,
    val salaireAnnuel : Int,
    var isCadre : Boolean,
    var ville : String?
){
    constructor(intitulePoste : String,
                salaireAnnuel : Int)
            : this(intitulePoste,salaireAnnuel,true,null)
}

fun main50() {
    val developpeurNantais = Travail(
        "Développeur", 34000, true, "Nantes"
    )
    val designerEnTT = Travail(
        "Designer", 44000, true, null
    )
    val dirigeantESN = Travail(
        "PDG",74000,true, "Paris")
    val devAugmente = developpeurNantais.copy(
        salaireAnnuel = 34200
    )
    println(devAugmente)
}