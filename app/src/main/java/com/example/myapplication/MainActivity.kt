package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MyScreen()
                }
            }
        }
    }
}

@Composable
fun MyScreen() {
    var inputText by remember { mutableStateOf("") }
    var displayedText by remember { mutableStateOf("Введите текст") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = displayedText,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 30.dp)
        )
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Другова Валерия ЗИСТ-3") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                if (inputText.isNotBlank()) {
                    displayedText = inputText
                }
            }
        ) {
            Text("Показать")
        }
    }
}

// Вспомогательная функция для темы (обычно создаётся автоматически)
@Composable
fun MyFirstAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}