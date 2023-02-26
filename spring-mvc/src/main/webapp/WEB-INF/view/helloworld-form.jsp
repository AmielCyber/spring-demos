<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World - Input Form</title>
</head>
<body>
    <!-- Sends studentName to /processForm?studentName=... --->
    <form action="processFormVersionThree" method="GET">
        <input type="text" name="studentName" placeholder="What's your name?" />
        <input type="submit" />
    </form>
</body>
</html>
