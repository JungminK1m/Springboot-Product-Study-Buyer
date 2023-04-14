<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>Product</title>
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1" />
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
            <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet" />
            <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet" />
            <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
        </head>
        <style>
            .gitlink {
                text-decoration-line: none;
                color: rgb(255, 105, 138);
                font-weight: bolder;
                background-color: rgb(255, 228, 154);
            }

            .center {
                display: flex;
                justify-content: center;
            }
        </style>

        <body>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <div class="container-fluid">
                    <h3 style="color: white;">🤍쇼핑몰🛒</h3>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapsibleNavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    // 로그인 안 했을 때 헤더
                    <c:choose>
                       <c:when test="${principal == null}">
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="/product">상품목록</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/">로그인</a>
                            </li>
                        </ul>
                    </div>
                       </c:when>
                    
                    // 로그인 했을 때 헤더
                    
                       <c:otherwise>
                       <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="/product">상품목록</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/orderListForm/${principal.userId}">주문확인</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/logout">로그아웃</a>
                            </li>
                        </ul>
                    </div>
                       </c:otherwise>
                    </c:choose>
                </div>
            </nav>
        </body>

        </html>