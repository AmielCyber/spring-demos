<!-- MVC Form Tags Dependency -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
     <head>
         <title>Student Registration Form</title>
     </head>
    <body>
        <!-- Spring MVC Form Tags -->
        <!-- Pass the name of the Model Class -->
        <form:form action="processForm" modelAttribute="student">
            <!-- Path will be the model attribute name -->
            <!-- Form is loaded -> Spring MVC will call modelClass.get-->
            <!-- Form is submitted -> Spring MVC will call modelClass.set-->
            First name: <form:input path="firstName" />
            <br><br>
            Last name: <form:input path="lastName" />
            <br><br>
            Country:
            <form:select path="country">
                <--! from:option value="Germany" label="Germany" HARD CODED -->
                <--! Gets items from a hashed map -->
                <form:options items="${student.countryOptions}" />
            </form:select>
            <br><br>
            Favorite Language:
            Java <form:radiobutton path="favoriteLanguage" value="Java" />
            Node.js <form:radiobutton path="favoriteLanguage" value="Node.js" />
            C# <form:radiobutton path="favoriteLanguage" value="C#" />
            Go <form:radiobutton path="favoriteLanguage" value="Go" />
            <br><br>
            Operating Systems:
            Linux <form:checkbox path="operatingSystems" value="Linux" />
            Mac <form:checkbox path="operatingSystems" value="Mac" />
            Windows <form:checkbox path="operatingSystems" value="Windows" />

            <br><br>
            <input type="submit" value="Submit" />
        </form:form>
    </body>


</html>