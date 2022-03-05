package com.example.coffeemachine

class CoffeeMachine
{
    private val name: String
    private var volumeWater: Int by Delegate(1000)
    private val volumeMilk: Int
    private val volumeLemonJuice: Int
    private val volumeIceCream: Int
    private val volumeCream: Int
    private val coffeeMachineMemory: String

    constructor()
    {
        name = "default"
        volumeMilk = 2000
        volumeLemonJuice = 500
        volumeIceCream = 2000
        volumeCream = 2000
        coffeeMachineMemory = "coffeeMachineMemory"
    }

    constructor( _name: String, _volumeWater: Int, _volumeMilk: Int,
        _volumeLemonJuice: Int, _volumeIceCream:Int, _volumeCream: Int)
    {
        name = _name
        volumeWater = _volumeWater
        volumeMilk = _volumeMilk
        volumeLemonJuice = _volumeLemonJuice
        volumeIceCream = _volumeIceCream
        volumeCream = _volumeCream
        coffeeMachineMemory = "coffeeMachineMemory"
    }

    fun start()
    {

    }

    fun сhecking()
    {
        when (false)
        {
            volumeWater > 1000 -> print("Oh! Please pour Water\n")
            volumeMilk > 1000 -> print("Oh! Please pour Milk\n")
            volumeLemonJuice > 1000 -> print("Oh! Please pour Lemon Juice\n")
            volumeIceCream > 1000 -> print("Oh! Please pour Ice Cream\n")
            volumeCream > 1000 -> print("Oh! Please pour Cream\n")
            else -> {
                print("Everything is fine)))))\n")
            }
        }
    }

    fun addIngredient() {
        volumeWater += 100
    }
}