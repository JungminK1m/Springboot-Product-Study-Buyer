<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>

        <div class="container">
            <form action="/login" method="post" name="form">
                <div class="mb-3 mt-3">
                    <input type="text" class="form-control" placeholder="username" name="userName" />
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" placeholder="password" name="userPassword" />
                </div>
                <button type="submit" class="btn btn-primary">
                    로그인
                </button>

            </form>
            <button onclick="location.href='/joinForm'" ; class="btn btn-secondary mt-3">
                아직 회원이 아니신가요?
            </button>
        </div>

        <%@ include file="../layout/footer.jsp" %>