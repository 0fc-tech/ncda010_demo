package com.example.demokotlin

import kotlin.random.Random

//Boucle For
fun main10() {
    val listClient = listOf(
        "John Doe", "Peter Parker","Harry Potter", "Tony Stark")
    for(client in listClient){
        println("Bienvenu $client,\n " +
                "Notre solution de paiement est conçue pour vous")
    }
    for((id,client) in listClient.withIndex()){
        println("Bienvenu $client, vous êtes le numéro $id\n " +
                "Notre solution de paiement est conçue pour vous")
    }

}
fun main11(){
    val secretNumber = Random.nextInt(1, 11)
    var guess: Int
    var attempts = 0

    println("Devinez le nombre entre 1 et 10!")

    while (true) {
        print("Entrez votre nombre: ")
        guess = readLine()!!.toInt()
        attempts++

        if (guess == secretNumber) {
            println("Bravo! vous avez trouvé $secretNumber en $attempts tentatives.")
                break
        } else {
            println("Essayez encore.")
        }
    }
}
