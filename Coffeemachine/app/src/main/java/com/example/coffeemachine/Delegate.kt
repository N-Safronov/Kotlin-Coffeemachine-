package com.example.coffeemachine

import kotlin.reflect.KProperty

class Delegate(
    var max: Int
) {
    private var innerValue: Int = 0
    operator fun getValue(coffeeMachine: CoffeeMachine, property: KProperty<*>): Int {
        return innerValue
    }
    operator fun setValue(coffeeMachine: CoffeeMachine, property: KProperty<*>, value: Int) {
        if(value < 0 || value > max) {
            return
        }
        innerValue = value
    }
}