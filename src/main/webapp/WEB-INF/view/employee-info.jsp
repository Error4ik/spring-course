<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<body>
<div>
    <h2>Employee Info!</h2>
    <br>
    <div>
        <form:form action="save-employee" modelAttribute="employee">
            <form:hidden path="id"/>

            Name
            <form:input path="name"/>
            <br><br>
            Surname
            <form:input path="surname"/>
            <br><br>
            Department
            <form:input path="department"/>
            <br><br>
            Salary
            <form:input path="salary"/>
            <br><br>
            <input type="submit" value="Add">
        </form:form>
    </div>
</div>
</body>
</html>