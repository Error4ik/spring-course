<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <th>Operations</th>
            </tr>
            <c:forEach var="emp" items="${employees}">
                <c:url var="updateButton" value="/update-info">
                    <c:param name="employeeId" value="${emp.id}"/>
                </c:url>
                <c:url var="deleteButton" value="/delete-employee">
                    <c:param name="employeeId" value="${emp.id}"/>
                </c:url>
                <tr>
                    <td>${emp.name}</td>
                    <td>${emp.surname}</td>
                    <td>${emp.department}</td>
                    <td>${emp.salary}</td>
                    <td>
                        <input type="button" value="update" onclick="window.location.href='${updateButton}'"/>
                        <input type="button" value="delete" onclick="window.location.href='${deleteButton}'"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br>
    <div>
        <input type="button" value="Add Employee" onclick="window.location.href='add-employee'"/>
    </div>
</div>
</body>
</html>