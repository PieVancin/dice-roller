package com.pievancin.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // a listener of a button that calls the rollDice function
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        // create new Dice with 6 sides and rolls it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // shows the returned number inside a textView
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        val dice2 = Dice(20)
        val diceRoll2 = dice2.roll()

        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = diceRoll2.toString()
    }
}

// dice abstraction class that contains sides and a function
class Dice(private val numSides: Int) {
    // a function that rolls the dice and return a random number
    fun roll(): Int {
        return (1..numSides).random()
    }
}