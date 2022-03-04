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
        var running: Boolean = true

        while (running)
        {
            printMessageText(2);
            val input = readLine().toString()
            try
            {
                when (input.toInt())
                {
                    0 -> running = exitMode()
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
            1 -> print("Hello!\n")
            2 -> print("0 - Exit / 1 - Drinks menu / 2 - God 'mode\n")
            3 -> print("1 - Restart / 0 - Power off\n")
            else -> {
                print("Error")
            }
        }
    }

//    private exitNow(exitFunc: () -> Void) {
//
//    }

    private fun exitMode() : Boolean
    {
        printMessageText(3)
        val input = readLine().toString()
        when (input.toInt())
        {
            0 -> println("OK)!")
            1 -> start()
            else -> {
                print("Please enter a valid number!")
            }
        }
        return false
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