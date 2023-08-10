package com.example.calculatenow
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var displayTextView: TextView
    private var currentInput: StringBuilder = StringBuilder()
    private var currentOperator: String = ""
    private var result: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayTextView = findViewById(R.id.displayTextView)
    }

    fun onNumberButtonClick(view: View) {
        val button = view as Button
        val buttonText = button.text.toString()

        currentInput.append(buttonText)
        displayTextView.text = currentInput.toString()
    }

    fun onOperatorButtonClick(view: View) {
        val button = view as Button
        currentOperator = button.text.toString()

        if (currentInput.isNotEmpty()) {
            result = currentInput.toString().toDouble()
            currentInput.clear()
        }
    }

    fun onEqualsButtonClick(view: View) {
        if (currentInput.isNotEmpty()) {
            val secondOperand = currentInput.toString().toDouble()
            when (currentOperator) {
                "+" -> result = result?.plus(secondOperand)
                "-" -> result = result?.minus(secondOperand)
                "*" -> result = result?.times(secondOperand)
                "/" -> result = result?.div(secondOperand)
            }

            displayTextView.text = result.toString()
            currentInput.clear()
            currentOperator = ""
        }
    }

    fun onClearButtonClick(view: View) {
        currentInput.clear()
        currentOperator = ""
        result = null
        displayTextView.text = ""
    }
}
