# AJAX Blog Demo

Đây là demo sử dụng jQuery AJAX để tương tác với API từ project blog.

## Cách sử dụng

### 1. Chạy project blog
```bash
cd ../blogg
./gradlew bootRun
```
Project blog sẽ chạy trên `http://localhost:8080`

### 2. Mở trang HTML
Mở file `index.html` trong trình duyệt hoặc sử dụng live server.

### 3. Tính năng

#### Tìm kiếm
- Nhập từ khóa vào ô tìm kiếm
- Chọn danh mục (nếu có)
- Nhấn "Tìm kiếm" hoặc Enter
- Kết quả sẽ hiển thị ngay lập tức mà không cần reload trang

#### Tải thêm
- Sau khi tìm kiếm, nếu còn nhiều kết quả
- Nhấn nút "Tải thêm" để xem thêm 20 bài viết tiếp theo
- Dữ liệu sẽ được append vào bảng hiện tại

#### Xóa bài viết
- Nhấn "Xóa" trong cột "Hành động"
- Xác nhận xóa
- Dữ liệu sẽ được cập nhật ngay lập tức

## API Endpoints

- `GET /blogs/search` - Tìm kiếm bài viết
- `GET /blogs/load-more` - Tải thêm bài viết
- `POST /blogs/delete/{id}` - Xóa bài viết

## Công nghệ sử dụng

- jQuery 3.6.0
- AJAX
- Spring Boot (backend)
- Thymeleaf (backend templates)
