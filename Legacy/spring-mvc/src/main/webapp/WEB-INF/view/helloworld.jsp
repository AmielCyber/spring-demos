<!DOCTYPE html>
<html>
<body>
    Hello World of Spring!
    <br><br>
    <!-- Gets the params /processForm?studentName=...  // param ={studentName: ... } -->
    Student name: ${param.studentName}
    <br><br>
    <!-- Access an attribute from the model -->
    The message: ${message}

</body>
</html>
