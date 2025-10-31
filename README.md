Dự án School Giftshop (Cửa hàng Quà tặng Trường học)

Đây là một dự án ứng dụng web thương mại điện tử được xây dựng bằng Java Servlet/JSP, mô phỏng một cửa hàng quà tặng trực tuyến. Dự án hỗ trợ nhiều vai trò người dùng bao gồm Khách hàng, Người bán và Người vận chuyển, với một hệ thống quản lý sản phẩm, giỏ hàng, đơn hàng và một module tối ưu hóa giao hàng.

Tính năng chính

Dự án được phân chia thành các module chức năng dựa trên vai trò người dùng:

1. Chức năng chung

Xác thực: Đăng ký và Đăng nhập cho tất cả các vai trò.

Bảo mật: Mã hóa mật khẩu (sử dụng util.Encryption).

2. Khách hàng (Customer)

Trang chủ: Duyệt xem sản phẩm, tìm kiếm và lọc sản phẩm theo danh mục.

Chi tiết sản phẩm: Xem thông tin chi tiết, hình ảnh và giá của sản phẩm.

Giỏ hàng: Thêm, xóa, cập nhật số lượng sản phẩm trong giỏ hàng.

Danh sách yêu thích (Wishlist): Thêm hoặc xóa sản phẩm khỏi danh sách yêu thích.

Thanh toán: Thực hiện quy trình đặt hàng và thanh toán.

Quản lý đơn hàng: Xem lịch sử các đơn hàng đã đặt.

Quản lý tài khoản: Cập nhật thông tin cá nhân và thay đổi mật khẩu.

3. Người bán (Seller)

Dashboard: Giao diện quản lý riêng cho người bán.

Quản lý sản phẩm (CRUD): Thêm, xem, cập nhật và xóa sản phẩm.

Quản lý hình ảnh: Tải lên nhiều hình ảnh cho sản phẩm.

Quản lý đơn hàng: Xem và xử lý các đơn hàng của khách hàng.

Báo cáo: Xem báo cáo thống kê (doanh thu, sản phẩm bán chạy - seller/report.jsp).

4. Giao vận (Transport)

Bản đồ địa chỉ: Hệ thống quản lý các địa điểm (Nodes) và các tuyến đường (Edges) giữa chúng.

Tối ưu hóa đường đi: Sử dụng Thuật toán Dijkstra (service.DijkstraService) để tìm đường đi ngắn nhất từ kho hàng (hoặc người bán) đến địa chỉ của khách hàng.

Quản lý giao hàng: Xem bản đồ các đơn hàng và cập nhật trạng thái địa chỉ.

Công nghệ sử dụng

Ngôn ngữ Backend: Java (JDK 11+)

Framework/Công nghệ Web: Java Servlets, JSP (JavaServer Pages), JSTL

Cơ sở dữ liệu: Microsoft SQL Server (sử dụng driver mssql-jdbc)

Quản lý dự án & Build: Apache Maven

Frontend: JSP, JavaScript (cho logic bản đồ giao vận)

Thư viện chính:

jakarta.servlet-api: Xử lý các request/response web.

GSON: Xử lý dữ liệu JSON (dùng cho module bản đồ/giao vận).

commons-fileupload2: Xử lý việc tải lên tệp (hình ảnh sản phẩm).

angus-mail: Gửi email (có thể dùng cho xác nhận đăng ký hoặc đơn hàng).

Cài đặt và Chạy dự án

Để chạy dự án này trên máy cục bộ của bạn, hãy làm theo các bước sau:

1. Yêu cầu

JDK (Java Development Kit) 11 hoặc cao hơn.

Apache Maven.

Microsoft SQL Server.

Một Servlet Container (Apache Tomcat 10.1+).

2. Cấu hình Cơ sở dữ liệu

Mở Microsoft SQL Server Management Studio (SSMS).

Tạo một cơ sở dữ liệu mới (ví dụ: SchoolGiftShop).

Chạy script SQL trong tệp createDB.sql để tạo tất cả các bảng và quan hệ cần thiết.

(Tùy chọn) Chạy queryDB.sql nếu bạn có dữ liệu mẫu muốn thêm vào.

3. Cấu hình Chuỗi kết nối

Mở tệp src/main/java/database/JDBCUtil.java.

Tìm đến phương thức getConnection().

Cập nhật biến url với thông tin kết nối đến cơ sở dữ liệu MS SQL Server của bạn (tên server, port, tên database, user, password).

// Ví dụ trong JDBCUtil.java
String url = "jdbc:sqlserver://[SERVER_CUA_BAN]:1433;databaseName=school_giftshop;encrypt=true;trustServerCertificate=true;";
String user = "sa";
String password = "123456789";


4. Build và Deploy

Mở Terminal hoặc Command Prompt tại thư mục gốc của dự án (nơi có tệp pom.xml).

Chạy lệnh Maven để build dự án thành tệp .war:

mvn clean package


Sau khi build thành công, bạn sẽ tìm thấy tệp school-giftshop-0.0.1-SNAPSHOT.war (hoặc tương tự) trong thư mục target/.

Deploy tệp .war này lên Apache Tomcat (bằng cách sao chép vào thư mục webapps/ của Tomcat hoặc deploy qua giao diện quản lý của Tomcat).

Khởi động Tomcat và truy cập dự án qua trình duyệt (thường là http://localhost:8080/school-giftshop-0.0.1-SNAPSHOT/).

Cấu trúc Thư mục

school-giftshop/
│
├── src/main/java/
│   ├── controller/   # Servlets (Controllers) xử lý logic chính
│   │   └── customer/ # Servlets cho khách hàng
│   ├── database/     # Lớp DAO (Data Access Object) và JDBCUtil
│   ├── model/        # Các lớp POJO (Plain Old Java Object)
│   │   └── transport/  # Models cho module giao vận (Node, Edge)
│   ├── service/      # Logic nghiệp vụ (DijkstraService)
│   └── util/         # Các lớp tiện ích (Encryption)
│
├── src/main/webapp/
│   ├── account/      # JSP cho trang tài khoản (thông tin, đổi mật khẩu)
│   ├── customer/     # JSP cho các trang của khách hàng
│   ├── seller/       # JSP cho các trang của người bán
│   ├── transport/    # JSP và JS cho module giao vận
│   ├── uploads/      # Thư mục lưu trữ hình ảnh sản phẩm (cần tạo)
│   ├── WEB-INF/
│   │   └── web.xml   # File cấu hình Servlet (Deployment Descriptor)
│   ├── index.jsp     # Trang đăng nhập
│   └── register.jsp  # Trang đăng ký
│
├── createDB.sql      # Script khởi tạo cơ sở dữ liệu
├── queryDB.sql       # Script truy vấn (hoặc thêm dữ liệu mẫu)
└── pom.xml           # File cấu hình Maven
