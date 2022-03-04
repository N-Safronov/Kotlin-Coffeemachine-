package com.example.coffeemachine

class Interface
{
    fun start()
    {
        dialog();
    }

    private fun dialog()
    {
        printMessageText(1);
        сheckingMachine()
        val running: Boolean = true

        while (running)
        {
            printMessageText(2);
            val input = readLine().toString()
            try
            {
                when (input.toInt())
                {
                    0 -> exitMode(running)
                    1 -> drinnksMenu()
                    2 -> godMode()
                    else -> {
                        print("Please enter a valid number!")
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
            1 -> print("Hello!")
            2 -> print("0 - Exit / 1 - Drinks menu / 2 - God 'mode")
            3 -> print("")
            else -> {
                print("Please enter a valid number!")
            }
        }
    }

    private fun exitMode(running: Boolean)
    {
       // return running = false
    }

    private fun сheckingMachine()
    {

    }

    private fun drinnksMenu()
    {

    }

    private fun godMode(){


    }
}