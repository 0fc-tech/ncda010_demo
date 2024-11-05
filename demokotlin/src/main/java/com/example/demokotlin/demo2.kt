package com.example.demokotlin

//if / else / else if
fun main5() {
    val customerLivingInFrance = true
    val customerLivingInNL = false
    val shippingCost = if(customerLivingInFrance)
        5
    else if(customerLivingInNL)
        8
    else 80
    println("Coût de transport : $shippingCost")
}
//when
fun main6() {
    val idCategory = 9832
    val categorieGenerale = when(idCategory){
        in 1..1000-> "Alimentaire"
        in 1001..4500 -> "Culture"
        4501,4502,4503,4504-> "High Tech"
        else ->"Santé"
    }
    println("Catégorie Générale : $categorieGenerale")
}
