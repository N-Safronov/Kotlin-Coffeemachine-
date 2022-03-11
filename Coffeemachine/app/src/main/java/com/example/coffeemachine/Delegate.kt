package com.example.coffeemachine

import kotlin.reflect.KProperty

class Delegate(
    private var max: Int,
    private var initial: Int = 0
) {
    private var innerValue: Int = initial
    operator fun getValue(coffeeMachine: CoffeeMachine, property: KProperty<*>): Int {
        return innerValue
    }
    operator fun setValue(coffeeMachine: CoffeeMachine, property: KProperty<*>, value: Int) {
       /* if(value > 0 || value > max) {
            return
        }*/
        innerValue = value
    }
}