package com.example.coffeemachine

class CoffeeMachine
{
    private val name: String
    private val model: String
    private val volumeWater: Int
    private val volumeMilk: Int
    private val volumeLemonJuice: Int
    private val volumeIceCream: Int
    private val volumeCream: Int

    constructor()
    {
        name = "default"
        model = "default"
        volumeWater = 0
        volumeMilk = 0
        volumeLemonJuice = 0
        volumeIceCream = 0
        volumeCream = 0
    }

    constructor( _name: String, _model: String, _volumeWater: Int, _volumeMilk: Int,
        _volumeLemonJuice: Int, _volumeIceCream:Int, _volumeCream: Int)
    {
        name = _name
        model = _model
        volumeWater = _volumeWater
        volumeMilk = _volumeMilk
        volumeLemonJuice = _volumeLemonJuice
        volumeIceCream = _volumeIceCream
        volumeCream = _volumeCream
    }
}