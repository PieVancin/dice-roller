package com.pievancin.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // a listener of a button that calls the rollDice function
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // do a dice roll when the app starts
        rollDice()
    }

    private fun rollDice() {
        // create new Dice with 6 sides and rolls it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // stores the imageView into a variable
        val diceImage: ImageView = findViewById(R.id.imageView)

        // determine which drawable resource will be returned based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // shows the returned dice image inside the imageView
        diceImage.setImageResource(drawableResource)

        diceImage.contentDescription = diceRoll.toString()
    }
}

// dice abstraction class that contains sides and a function
class Dice(private val numSides: Int) {
    // a function that rolls the dice and return a random number
    fun roll(): Int {
        return (1..numSides).random()
    }
}