package com.ghfir.percobaan

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ConverterActivity : AppCompatActivity() {

    // --- UI Umum untuk Converter Activity ---
    private lateinit var btnBack: ImageButton
    private lateinit var tvConverterTitle: TextView
    private lateinit var layoutCategorySelection: LinearLayout

    // --- Deklarasi Layout Konverter Spesifik ---
    private lateinit var layoutTemperatureConverter: LinearLayout
    private lateinit var layoutLengthConverter: LinearLayout
    private lateinit var layoutFrequencyConverter: LinearLayout
    private lateinit var layoutEnergyConverter: LinearLayout
    private lateinit var layoutFuelConverter: LinearLayout
    private lateinit var layoutAreaConverter: LinearLayout
    private lateinit var layoutTimeConverter: LinearLayout
    private lateinit var layoutSpeedConverter: LinearLayout
    private lateinit var layoutMassConverter: LinearLayout
    private lateinit var layoutCurrentConverter: LinearLayout
    private lateinit var layoutPressureConverter: LinearLayout
    private lateinit var layoutAngleConverter: LinearLayout

    // --- Deklarasi UI Konversi Suhu ---
    private lateinit var etInputTemp: EditText
    private lateinit var btnCelsiusToFahrenheit: Button
    private lateinit var btnFahrenheitToCelsius: Button
    private lateinit var tvTempResult: TextView

    // --- Deklarasi UI Konversi Panjang ---
    private lateinit var etInputLength: EditText
    private lateinit var btnMeterToCm: Button // Contoh: Meter ke Sentimeter
    private lateinit var btnCmToMeter: Button // Contoh: Sentimeter ke Meter
    private lateinit var tvLengthResult: TextView

    // --- Deklarasi UI Konversi Frekuensi ---
    private lateinit var etInputFreq: EditText
    private lateinit var btnHzToKHz: Button
    private lateinit var btnKHzToHz: Button
    private lateinit var tvFreqResult: TextView

    // --- Deklarasi UI Konversi Energi ---
    private lateinit var etInputEnergy: EditText
    private lateinit var btnJoulesToCalories: Button
    private lateinit var btnCaloriesToJoules: Button
    private lateinit var tvEnergyResult: TextView

    // --- Deklarasi UI Konversi Bahan Bakar (Fuel) ---
    private lateinit var etInputFuel: EditText
    private lateinit var btnLitreToGallon: Button
    private lateinit var btnGallonToLitre: Button
    private lateinit var tvFuelResult: TextView

    // --- Deklarasi UI Konversi Area ---
    private lateinit var etInputArea: EditText
    private lateinit var btnSqMToSqKm: Button
    private lateinit var btnSqKmToSqM: Button
    private lateinit var tvAreaResult: TextView

    // --- Deklarasi UI Konversi Waktu (Time) ---
    private lateinit var etInputTime: EditText
    private lateinit var btnSecToMin: Button
    private lateinit var btnMinToSec: Button
    private lateinit var tvTimeResult: TextView

    // --- Deklarasi UI Konversi Kecepatan (Speed) ---
    private lateinit var etInputSpeed: EditText
    private lateinit var btnKmphToMps: Button
    private lateinit var btnMpsToKmph: Button
    private lateinit var tvSpeedResult: TextView

    // --- Deklarasi UI Konversi Massa ---
    private lateinit var etInputMass: EditText
    private lateinit var btnKgToGram: Button
    private lateinit var btnGramToKg: Button
    private lateinit var tvMassResult: TextView

    // --- Deklarasi UI Konversi Arus (Current) ---
    private lateinit var etInputCurrent: EditText
    private lateinit var btnAmpereToMilliampere: Button
    private lateinit var btnMilliampereToAmpere: Button
    private lateinit var tvCurrentResult: TextView

    // --- Deklarasi UI Konversi Tekanan (Pressure) ---
    private lateinit var etInputPressure: EditText
    private lateinit var btnPascalToKPa: Button
    private lateinit var btnKPaToPascal: Button
    private lateinit var tvPressureResult: TextView

    // --- Deklarasi UI Konversi Sudut (Angle) ---
    private lateinit var etInputAngle: EditText
    private lateinit var btnDegToRad: Button
    private lateinit var btnRadToDeg: Button
    private lateinit var tvAngleResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        // --- Inisialisasi UI Umum ---
        btnBack = findViewById(R.id.btnBack)
        tvConverterTitle = findViewById(R.id.tvConverterTitle)
        layoutCategorySelection = findViewById(R.id.layoutCategorySelection)

        // --- Inisialisasi Layout Konverter Spesifik ---
        layoutTemperatureConverter = findViewById(R.id.layoutTemperatureConverter)
        layoutLengthConverter = findViewById(R.id.layoutLengthConverter)
        layoutFrequencyConverter = findViewById(R.id.layoutFrequencyConverter)
        layoutEnergyConverter = findViewById(R.id.layoutEnergyConverter)
        layoutFuelConverter = findViewById(R.id.layoutFuelConverter)
        layoutAreaConverter = findViewById(R.id.layoutAreaConverter)
        layoutTimeConverter = findViewById(R.id.layoutTimeConverter)
        layoutSpeedConverter = findViewById(R.id.layoutSpeedConverter)
        layoutMassConverter = findViewById(R.id.layoutMassConverter)
        layoutCurrentConverter = findViewById(R.id.layoutCurrentConverter)
        layoutPressureConverter = findViewById(R.id.layoutPressureConverter)
        layoutAngleConverter = findViewById(R.id.layoutAngleConverter)

        // --- Inisialisasi UI Konversi Suhu ---
        etInputTemp = findViewById(R.id.etInputTemp)
        btnCelsiusToFahrenheit = findViewById(R.id.btnCelsiusToFahrenheit)
        btnFahrenheitToCelsius = findViewById(R.id.btnFahrenheitToCelsius)
        tvTempResult = findViewById(R.id.tvTempResult)

        // --- Inisialisasi UI Konversi Panjang ---
        etInputLength = findViewById(R.id.etInputLength)
        btnMeterToCm = findViewById(R.id.btnMeterToCm)
        btnCmToMeter = findViewById(R.id.btnCmToMeter)
        tvLengthResult = findViewById(R.id.tvLengthResult)

        // --- Inisialisasi UI Konversi Frekuensi ---
        etInputFreq = findViewById(R.id.etInputFreq)
        btnHzToKHz = findViewById(R.id.btnHzToKHz)
        btnKHzToHz = findViewById(R.id.btnKHzToHz)
        tvFreqResult = findViewById(R.id.tvFreqResult)

        // --- Inisialisasi UI Konversi Energi ---
        etInputEnergy = findViewById(R.id.etInputEnergy)
        btnJoulesToCalories = findViewById(R.id.btnJoulesToCalories)
        btnCaloriesToJoules = findViewById(R.id.btnCaloriesToJoules)
        tvEnergyResult = findViewById(R.id.tvEnergyResult)

        // --- Inisialisasi UI Konversi Bahan Bakar (Fuel) ---
        etInputFuel = findViewById(R.id.etInputFuel)
        btnLitreToGallon = findViewById(R.id.btnLitreToGallon)
        btnGallonToLitre = findViewById(R.id.btnGallonToLitre)
        tvFuelResult = findViewById(R.id.tvFuelResult)

        // --- Inisialisasi UI Konversi Area ---
        etInputArea = findViewById(R.id.etInputArea)
        btnSqMToSqKm = findViewById(R.id.btnSqMToSqKm)
        btnSqKmToSqM = findViewById(R.id.btnSqKmToSqM)
        tvAreaResult = findViewById(R.id.tvAreaResult)

        // --- Inisialisasi UI Konversi Waktu (Time) ---
        etInputTime = findViewById(R.id.etInputTime)
        btnSecToMin = findViewById(R.id.btnSecToMin)
        btnMinToSec = findViewById(R.id.btnMinToSec)
        tvTimeResult = findViewById(R.id.tvTimeResult)

        // --- Inisialisasi UI Konversi Kecepatan (Speed) ---
        etInputSpeed = findViewById(R.id.etInputSpeed)
        btnKmphToMps = findViewById(R.id.btnKmphToMps)
        btnMpsToKmph = findViewById(R.id.btnMpsToKmph)
        tvSpeedResult = findViewById(R.id.tvSpeedResult)

        // --- Inisialisasi UI Konversi Massa ---
        etInputMass = findViewById(R.id.etInputMass)
        btnKgToGram = findViewById(R.id.btnKgToGram)
        btnGramToKg = findViewById(R.id.btnGramToKg)
        tvMassResult = findViewById(R.id.tvMassResult)

        // --- Inisialisasi UI Konversi Arus (Current) ---
        etInputCurrent = findViewById(R.id.etInputCurrent)
        btnAmpereToMilliampere = findViewById(R.id.btnAmpereToMilliampere)
        btnMilliampereToAmpere = findViewById(R.id.btnMilliampereToAmpere)
        tvCurrentResult = findViewById(R.id.tvCurrentResult)

        // --- Inisialisasi UI Konversi Tekanan (Pressure) ---
        etInputPressure = findViewById(R.id.etInputPressure)
        btnPascalToKPa = findViewById(R.id.btnPascalToKPa)
        btnKPaToPascal = findViewById(R.id.btnKPaToPascal)
        tvPressureResult = findViewById(R.id.tvPressureResult)

        // --- Inisialisasi UI Konversi Sudut (Angle) ---
        etInputAngle = findViewById(R.id.etInputAngle)
        btnDegToRad = findViewById(R.id.btnDegToRad)
        btnRadToDeg = findViewById(R.id.btnRadToDeg)
        tvAngleResult = findViewById(R.id.tvAngleResult)


        // --- Listener Tombol Kembali ---
        btnBack.setOnClickListener {
            if (layoutCategorySelection.visibility == View.GONE) {
                showCategorySelection()
            } else {
                onBackPressedDispatcher.onBackPressed()
            }
        }

        // --- Setup Listener untuk Tombol Kategori ---
        setupCategoryButtons()

        // --- Setup Listener untuk Tombol Konversi Spesifik ---
        btnCelsiusToFahrenheit.setOnClickListener { convertTemperature(true) }
        btnFahrenheitToCelsius.setOnClickListener { convertTemperature(false) }

        btnMeterToCm.setOnClickListener { convertLength(true) }
        btnCmToMeter.setOnClickListener { convertLength(false) }

        btnHzToKHz.setOnClickListener { convertFrequency(true) }
        btnKHzToHz.setOnClickListener { convertFrequency(false) }

        btnJoulesToCalories.setOnClickListener { convertEnergy(true) }
        btnCaloriesToJoules.setOnClickListener { convertEnergy(false) }

        btnLitreToGallon.setOnClickListener { convertFuel(true) }
        btnGallonToLitre.setOnClickListener { convertFuel(false) }

        btnSqMToSqKm.setOnClickListener { convertArea(true) }
        btnSqKmToSqM.setOnClickListener { convertArea(false) }

        btnSecToMin.setOnClickListener { convertTime(true) }
        btnMinToSec.setOnClickListener { convertTime(false) }

        btnKmphToMps.setOnClickListener { convertSpeed(true) }
        btnMpsToKmph.setOnClickListener { convertSpeed(false) }

        btnKgToGram.setOnClickListener { convertMass(true) }
        btnGramToKg.setOnClickListener { convertMass(false) }

        btnAmpereToMilliampere.setOnClickListener { convertCurrent(true) }
        btnMilliampereToAmpere.setOnClickListener { convertCurrent(false) }

        btnPascalToKPa.setOnClickListener { convertPressure(true) }
        btnKPaToPascal.setOnClickListener { convertPressure(false) }

        btnDegToRad.setOnClickListener { convertAngle(true) }
        btnRadToDeg.setOnClickListener { convertAngle(false) }


        // Tampilkan layar pemilihan kategori pertama kali saat Activity dibuat
        showCategorySelection()
    }

    private fun setupCategoryButtons() {
        findViewById<LinearLayout>(R.id.btnCategoryFrequency).setOnClickListener { showFrequencyConverter() }
        findViewById<LinearLayout>(R.id.btnCategoryEnergy).setOnClickListener { showEnergyConverter() }
        findViewById<LinearLayout>(R.id.btnCategoryFuel).setOnClickListener { showFuelConverter() }
        findViewById<LinearLayout>(R.id.btnCategoryArea).setOnClickListener { showAreaConverter() }
        findViewById<LinearLayout>(R.id.btnCategoryLength).setOnClickListener { showLengthConverter() }
        findViewById<LinearLayout>(R.id.btnCategoryTime).setOnClickListener { showTimeConverter() }
        findViewById<LinearLayout>(R.id.btnCategorySpeed).setOnClickListener { showSpeedConverter() }
        findViewById<LinearLayout>(R.id.btnCategoryTemperature).setOnClickListener { showTemperatureConverter() }
        findViewById<LinearLayout>(R.id.btnCategoryMass).setOnClickListener { showMassConverter() }
        findViewById<LinearLayout>(R.id.btnCategoryCurrent).setOnClickListener { showCurrentConverter() }
        findViewById<LinearLayout>(R.id.btnCategoryPressure).setOnClickListener { showPressureConverter() }
        findViewById<LinearLayout>(R.id.btnCategoryAngle).setOnClickListener { showAngleConverter() }
    }

    private fun hideAllConverters() {
        layoutTemperatureConverter.visibility = View.GONE
        layoutLengthConverter.visibility = View.GONE
        layoutFrequencyConverter.visibility = View.GONE
        layoutEnergyConverter.visibility = View.GONE
        layoutFuelConverter.visibility = View.GONE
        layoutAreaConverter.visibility = View.GONE
        layoutTimeConverter.visibility = View.GONE
        layoutSpeedConverter.visibility = View.GONE
        layoutMassConverter.visibility = View.GONE
        layoutCurrentConverter.visibility = View.GONE
        layoutPressureConverter.visibility = View.GONE
        layoutAngleConverter.visibility = View.GONE
    }

    private fun showCategorySelection() {
        tvConverterTitle.text = "Unit Converter"
        layoutCategorySelection.visibility = View.VISIBLE
        hideAllConverters()
    }

    private fun showTemperatureConverter() {
        tvConverterTitle.text = "Temperature Converter"
        layoutCategorySelection.visibility = View.GONE
        hideAllConverters()
        layoutTemperatureConverter.visibility = View.VISIBLE
        etInputTemp.setText("")
        tvTempResult.text = "Hasil: -"
    }

    private fun showLengthConverter() {
        tvConverterTitle.text = "Length Converter"
        layoutCategorySelection.visibility = View.GONE
        hideAllConverters()
        layoutLengthConverter.visibility = View.VISIBLE
        etInputLength.setText("")
        tvLengthResult.text = "Hasil: -"
    }

    private fun showFrequencyConverter() {
        tvConverterTitle.text = "Frequency Converter"
        layoutCategorySelection.visibility = View.GONE
        hideAllConverters()
        layoutFrequencyConverter.visibility = View.VISIBLE
        etInputFreq.setText("")
        tvFreqResult.text = "Hasil: -"
    }

    private fun showEnergyConverter() {
        tvConverterTitle.text = "Energy Converter"
        layoutCategorySelection.visibility = View.GONE
        hideAllConverters()
        layoutEnergyConverter.visibility = View.VISIBLE
        etInputEnergy.setText("")
        tvEnergyResult.text = "Hasil: -"
    }

    private fun showFuelConverter() {
        tvConverterTitle.text = "Fuel Converter"
        layoutCategorySelection.visibility = View.GONE
        hideAllConverters()
        layoutFuelConverter.visibility = View.VISIBLE
        etInputFuel.setText("")
        tvFuelResult.text = "Hasil: -"
    }

    private fun showAreaConverter() {
        tvConverterTitle.text = "Area Converter"
        layoutCategorySelection.visibility = View.GONE
        hideAllConverters()
        layoutAreaConverter.visibility = View.VISIBLE
        etInputArea.setText("")
        tvAreaResult.text = "Hasil: -"
    }

    private fun showTimeConverter() {
        tvConverterTitle.text = "Time Converter"
        layoutCategorySelection.visibility = View.GONE
        hideAllConverters()
        layoutTimeConverter.visibility = View.VISIBLE
        etInputTime.setText("")
        tvTimeResult.text = "Hasil: -"
    }

    private fun showSpeedConverter() {
        tvConverterTitle.text = "Speed Converter"
        layoutCategorySelection.visibility = View.GONE
        hideAllConverters()
        layoutSpeedConverter.visibility = View.VISIBLE
        etInputSpeed.setText("")
        tvSpeedResult.text = "Hasil: -"
    }

    private fun showMassConverter() {
        tvConverterTitle.text = "Mass Converter"
        layoutCategorySelection.visibility = View.GONE
        hideAllConverters()
        layoutMassConverter.visibility = View.VISIBLE
        etInputMass.setText("")
        tvMassResult.text = "Hasil: -"
    }

    private fun showCurrentConverter() {
        tvConverterTitle.text = "Current Converter"
        layoutCategorySelection.visibility = View.GONE
        hideAllConverters()
        layoutCurrentConverter.visibility = View.VISIBLE
        etInputCurrent.setText("")
        tvCurrentResult.text = "Hasil: -"
    }

    private fun showPressureConverter() {
        tvConverterTitle.text = "Pressure Converter"
        layoutCategorySelection.visibility = View.GONE
        hideAllConverters()
        layoutPressureConverter.visibility = View.VISIBLE
        etInputPressure.setText("")
        tvPressureResult.text = "Hasil: -"
    }

    private fun showAngleConverter() {
        tvConverterTitle.text = "Angle Converter"
        layoutCategorySelection.visibility = View.GONE
        hideAllConverters()
        layoutAngleConverter.visibility = View.VISIBLE
        etInputAngle.setText("")
        tvAngleResult.text = "Hasil: -"
    }

    // --- Fungsi Konversi ---
    private fun convertTemperature(isCToF: Boolean) {
        val inputText = etInputTemp.text.toString()
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai suhu", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            val inputValue = inputText.toDouble()
            val result: Double
            val resultText: String
            if (isCToF) {
                result = (inputValue * 9 / 5) + 32
                resultText = String.format("%.2f °F", result)
            } else {
                result = (inputValue - 32) * 5 / 9
                resultText = String.format("%.2f °C", result)
            }
            tvTempResult.text = resultText
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Input tidak valid. Masukkan angka.", Toast.LENGTH_SHORT).show()
            tvTempResult.text = "Error"
        }
    }

    private fun convertLength(isMToCm: Boolean) {
        val inputText = etInputLength.text.toString()
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai panjang", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            val inputValue = inputText.toDouble()
            val result: Double
            val resultText: String
            if (isMToCm) {
                result = inputValue * 100 // Meter ke Sentimeter
                resultText = String.format("%.2f cm", result)
            } else {
                result = inputValue / 100 // Sentimeter ke Meter
                resultText = String.format("%.2f m", result)
            }
            tvLengthResult.text = resultText
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Input tidak valid. Masukkan angka.", Toast.LENGTH_SHORT).show()
            tvLengthResult.text = "Error"
        }
    }

    private fun convertFrequency(isHzToKHz: Boolean) {
        val inputText = etInputFreq.text.toString()
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai frekuensi", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            val inputValue = inputText.toDouble()
            val result: Double
            val resultText: String
            if (isHzToKHz) {
                result = inputValue / 1000 // Hz ke KHz
                resultText = String.format("%.2f KHz", result)
            } else {
                result = inputValue * 1000 // KHz ke Hz
                resultText = String.format("%.2f Hz", result)
            }
            tvFreqResult.text = resultText
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Input tidak valid. Masukkan angka.", Toast.LENGTH_SHORT).show()
            tvFreqResult.text = "Error"
        }
    }

    private fun convertEnergy(isJoulesToCalories: Boolean) {
        val inputText = etInputEnergy.text.toString()
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai energi", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            val inputValue = inputText.toDouble()
            val result: Double
            val resultText: String
            if (isJoulesToCalories) {
                result = inputValue * 0.239006 // Joule ke Kalori
                resultText = String.format("%.2f cal", result)
            } else {
                result = inputValue * 4.184 // Kalori ke Joule
                resultText = String.format("%.2f J", result)
            }
            tvEnergyResult.text = resultText
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Input tidak valid. Masukkan angka.", Toast.LENGTH_SHORT).show()
            tvEnergyResult.text = "Error"
        }
    }

    private fun convertFuel(isLitreToGallon: Boolean) {
        val inputText = etInputFuel.text.toString()
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai bahan bakar", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            val inputValue = inputText.toDouble()
            val result: Double
            val resultText: String
            if (isLitreToGallon) {
                result = inputValue * 0.264172 // Litre ke Gallon (US liquid)
                resultText = String.format("%.2f gal", result)
            } else {
                result = inputValue * 3.78541 // Gallon (US liquid) ke Litre
                resultText = String.format("%.2f L", result)
            }
            tvFuelResult.text = resultText
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Input tidak valid. Masukkan angka.", Toast.LENGTH_SHORT).show()
            tvFuelResult.text = "Error"
        }
    }

    private fun convertArea(isSqMToSqKm: Boolean) {
        val inputText = etInputArea.text.toString()
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai area", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            val inputValue = inputText.toDouble()
            val result: Double
            val resultText: String
            if (isSqMToSqKm) {
                result = inputValue / 1_000_000 // Meter persegi ke Kilometer persegi
                resultText = String.format("%.6f km²", result)
            } else {
                result = inputValue * 1_000_000 // Kilometer persegi ke Meter persegi
                resultText = String.format("%.2f m²", result)
            }
            tvAreaResult.text = resultText
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Input tidak valid. Masukkan angka.", Toast.LENGTH_SHORT).show()
            tvAreaResult.text = "Error"
        }
    }

    private fun convertTime(isSecToMin: Boolean) {
        val inputText = etInputTime.text.toString()
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai waktu", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            val inputValue = inputText.toDouble()
            val result: Double
            val resultText: String
            if (isSecToMin) {
                result = inputValue / 60 // Detik ke Menit
                resultText = String.format("%.2f min", result)
            } else {
                result = inputValue * 60 // Menit ke Detik
                resultText = String.format("%.2f sec", result)
            }
            tvTimeResult.text = resultText
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Input tidak valid. Masukkan angka.", Toast.LENGTH_SHORT).show()
            tvTimeResult.text = "Error"
        }
    }

    private fun convertSpeed(isKmphToMps: Boolean) {
        val inputText = etInputSpeed.text.toString()
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai kecepatan", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            val inputValue = inputText.toDouble()
            val result: Double
            val resultText: String
            if (isKmphToMps) {
                result = inputValue * (1000.0 / 3600.0) // km/h ke m/s
                resultText = String.format("%.2f m/s", result)
            } else {
                result = inputValue * (3600.0 / 1000.0) // m/s ke km/h
                resultText = String.format("%.2f km/h", result)
            }
            tvSpeedResult.text = resultText
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Input tidak valid. Masukkan angka.", Toast.LENGTH_SHORT).show()
            tvSpeedResult.text = "Error"
        }
    }

    private fun convertMass(isKgToGram: Boolean) {
        val inputText = etInputMass.text.toString()
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai massa", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            val inputValue = inputText.toDouble()
            val result: Double
            val resultText: String
            if (isKgToGram) {
                result = inputValue * 1000 // Kilogram ke Gram
                resultText = String.format("%.2f g", result)
            } else {
                result = inputValue / 1000 // Gram ke Kilogram
                resultText = String.format("%.2f kg", result)
            }
            tvMassResult.text = resultText
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Input tidak valid. Masukkan angka.", Toast.LENGTH_SHORT).show()
            tvMassResult.text = "Error"
        }
    }

    private fun convertCurrent(isAmpereToMilliampere: Boolean) {
        val inputText = etInputCurrent.text.toString()
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai arus", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            val inputValue = inputText.toDouble()
            val result: Double
            val resultText: String
            if (isAmpereToMilliampere) {
                result = inputValue * 1000 // Ampere ke Milliampere
                resultText = String.format("%.2f mA", result)
            } else {
                result = inputValue / 1000 // Milliampere ke Ampere
                resultText = String.format("%.2f A", result)
            }
            tvCurrentResult.text = resultText
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Input tidak valid. Masukkan angka.", Toast.LENGTH_SHORT).show()
            tvCurrentResult.text = "Error"
        }
    }

    private fun convertPressure(isPascalToKPa: Boolean) {
        val inputText = etInputPressure.text.toString()
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai tekanan", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            val inputValue = inputText.toDouble()
            val result: Double
            val resultText: String
            if (isPascalToKPa) {
                result = inputValue / 1000 // Pascal ke KiloPascal
                resultText = String.format("%.2f kPa", result)
            } else {
                result = inputValue * 1000 // KiloPascal ke Pascal
                resultText = String.format("%.2f Pa", result)
            }
            tvPressureResult.text = resultText
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Input tidak valid. Masukkan angka.", Toast.LENGTH_SHORT).show()
            tvPressureResult.text = "Error"
        }
    }

    private fun convertAngle(isDegToRad: Boolean) {
        val inputText = etInputAngle.text.toString()
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai sudut", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            val inputValue = inputText.toDouble()
            val result: Double
            val resultText: String
            if (isDegToRad) {
                result = Math.toRadians(inputValue) // Derajat ke Radian
                resultText = String.format("%.2f rad", result)
            } else {
                result = Math.toDegrees(inputValue) // Radian ke Derajat
                resultText = String.format("%.2f °", result)
            }
            tvAngleResult.text = resultText
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Input tidak valid. Masukkan angka.", Toast.LENGTH_SHORT).show()
            tvAngleResult.text = "Error"
        }
    }
}