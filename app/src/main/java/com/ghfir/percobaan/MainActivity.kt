package com.ghfir.percobaan

import android.content.Intent
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var currentInput = ""
    private var isResultShown = false
    private lateinit var soundPool: SoundPool
    private var soundId: Int = 0
    private lateinit var btnBack: ImageButton // Deklarasikan di sini

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplay = findViewById(R.id.tvDisplay)
        setupNumberButtons()
        setupOperatorButtons()
        setupSpecialButtons()

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool = SoundPool.Builder()
            .setMaxStreams(1)
            .setAudioAttributes(audioAttributes)
            .build()
        soundId = soundPool.load(this, R.raw.sound_effect, 1)

        // Pindahkan inisialisasi dan listener ke sini
        btnBack = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish() // Tutup MainActivity
        }
    }

    private fun setupNumberButtons() {
        listOf<MaterialButton>(
            findViewById(R.id.btn0),
            findViewById(R.id.btn1),
            findViewById(R.id.btn2),
            findViewById(R.id.btn3),
            findViewById(R.id.btn4),
            findViewById(R.id.btn5),
            findViewById(R.id.btn6),
            findViewById(R.id.btn7),
            findViewById(R.id.btn8),
            findViewById(R.id.btn9)
        ).forEach { button ->
            button.setOnClickListener {
                appendNumber(button.text.toString())
            }
        }
    }

    private fun setupOperatorButtons() {
        listOf<MaterialButton>(
            findViewById(R.id.btnAdd),
            findViewById(R.id.btnSubtract),
            findViewById(R.id.btnMultiply),
            findViewById(R.id.btnDivide),
            findViewById(R.id.btnPercentage)
        ).forEach { button ->
            button.setOnClickListener {
                appendOperator(button.text.toString())
            }
        }
    }

    private fun setupSpecialButtons() {
        findViewById<MaterialButton>(R.id.btnClear).setOnClickListener { clearDisplay() }
        findViewById<MaterialButton>(R.id.btnDel).setOnClickListener { deleteLastCharacter() }
        findViewById<MaterialButton>(R.id.btnDot).setOnClickListener { appendDecimal() }
        findViewById<MaterialButton>(R.id.btnEquals).setOnClickListener { calculateResult() }
    }

    private fun appendNumber(number: String) {
        playEffect()
        if (isResultShown) {
            currentInput = ""
            isResultShown = false
        }
        currentInput += number
        updateDisplay()
    }

    private fun appendOperator(operator: String) {
        playEffect()
        if (currentInput.isNotEmpty() && !isLastCharOperator()) {
            currentInput += when (operator) {
                "×" -> "*"
                "÷" -> "/"
                "%" -> "%"
                else -> operator
            }
            updateDisplay()
        }
    }

    private fun appendDecimal() {
        playEffect()
        when {
            currentInput.isEmpty() || isLastCharOperator() -> currentInput += "0."
            !currentInput.contains(".") -> currentInput += "."
        }
        updateDisplay()
    }

    private fun deleteLastCharacter() {
        if (currentInput.isNotEmpty()) {
            currentInput = currentInput.dropLast(1)
            updateDisplay()
        }
    }

    private fun clearDisplay() {
        currentInput = ""
        tvDisplay.text = "0"
        isResultShown = false
    }

    private fun calculateResult() {
        try {
            val expression = ExpressionBuilder(currentInput)
                .build()
            val result = expression.evaluate()

            currentInput = when {
                result % 1 == 0.0 -> String.format("%.0f", result)
                else -> String.format("%.2f", result).replace(",", ".")
            }

            tvDisplay.text = currentInput
            isResultShown = true
        } catch (e: Exception) {
            tvDisplay.text = "Error"
            currentInput = ""
        }
    }

    private fun isLastCharOperator(): Boolean {
        return currentInput.isNotEmpty() && currentInput.last() in listOf('+', '-', '*', '/', '%')
    }

    private fun updateDisplay() {
        tvDisplay.text = currentInput.ifEmpty { "0" }
    }
    private fun playEffect(){
        soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPool.release()
    }

}