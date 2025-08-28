<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>모두 안녕!</title>
</head>
<body>
    <h1>반가워요!</h1>
    <form method="post">
        <select name="model">
            <option value="gemini-2.5-pro">Gemini 2.5 Pro</option>
            <option value="gemini-2.5-flash-lite">Gemini 2.5 Flash Lite</option>
            <option value="gemini-2.0-flash">Gemini 2.0 Flash</option>
        </select>
        <input name="question" placeholder="질문을 입력해보세요">
        <button>질문하기</button>
    </form>
    <p>
        <%= request.getAttribute("text") %>
    </p>
</body>
</html>