package com.example.eventpracticeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventpracticeapp.ui.theme.EventPracticeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EventPracticeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // We'll place our interactive screen inside the Scaffold
                    InteractiveScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun InteractiveScreen(modifier: Modifier = Modifier) {
    // State variables to hold the content of the text fields
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var outputMessage by remember { mutableStateOf("") }

    // State for handling errors on the text fields
    var isNameError by remember { mutableStateOf(false) }
    var isAgeError by remember { mutableStateOf(false) }

    // Get the current context to show Toast messages
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // --- Name Input Field ---
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                isNameError = false // Clear error when user types
            },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(),
            isError = isNameError,
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // --- Age Input Field ---
        OutlinedTextField(
            value = age,
            onValueChange = {
                age = it
                isAgeError = false // Clear error when user types
            },
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth(),
            // Set the keyboard to only show numbers
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = isAgeError,
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // --- Submit Button ---
        Button(
            onClick = {
                // Reset errors before validation
                isNameError = name.isBlank()
                isAgeError = age.isBlank()

                // 1. Validate that both fields are not empty
                if (name.isBlank() || age.isBlank()) {
                    Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                    outputMessage = "" // Clear previous success message
                } else {
                    // 2. Use a try-catch block for non-numeric age input
                    try {
                        val ageInt = age.toInt()
                        // Validation successful, display the message
                        outputMessage = "Hello, $name! You are $ageInt years old."
                    } catch (_: NumberFormatException) { // <<< CORRECTED: 'e' is replaced with '_'
                        // Handle invalid age input
                        isAgeError = true
                        outputMessage = "Error: Please enter a valid number for age."
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- Output Display ---
        if (outputMessage.isNotEmpty()) {
            Text(
                text = outputMessage,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InteractiveScreenPreview() {
    EventPracticeAppTheme {
        InteractiveScreen()
    }
}

