package shop.mtcoding.productapp_buyer.handler.ex;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    // 상태코드
    private HttpStatus status;

    // 생성자s
    public CustomException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
