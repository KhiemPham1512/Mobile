package com.example.ui1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Gọi màn hình giao diện ra
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {
    // =========================================================
    // NƠI BẠN TỰ DO THAY ĐỔI THÔNG TIN:
    val tenSinhVien = "Phạm Gia Khiêm" // Đổi tên tại đây
    val maSoSinhVien = "074206004060"      // Đổi MSSV tại đây
    // =========================================================

    // Toàn bộ màn hình
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        // DÙNG BOX: Cho phép neo các phần tử ở các vị trí tự do trên màn hình
        Box(modifier = Modifier.fillMaxSize()) {

            // 1. THANH CÔNG CỤ (Được neo cứng ở trên cùng - TopCenter)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.TopCenter),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                }
            }

            // 2. NHÓM ẢNH, TÊN, MSSV (Được neo vào chính giữa màn hình - Center)
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Ảnh đại diện
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(170.dp)
                        .clip(CircleShape)
                        .border(width = 4.dp, color = Color.LightGray, shape = CircleShape)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Tên sinh viên
                Text(
                    text = tenSinhVien,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // 3. MÃ SỐ SINH VIÊN (Nổi bật bằng Tương phản thay vì Kích thước)
                Text(
                    text = maSoSinhVien,
                    fontSize = 18.sp, // Kích thước vẫn nhỏ như cũ
                    fontWeight = FontWeight.Bold, // Làm đậm nét chữ
                    color = MaterialTheme.colorScheme.primary, // Đổi sang màu nổi bật (Thường là màu tím/xanh tùy theme)
                    letterSpacing = 2.sp // Kéo giãn khoảng cách giữa các chữ cái để dễ đọc hơn
                )
            }
        }
    }
}