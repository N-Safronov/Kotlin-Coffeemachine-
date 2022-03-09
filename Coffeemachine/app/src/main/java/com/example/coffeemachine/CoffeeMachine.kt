package com.example.coffeemachine

class CoffeeMachine(
    private val name: String = "Default"
)  {
    private var coffeeBean: Int by Delegate(1000, 1000)
    private var volumeWater: Int by Delegate(1000, 1000)
    private var volumeMilk: Int by Delegate(1000, 1000)
    private var volumeCream: Int by Delegate(1000, 1000)
    private var state: Int by Delegate(100, 100)
    private var coffee: Map<String, Coffee> = mapOf(
        "Espresso" to Coffee("Espresso", "Espresso",
            2, 40, 0, 0),
        "Doppio" to Coffee("Doppio", "Double dose Espresso",
            2, 400, 0, 0),
        "Ristretto" to Coffee("Ristretto", "Espresso + Double dose of caffeine",
            3, 40, 0, 0),
        "Lungo" to  Coffee("Lungo", "Espresso + Reduced dose of caffeine",
            1, 60, 0, 0),
        "Americano" to Coffee("Americano", "Espresso + Triple dose Water",
            2, 140, 0, 0),
        "Cappuccino" to Coffee("Cappuccino", "Espresso + Milk + Double dose frothed milk",
            2, 40, 80, 0),
        "Macchiato" to Coffee("Macchiato", "Double dose espresso + Frothed milk",
            2, 60, 25, 0),
        "Latte" to  Coffee("Latte", "Espresso + Double dose milk + Frothed milk",
            2, 40, 60, 25),
        "Con Panna" to Coffee("Con Panna", "Espresso + Whipped cream",
            2, 40, 0, 25),
        "Vienna coffee" to Coffee("Vienna coffee", "Espresso + Double dose whipped cream",
            2, 40, 0, 50),
        "Latte macchiato" to Coffee("Latte macchiato", "Espresso + Double dose milk + Whipped cream",
            2, 40, 60, 25)
    )

    fun start()
    {
        //у меня была идея, но с json не получилось
    }

    fun addIngredientBean(ingredient : Int) { coffeeBean += ingredient }

    fun addIngredientWater(ingredient : Int) { volumeWater += ingredient }

    fun addIngredientMilk(ingredient : Int) { volumeMilk += ingredient }

    fun addIngredientCream(ingredient : Int) { volumeCream += ingredient }


    fun сheckIngredient(amount : Int, ingredient: Int):Boolean
    {
        if(coffeeBean >= ingredient * 2 * amount) //!!!!!!!!!!eror
        {
            return true
        }
        return false
    }

    fun spendingIngredient(name: String, amount : Int)
    {
            coffeeBean -= coffee[name]!!.volumeCaffeine * amount
            volumeWater -= coffee[name]!!.volumeWater * amount
            volumeMilk -= coffee[name]!!.volumeMilk * amount
            volumeCream -= coffee[name]!!.volumeCream * amount
    }

    fun createDrink(name: String, amount : Int)
    {
        if(сheckIngredient(amount, coffee[name]!!.volumeCaffeine) &&
            сheckIngredient(amount, coffee[name]!!.volumeWater) &&
            сheckIngredient(amount, coffee[name]!!.volumeMilk) &&
            сheckIngredient(amount, coffee[name]!!.volumeCream)
        )
        {
            for (i in 1..amount) {
                spendingIngredient(name, amount)
                println("Drrrr")
                doWork()
                println("$i : $name")
            }
        }
        else
        {
            println("NO INGRIDIENT")
        }
    }

    fun menuDrink()
    {
        /*coffee[1].name
        for (i in coffee)
        {
            println()
        }*/
    }

    fun doWork() {
        for (i in 0..3) {
            Thread.sleep(1000)
            print(".")
        }
        print("\n")
    }
}


