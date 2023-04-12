<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
        </head>

        <body>
            <h1>Test</h1>
            <tbody>
                <c:forEach items="${productList}" var="product">
                    <tr>
                        <td>${product.productId}</td>
                        <td>${product.productName}</a></td>
                        <td>${product.productPrice}원</td>
                        <td>${product.productQty}개</td>
                    </tr>
                </c:forEach>
            </tbody>

        </html>