# CRM Building Management

Hệ thống quản lý bất động sản cho thuê (CRM), xây dựng theo mô hình Single Page Application (SPA) với backend Spring Boot và frontend thuần HTML/JS.

---

## Công nghệ sử dụng

**Backend**
- Java 21
- Spring Boot 3.5
- Spring Security + JWT (jjwt 0.12.6)
- Spring Data JPA + Hibernate
- MySQL 8
- Lombok, ModelMapper

**Frontend**
- HTML/CSS/JavaScript (jQuery)
- Bootstrap + Ace Admin Template
- Font Awesome 4.5

---

## Cấu trúc dự án

```
src/main/java/com/BuildingWeb/
├── Present/        # REST Controllers & Web Controller
├── Service/        # Business logic (interface + impl)
├── Repository/     # JPA Repositories (bao gồm custom query)
├── Entity/         # JPA Entities ánh xạ database
├── DTO/            # Request/Response DTOs
├── Config/         # SecurityConfig, ModelMapperConfig
├── Builder/        # Builder pattern cho tìm kiếm tòa nhà
├── Converter/      # Chuyển đổi DTO <-> Entity
├── Exception/      # GlobalExceptionHandler, ErrorCode
├── Utils/          # Các tiện ích dùng chung
└── Application.java

src/main/resources/static/
├── index.html          # Layout chính (SPA shell)
├── Dashboard.html      # Trang tổng quan
├── Building.html       # Danh sách tòa nhà
├── InsertBuilding.html # Thêm tòa nhà
├── UpdateBuilding.html # Cập nhật tòa nhà
├── Customer.html       # Quản lý khách hàng
├── Transaction.html    # Lịch sử giao dịch
├── User.html           # Phân quyền hệ thống
├── Login.html          # Đăng nhập
└── Register.html       # Đăng ký
```

---

## Tính năng chính

| Module | Mô tả |
|---|---|
| Xác thực | Đăng nhập / Đăng ký, bảo mật bằng JWT |
| Tòa nhà | CRUD tòa nhà, tìm kiếm nâng cao, phân loại hạng A/B |
| Khách hàng | Quản lý khách hàng, giao khách cho nhân viên |
| Giao dịch | Theo dõi lịch sử giao dịch theo loại |
| Phân quyền | Quản lý user, gán role (ADMIN / MANAGER / STAFF) |
| Dashboard | Thống kê tòa nhà, KPI nhân viên |

---

## Phân quyền

| Role | Quyền truy cập |
|---|---|
| `ROLE_ADMIN` | Toàn bộ hệ thống, bao gồm phân quyền user |
| `ROLE_MANAGER` | Dashboard, tòa nhà, khách hàng, giao dịch |
| `ROLE_STAFF` | Tòa nhà, khách hàng được giao |

---

## Cài đặt & Chạy

### Yêu cầu
- Java 21+
- Maven
- MySQL 8

### Các bước

1. **Tạo database**
```sql
CREATE DATABASE db_building1;
```

2. **Cấu hình kết nối** trong `application-pro.properties`
```properties
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.url=${DB_URL}
```

3. **Build & chạy**
```bash
mvn spring-boot:run
```

4. **Truy cập**
```
http://localhost:8082
```

---

## API Endpoints chính

| Method | Endpoint | Mô tả |
|---|---|---|
| POST | `/api/auth/login` | Đăng nhập |
| POST | `/api/auth/register` | Đăng ký |
| GET/POST/PUT/DELETE | `/api/building/` | CRUD tòa nhà |
| GET | `/api/customer/` | Danh sách khách hàng |
| GET | `/api/transaction/` | Lịch sử giao dịch |
| GET | `/api/district/` | Danh sách quận |
| GET/POST | `/api/user/` | Quản lý user |
| POST | `/api/user/roles` | Gán role cho user |
