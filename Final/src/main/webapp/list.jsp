<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>

<header th:insert="common/header.html"></header>
    <div class="container">
      <table class="table">
        <thead class="thead-light">
          <tr class="text-center">
            <th scope="col">#</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">작성일</th>
          </tr>
        </thead>
        <tbody>
          <tr class="text-center" th:each="post : ${postList}">
            <th scope="row">
              <span th:text="${post.id}"></span>
            </th>
            <td>
              <a th:href="@{'/post/' + ${post.id}}">
                <span th:text="${post.title}"></span>
              </a>
            </td>
            <td>
              <span th:text="${post.author}"></span>
            </td>
            <td>
              <span th:text="${#temporals.format(post.createdDate, 'yyyy-MM-dd HH:mm')}"></span>
            </td>
          </tr>
        </tbody>
      </table>
      <div class="row">
        <div class="col-auto mr-auto"></div>
        <div class="col-auto">
          <a class="btn btn-primary" th:href="@{/post}" role="button">글쓰기</a>
        </div>
      </div>
    </div>
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    
</body>
</html>