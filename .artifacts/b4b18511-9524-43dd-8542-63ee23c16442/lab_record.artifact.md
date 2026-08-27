# Lab Record: Experiment No. 6

**Date:** August 27, 2026
**Subject:** Mobile Application Development
**Topic:** Implementation of Basic Android UI Components in a Registration Form

---

## 1. Aim
To design and develop an Android application that utilizes various basic UI components such as **TextView, EditText, Button, ImageButton, CheckBox, ToggleButton, RadioButton, and RadioGroup** to create a comprehensive and aesthetic Registration Form with scrolling functionality.

## 2. Software & Hardware Requirements

### Software Requirements:
- **Operating System:** Windows 10/11
- **Integrated Development Environment (IDE):** Android Studio (latest version)
- **Programming Language:** Kotlin
- **JDK:** Version 11 or higher

### Hardware Requirements:
- **Processor:** Intel Core i5 or higher
- **RAM:** 8 GB minimum (16 GB recommended)
- **Disk Space:** 4 GB minimum
- **Device:** Android Emulator (Pixel 8) or physical Android device

## 3. Theory (UI Components Overview)
- **TextView:** Used to display read-only text to the user.
- **EditText:** An extension of TextView that allows users to type and edit text.
- **Button:** A clickable UI element to trigger actions (e.g., Submit).
- **ImageButton:** Similar to a Button but displays an image instead of text.
- **CheckBox:** A two-state button that can be either checked or unchecked (multiple selections allowed).
- **ToggleButton:** A button that displays checked/unchecked states with text (e.g., ON/OFF).
- **RadioButton & RadioGroup:** Radio buttons allow the user to select one option from a set. RadioGroup ensures only one RadioButton is selected at a time.
- **ScrollView:** A container that allows a single direct child (usually a LinearLayout) to be scrolled if its content exceeds the screen size.

## 4. Source Code

### A. Layout File (`activity_main.xml`)
This file defines the UI structure using a `ScrollView` and `MaterialCardView` for an aesthetic, modern look.

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/background">

    <ScrollView
        android:id="@+id/main"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:padding="24dp">

            <!-- Header Section -->
            <com.google.android.material.card.MaterialCardView
                android:layout_width="100dp"
                android:layout_height="100dp"
                android:layout_gravity="center_horizontal"
                android:layout_marginBottom="16dp"
                app:cardCornerRadius="50dp"
                app:cardElevation="4dp">

                <ImageButton
                    android:id="@+id/imageButton"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:scaleType="centerInside"
                    android:src="@drawable/ic_launcher_foreground"
                    android:background="@color/primaryContainer"
                    android:contentDescription="Upload Photo" />
            </com.google.android.material.card.MaterialCardView>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Create Account"
                android:textSize="28sp"
                android:textStyle="bold"
                android:textColor="@color/onSurface"
                android:layout_gravity="center_horizontal"
                android:layout_marginBottom="24dp" />

            <!-- Account Details Card -->
            <com.google.android.material.card.MaterialCardView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginBottom="16dp"
                app:cardCornerRadius="16dp"
                app:cardElevation="2dp">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:orientation="vertical"
                    android:padding="16dp">

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Account Details"
                        android:textSize="18sp"
                        android:textStyle="bold"
                        android:layout_marginBottom="12dp"/>

                    <com.google.android.material.textfield.TextInputLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:hint="Full Name"
                        android:layout_marginBottom="12dp"
                        style="@style/Widget.Material3.TextInputLayout.OutlinedBox">
                        <com.google.android.material.textfield.TextInputEditText
                            android:id="@+id/nameEdit"
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:inputType="textPersonName" />
                    </com.google.android.material.textfield.TextInputLayout>

                    <com.google.android.material.textfield.TextInputLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:hint="Email Address"
                        android:layout_marginBottom="12dp"
                        style="@style/Widget.Material3.TextInputLayout.OutlinedBox">
                        <com.google.android.material.textfield.TextInputEditText
                            android:id="@+id/emailEdit"
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:inputType="textEmailAddress" />
                    </com.google.android.material.textfield.TextInputLayout>

                    <com.google.android.material.textfield.TextInputLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:hint="Password"
                        app:passwordToggleEnabled="true"
                        style="@style/Widget.Material3.TextInputLayout.OutlinedBox">
                        <com.google.android.material.textfield.TextInputEditText
                            android:id="@+id/passwordEdit"
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:inputType="textPassword" />
                    </com.google.android.material.textfield.TextInputLayout>
                </LinearLayout>
            </com.google.android.material.card.MaterialCardView>

            <!-- Personal Info Card -->
            <com.google.android.material.card.MaterialCardView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginBottom="16dp"
                app:cardCornerRadius="16dp"
                app:cardElevation="2dp">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:orientation="vertical"
                    android:padding="16dp">

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Personal Info"
                        android:textSize="18sp"
                        android:textStyle="bold"
                        android:layout_marginBottom="12dp"/>

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Gender"
                        android:textSize="14sp" />

                    <RadioGroup
                        android:id="@+id/radioGroup"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:orientation="horizontal"
                        android:layout_marginBottom="16dp">
                        <RadioButton android:id="@+id/radioMale" android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1" android:text="Male" />
                        <RadioButton android:id="@+id/radioFemale" android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1" android:text="Female" />
                        <RadioButton android:id="@+id/radioOther" android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1" android:text="Other" />
                    </RadioGroup>

                    <Button
                        android:id="@+id/dateButton"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:text="Select Date of Birth"
                        style="@style/Widget.Material3.Button.TonalButton" />
                </LinearLayout>
            </com.google.android.material.card.MaterialCardView>

            <!-- Preferences Card -->
            <com.google.android.material.card.MaterialCardView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginBottom="24dp"
                app:cardCornerRadius="16dp"
                app:cardElevation="2dp">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:orientation="vertical"
                    android:padding="16dp">

                    <CheckBox
                        android:id="@+id/checkBox"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="I accept the Terms and Conditions"
                        android:layout_marginBottom="8dp" />

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:orientation="horizontal"
                        android:gravity="center_vertical">
                        <TextView android:layout_width="0dp" android:layout_height="wrap_content" android:layout_weight="1" android:text="Subscribe to newsletter" />
                        <ToggleButton android:id="@+id/toggleButton" android:layout_width="wrap_content" android:layout_height="wrap_content" android:textOn="YES" android:textOff="NO" />
                    </LinearLayout>
                </LinearLayout>
            </com.google.android.material.card.MaterialCardView>

            <Button
                android:id="@+id/submitButton"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginBottom="24dp"
                android:text="Submit"
                style="@style/Widget.Material3.Button" />

            <!-- Live Summary Card -->
            <com.google.android.material.card.MaterialCardView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:cardCornerRadius="16dp"
                app:cardBackgroundColor="#F1F1F1">
                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:padding="16dp">
                    <TextView
                        android:id="@+id/resultTextView"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:text="Fill in the details to create your account." />
                </LinearLayout>
            </com.google.android.material.card.MaterialCardView>

        </LinearLayout>
    </ScrollView>

    <!-- Scroll Controls -->
    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_margin="16dp"
        android:orientation="vertical">
        <com.google.android.material.floatingactionbutton.FloatingActionButton
            android:id="@+id/scrollUpButton"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginBottom="8dp"
            android:src="@android:drawable/arrow_up_float" />
        <com.google.android.material.floatingactionbutton.FloatingActionButton
            android:id="@+id/scrollDownButton"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@android:drawable/arrow_down_float" />
    </LinearLayout>
</FrameLayout>
```

### B. Activity File (`MainActivity.kt`)
This file contains the logic for form validation, Date Picker, and scrolling functionality.

```kotlin
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
        scrollUpButton.setOnClickListener { scrollView.smoothScrollTo(0, 0) }
        scrollDownButton.setOnClickListener { scrollView.fullScroll(ScrollView.FOCUS_DOWN) }

        // Date Picker Setup
        dateButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val dpd = DatePickerDialog(this, { _, yr, month, day ->
                selectedDate = "$day/${month + 1}/$yr"
                dateButton.text = "DOB: $selectedDate"
                updateLiveSummary()
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
            dpd.show()
        }

        // Listeners for Live Summary
        nameEdit.setOnFocusChangeListener { _, _ -> updateLiveSummary() }
        emailEdit.setOnFocusChangeListener { _, _ -> updateLiveSummary() }
        checkBox.setOnCheckedChangeListener { _, _ -> updateLiveSummary() }
        toggleButton.setOnCheckedChangeListener { _, _ -> updateLiveSummary() }
        radioGroup.setOnCheckedChangeListener { _, _ -> updateLiveSummary() }

        submitButton.setOnClickListener {
            if (validateForm()) {
                resultTextView.text = "✅ Submission Successful!\nWelcome, ${nameEdit.text}!"
                Toast.makeText(this, "Account Created!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validateForm(): Boolean {
        val name = nameEdit.text.toString()
        val email = emailEdit.text.toString()
        if (name.isBlank()) { nameEdit.error = "Name is required"; return false }
        if (email.isBlank() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEdit.error = "Enter a valid email"; return false
        }
        if (passwordEdit.text.length < 6) { passwordEdit.error = "Min 6 characters"; return false }
        if (!checkBox.isChecked) { Toast.makeText(this, "Accept Terms", Toast.LENGTH_SHORT).show(); return false }
        return true
    }

    private fun updateLiveSummary() {
        val gender = if (radioGroup.checkedRadioButtonId != -1)
            findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text else "Not selected"
        resultTextView.text = """
            👤 Name: ${nameEdit.text}
            📧 Email: ${emailEdit.text}
            📅 DOB: $selectedDate
            🚻 Gender: $gender
            🔔 Newsletter: ${if (toggleButton.isChecked) "Yes" else "No"}
        """.trimIndent()
    }
}
```

## 5. Output Description
1.  **Form Entry:** User enters name, email, and password. Validation logic checks for correct formats.
2.  **Date Selection:** Clicking "Select Date of Birth" opens a `DatePickerDialog`.
3.  **Preferences:** User toggles a newsletter subscription and accepts terms.
4.  **Live Summary:** A card at the bottom reflects the user's progress in real-time.
5.  **Scrolling:** Floating action buttons allow the user to jump to the top or bottom of the long form instantly.
6.  **Submission:** On clicking "Submit", if validation passes, a success message and Toast are displayed.

## 6. Conclusion
The application was successfully developed using various Android UI components. The use of a ScrollView along with floating scroll buttons ensures a smooth user experience for long forms, and the Material 3 design makes the interface aesthetic and user-friendly.
