package com.example.ui2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorScreen()
        }
    }
}

@Composable
fun CalculatorScreen() {
    // 1. Quản lý trạng thái (State)
    var num1Text by remember { mutableStateOf("") }
    var num2Text by remember { mutableStateOf("") }
    var selectedOp by remember { mutableStateOf<String?>(null) }
    var resultText by remember { mutableStateOf("") }

    // 2. Hàm tính toán tự động
    fun calculate(first: String, second: String, op: String?) {
        val n1 = first.toDoubleOrNull()
        val n2 = second.toDoubleOrNull()

        // Nếu thiếu số hoặc chưa chọn phép toán thì xóa kết quả
        if (n1 == null || n2 == null || op == null) {
            resultText = ""
            return
        }

        val rawResult = when (op) {
            "+" -> n1 + n2
            "-" -> n1 - n2
            "*" -> n1 * n2
            "/" -> {
                if (n2 == 0.0) {
                    resultText = "Không thể chia cho 0"
                    return
                }
                n1 / n2
            }
            else -> null
        }

        // Định dạng bỏ đuôi .0 nếu kết quả là số nguyên chẵn (ví dụ: 8 thay vì 8.0)
        resultText = if (rawResult != null) {
            if (rawResult % 1.0 == 0.0) rawResult.toInt().toString() else rawResult.toString()
        } else ""
    }

    // 3. Xây dựng giao diện (UI)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Tiêu đề bài tập
            Text(
                text = "Thực hành 03",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Ô nhập số thứ nhất
            OutlinedTextField(
                value = num1Text,
                onValueChange = { input ->
                    num1Text = input
                    calculate(input, num2Text, selectedOp)
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                placeholder = { Text("Nhập số thứ nhất") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Hàng 4 nút phép toán: +, -, *, /
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val buttonData = listOf(
                    Triple("+", Color(0xFFE57373), "Cộng"),
                    Triple("-", Color(0xFFFFB74D), "Trừ"),
                    Triple("*", Color(0xFF7E57C2), "Nhân"),
                    Triple("/", Color(0xFF212121), "Chia")
                )

                buttonData.forEach { (symbol, bgColor, _) ->
                    val isSelected = selectedOp == symbol
                    val activeBorderColor = if (symbol == "/") Color(0xFF2979FF) else Color.Black
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .then(
                                if (isSelected) Modifier.border(4.dp, color = activeBorderColor, RoundedCornerShape(8.dp))
                                else Modifier
                            )
                            .clip(RoundedCornerShape(8.dp))
                            .background(bgColor)
                            .clickable {
                                selectedOp = symbol
                                calculate(num1Text, num2Text, symbol)
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = symbol,
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Ô nhập số thứ hai
            OutlinedTextField(
                value = num2Text,
                onValueChange = { input ->
                    num2Text = input
                    calculate(num1Text, input, selectedOp)
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                placeholder = { Text("Nhập số thứ hai") }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Vùng hiển thị kết quả
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = if (resultText.isEmpty()) "Kết quả:" else "Kết quả: $resultText",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}