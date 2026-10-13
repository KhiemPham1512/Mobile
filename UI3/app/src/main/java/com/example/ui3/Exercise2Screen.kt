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

data class RankResult(
    val title: String,
    val textColor: Color,
    val bgColor: Color
)

fun evaluateScore(score: Double): RankResult {
    return if (score < 0.0 || score > 10.0) {
        RankResult("Không hợp lệ", Color.Gray, Color(0xFFF1F5F9))
    } else if (score >= 8.0) {
        RankResult("Giỏi", Color(0xFF2E7D32), Color(0xFFE8F5E9))
    } else if (score >= 6.5) {
        RankResult("Khá", Color(0xFF1976D2), Color(0xFFE3F2FD))
    } else if (score >= 5.0) {
        RankResult("Trung bình", Color(0xFFF57C00), Color(0xFFFFF3E0))
    } else {
        RankResult("Yếu", Color(0xFFD32F2F), Color(0xFFFFEBEE))
    }
}

@Composable
fun Exercise2Screen() {
    val mainScore = 8.5
    val mainRank = evaluateScore(mainScore)
    val extraScores = listOf(9.0, 7.0, 5.5, 3.0, 11.0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFC))
    ) {
        Surface(modifier = Modifier.fillMaxWidth(), color = Color(0xFF284478)) {
            Text(
                text = "Xếp loại học lực",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp, horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Điểm trung bình", color = Color.Gray, fontSize = 15.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = mainScore.toString(),
                        fontSize = 52.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1E293B)
                    )
                    Spacer(modifier = Modifier.height(18.dp))

                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = mainRank.bgColor,
                        modifier = Modifier.fillMaxWidth().height(54.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = mainRank.title,
                                color = mainRank.textColor,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "KIỂM TRA THÊM",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth() .padding(horizontal = 8.dp),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(vertical = 4.dp)) {
                    extraScores.forEachIndexed { index, score ->
                        val rank = evaluateScore(score)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Điểm ${if (score % 1.0 == 0.0) score.toInt() else score}",
                                fontSize = 15.sp,
                                color = Color(0xFF334155)
                            )
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = rank.bgColor
                            ) {
                                Text(
                                    text = rank.title,
                                    color = rank.textColor,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
                                )
                            }
                        }
                        if (index < extraScores.lastIndex) {
                            HorizontalDivider(
                                modifier = Modifier.padding(horizontal = 16.dp), // Thụt lề 2 đầu để đường kẻ tinh tế
                                thickness = 1.dp,
                                color = Color(0xFFF1F5F9)
                            )
                        }
                    }
                }
            }
        }
    }
}