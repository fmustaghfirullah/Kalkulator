package com.ghfir.percobaan

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner

class ConverterActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageButton
    private lateinit var tvConverterTitle: TextView
    private lateinit var layoutCategorySelection: LinearLayout

    private lateinit var btnCategoryFrequency: LinearLayout
    private lateinit var btnCategoryEnergy: LinearLayout
    private lateinit var btnCategoryFuel: LinearLayout
    private lateinit var btnCategoryArea: LinearLayout
    private lateinit var btnCategoryLength: LinearLayout
    private lateinit var btnCategoryTime: LinearLayout
    private lateinit var btnCategorySpeed: LinearLayout
    private lateinit var btnCategoryTemperature: LinearLayout
    private lateinit var btnCategoryMass: LinearLayout
    private lateinit var btnCategoryCurrent: LinearLayout
    private lateinit var btnCategoryPressure: LinearLayout
    private lateinit var btnCategoryAngle: LinearLayout

    private lateinit var layoutFrequencyConverter: LinearLayout
    private lateinit var etInputFreq: EditText
    private lateinit var spinnerFromFreq: AppCompatSpinner
    private lateinit var spinnerToFreq: AppCompatSpinner
    private lateinit var btnConvertFreq: Button
    private lateinit var tvFreqResult: TextView

    private lateinit var layoutEnergyConverter: LinearLayout
    private lateinit var etInputEnergy: EditText
    private lateinit var spinnerFromEnergy: AppCompatSpinner
    private lateinit var spinnerToEnergy: AppCompatSpinner
    private lateinit var btnConvertEnergy: Button
    private lateinit var tvEnergyResult: TextView

    private lateinit var layoutFuelConverter: LinearLayout
    private lateinit var etInputFuel: EditText
    private lateinit var spinnerFromFuel: AppCompatSpinner
    private lateinit var spinnerToFuel: AppCompatSpinner
    private lateinit var btnConvertFuel: Button
    private lateinit var tvFuelResult: TextView

    private lateinit var layoutAreaConverter: LinearLayout
    private lateinit var etInputArea: EditText
    private lateinit var spinnerFromArea: AppCompatSpinner
    private lateinit var spinnerToArea: AppCompatSpinner
    private lateinit var btnConvertArea: Button
    private lateinit var tvAreaResult: TextView

    private lateinit var layoutLengthConverter: LinearLayout
    private lateinit var etInputLength: EditText
    private lateinit var spinnerFromLength: AppCompatSpinner
    private lateinit var spinnerToLength: AppCompatSpinner
    private lateinit var btnConvertLength: Button
    private lateinit var tvLengthResult: TextView

    private lateinit var layoutTimeConverter: LinearLayout
    private lateinit var etInputTime: EditText
    private lateinit var spinnerFromTime: AppCompatSpinner
    private lateinit var spinnerToTime: AppCompatSpinner
    private lateinit var btnConvertTime: Button
    private lateinit var tvTimeResult: TextView

    private lateinit var layoutSpeedConverter: LinearLayout
    private lateinit var etInputSpeed: EditText
    private lateinit var spinnerFromSpeed: AppCompatSpinner
    private lateinit var spinnerToSpeed: AppCompatSpinner
    private lateinit var btnConvertSpeed: Button
    private lateinit var tvSpeedResult: TextView

    private lateinit var layoutTemperatureConverter: LinearLayout
    private lateinit var etInputTemp: EditText
    private lateinit var spinnerFromTemp: AppCompatSpinner
    private lateinit var spinnerToTemp: AppCompatSpinner
    private lateinit var btnConvertTemp: Button
    private lateinit var tvTempResult: TextView

    private lateinit var layoutMassConverter: LinearLayout
    private lateinit var etInputMass: EditText
    private lateinit var spinnerFromMass: AppCompatSpinner
    private lateinit var spinnerToMass: AppCompatSpinner
    private lateinit var btnConvertMass: Button
    private lateinit var tvMassResult: TextView

    private lateinit var layoutCurrentConverter: LinearLayout
    private lateinit var etInputCurrent: EditText
    private lateinit var spinnerFromCurrent: AppCompatSpinner
    private lateinit var spinnerToCurrent: AppCompatSpinner
    private lateinit var btnConvertCurrent: Button
    private lateinit var tvCurrentResult: TextView

    private lateinit var layoutPressureConverter: LinearLayout
    private lateinit var etInputPressure: EditText
    private lateinit var spinnerFromPressure: AppCompatSpinner
    private lateinit var spinnerToPressure: AppCompatSpinner
    private lateinit var btnConvertPressure: Button
    private lateinit var tvPressureResult: TextView

    private lateinit var layoutAngleConverter: LinearLayout
    private lateinit var etInputAngle: EditText
    private lateinit var spinnerFromAngle: AppCompatSpinner
    private lateinit var spinnerToAngle: AppCompatSpinner
    private lateinit var btnConvertAngle: Button
    private lateinit var tvAngleResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        btnBack = findViewById(R.id.btnBack)
        tvConverterTitle = findViewById(R.id.tvConverterTitle)
        layoutCategorySelection = findViewById(R.id.layoutCategorySelection)

        btnCategoryFrequency = findViewById(R.id.btnCategoryFrequency)
        btnCategoryEnergy = findViewById(R.id.btnCategoryEnergy)
        btnCategoryFuel = findViewById(R.id.btnCategoryFuel)
        btnCategoryArea = findViewById(R.id.btnCategoryArea)
        btnCategoryLength = findViewById(R.id.btnCategoryLength)
        btnCategoryTime = findViewById(R.id.btnCategoryTime)
        btnCategorySpeed = findViewById(R.id.btnCategorySpeed)
        btnCategoryTemperature = findViewById(R.id.btnCategoryTemperature)
        btnCategoryMass = findViewById(R.id.btnCategoryMass)
        btnCategoryCurrent = findViewById(R.id.btnCategoryCurrent)
        btnCategoryPressure = findViewById(R.id.btnCategoryPressure)
        btnCategoryAngle = findViewById(R.id.btnCategoryAngle)

        layoutFrequencyConverter = findViewById(R.id.layoutFrequencyConverter)
        etInputFreq = findViewById(R.id.etInputFreq)
        spinnerFromFreq = findViewById(R.id.spinnerFromFreq)
        spinnerToFreq = findViewById(R.id.spinnerToFreq)
        btnConvertFreq = findViewById(R.id.btnConvertFreq)
        tvFreqResult = findViewById(R.id.tvFreqResult)

        layoutEnergyConverter = findViewById(R.id.layoutEnergyConverter)
        etInputEnergy = findViewById(R.id.etInputEnergy)
        spinnerFromEnergy = findViewById(R.id.spinnerFromEnergy)
        spinnerToEnergy = findViewById(R.id.spinnerToEnergy)
        btnConvertEnergy = findViewById(R.id.btnConvertEnergy)
        tvEnergyResult = findViewById(R.id.tvEnergyResult)

        layoutFuelConverter = findViewById(R.id.layoutFuelConverter)
        etInputFuel = findViewById(R.id.etInputFuel)
        spinnerFromFuel = findViewById(R.id.spinnerFromFuel)
        spinnerToFuel = findViewById(R.id.spinnerToFuel)
        btnConvertFuel = findViewById(R.id.btnConvertFuel)
        tvFuelResult = findViewById(R.id.tvFuelResult)

        layoutAreaConverter = findViewById(R.id.layoutAreaConverter)
        etInputArea = findViewById(R.id.etInputArea)
        spinnerFromArea = findViewById(R.id.spinnerFromArea)
        spinnerToArea = findViewById(R.id.spinnerToArea)
        btnConvertArea = findViewById(R.id.btnConvertArea)
        tvAreaResult = findViewById(R.id.tvAreaResult)

        layoutLengthConverter = findViewById(R.id.layoutLengthConverter)
        etInputLength = findViewById(R.id.etInputLength)
        spinnerFromLength = findViewById(R.id.spinnerFromLength)
        spinnerToLength = findViewById(R.id.spinnerToLength)
        btnConvertLength = findViewById(R.id.btnConvertLength)
        tvLengthResult = findViewById(R.id.tvLengthResult)

        layoutTimeConverter = findViewById(R.id.layoutTimeConverter)
        etInputTime = findViewById(R.id.etInputTime)
        spinnerFromTime = findViewById(R.id.spinnerFromTime)
        spinnerToTime = findViewById(R.id.spinnerToTime)
        btnConvertTime = findViewById(R.id.btnConvertTime)
        tvTimeResult = findViewById(R.id.tvTimeResult)

        layoutSpeedConverter = findViewById(R.id.layoutSpeedConverter)
        etInputSpeed = findViewById(R.id.etInputSpeed)
        spinnerFromSpeed = findViewById(R.id.spinnerFromSpeed)
        spinnerToSpeed = findViewById(R.id.spinnerToSpeed)
        btnConvertSpeed = findViewById(R.id.btnConvertSpeed)
        tvSpeedResult = findViewById(R.id.tvSpeedResult)

        layoutTemperatureConverter = findViewById(R.id.layoutTemperatureConverter)
        etInputTemp = findViewById(R.id.etInputTemp)
        spinnerFromTemp = findViewById(R.id.spinnerFromTemp)
        spinnerToTemp = findViewById(R.id.spinnerToTemp)
        btnConvertTemp = findViewById(R.id.btnConvertTemp)
        tvTempResult = findViewById(R.id.tvTempResult)

        layoutMassConverter = findViewById(R.id.layoutMassConverter)
        etInputMass = findViewById(R.id.etInputMass)
        spinnerFromMass = findViewById(R.id.spinnerFromMass)
        spinnerToMass = findViewById(R.id.spinnerToMass)
        btnConvertMass = findViewById(R.id.btnConvertMass)
        tvMassResult = findViewById(R.id.tvMassResult)

        layoutCurrentConverter = findViewById(R.id.layoutCurrentConverter)
        etInputCurrent = findViewById(R.id.etInputCurrent)
        spinnerFromCurrent = findViewById(R.id.spinnerFromCurrent)
        spinnerToCurrent = findViewById(R.id.spinnerToCurrent)
        btnConvertCurrent = findViewById(R.id.btnConvertCurrent)
        tvCurrentResult = findViewById(R.id.tvCurrentResult)

        layoutPressureConverter = findViewById(R.id.layoutPressureConverter)
        etInputPressure = findViewById(R.id.etInputPressure)
        spinnerFromPressure = findViewById(R.id.spinnerFromPressure)
        spinnerToPressure = findViewById(R.id.spinnerToPressure)
        btnConvertPressure = findViewById(R.id.btnConvertPressure)
        tvPressureResult = findViewById(R.id.tvPressureResult)

        layoutAngleConverter = findViewById(R.id.layoutAngleConverter)
        etInputAngle = findViewById(R.id.etInputAngle)
        spinnerFromAngle = findViewById(R.id.spinnerFromAngle)
        spinnerToAngle = findViewById(R.id.spinnerToAngle)
        btnConvertAngle = findViewById(R.id.btnConvertAngle)
        tvAngleResult = findViewById(R.id.tvAngleResult)

        setupSpinners()
        setupListeners()
    }

    private fun setupSpinners() {
        val temperatureUnits = arrayOf("Celsius", "Fahrenheit", "Kelvin")
        val lengthUnits = arrayOf("Meter", "Kilometer", "Centimeter", "Milimeter", "Inch", "Foot", "Yard", "Mile")
        val frequencyUnits = arrayOf("Hertz", "Kilohertz", "Megahertz", "Gigahertz")
        val energyUnits = arrayOf("Joule", "Kilojoule", "Kalori", "Kilokalori", "Wh", "kWh")
        val fuelUnits = arrayOf("Liter", "Mililiter", "Gallon (US)", "Gallon (UK)")
        val areaUnits = arrayOf("Meter persegi", "Kilometer persegi", "Centimeter persegi", "Hektar", "Are", "Acre")
        val timeUnits = arrayOf("Detik", "Menit", "Jam", "Hari", "Minggu", "Bulan", "Tahun")
        val speedUnits = arrayOf("Meter/detik", "Kilometer/jam", "Mil/jam", "Knot", "Mach")
        val massUnits = arrayOf("Gram", "Kilogram", "Miligram", "Ton", "Pound", "Ounce")
        val currentUnits = arrayOf("Ampere", "Miliampere", "Kiloampere")
        val pressureUnits = arrayOf("Pascal", "Kilopascal", "Megapascal", "Bar", "Atmosphere", "PSI")
        val angleUnits = arrayOf("Derajat", "Radian", "Gradian")

        setupSpinner(spinnerFromTemp, spinnerToTemp, temperatureUnits)
        setupSpinner(spinnerFromLength, spinnerToLength, lengthUnits)
        setupSpinner(spinnerFromFreq, spinnerToFreq, frequencyUnits)
        setupSpinner(spinnerFromEnergy, spinnerToEnergy, energyUnits)
        setupSpinner(spinnerFromFuel, spinnerToFuel, fuelUnits)
        setupSpinner(spinnerFromArea, spinnerToArea, areaUnits)
        setupSpinner(spinnerFromLength, spinnerToLength, lengthUnits)
        setupSpinner(spinnerFromTime, spinnerToTime, timeUnits)
        setupSpinner(spinnerFromSpeed, spinnerToSpeed, speedUnits)
        setupSpinner(spinnerFromMass, spinnerToMass, massUnits)
        setupSpinner(spinnerFromCurrent, spinnerToCurrent, currentUnits)
        setupSpinner(spinnerFromPressure, spinnerToPressure, pressureUnits)
        setupSpinner(spinnerFromAngle, spinnerToAngle, angleUnits)
    }

    private fun setupSpinner(spinnerFrom: AppCompatSpinner, spinnerTo: AppCompatSpinner, units: Array<String>) {
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item_custom, units)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item_custom)
        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter
    }

    private fun setupListeners() {
        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        btnCategoryFrequency.setOnClickListener { showConverterLayout(layoutFrequencyConverter, "Frequency Converter") }
        btnCategoryEnergy.setOnClickListener { showConverterLayout(layoutEnergyConverter, "Energy Converter") }
        btnCategoryFuel.setOnClickListener { showConverterLayout(layoutFuelConverter, "Fuel Converter") }
        btnCategoryArea.setOnClickListener { showConverterLayout(layoutAreaConverter, "Area Converter") }
        btnCategoryLength.setOnClickListener { showConverterLayout(layoutLengthConverter, "Length Converter") }
        btnCategoryTime.setOnClickListener { showConverterLayout(layoutTimeConverter, "Time Converter") }
        btnCategorySpeed.setOnClickListener { showConverterLayout(layoutSpeedConverter, "Speed Converter") }
        btnCategoryTemperature.setOnClickListener { showConverterLayout(layoutTemperatureConverter, "Temperature Converter") }
        btnCategoryMass.setOnClickListener { showConverterLayout(layoutMassConverter, "Mass Converter") }
        btnCategoryCurrent.setOnClickListener { showConverterLayout(layoutCurrentConverter, "Current Converter") }
        btnCategoryPressure.setOnClickListener { showConverterLayout(layoutPressureConverter, "Pressure Converter") }
        btnCategoryAngle.setOnClickListener { showConverterLayout(layoutAngleConverter, "Angle Converter") }

        btnConvertFreq.setOnClickListener { convertFrequency() }
        btnConvertEnergy.setOnClickListener { convertEnergy() }
        btnConvertFuel.setOnClickListener { convertFuel() }
        btnConvertArea.setOnClickListener { convertArea() }
        btnConvertLength.setOnClickListener { convertLength() }
        btnConvertTime.setOnClickListener { convertTime() }
        btnConvertSpeed.setOnClickListener { convertSpeed() }
        btnConvertTemp.setOnClickListener { convertTemperature() }
        btnConvertMass.setOnClickListener { convertMass() }
        btnConvertCurrent.setOnClickListener { convertCurrent() }
        btnConvertPressure.setOnClickListener { convertPressure() }
        btnConvertAngle.setOnClickListener { convertAngle() }

        setupInputAndSpinnerListeners(etInputFreq, spinnerFromFreq, spinnerToFreq) { convertFrequency() }
        setupInputAndSpinnerListeners(etInputEnergy, spinnerFromEnergy, spinnerToEnergy) { convertEnergy() }
        setupInputAndSpinnerListeners(etInputFuel, spinnerFromFuel, spinnerToFuel) { convertFuel() }
        setupInputAndSpinnerListeners(etInputArea, spinnerFromArea, spinnerToArea) { convertArea() }
        setupInputAndSpinnerListeners(etInputLength, spinnerFromLength, spinnerToLength) { convertLength() }
        setupInputAndSpinnerListeners(etInputTime, spinnerFromTime, spinnerToTime) { convertTime() }
        setupInputAndSpinnerListeners(etInputSpeed, spinnerFromSpeed, spinnerToSpeed) { convertSpeed() }
        setupInputAndSpinnerListeners(etInputTemp, spinnerFromTemp, spinnerToTemp) { convertTemperature() }
        setupInputAndSpinnerListeners(etInputMass, spinnerFromMass, spinnerToMass) { convertMass() }
        setupInputAndSpinnerListeners(etInputCurrent, spinnerFromCurrent, spinnerToCurrent) { convertCurrent() }
        setupInputAndSpinnerListeners(etInputPressure, spinnerFromPressure, spinnerToPressure) { convertPressure() }
        setupInputAndSpinnerListeners(etInputAngle, spinnerFromAngle, spinnerToAngle) { convertAngle() }
    }

    private fun setupInputAndSpinnerListeners(editText: EditText, spinnerFrom: AppCompatSpinner, spinnerTo: AppCompatSpinner, convertAction: () -> Unit) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                convertAction()
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        val itemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                convertAction()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinnerFrom.onItemSelectedListener = itemSelectedListener
        spinnerTo.onItemSelectedListener = itemSelectedListener
    }

    private fun showConverterLayout(layoutToShow: LinearLayout, title: String) {
        layoutCategorySelection.visibility = View.GONE
        layoutFrequencyConverter.visibility = View.GONE
        layoutEnergyConverter.visibility = View.GONE
        layoutFuelConverter.visibility = View.GONE
        layoutAreaConverter.visibility = View.GONE
        layoutLengthConverter.visibility = View.GONE
        layoutTimeConverter.visibility = View.GONE
        layoutSpeedConverter.visibility = View.GONE
        layoutTemperatureConverter.visibility = View.GONE
        layoutMassConverter.visibility = View.GONE
        layoutCurrentConverter.visibility = View.GONE
        layoutPressureConverter.visibility = View.GONE
        layoutAngleConverter.visibility = View.GONE

        layoutToShow.visibility = View.VISIBLE
        tvConverterTitle.text = title

        when (layoutToShow.id) {
            R.id.layoutFrequencyConverter -> convertFrequency()
            R.id.layoutEnergyConverter -> convertEnergy()
            R.id.layoutFuelConverter -> convertFuel()
            R.id.layoutAreaConverter -> convertArea()
            R.id.layoutLengthConverter -> convertLength()
            R.id.layoutTimeConverter -> convertTime()
            R.id.layoutSpeedConverter -> convertSpeed()
            R.id.layoutTemperatureConverter -> convertTemperature()
            R.id.layoutMassConverter -> convertMass()
            R.id.layoutCurrentConverter -> convertCurrent()
            R.id.layoutPressureConverter -> convertPressure()
            R.id.layoutAngleConverter -> convertAngle()
        }
    }

    override fun onBackPressed() {
        if (layoutCategorySelection.visibility == View.GONE) {
            layoutCategorySelection.visibility = View.VISIBLE
            layoutFrequencyConverter.visibility = View.GONE
            layoutEnergyConverter.visibility = View.GONE
            layoutFuelConverter.visibility = View.GONE
            layoutAreaConverter.visibility = View.GONE
            layoutLengthConverter.visibility = View.GONE
            layoutTimeConverter.visibility = View.GONE
            layoutSpeedConverter.visibility = View.GONE
            layoutTemperatureConverter.visibility = View.GONE
            layoutMassConverter.visibility = View.GONE
            layoutCurrentConverter.visibility = View.GONE
            layoutPressureConverter.visibility = View.GONE
            layoutAngleConverter.visibility = View.GONE
            tvConverterTitle.text = "Unit Converter"
        } else {
            super.onBackPressed()
        }
    }

    private fun convertFrequency() {
        val inputValue = etInputFreq.text.toString().toDoubleOrNull()
        if (inputValue == null) {
            tvFreqResult.text = "Hasil: -"
            return
        }
        val fromUnit = spinnerFromFreq.selectedItem.toString()
        val toUnit = spinnerToFreq.selectedItem.toString()
        val result = performFrequencyConversion(inputValue, fromUnit, toUnit)
        tvFreqResult.text = "Hasil: %.4f".format(result)
    }

    private fun performFrequencyConversion(value: Double, fromUnit: String, toUnit: String): Double {
        var baseValue = value
        when (fromUnit) {
            "Hertz" -> {}
            "Kilohertz" -> baseValue *= 1000.0
            "Megahertz" -> baseValue *= 1_000_000.0
            "Gigahertz" -> baseValue *= 1_000_000_000.0
        }

        return when (toUnit) {
            "Hertz" -> baseValue
            "Kilohertz" -> baseValue / 1000.0
            "Megahertz" -> baseValue / 1_000_000.0
            "Gigahertz" -> baseValue / 1_000_000_000.0
            else -> 0.0
        }
    }

    private fun convertEnergy() {
        val inputValue = etInputEnergy.text.toString().toDoubleOrNull()
        if (inputValue == null) {
            tvEnergyResult.text = "Hasil: -"
            return
        }
        val fromUnit = spinnerFromEnergy.selectedItem.toString()
        val toUnit = spinnerToEnergy.selectedItem.toString()
        val result = performEnergyConversion(inputValue, fromUnit, toUnit)
        tvEnergyResult.text = "Hasil: %.4f".format(result)
    }

    private fun performEnergyConversion(value: Double, fromUnit: String, toUnit: String): Double {
        var baseValue = value
        when (fromUnit) {
            "Joule" -> {}
            "Kilojoule" -> baseValue *= 1000.0
            "Kalori" -> baseValue *= 4.184
            "Kilokalori" -> baseValue *= 4184.0
            "Wh" -> baseValue *= 3600.0
            "kWh" -> baseValue *= 3_600_000.0
        }

        return when (toUnit) {
            "Joule" -> baseValue
            "Kilojoule" -> baseValue / 1000.0
            "Kalori" -> baseValue / 4.184
            "Kilokalori" -> baseValue / 4184.0
            "Wh" -> baseValue / 3600.0
            "kWh" -> baseValue / 3_600_000.0
            else -> 0.0
        }
    }

    private fun convertFuel() {
        val inputValue = etInputFuel.text.toString().toDoubleOrNull()
        if (inputValue == null) {
            tvFuelResult.text = "Hasil: -"
            return
        }
        val fromUnit = spinnerFromFuel.selectedItem.toString()
        val toUnit = spinnerToFuel.selectedItem.toString()
        val result = performFuelConversion(inputValue, fromUnit, toUnit)
        tvFuelResult.text = "Hasil: %.4f".format(result)
    }

    private fun performFuelConversion(value: Double, fromUnit: String, toUnit: String): Double {
        var baseValue = value
        when (fromUnit) {
            "Liter" -> {}
            "Mililiter" -> baseValue /= 1000.0
            "Gallon (US)" -> baseValue *= 3.78541
            "Gallon (UK)" -> baseValue *= 4.54609
        }

        return when (toUnit) {
            "Liter" -> baseValue
            "Mililiter" -> baseValue * 1000.0
            "Gallon (US)" -> baseValue / 3.78541
            "Gallon (UK)" -> baseValue / 4.54609
            else -> 0.0
        }
    }

    private fun convertArea() {
        val inputValue = etInputArea.text.toString().toDoubleOrNull()
        if (inputValue == null) {
            tvAreaResult.text = "Hasil: -"
            return
        }
        val fromUnit = spinnerFromArea.selectedItem.toString()
        val toUnit = spinnerToArea.selectedItem.toString()
        val result = performAreaConversion(inputValue, fromUnit, toUnit)
        tvAreaResult.text = "Hasil: %.4f".format(result)
    }

    private fun performAreaConversion(value: Double, fromUnit: String, toUnit: String): Double {
        var baseValue = value
        when (fromUnit) {
            "Meter persegi" -> {}
            "Kilometer persegi" -> baseValue *= 1_000_000.0
            "Centimeter persegi" -> baseValue /= 10_000.0
            "Hektar" -> baseValue *= 10_000.0
            "Are" -> baseValue *= 100.0
            "Acre" -> baseValue *= 4046.86
        }

        return when (toUnit) {
            "Meter persegi" -> baseValue
            "Kilometer persegi" -> baseValue / 1_000_000.0
            "Centimeter persegi" -> baseValue * 10_000.0
            "Hektar" -> baseValue / 10_000.0
            "Are" -> baseValue / 100.0
            "Acre" -> baseValue / 4046.86
            else -> 0.0
        }
    }

    private fun convertLength() {
        val inputValue = etInputLength.text.toString().toDoubleOrNull()
        if (inputValue == null) {
            tvLengthResult.text = "Hasil: -"
            return
        }
        val fromUnit = spinnerFromLength.selectedItem.toString()
        val toUnit = spinnerToLength.selectedItem.toString()
        val result = performLengthConversion(inputValue, fromUnit, toUnit)
        tvLengthResult.text = "Hasil: %.4f".format(result)
    }

    private fun performLengthConversion(value: Double, fromUnit: String, toUnit: String): Double {
        var baseValue = value
        when (fromUnit) {
            "Meter" -> {}
            "Kilometer" -> baseValue *= 1000.0
            "Centimeter" -> baseValue /= 100.0
            "Milimeter" -> baseValue /= 1000.0
            "Inch" -> baseValue *= 0.0254
            "Foot" -> baseValue *= 0.3048
            "Yard" -> baseValue *= 0.9144
            "Mile" -> baseValue *= 1609.34
        }

        return when (toUnit) {
            "Meter" -> baseValue
            "Kilometer" -> baseValue / 1000.0
            "Centimeter" -> baseValue * 100.0
            "Milimeter" -> baseValue * 1000.0
            "Inch" -> baseValue / 0.0254
            "Foot" -> baseValue / 0.3048
            "Yard" -> baseValue / 0.9144
            "Mile" -> baseValue / 1609.34
            else -> 0.0
        }
    }

    private fun convertTime() {
        val inputValue = etInputTime.text.toString().toDoubleOrNull()
        if (inputValue == null) {
            tvTimeResult.text = "Hasil: -"
            return
        }
        val fromUnit = spinnerFromTime.selectedItem.toString()
        val toUnit = spinnerToTime.selectedItem.toString()
        val result = performTimeConversion(inputValue, fromUnit, toUnit)
        tvTimeResult.text = "Hasil: %.4f".format(result)
    }

    private fun performTimeConversion(value: Double, fromUnit: String, toUnit: String): Double {
        var baseValue = value
        when (fromUnit) {
            "Detik" -> {}
            "Menit" -> baseValue *= 60.0
            "Jam" -> baseValue *= 3600.0
            "Hari" -> baseValue *= 86400.0
            "Minggu" -> baseValue *= 604800.0
            "Bulan" -> baseValue *= 2592000.0
            "Tahun" -> baseValue *= 31536000.0
        }

        return when (toUnit) {
            "Detik" -> baseValue
            "Menit" -> baseValue / 60.0
            "Jam" -> baseValue / 3600.0
            "Hari" -> baseValue / 86400.0
            "Minggu" -> baseValue / 604800.0
            "Bulan" -> baseValue / 2592000.0
            "Tahun" -> baseValue / 31536000.0
            else -> 0.0
        }
    }

    private fun convertSpeed() {
        val inputValue = etInputSpeed.text.toString().toDoubleOrNull()
        if (inputValue == null) {
            tvSpeedResult.text = "Hasil: -"
            return
        }
        val fromUnit = spinnerFromSpeed.selectedItem.toString()
        val toUnit = spinnerToSpeed.selectedItem.toString()
        val result = performSpeedConversion(inputValue, fromUnit, toUnit)
        tvSpeedResult.text = "Hasil: %.4f".format(result)
    }

    private fun performSpeedConversion(value: Double, fromUnit: String, toUnit: String): Double {
        var baseValue = value
        when (fromUnit) {
            "Meter/detik" -> {}
            "Kilometer/jam" -> baseValue /= 3.6
            "Mil/jam" -> baseValue *= 0.44704
            "Knot" -> baseValue *= 0.514444
            "Mach" -> baseValue *= 343.0
        }

        return when (toUnit) {
            "Meter/detik" -> baseValue
            "Kilometer/jam" -> baseValue * 3.6
            "Mil/jam" -> baseValue / 0.44704
            "Knot" -> baseValue / 0.514444
            "Mach" -> baseValue / 343.0
            else -> 0.0
        }
    }

    private fun convertTemperature() {
        val inputValue = etInputTemp.text.toString().toDoubleOrNull()
        if (inputValue == null) {
            tvTempResult.text = "Hasil: -"
            return
        }
        val fromUnit = spinnerFromTemp.selectedItem.toString()
        val toUnit = spinnerToTemp.selectedItem.toString()
        val result = performTemperatureConversion(inputValue, fromUnit, toUnit)
        tvTempResult.text = "Hasil: %.4f".format(result)
    }

    private fun performTemperatureConversion(value: Double, fromUnit: String, toUnit: String): Double {
        var celsius = 0.0
        when (fromUnit) {
            "Celsius" -> celsius = value
            "Fahrenheit" -> celsius = (value - 32) * 5 / 9
            "Kelvin" -> celsius = value - 273.15
        }

        return when (toUnit) {
            "Celsius" -> celsius
            "Fahrenheit" -> (celsius * 9 / 5) + 32
            "Kelvin" -> celsius + 273.15
            else -> 0.0
        }
    }

    private fun convertMass() {
        val inputValue = etInputMass.text.toString().toDoubleOrNull()
        if (inputValue == null) {
            tvMassResult.text = "Hasil: -"
            return
        }
        val fromUnit = spinnerFromMass.selectedItem.toString()
        val toUnit = spinnerToMass.selectedItem.toString()
        val result = performMassConversion(inputValue, fromUnit, toUnit)
        tvMassResult.text = "Hasil: %.4f".format(result)
    }

    private fun performMassConversion(value: Double, fromUnit: String, toUnit: String): Double {
        var baseValue = value
        when (fromUnit) {
            "Gram" -> {}
            "Kilogram" -> baseValue *= 1000.0
            "Miligram" -> baseValue /= 1000.0
            "Ton" -> baseValue *= 1_000_000.0
            "Pound" -> baseValue *= 453.592
            "Ounce" -> baseValue *= 28.3495
        }

        return when (toUnit) {
            "Gram" -> baseValue
            "Kilogram" -> baseValue / 1000.0
            "Miligram" -> baseValue * 1000.0
            "Ton" -> baseValue / 1_000_000.0
            "Pound" -> baseValue / 453.592
            "Ounce" -> baseValue / 28.3495
            else -> 0.0
        }
    }

    private fun convertCurrent() {
        val inputValue = etInputCurrent.text.toString().toDoubleOrNull()
        if (inputValue == null) {
            tvCurrentResult.text = "Hasil: -"
            return
        }
        val fromUnit = spinnerFromCurrent.selectedItem.toString()
        val toUnit = spinnerToCurrent.selectedItem.toString()
        val result = performCurrentConversion(inputValue, fromUnit, toUnit)
        tvCurrentResult.text = "Hasil: %.4f".format(result)
    }

    private fun performCurrentConversion(value: Double, fromUnit: String, toUnit: String): Double {
        var baseValue = value
        when (fromUnit) {
            "Ampere" -> {}
            "Miliampere" -> baseValue /= 1000.0
            "Kiloampere" -> baseValue *= 1000.0
        }

        return when (toUnit) {
            "Ampere" -> baseValue
            "Miliampere" -> baseValue * 1000.0
            "Kiloampere" -> baseValue / 1000.0
            else -> 0.0
        }
    }

    private fun convertPressure() {
        val inputValue = etInputPressure.text.toString().toDoubleOrNull()
        if (inputValue == null) {
            tvPressureResult.text = "Hasil: -"
            return
        }
        val fromUnit = spinnerFromPressure.selectedItem.toString()
        val toUnit = spinnerToPressure.selectedItem.toString()
        val result = performPressureConversion(inputValue, fromUnit, toUnit)
        tvPressureResult.text = "Hasil: %.4f".format(result)
    }

    private fun performPressureConversion(value: Double, fromUnit: String, toUnit: String): Double {
        var baseValue = value
        when (fromUnit) {
            "Pascal" -> {}
            "Kilopascal" -> baseValue *= 1000.0
            "Megapascal" -> baseValue *= 1_000_000.0
            "Bar" -> baseValue *= 100_000.0
            "Atmosphere" -> baseValue *= 101325.0
            "PSI" -> baseValue *= 6894.76
        }

        return when (toUnit) {
            "Pascal" -> baseValue
            "Kilopascal" -> baseValue / 1000.0
            "Megapascal" -> baseValue / 1_000_000.0
            "Bar" -> baseValue / 100_000.0
            "Atmosphere" -> baseValue / 101325.0
            "PSI" -> baseValue / 6894.76
            else -> 0.0
        }
    }

    private fun convertAngle() {
        val inputValue = etInputAngle.text.toString().toDoubleOrNull()
        if (inputValue == null) {
            tvAngleResult.text = "Hasil: -"
            return
        }
        val fromUnit = spinnerFromAngle.selectedItem.toString()
        val toUnit = spinnerToAngle.selectedItem.toString()
        val result = performAngleConversion(inputValue, fromUnit, toUnit)
        tvAngleResult.text = "Hasil: %.4f".format(result)
    }

    private fun performAngleConversion(value: Double, fromUnit: String, toUnit: String): Double {
        var baseValue = value
        when (fromUnit) {
            "Derajat" -> baseValue = Math.toRadians(value)
            "Radian" -> {}
            "Gradian" -> baseValue = value * (Math.PI / 200.0)
        }

        return when (toUnit) {
            "Derajat" -> Math.toDegrees(baseValue)
            "Radian" -> baseValue
            "Gradian" -> baseValue / (Math.PI / 200.0)
            else -> 0.0
        }
    }
}