<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<body>
<div>
    <h2>All employees!</h2>
    <br>
    <div>
        <table>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Department</th>
                <th>Salary</th>
            </tr>
            <c:forEach var="emp" items="${employees}">
                <tr>
                    <td>${emp.name}</td>
                    <td>${emp.surname}</td>
                    <td>${emp.department}</td>
                    <td>${emp.salary}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br>
    <div>
        <input type="button" value="Add Employee" onclick="window.location.href='add-employee'">
    </div>
</div>
</body>
</html>