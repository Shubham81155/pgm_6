package com.example.exp6

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var nameEdit: EditText
    private lateinit var emailEdit: EditText
    private lateinit var passwordEdit: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var toggleButton: ToggleButton
    private lateinit var radioGroup: RadioGroup
    private lateinit var resultTextView: TextView
    private lateinit var dateButton: Button
    
    private var selectedDate: String = "Not selected"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize Views
        nameEdit = findViewById(R.id.nameEdit)
        emailEdit = findViewById(R.id.emailEdit)
        passwordEdit = findViewById(R.id.passwordEdit)
        checkBox = findViewById(R.id.checkBox)
        toggleButton = findViewById(R.id.toggleButton)
        radioGroup = findViewById(R.id.radioGroup)
        resultTextView = findViewById(R.id.resultTextView)
        dateButton = findViewById(R.id.dateButton)

        val submitButton: Button = findViewById(R.id.submitButton)
        val imageButton: ImageButton = findViewById(R.id.imageButton)
        val scrollUpButton: View = findViewById(R.id.scrollUpButton)
        val scrollDownButton: View = findViewById(R.id.scrollDownButton)
        val scrollView: ScrollView = findViewById(R.id.main)

        // Scroll Buttons Logic
        scrollUpButton.setOnClickListener {
            scrollView.smoothScrollTo(0, 0)
        }

        scrollDownButton.setOnClickListener {
            scrollView.fullScroll(ScrollView.FOCUS_DOWN)
        }

        // Date Picker Setup
        dateButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(this, { _, yr, monthOfYear, dayOfMonth ->
                selectedDate = "$dayOfMonth/${monthOfYear + 1}/$yr"
                dateButton.text = "DOB: $selectedDate"
                updateLiveSummary()
            }, year, month, day)
            dpd.show()
        }

        // Live updates for summary
        nameEdit.setOnFocusChangeListener { _, _ -> updateLiveSummary() }
        emailEdit.setOnFocusChangeListener { _, _ -> updateLiveSummary() }
        checkBox.setOnCheckedChangeListener { _, _ -> updateLiveSummary() }
        toggleButton.setOnCheckedChangeListener { _, _ -> updateLiveSummary() }
        radioGroup.setOnCheckedChangeListener { _, _ -> updateLiveSummary() }

        imageButton.setOnClickListener {
            Toast.makeText(this, "Photo upload feature coming soon!", Toast.LENGTH_SHORT).show()
        }

        submitButton.setOnClickListener {
            if (validateForm()) {
                val name = nameEdit.text.toString()
                resultTextView.text = "✅ Submission Successful!\nWelcome, $name!"
                Toast.makeText(this, "Account Created Successfully!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validateForm(): Boolean {
        val name = nameEdit.text.toString()
        val email = emailEdit.text.toString()
        val password = passwordEdit.text.toString()

        if (name.isBlank()) {
            nameEdit.error = "Name is required"
            return false
        }
        if (email.isBlank() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEdit.error = "Enter a valid email"
            return false
        }
        if (password.length < 6) {
            passwordEdit.error = "Password must be at least 6 characters"
            return false
        }
        if (!checkBox.isChecked) {
            Toast.makeText(this, "Please accept Terms & Conditions", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun updateLiveSummary() {
        val name = nameEdit.text.toString().ifBlank { "..." }
        val email = emailEdit.text.toString().ifBlank { "..." }
        
        val selectedRadioId = radioGroup.checkedRadioButtonId
        val gender = if (selectedRadioId != -1) {
            findViewById<RadioButton>(selectedRadioId).text
        } else {
            "Not selected"
        }

        val summary = """
            📝 Current Progress:
            👤 Name: $name
            📧 Email: $email
            📅 DOB: $selectedDate
            🚻 Gender: $gender
            🔔 Newsletter: ${if (toggleButton.isChecked) "Yes" else "No"}
            📜 Terms: ${if (checkBox.isChecked) "Accepted" else "Not Accepted"}
        """.trimIndent()

        resultTextView.text = summary
    }
}