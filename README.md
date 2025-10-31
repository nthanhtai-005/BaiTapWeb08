# 🏫 School Giftshop – Cửa hàng Quà tặng Trường học

**School Giftshop** là một **ứng dụng web thương mại điện tử** được xây dựng bằng **Java Servlet/JSP**, mô phỏng một cửa hàng quà tặng trực tuyến.  
Dự án hỗ trợ nhiều vai trò người dùng bao gồm **Khách hàng**, **Người bán**, và **Người vận chuyển**, với hệ thống **quản lý sản phẩm, giỏ hàng, đơn hàng** cùng **module tối ưu hóa giao hàng**.

---

## 🚀 Tính năng chính

Dự án được chia thành các module theo vai trò người dùng:

### 1. 🔐 Chức năng chung
- **Xác thực:** Đăng ký và đăng nhập cho tất cả vai trò.  
- **Bảo mật:** Mã hóa mật khẩu (sử dụng `util.Encryption`).

### 2. 👩‍🎓 Khách hàng (Customer)
- 🏠 **Trang chủ:** Duyệt, tìm kiếm, lọc sản phẩm theo danh mục.  
- 🧾 **Chi tiết sản phẩm:** Hiển thị hình ảnh, mô tả, giá.  
- 🛒 **Giỏ hàng:** Thêm, xóa, cập nhật sản phẩm.  
- 💖 **Danh sách yêu thích:** Thêm/xóa sản phẩm khỏi wishlist.  
- 💳 **Thanh toán:** Đặt hàng và thanh toán.  
- 📦 **Quản lý đơn hàng:** Xem lịch sử đơn hàng.  
- 👤 **Quản lý tài khoản:** Cập nhật thông tin và đổi mật khẩu.

### 3. 🧑‍💼 Người bán (Seller)
- 📊 **Dashboard:** Giao diện quản lý riêng cho người bán.  
- 🛍️ **Quản lý sản phẩm (CRUD):** Thêm, sửa, xóa, xem chi tiết.  
- 🖼️ **Quản lý hình ảnh:** Tải lên nhiều hình ảnh cho sản phẩm.  
- 📦 **Quản lý đơn hàng:** Theo dõi và xử lý đơn của khách hàng.  
- 📈 **Báo cáo:** Thống kê doanh thu, sản phẩm bán chạy (`seller/report.jsp`).

### 4. 🚚 Giao vận (Transport)
- 🗺️ **Bản đồ địa chỉ:** Quản lý các **điểm (Nodes)** và **tuyến đường (Edges)**.  
- ⚙️ **Tối ưu hóa đường đi:** Sử dụng **thuật toán Dijkstra** (`service.DijkstraService`) để tìm đường ngắn nhất.  
- 📍 **Quản lý giao hàng:** Hiển thị bản đồ đơn hàng và cập nhật trạng thái.

---

## 🧰 Công nghệ sử dụng

| Loại | Công nghệ |
|------|------------|
| **Ngôn ngữ Backend** | Java (JDK 11+) |
| **Web Framework** | Java Servlets, JSP, JSTL |
| **Cơ sở dữ liệu** | Microsoft SQL Server |
| **Quản lý dự án & Build** | Apache Maven |
| **Frontend** | JSP, JavaScript (cho module bản đồ giao vận) |

### 🔗 Thư viện chính
- `jakarta.servlet-api` – Xử lý request/response web  
- `GSON` – Xử lý JSON (dùng cho bản đồ giao vận)  
- `commons-fileupload2` – Upload hình ảnh sản phẩm  
- `angus-mail` – Gửi email xác nhận đăng ký hoặc đơn hàng  

---

## ⚙️ Cài đặt và Chạy dự án

### 1. Yêu cầu
- JDK 11 trở lên  
- Apache Maven  
- Microsoft SQL Server  
- Apache Tomcat 10.1+

### 2. Cấu hình Cơ sở dữ liệu
1. Mở **SQL Server Management Studio (SSMS)**  
2. Tạo cơ sở dữ liệu mới, ví dụ: `SchoolGiftShop`  
3. Chạy script trong **`createDB.sql`** để tạo bảng và quan hệ  
4. *(Tùy chọn)* Chạy **`queryDB.sql`** để thêm dữ liệu mẫu  

### 3. Cấu hình Chuỗi kết nối
Mở tệp `src/main/java/database/JDBCUtil.java`  
Cập nhật thông tin trong phương thức `getConnection()`:

java
String url = "jdbc:sqlserver://[SERVER_CUA_BAN]:1433;databaseName=school_giftshop;encrypt=true;trustServerCertificate=true;";
String user = "sa";
String password = "123456789";
## 🗂️ 3. Cấu trúc thư mục dự án
school-giftshop/
│
├── src/main/java/
│   ├── controller/       # Servlets (Controllers) xử lý logic chính
│   │   └── customer/     # Servlets cho khách hàng
│   ├── database/         # DAO và JDBCUtil
│   ├── model/            # Các lớp POJO (Plain Old Java Object)
│   │   └── transport/    # Models cho module giao vận (Node, Edge)
│   ├── service/          # Logic nghiệp vụ (DijkstraService)
│   └── util/             # Lớp tiện ích (Encryption)
│
├── src/main/webapp/
│   ├── account/          # JSP cho trang tài khoản
│   ├── customer/         # JSP cho khách hàng
│   ├── seller/           # JSP cho người bán
│   ├── transport/        # JSP & JS cho module giao vận
│   ├── uploads/          # Lưu hình ảnh sản phẩm (tạo thủ công)
│   ├── WEB-INF/
│   │   └── web.xml       # Cấu hình Servlet
│   ├── index.jsp         # Trang đăng nhập
│   └── register.jsp      # Trang đăng ký
│
├── createDB.sql          # Script tạo cơ sở dữ liệu
├── queryDB.sql           # Script thêm dữ liệu mẫu
└── pom.xml               # File cấu hình Maven
## ⚙️ 4. Build và Deploy

### Cách build dự án
1. Mở dự án trong IDE (Visual Studio Code, IntelliJ IDEA hoặc NetBeans).  
2. Cấu hình server Tomcat (phiên bản 10.x trở lên).  
3. Kết nối cơ sở dữ liệu MySQL (import file `schoolgiftshop.sql` vào phpMyAdmin).  
4. Cập nhật thông tin kết nối trong `DBConnect.java`.  

### Cách deploy
1. Build dự án → tạo file `.war`.  
2. Copy file `.war` vào thư mục `webapps` của Tomcat.  
3. Khởi động Tomcat, truy cập trình duyệt:  http://localhost:8080/SchoolGiftshop
