package com.example.coffeemachine

class Interface
{
    fun start()
    {
        CoffeeMachine().start()
        сheckingMachine()
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
            4 -> print("Checking the status of the coffee machine.....\n")
            else -> {
                print("Error")
            }
        }
    }

    private fun сheckingMachine()
    {
        printMessageText(4)
        CoffeeMachine().сhecking()
    }

    private fun drinnksMenu()
    {

    }

    private fun godMode(){


    }
}