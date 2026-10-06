# BÀI TẬP TUẦN 1 - MÔN LẬP TRÌNH THIẾT BỊ DI ĐỘNG

* **Sinh viên thực hiện:** Phạm Gia Khiêm
* **Mã số sinh viên:** 074206004060

---

## PHẦN 1: ĐỊNH HƯỚNG VÀ TƯ DUY NGHỀ NGHIỆP

### Câu 1: Mong muốn và định hướng của bạn sau khi học xong môn học là gì?
* **Mong muốn:** Nắm vững toàn bộ chu trình phát triển một ứng dụng di động hoàn chỉnh từ Frontend đến Backend. Không chỉ dừng lại ở bài tập mẫu, mục tiêu là tự thiết kế, lập trình và đưa một sản phẩm có tính ứng dụng thực tế, sẵn sàng thương mại hóa lên các kho ứng dụng.
* **Định hướng nghề nghiệp:** Từ sản phẩm thực chiến đã hoàn thiện, tôi sẽ xây dựng Portfolio và CV chuyên nghiệp để ứng tuyển vị trí Lập trình viên Di động (Mobile Developer) tại các doanh nghiệp công nghệ, với nền tảng vững chắc về kiến trúc phần mềm (MVVM), giao diện hiện đại (Jetpack Compose) và kỹ năng kết nối hệ thống API backend.

### Câu 2: Theo bạn, trong tương lai gần (10 năm) lập trình di động có phát triển không? Giải thích tại sao?
Lập trình di động chắc chắn **sẽ tiếp tục bùng nổ và phân hóa mạnh mẽ** trong 10 năm tới vì 3 lý do cốt lõi:
1. **Thiết bị điện toán trung tâm (Hub of Computing):** Điện thoại thông minh không còn là thiết bị độc lập mà đã trở thành trạm điều khiển trung tâm cho toàn bộ hệ sinh thái phần cứng: thiết bị nhà thông minh (Smart Home), thiết bị đeo (Wearables), xe thông minh (Automotive) và thiết bị y tế cá nhân.
2. **Kỷ nguyên AI trên thiết bị (On-device AI):** Thay vì gửi toàn bộ dữ liệu lên máy chủ đám mây, các dòng chip di động mới cho phép chạy mô hình AI trực tiếp trên máy để bảo mật và phản hồi tức thì. Điều này mở ra nhu cầu khổng lồ về các kỹ sư di động biết tối ưu hóa thuật toán và tích hợp AI vào ứng dụng.
3. **Thói quen và trải nghiệm người dùng:** Mọi dịch vụ thiết yếu từ tài chính, thương mại điện tử, định danh số đến y tế đều ưu tiên mô hình "Mobile-First". Con người ngày càng phụ thuộc vào các trải nghiệm tiện ích, mượt mà trên màn hình cảm ứng.

---

## PHẦN 2: THỰC HÀNH UI

### Câu 3: Viết một ứng dụng có giao diện theo yêu cầu
* Đã hoàn thiện thiết kế giao diện hồ sơ cá nhân (Profile UI) bằng **Jetpack Compose (Kotlin)**.
* Giao diện bao gồm thanh điều hướng trên cùng, ảnh đại diện bo tròn có viền tương phản, họ tên in đậm và mã số sinh viên, được căn chỉnh bố cục tập trung bằng container `Box` và `Column`. Mã nguồn nằm chi tiết trong file `MainActivity.kt`.

---

## PHẦN 3: TÌM HIỂU MÔ HÌNH HAA VÀ XU THẾ CÔNG NGHỆ HIỆN NAY

### Câu 4: Tìm hiểu mô hình giáo dục của HAA (Horowitz Andreessen Academy), ưu điểm và nhược điểm
Mô hình giáo dục **HAA** (lấy cảm hứng từ triết lý công nghệ và đầu tư của quỹ mạo hiểm Andreessen Horowitz - a16z) là mô hình đào tạo theo định hướng **thực chiến công nghệ cao (Apprenticeship & Venture-backed Education)**, tập trung vào việc tạo ra những kỹ sư giải quyết được các bài toán thực tế của kỷ nguyên AI và phần mềm hiện đại.

* **Ưu điểm:**
    * *Học qua làm thật (Project-Based):* Giảm tải lý thuyết hàn lâm, tập trung 100% vào việc xây dựng sản phẩm thật, chạy thật trên môi trường doanh nghiệp.
    * *Bắt kịp công nghệ mới nhất:* Chương trình giảng dạy thay đổi linh hoạt theo tuần/tháng, tích hợp ngay các công cụ mới (AI Co-pilot, Cloud Native, Microservices) mà đại học truyền thống chưa kịp cập nhật.
    * *Rèn luyện tư duy sản phẩm:* Không chỉ dạy viết code, mô hình này rèn luyện cho kỹ sư tư duy kinh doanh, hiểu nhu cầu thị trường và khả năng thương mại hóa phần mềm.
* **Nhược điểm:**
    * *Áp lực tự học cực cao:* Đòi hỏi người học phải có tính chủ động và năng lực tự giải quyết vấn đề lớn; người học thụ động sẽ rất dễ bị đào thải.
    * *Nguy cơ hổng kiến thức nền tảng:* Việc tập trung quá nhanh vào công nghệ ứng dụng có thể khiến người học thiếu hụt các môn khoa học máy tính cơ bản sâu sắc (toán rời rạc, nguyên lý hệ điều hành, cấu trúc máy tính) nếu không tự trau dồi thêm.

### Câu 5: Internet và AI đã thay đổi cách con người tiếp cận tri thức như thế nào?
Sự dịch chuyển của phương thức học tập qua 3 thời kỳ:

| Tiêu chí | Trước khi có Internet | Thời kỳ Internet phổ biến | Thời kỳ AI tạo sinh (GenAI) hiện nay |
| :--- | :--- | :--- | :--- |
| **Tìm kiếm** | Bị giới hạn trong sách in, thư viện, giáo trình và sự truyền đạt một chiều từ thầy cô. Tốc độ tìm kiếm tính bằng giờ hoặc ngày. | Tìm kiếm diện rộng qua Google, Wikipedia, diễn đàn (StackOverflow). Thông tin dồi dào nhưng phân mảnh, đòi hỏi người học tự lọc thủ công. | Tìm kiếm tương tác dạng hội thoại 1-1. AI tự động đọc hiểu, chắt lọc, tổng hợp từ hàng triệu nguồn và đưa ra lời giải đúng ngữ cảnh chỉ sau vài giây. |
| **Ghi nhớ** | Đòi hỏi học thuộc lòng kiến thức, ghi chép sổ tay; bộ nhớ não bộ là kho lưu trữ duy nhất để đem vào phòng thi hoặc công việc. | Hình thành "Hiệu ứng Google" (Google Effect): Não bộ không còn ghi nhớ nội dung chi tiết mà chuyển sang ghi nhớ "đường dẫn" và từ khóa để tìm lại thông tin khi cần. | Não bộ được giải phóng khỏi việc ghi nhớ cú pháp hay chi tiết vụn vặt; chuyển trọng tâm sang ghi nhớ logic kiến trúc, mô hình tư duy và bản chất cốt lõi của bài toán. |
| **Vận dụng** | Vận dụng chậm, chủ yếu làm theo khuôn mẫu đã dạy trong sách hoặc phụ thuộc vào sự hướng dẫn trực tiếp từ chuyên gia. | Tự học qua video/khóa học trực tuyến; sao chép và chắp vá các đoạn mã nguồn hoặc tài liệu mẫu tìm thấy trên mạng để giải quyết bài toán. | Làm việc cộng tác (Co-pilot): AI đóng vai trò người trợ lý viết khung code/ý tưởng sơ bộ, con người đóng vai trò kiến trúc sư để phản biện, kiểm thử và tối ưu hóa giải pháp. |

### Câu 6: Chúng ta cần học gì khi AI có thể làm gần như mọi thứ?
Khi AI có thể viết mã nguồn, dịch văn bản và vẽ tranh trong vài giây, giá trị của việc học "thuộc lòng cú pháp" giảm về 0. Người học hiện đại cần tập trung vào:
1. **Hiểu bản chất vấn đề từ gốc rễ (First Principles Thinking):** Cần nắm rõ cách máy tính, mạng internet và luồng dữ liệu vận hành từ bên dưới để biết giải pháp AI đưa ra có chuẩn xác, an toàn và tối ưu hay không.
2. **Kỹ năng chia nhỏ và mô tả bài toán (Problem Decomposition & Framing):** AI chỉ đưa ra kết quả xuất sắc khi nhận được yêu cầu xuất sắc. Học cách bóc tách một vấn đề lớn, phức tạp ngoài đời thực thành các bài toán logic nhỏ mà máy móc có thể hiểu và giải quyết.
3. **Kiến trúc hệ thống và tích hợp (System Architecture):** AI có thể viết từng đoạn hàm riêng lẻ, nhưng việc ghép nối các đoạn hàm đó thành một hệ thống phần mềm lớn, chịu tải cao, bảo mật và bảo trì được qua nhiều năm vẫn hoàn toàn là việc của kỹ sư con người.
4. **Tư duy thẩm định và kiểm soát chất lượng (Verification & Quality Assurance):** Luôn hoài nghi lành mạnh với kết quả của AI để phát hiện lỗ hổng bảo mật, lỗi logic ngầm và ảo giác (hallucination) mà mô hình tạo ra.

### Câu 7: Những năng lực cần phát triển trong thời đại AI và lý do quan trọng
1. **Năng lực tư duy phản biện (Critical Thinking):**
    * *Vì sao quan trọng:* AI luôn đưa ra câu trả lời với giọng điệu rất tự tin, dù nội dung đó có thể chứa mã độc, vi phạm bản quyền hoặc sai lệch logic. Người thiếu tư duy phản biện sẽ trở thành "nô lệ" sao chép kết quả mù quáng và tạo ra các lỗ hổng thảm họa cho sản phẩm.
2. **Năng lực thấu cảm và tư duy sản phẩm (Empathy & Product Sense):**
    * *Vì sao quan trọng:* AI không có cảm xúc, không trải nghiệm nỗi đau hay sự bất tiện của người dùng ngoài đời thực. Khả năng lắng nghe khách hàng, thấu hiểu tâm lý hành vi để thiết kế ra sản phẩm thực sự hữu ích là thế mạnh độc quyền của con người.
3. **Năng lực tự học và khả năng thích ứng (Meta-learning & Adaptability):**
    * *Vì sao quan trọng:* Trong thời đại mà các công cụ công nghệ mới ra đời theo từng tuần, một ngôn ngữ lập trình hay framework có thể lỗi thời chỉ sau vài năm. Kỹ năng "học cách tự học nhanh" là tấm khiên bảo vệ duy nhất giúp một lập trình viên không bị thị trường đào thải.
4. **Năng lực giao tiếp và làm việc nhóm (Communication & Collaboration):**
    * *Vì sao quan trọng:* Xây dựng một dự án công nghệ lớn là hoạt động tập thể đòi hỏi sự đồng thuận, đàm phán và kết nối giữa các bên (kỹ sư, thiết kế, kinh doanh, khách hàng). AI không thể thay thế con người trong việc truyền cảm hứng, giải quyết xung đột nội bộ và dẫn dắt đội ngũ.