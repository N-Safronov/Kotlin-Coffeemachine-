package com.example.coffeemachine

class Interface
{
    private val coffeeMachine = CoffeeMachine()

    fun start()
    {
        coffeeMachine.start()
        dialog();
    }

    private fun dialog()
    {
        printMessageText(1);
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
            1 -> print("Hello!\n")
            2 -> print("Please enter a valid number!\n")
            3 -> print("0 - Power off / 1 - Drinks menu / 2 - God 'mode\n")
            else -> {
                print("Error")
            }
        }
    }


    private fun drinnksMenu()
    {
        /* var coffee: List<Coffee> = CoffeeMachine().getCoffee()

       for(i in coffee){
            println(coffee)
        }*/

       println(coffeeMachine.createDrink("Doppio", 2))
    }

    private fun godMode(){


    }
}