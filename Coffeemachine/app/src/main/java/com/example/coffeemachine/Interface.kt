package com.example.coffeemachine

class Interface
{
    private val coffeeMachine = CoffeeMachine()
    val listCoffeeText = listOf(
        "Espresso", "Doppio", "Ristretto", "Lungo", "Americano",
        "Cappuccino", "Macchiato", "Latte", "Con Panna", "Vienna coffee", "Latte macchiato"
    )

    fun start()
    {
        coffeeMachine.start()
        printMessageText(1);
        dialog()
    }

    private fun dialog()
    {
        var running: Boolean = true

        while (running)
        {
            printMessageText(3);
            val input = readLine().toString()
            try
            {
                when (input.toInt())
                {
                    0 -> running = false
                    1 -> drinnksMenu()
                    2 -> godMode()
                    3 -> checkIngredients()
                    else -> {
                        printMessageText(2)
                    }
                }
            }
            catch (e:Exception)
            {
                println("Error: ${e.message}")
            }
        }
    }

    private fun printMessageText(input: Int)
    {
        when (input)
        {
            1 -> println("Hello!")
            2 -> println("Please enter a valid number!")
            3 -> println("0 - Power off / 1 - Drinks menu / 2 - God 'mode / " +
                    "3 - Check ingredients and add if needed" )
            4 -> println("0 - Exit to the main menu / 1 - Choose which ingredients to add")
            5 -> println("1 - Add Bean max / 2 - Add Milk max / 3 - Add Cream max / " +
                    "4 - Add Water max / 0 - Exit to the main menu\n")
            6 ->  println("Bean: ${coffeeMachine.coffeeBean}\n" +
                    "Milk: ${coffeeMachine.volumeMilk}\n" +
                    "Cream: ${coffeeMachine.volumeCream}\n" +
                    "Water: ${coffeeMachine.volumeWater}\n\n")
            7 -> println("1 - Espresso / 2 - Doppio / 3 - Ristreto / 4 - Lungo / " +
                    "5 - Americano / 6 - Cappuccino\n" +
                    "7 - Macchiato / 8 - Latte / 9 - Con Panna / " +
                    "10 - Vienna Coffee / 11 - Latte Macchiato")
            8 -> println("Enter the number of mugs:")
            9 -> println("God mode allows you to choose the amount of ingredients yourself:)\n" +
                    "You can also see the recipe for any drink or press 0:")
            10 -> println("1 - Espresso / 2 - Double dose of caffeine / 3 - Reduced dose of caffeine" +
                    "4 - Water / 5 - Milk / 6 - frothed milk / 7 - Cream / 8 - Whipped cream")
            else -> {
                println("Error")
            }
        }
    }


    private fun drinnksMenu()
    {
        printMessageText(7)
        val inputName = readLine().toString()
        printMessageText(8)
        val inputAmount = readLine().toString()
        println(coffeeMachine.createDrink(listCoffeeText[inputName.toInt()-1], inputAmount.toInt()))
    }

    private fun godMode()
    {
        printMessageText(9)
        printMessageText(7)
        val inputName = readLine().toString()
        if(inputName.toInt() !=0) {
            println("Recipe: ${coffeeMachine.getRecipe(listCoffeeText[inputName.toInt() - 1])}")
        }

        val inputIngredient = readLine().toString()
        var inputBean : String = "2"
        var inputMilk : String = "0"
        var inputCream : String = "0"
        var inputWater : Int = 0
        var running: Boolean = true

        printMessageText(10)

        while (running) {
            when (inputIngredient.toInt()) {
                0 -> inputWater += readLine().toString()
                1 -> inputBean = "3"
                2 -> inputBean = "1"
                3 -> inputWater += readLine().toInt()
                4 -> checkIngredients()
                5 -> checkIngredients()
                6 -> checkIngredients()
                7 -> checkIngredients()
                8 -> checkIngredients()
                else -> {
                    printMessageText(2)
                }
            }
        }

        printMessageText(8)
        val inputAmount = readLine().toString()

        coffeeMachine.createDrink(inputAmount.toInt(), inputBean.toInt(), inputMilk.toInt(),
            inputCream.toInt(), inputWater.toInt())
    }

    private fun checkIngredients()
    {
        printMessageText(6)

        printMessageText(4)
        var input = readLine().toString()

        if (input.toInt() == 1)
        {
            var running: Boolean = true

            while (running)
            {
                printMessageText(6)
                printMessageText(5)
                input = readLine().toString()

                when (input.toInt()) {
                    1 -> coffeeMachine.addIngredientBeanMax()
                    2 -> coffeeMachine.addIngredientMilkMax()
                    3 -> coffeeMachine.addIngredientCreamMax()
                    4 -> coffeeMachine.addIngredientWaterMax()
                    0 -> running = false
                    else -> {
                        printMessageText(2)
                    }
                }
            }
        }
    }

}