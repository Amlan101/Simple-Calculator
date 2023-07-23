package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide();

        val b1 = findViewById<Button>(R.id.buttonSum)
        val b2 = findViewById<Button>(R.id.buttonDiff)
        val b3 = findViewById<Button>(R.id.buttonProduct)
        val b4 = findViewById<Button>(R.id.buttonDivide)

        b1.setOnClickListener{
            validate(userNum1.text.toString(), userNum2.text.toString(), '+')
        }
        b2.setOnClickListener{
            validate(userNum1.text.toString(), userNum2.text.toString() ,'-')
        }
        b3.setOnClickListener{
            validate(userNum1.text.toString(), userNum2.text.toString() ,'*')
        }
        b4.setOnClickListener{
            validate(userNum1.text.toString(), userNum2.text.toString() ,'/')
        }
    }

    private fun validate( first: String, second: String, operator: Char) {
        if(first.isEmpty()){
            userNum1.error = "Give a number!"
        }
        if(second.isEmpty()){
            userNum2.error = "Give a number!"
        }
        if(first.isNotEmpty() && second.isNotEmpty()){
            calculation(first.toDouble(), second.toDouble(), operator)
        }
    }
    private fun calculation(first: Double, second: Double, operator: Char) {
        var result = 0.0
        when(operator) {
            '+' -> result = first + second
            '-' -> result = first - second
            '*' -> result = first * second
            '/' -> result = first / second
        }
        tv_Result.text = result.toString()
    }
}