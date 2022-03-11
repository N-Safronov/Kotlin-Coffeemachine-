package com.example.coffeemachine

class CoffeeMachine(
    private val name: String = "Default"
)
{
    private var coffeeBean: Int by Delegate(1000, 1000)
    private var volumeWater: Int by Delegate(1000, 1000)
    private var volumeMilk: Int by Delegate(1000, 1000)
    private var volumeCream: Int by Delegate(1000, 1000)
    private var state: Int by Delegate(10, 10)
    private var coffee: Map<String, Coffee> = mapOf(
        "Espresso" to Coffee("Espresso", "Espresso",
            2, 40, 0, 0),
        "Doppio" to Coffee("Doppio", "Double dose Espresso",
            2, 40, 0, 0),
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

    fun addIngredientBeanMax() { coffeeBean = 1000 }

    fun addIngredientWaterMax() { volumeWater = 1000 }

    fun addIngredientMilkMax() { volumeMilk = 1000 }

    fun addIngredientCreamMax() { volumeCream = 1000 }


    fun getIngredientBean() : Int { return coffeeBean }

    fun getIngredientWater() : Int { return volumeWater }

    fun getIngredientMilk() : Int { return volumeMilk }

    fun getIngredientCream() : Int { return volumeCream }


    private fun сheckIngredient(remainingIngredient: Int, amount : Int, ingredient: Int):Boolean
    {
        if(remainingIngredient >= ingredient * amount)
        {
            return true
        }
        return false
    }

    private fun spendingIngredient(_coffeeBean: Int, _volumeWater: Int, _volumeMilk: Int, _volumeCream: Int)
    {
        coffeeBean -= _coffeeBean
        volumeWater -= _volumeWater
        volumeMilk -= _volumeMilk
        volumeCream -= _volumeCream
        state -= 1
    }

    private fun machineCleaning()
    {
        volumeWater -= 20
        println("Coffee machine is being cleaned!")
        state = 10
        doWork("cleaned")
    }

    fun createDrink(name: String, amount : Int)
    {
        if(сheckIngredient(coffeeBean, amount, coffee[name]!!.volumeCaffeine) &&
            сheckIngredient(volumeWater, amount, coffee[name]!!.volumeWater) &&
            сheckIngredient(volumeMilk, amount, coffee[name]!!.volumeMilk) &&
            сheckIngredient( volumeCream, amount, coffee[name]!!.volumeCream)
        )
        {
            for (i in 1..amount)
            {
                if(state <= 0)
                {
                    machineCleaning()
                }
                println("All right!")
                spendingIngredient(coffee[name]!!.volumeCaffeine, coffee[name]!!.volumeWater,
                    coffee[name]!!.volumeMilk, coffee[name]!!.volumeCream)
                doWork(name)
                println("$i : $name\n")
            }
        }
        else
        {
            println("NO INGRIDIENT!")
        }
    }

    fun createDrink(amount : Int, _coffeeBean: Int, _volumeWater: Int, _volumeMilk: Int, _volumeCream: Int)
    {
        if(сheckIngredient(coffeeBean, amount, _coffeeBean) &&
            сheckIngredient(volumeWater, amount, _volumeWater) &&
            сheckIngredient(volumeMilk, amount, _volumeMilk) &&
            сheckIngredient( volumeCream, amount, _volumeCream)
        )
        {
            for (i in 1..amount)
            {
                if(state <= 0)
                {
                    machineCleaning()
                }
                println("All right!")
                spendingIngredient(_coffeeBean, _volumeWater, _volumeMilk, _volumeCream)
                doWork("Your drink")
                println("$i : Your drink\n")
            }
        }
        else
        {
            println("NO INGRIDIENT!")
        }
    }

    fun getRecipe(name: String) : String
    {
        return coffee[name]!!.recipe
    }

    private fun doWork(name : String) {
        println("Please wait :)\nGoing on $name\nDrrrr")
        for (i in 0..3) {
            Thread.sleep(1000)
            print(".")
        }
        print("\n")
    }
}


