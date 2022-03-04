package com.example.coffeemachine

class Coffee
{
    private val name: String
    private val recipe: String
    private val volume: String
    private val temperature : Int

    constructor() {
        name = "default"
        recipe = "non"
        volume = "0"
        temperature = 0
    }

    constructor(_name: String, _recipe: String, _volume: String, _temperature: Int) {
        name = _name
        recipe = _recipe
        volume = _volume
        temperature = _temperature
    }
}