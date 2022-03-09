package com.example.coffeemachine

class Coffee
{
    var name: String
        private set
    var recipe: String
        private set
    var volumeCaffeine: Int
        private set
    var volumeWater: Int
        private set
    var volumeMilk: Int
        private set
    var volumeCream: Int
        private set

    constructor() {
        name = "Espresso"
        recipe = "Espresso"
        volumeCaffeine = 2
        volumeWater = 35
        volumeMilk = 0
        volumeCream = 0
    }

    constructor(_name: String, _recipe: String, _volumeCaffeine: Int , _volumeWater: Int,
                _volumeMilk: Int, _volumeCream: Int) {
        name = _name
        recipe = _recipe
        volumeCaffeine = _volumeCaffeine
        volumeWater = _volumeWater
        volumeMilk = _volumeMilk
        volumeCream = _volumeCream
    }
}