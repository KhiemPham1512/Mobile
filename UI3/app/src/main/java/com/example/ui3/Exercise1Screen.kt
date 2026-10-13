package com.example.ui3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Student(
    val name: String,
    val email: String?,
    val phone: String?
)

@Composable
fun Exercise1Screen() {
    val students = listOf(
        Student("Phạm Gia Khiêm", "khiem@ut.edu.vn", "0346 456 963"),
        Student("Trịnh Lê Thanh Hằng", null, "0397 462 789"),
        Student("Phạm Bá Trí Tâm", "tam@ut.edu.vn", null),
        Student("Lưu Bị", null, null),
        Student("Quan Vũ", "vu@ut.edu.vn", "0933 111 222")
    )

    var missingEmailCount = 0
    for (student in students) {
        if (student.email == null) {
            missingEmailCount++
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FB))
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFF284478)
        ) {
            Text(
                text = "Danh sách sinh viên",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            for (student in students) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = student.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1E293B)
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        val emailDisplay = student.email ?: "Chưa cập nhật"
                        Text(
                            text = "Email: $emailDisplay",
                            fontSize = 13.sp,
                            color = if (student.email == null) Color(0xFFD32F2F) else Color.Gray
                        )

                        val phoneDisplay = student.phone ?: "Chưa cập nhật"
                        Text(
                            text = "SĐT: $phoneDisplay",
                            fontSize = 13.sp,
                            color = if (student.phone == null) Color(0xFFD32F2F) else Color.Gray
                        )
                    }
                }
            }
        }

        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFE2E8F0)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Tổng: ${students.size} sinh viên",
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
                Text(
                    text = "Thiếu email: $missingEmailCount",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFFD32F2F)
                )
            }
        }
    }
}