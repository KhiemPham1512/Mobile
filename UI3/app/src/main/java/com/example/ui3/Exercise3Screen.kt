package com.example.ui3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

data class StudentScore(
    val name: String,
    val score: Double?
)

@Composable
fun Exercise3Screen() {
    // Giữ nguyên 100% dữ liệu thực tế của bạn
    val list = listOf(
        StudentScore("Phạm Gia Khiêm", 7.8),
        StudentScore("Trịnh Lê Thanh Hằng", 9.0),
        StudentScore("Phạm Bá Trí Tâm", null),
        StudentScore("Lưu Bị", 5.8),
        StudentScore("Quan Vũ", 4.3)
    )

    var sum = 0.0
    var validCount = 0
    var excellentCount = 0
    var nullCount = 0
    var maxScore = 0.0

    for (s in list) {
        if (s.score != null) {
            val sc = s.score
            sum += sc
            validCount++
            if (sc >= 8.0) excellentCount++
            if (sc > maxScore) maxScore = sc
        } else {
            nullCount++
        }
    }

    val averageScore = if (validCount > 0) sum / validCount else 0.0
    val formattedAvg = String.format(Locale.US, "%.2f", averageScore)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F5F9))
    ) {
        // Thanh tiêu đề TopBar
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFF243B6B)
        ) {
            Text(
                text = "Bảng điểm lớp",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 15.dp)
            )
        }

        // Bố cục thân màn hình: Nới rộng nhẹ lề để toàn bộ khối lấp đầy khung nhìn
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            // 1. Thẻ thống kê tổng hợp (Mở rộng độ thoáng lên 18.dp)
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF284478)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(22.dp)) {
                    Text(
                        text = "Điểm trung bình lớp",
                        color = Color(0xFFB0C4DE),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    // Điểm TB nâng lên 36.sp to rõ, vững chãi
                    Text(
                        text = formattedAvg,
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    HorizontalDivider(
                        color = Color.White.copy(alpha = 0.45f),
                        thickness = 1.dp
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = "Giỏi", color = Color(0xFFB0C4DE), fontSize = 12.sp)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(text = "$excellentCount", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 19.sp)
                        }
                        Column {
                            Text(text = "Chưa có điểm", color = Color(0xFFB0C4DE), fontSize = 12.sp)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(text = "$nullCount", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 19.sp)
                        }
                        Column {
                            Text(text = "Cao nhất", color = Color(0xFFB0C4DE), fontSize = 12.sp)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(text = "$maxScore", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 19.sp)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // 2. Nhãn danh sách sinh viên
            Text(
                text = "DANH SÁCH • ${list.size} SINH VIÊN",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF64748B)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 3. Danh sách 5 sinh viên: Nâng khoảng cách từ 7.dp lên 10.dp
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                for (s in list) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                // NÂNG PADDING DỌC: Từ 9.dp lên 14.dp giúp 5 ô dãn dài ra khoảng 50.dp, lấp đầy khoảng trống
                                .padding(horizontal = 16.dp, vertical = 14.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                // Tên sinh viên 16.sp sắc nét, dễ nhìn
                                Text(
                                    text = s.name,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 16.sp,
                                    color = Color(0xFF1E293B)
                                )
                                Spacer(modifier = Modifier.height(3.dp))
                                if (s.score != null) {
                                    val rank = evaluateScore(s.score)
                                    Text(
                                        text = rank.title,
                                        color = rank.textColor,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                } else {
                                    Text(
                                        text = "Chưa có điểm",
                                        color = Color(0xFF94A3B8),
                                        fontSize = 12.sp
                                    )
                                }
                            }

                            // Điểm số 20.sp cân xứng
                            Text(
                                text = s.score?.toString() ?: "—",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (s.score == null) Color(0xFF94A3B8) else Color(0xFF1E293B)
                            )
                        }
                    }
                }
            }
        }
    }
}