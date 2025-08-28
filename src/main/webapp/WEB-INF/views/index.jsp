<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>모두 안녕!</title>
</head>
<body>
    <h1>반가워요!</h1>
    <form method="post">
        <input name="question" placeholder="질문을 입력해보세요">
        <button>질문하기</button>
    </form>
    <p>
        <%= request.getAttribute("text") %>
    </p>
</body>
</html>