package com.ghfir.percobaan

import android.content.Intent
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.ArrayList
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    // Deklarasi UI komponen
    private lateinit var tvDisplay: TextView
    private lateinit var scientificRow1: LinearLayout
    private lateinit var scientificRow2: LinearLayout
    private lateinit var btnCalcMenu: MaterialButton
    private lateinit var btnRadDeg: MaterialButton
    private lateinit var btnBack: ImageButton

    // Nama mahasiswa
    private lateinit var namaMahasiswa: String
    private var umur: Int = 22

    // State kalkulator
    private var currentInput = ""
    private var isResultShown = false
    private var isScientificMode = false
    private var isRadMode = true // true = Radian, false = Degree untuk trigonometri

    // Sound effect
    private lateinit var soundPool: SoundPool
    private var soundId: Int = 0

    // Riwayat perhitungan untuk Math Notes
    private val calculationHistory = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        //Data Kiriman
//
//        namaMahasiswa = "Faisal Mustaghfirullah"
//        umur = 22
//
//        intent.putExtra(MenuActivity.EXTRA_NAME, namaMahasiswa)
//        intent.putExtra(MenuActivity.EXTRA_AGE, umur)
//        startActivity(intent)

        // Inisialisasi UI komponen
        tvDisplay = findViewById(R.id.tvDisplay)
        btnBack = findViewById(R.id.btnBack)
        scientificRow1 = findViewById(R.id.scientificRow1)
        scientificRow2 = findViewById(R.id.scientificRow2)
        btnCalcMenu = findViewById(R.id.btnCalcMenu)
        btnRadDeg = findViewById(R.id.btnRadDeg)

        // Setup listener tombol
        setupNumberButtons()
        setupOperatorButtons()
        setupSpecialButtons()
        setupScientificButtons()

        // Setup sound pool
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool = SoundPool.Builder()
            .setMaxStreams(1)
            .setAudioAttributes(audioAttributes)
            .build()
        soundId = soundPool.load(this, R.raw.sound_effect, 1)

        // Listener untuk tombol kembali ke menu utama
        btnBack.setOnClickListener {
            val mauPindah = Intent(this@MainActivity, MenuActivity::class.java)
            mauPindah.putExtra(MenuActivity.KEY_NAMA_MHS, "Faisal Mustaghfirullah")
            mauPindah.putExtra(MenuActivity.KEY_UMUR_MHS, 22533568)
            startActivity(mauPindah)
            finish()
        }

        // Listener untuk tombol menu kalkulator
        btnCalcMenu.setOnClickListener { view ->
            showCalculatorMenu(view)
        }

        // Update visibilitas mode ilmiah dan teks tombol Rad/Deg saat aplikasi dimulai
        updateScientificModeVisibility()
        updateRadDegButtonText()
    }

    // Setup listener untuk tombol angka (0-9)
    private fun setupNumberButtons() {
        listOf<MaterialButton>(
            findViewById(R.id.btn0), findViewById(R.id.btn1), findViewById(R.id.btn2),
            findViewById(R.id.btn3), findViewById(R.id.btn4), findViewById(R.id.btn5),
            findViewById(R.id.btn6), findViewById(R.id.btn7), findViewById(R.id.btn8),
            findViewById(R.id.btn9)
        ).forEach { button ->
            button.setOnClickListener {
                appendNumber(button.text.toString())
            }
        }
    }

    // Setup listener untuk tombol operator (+, -, ×, ÷)
    private fun setupOperatorButtons() {
        listOf<MaterialButton>(
            findViewById(R.id.btnAdd),
            findViewById(R.id.btnSubtract),
            findViewById(R.id.btnMultiply),
            findViewById(R.id.btnDivide)
        ).forEach { button ->
            button.setOnClickListener {
                appendOperator(button.text.toString())
            }
        }
    }

    // Setup listener untuk tombol khusus (AC, +/-, ., =, %)
    private fun setupSpecialButtons() {
        findViewById<MaterialButton>(R.id.btnClear).setOnClickListener { clearDisplay() }
        findViewById<MaterialButton>(R.id.btnDot).setOnClickListener { appendDecimal() }
        findViewById<MaterialButton>(R.id.btnEquals).setOnClickListener { calculateResult() }
        findViewById<MaterialButton>(R.id.btnPlusMinus).setOnClickListener { toggleSign() }
        findViewById<MaterialButton>(R.id.btnPercentage).setOnClickListener { applyPercentage() }
        // Jika Anda memiliki tombol DEL, tambahkan listener-nya di sini:
        // findViewById<MaterialButton>(R.id.btnDel).setOnClickListener { deleteLastCharacter() }
    }

    // Setup listener untuk tombol ilmiah (sin, cos, tan, ln, log, sqrt, ^, π, e)
    private fun setupScientificButtons() {
        btnRadDeg.setOnClickListener { toggleRadDegMode() }
        findViewById<MaterialButton>(R.id.btnSin).setOnClickListener { applyScientificFunction("sin") }
        findViewById<MaterialButton>(R.id.btnCos).setOnClickListener { applyScientificFunction("cos") }
        findViewById<MaterialButton>(R.id.btnTan).setOnClickListener { applyScientificFunction("tan") }
        findViewById<MaterialButton>(R.id.btnLn).setOnClickListener { applyScientificFunction("ln") }
        findViewById<MaterialButton>(R.id.btnLog).setOnClickListener { applyScientificFunction("log") }
        findViewById<MaterialButton>(R.id.btnRoot).setOnClickListener { applyScientificFunction("sqrt") }
        findViewById<MaterialButton>(R.id.btnPower).setOnClickListener { appendOperator("^") }
        findViewById<MaterialButton>(R.id.btnPi).setOnClickListener { appendConstant("pi") }
        findViewById<MaterialButton>(R.id.btnE).setOnClickListener { appendConstant("e") }
    }

    // Menambahkan angka ke input saat ini
    private fun appendNumber(number: String) {
        playEffect()
        if (isResultShown || tvDisplay.text.toString() == "Error") {
            currentInput = ""
            isResultShown = false
            tvDisplay.text = "0"
        }

        // Handle leading zero
        if (currentInput == "0" && number != ".") {
            currentInput = number
        } else {
            currentInput += number
        }
        updateDisplay()
    }

    // Menambahkan operator ke input saat ini
    private fun appendOperator(operator: String) {
        playEffect()
        if (currentInput.isEmpty() || currentInput == "Error") {
            // Izinkan minus (-) di awal untuk angka negatif
            if (operator == "-") {
                currentInput = "-"
                updateDisplay()
            }
            return
        }

        // Ganti operator jika operator terakhir
        if (isLastCharOperator()) {
            currentInput = currentInput.dropLast(1)
        }
        currentInput += when (operator) {
            "×" -> "*" // Konversi operator visual ke yang dikenali exp4j
            "÷" -> "/"
            else -> operator
        }
        updateDisplay()
    }

    // Menambahkan titik desimal
    private fun appendDecimal() {
        playEffect()
        if (isResultShown || tvDisplay.text.toString() == "Error") {
            currentInput = "0."
            isResultShown = false
            updateDisplay()
            return
        }

        // Cek apakah angka terakhir sudah memiliki titik desimal
        val lastNumber = currentInput.split(Regex("[+\\-*/%^]")).lastOrNull()
        if (lastNumber == null || !lastNumber.contains(".")) {
            if (currentInput.isEmpty() || isLastCharOperator()) {
                currentInput += "0."
            } else {
                currentInput += "."
            }
        }
        updateDisplay()
    }

    // Menambahkan konstanta (pi, e)
    private fun appendConstant(constant: String) {
        playEffect()
        if (isResultShown || tvDisplay.text.toString() == "Error") {
            currentInput = ""
            isResultShown = false
        }
        // Tambahkan operator perkalian implisit jika ditambahkan setelah angka atau kurung tutup
        if (currentInput.isNotEmpty() && (currentInput.last().isDigit() || currentInput.last() == ')')) {
            currentInput += "*"
        }
        currentInput += when (constant) {
            "pi" -> "pi" // exp4j mengenali 'pi'
            "e" -> "e"   // exp4j mengenali 'e'
            else -> ""
        }
        updateDisplay()
    }

    // Menghapus karakter terakhir (jika tombol DEL ada)
    private fun deleteLastCharacter() {
        playEffect()
        if (currentInput.isNotEmpty() && tvDisplay.text.toString() != "Error") {
            currentInput = currentInput.dropLast(1)
            if (currentInput.isEmpty()) {
                tvDisplay.text = "0"
            }
            updateDisplay()
        }
    }

    // Membersihkan display dan input
    private fun clearDisplay() {
        playEffect()
        currentInput = ""
        tvDisplay.text = "0"
        isResultShown = false
    }

    // Mengubah tanda (positif/negatif) dari angka terakhir
    private fun toggleSign() {
        playEffect()
        if (currentInput.isEmpty() || tvDisplay.text.toString() == "Error") return

        val lastNumberMatch = Regex("([+\\-*%/^])?([0-9]*\\.?[0-9]+)$").find(currentInput)
        if (lastNumberMatch != null) {
            val (operatorPrefix, numberString) = lastNumberMatch.destructured
            val prefix = currentInput.substring(0, lastNumberMatch.range.first)

            if (operatorPrefix == "-") { // Jika sudah ada tanda minus di depan angka
                currentInput = prefix + numberString // Hapus minusnya
            } else { // Jika tidak ada operator atau operator positif
                currentInput = prefix + "-" + numberString // Tambahkan minus
            }
        } else if (currentInput.toDoubleOrNull() != null) { // Jika hanya ada satu angka di display
            val value = currentInput.toDouble()
            currentInput = (value * -1).toString()
            if (currentInput.endsWith(".0")) currentInput = currentInput.dropLast(2)
        }
        updateDisplay()
    }

    // Menerapkan operasi persentase
    private fun applyPercentage() {
        playEffect()
        if (currentInput.isEmpty() || tvDisplay.text.toString() == "Error") return

        try {
            val processedInput = currentInput.replace("%", "*0.01") // Exp4j: N% = N * 0.01
            val expression = ExpressionBuilder(processedInput).build()
            val result = expression.evaluate()

            currentInput = formatResult(result)
            updateDisplay()
            isResultShown = true
        } catch (e: Exception) {
            tvDisplay.text = "Error"
            currentInput = ""
            Toast.makeText(this, "Format persentase tidak valid: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    // Menghitung hasil ekspresi
    private fun calculateResult() {
        playEffect()
        if (currentInput.isEmpty() || currentInput == "Error") return

        try {
            // Proses input untuk ekspresi yang dikenali exp4j
            val processedInput = currentInput.replace("%", "*0.01")
            val finalExpression = processedInput
                .replace("×", "*")
                .replace("÷", "/")
                .replace("√", "sqrt") // Pastikan icon '√' dikonversi ke 'sqrt'

            // Bangun ekspresi dengan mendaftarkan fungsi ilmiah
            val expression = ExpressionBuilder(finalExpression)
                .function(createFunction("sin", { angle -> if (isRadMode) sin(angle) else sin(Math.toRadians(angle)) }))
                .function(createFunction("cos", { angle -> if (isRadMode) cos(angle) else cos(Math.toRadians(angle)) }))
                .function(createFunction("tan", { angle -> if (isRadMode) tan(angle) else tan(Math.toRadians(angle)) }))
                .function(createFunction("ln", { value -> ln(value) }))
                .function(createFunction("log", { value -> log10(value) })) // log basis 10
                .function(createFunction("sqrt", { value -> sqrt(value) }))
                .build()

            val result = expression.evaluate()

            // Simpan perhitungan ke riwayat sebelum diformat ulang untuk display
            val historyEntry = "$currentInput = ${formatResult(result)}"
            calculationHistory.add(historyEntry)
            if (calculationHistory.size > 50) { // Batasi riwayat agar tidak terlalu panjang
                calculationHistory.removeAt(0)
            }

            currentInput = formatResult(result)
            tvDisplay.text = currentInput
            isResultShown = true
        } catch (e: Exception) {
            tvDisplay.text = "Error"
            currentInput = ""
            Toast.makeText(this, "Kesalahan: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    // Helper untuk membuat fungsi yang dikenali exp4j
    private fun createFunction(name: String, func: (Double) -> Double): net.objecthunter.exp4j.function.Function {
        return object : net.objecthunter.exp4j.function.Function(name, 1) {
            override fun apply(args: DoubleArray): Double {
                if (args.isEmpty()) throw IllegalArgumentException("Missing argument for function $name")
                return func(args[0])
            }
        }
    }

    // Menerapkan fungsi ilmiah (sin, cos, dll.) ke input
    private fun applyScientificFunction(functionName: String) {
        playEffect()
        if (isResultShown || tvDisplay.text.toString() == "Error") {
            currentInput = ""
            isResultShown = false
            tvDisplay.text = "0"
        }

        // Jika input saat ini adalah angka di akhir, terapkan fungsi ke angka itu
        val lastNumberMatch = Regex("([0-9]*\\.?[0-9]+)$").find(currentInput)
        if (lastNumberMatch != null && lastNumberMatch.range.last == currentInput.lastIndex) {
            val number = lastNumberMatch.value
            val prefix = currentInput.substring(0, lastNumberMatch.range.first)
            currentInput = "$prefix$functionName($number)"
        } else {
            // Jika tidak ada angka di akhir, atau input kosong, tambahkan fungsi dan kurung buka
            currentInput += "$functionName("
        }
        updateDisplay()
    }

    // Mengubah mode Radian/Derajat
    private fun toggleRadDegMode() {
        playEffect()
        isRadMode = !isRadMode
        updateRadDegButtonText()
        Toast.makeText(this, if (isRadMode) "Mode: Radian" else "Mode: Derajat", Toast.LENGTH_SHORT).show()
    }

    // Update teks tombol Rad/Deg
    private fun updateRadDegButtonText() {
        btnRadDeg.text = if (isRadMode) "Rad" else "Deg"
    }

    // Memeriksa apakah karakter terakhir adalah operator
    private fun isLastCharOperator(): Boolean {
        return currentInput.isNotEmpty() && currentInput.last() in listOf('+', '-', '*', '/', '%', '^')
    }

    // Memformat hasil perhitungan (menghilangkan .0 jika bulat, batasi desimal)
    private fun formatResult(result: Double): String {
        return when {
            result.isInfinite() || result.isNaN() -> "Error"
            result % 1 == 0.0 -> String.format("%.0f", result)
            else -> String.format("%.8f", result).trimEnd('0').trimEnd('.')
        }
    }

    // Update tampilan TextView
    private fun updateDisplay() {
        tvDisplay.text = currentInput.ifEmpty { "0" }
    }

    // Memainkan sound effect
    private fun playEffect(){
        soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPool.release()
    }

    // Menampilkan menu kalkulator (Basic, Scientific, Math Notes, Convert)
    private fun showCalculatorMenu(view: View) {
        val popup = PopupMenu(this, view)
        popup.menuInflater.inflate(R.menu.calculator_menu, popup.menu)

        // Setel status checked untuk item menu saat ini
        if (isScientificMode) {
            popup.menu.findItem(R.id.menu_scientific)?.isChecked = true
        } else {
            popup.menu.findItem(R.id.menu_basic)?.isChecked = true // Perbaiki ID di sini
        }

        popup.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.menu_basic -> {
                    isScientificMode = false
                    item.isChecked = true
                    updateScientificModeVisibility()
                    true
                }
                R.id.menu_scientific -> {
                    isScientificMode = true
                    item.isChecked = true
                    updateScientificModeVisibility()
                    true
                }
                R.id.menu_math_notes -> {
                    val intent = Intent(this, MathNotesActivity::class.java)
                    intent.putStringArrayListExtra("calculation_history", calculationHistory)
                    startActivity(intent)
                    true
                }
                R.id.menu_convert -> {
                    val intent = Intent(this, ConverterActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
        popup.show()
    }

    // Mengatur visibilitas baris tombol ilmiah
    private fun updateScientificModeVisibility() {
        if (isScientificMode) {
            scientificRow1.visibility = View.VISIBLE
            scientificRow2.visibility = View.VISIBLE
        } else {
            scientificRow1.visibility = View.GONE
            scientificRow2.visibility = View.GONE
        }
    }
}