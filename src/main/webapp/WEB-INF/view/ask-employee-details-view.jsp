<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<body>
<div>
    <h2>Ask</h2>
    <div>
        <form:form action="./show-details" modelAttribute="employee">
            Name <form:input path="name"/>
            <form:errors path="name"/>
            <br><br><br>
            Surname <form:input path="surname"/>
            <form:errors path="surname"/>
            <br><br><br>
            Email <form:input path="email"/>
            <form:errors path="email"/>
            <br><br><br>
            Salary <form:input path="salary"/>
            <form:errors path="salary"/>
            <br><br><br>
            Department
            <form:select path="department">
                <form:options items="${employee.departments}"/>
            </form:select>
            <br><br><br>
            Phone number
            <form:input path="phoneNumber"/>
            <for:errors path="phoneNumber"/>
            <br><br><br>
            Which car do you want?
            <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>
            <br><br><br>
            Foreign Language(s)
            <form:checkboxes path="languages" items="${employee.languagesMap}"/>
            <br><br><br>
            <input type="submit" value="Ok">
        </form:form>
    </div>
</div>
</body>
</html>