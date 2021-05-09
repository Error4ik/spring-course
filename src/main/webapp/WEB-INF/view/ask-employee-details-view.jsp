<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<body>
<div>
    <h2>Ask</h2>
    <div>
        <form:form action="show-details" modelAttribute="employee">
            Name <form:input path="name"/>
            <br><br><br>
            Surname <form:input path="surname"/>
            <br><br><br>
            Salary <form:input path="salary"/>
            <br><br><br>
            Department
            <form:select path="department">
                <%--                <form:option value="Information Technology" label="IT"/>--%>
                <%--                <form:option value="Human Resources" label="HR"/>--%>
                <%--                <form:option value="Sales" label="Sales"/>--%>
                <form:options items="${employee.departments}"/>
            </form:select>
            <br><br><br>
            <input type="submit" value="Ok">
        </form:form>
    </div>
</div>
</body>
</html>