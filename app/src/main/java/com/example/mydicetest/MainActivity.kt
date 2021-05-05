package com.example.mydicetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var numSides = 6
        val rollButton: Button = findViewById(R.id.button1)
        rollButton.setOnClickListener {
            rollDice(numSides)
            val toast = Toast.makeText(this, R.string.Toast_1, Toast.LENGTH_SHORT)
            toast.show()

        }
        var changeSides: Button = findViewById(R.id.button2)
        changeSides.setOnClickListener {
            val textNo: EditText = findViewById(R.id.editTextNumberSigned)
            numSides = textNo.text * 6
        }
    }

    private fun rollDice(numSides: Int) {
        val dice = Dice(numSides)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        val resultView: TextView = findViewById(R.id.textV1)
        resultView.text = diceRoll.toString()

    }
}

class Dice(val numSides: Int) {
    val times = 1
    fun roll(): Int {
        return (1..numSides).random()
    }
}
