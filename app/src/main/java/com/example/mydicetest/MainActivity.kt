package com.example.mydicetest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
            val newSides = textNo.text.toString().toIntOrNull()
            if ( newSides == null ) {
                val toast = Toast.makeText(this, R.string.Toast_3, Toast.LENGTH_SHORT)
                toast.show()
                return
            } else {
            val toast = Toast.makeText(this, R.string.Toast_2, Toast.LENGTH_SHORT)
            toast.show()
            numSides = newSides.times(6)!!
        }
    }

    private fun rollDice(numSides: Int=6) {
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
