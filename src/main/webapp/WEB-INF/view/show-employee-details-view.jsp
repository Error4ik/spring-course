<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<body>
<div>
    <div>
        <h2>
            Your name: ${employee.name}
        </h2>
    </div>
    <div>
        <h2>
            Your surname: ${employee.surname}
        </h2>
    </div>
    <div>
        <h2>
            Your salary: ${employee.salary}
        </h2>
    </div>
    <div>
        <h2>
            Your department: ${employee.department}
        </h2>
    </div>
    <div>
        <h2>
            Your Car: ${employee.carBrand}
        </h2>
    </div>
    <div>
        <h2>
            Your foreign language(s):
        </h2>
        <ul>
            <c:forEach var="lang" items="${employee.languages}">
                <li>${lang}</li>
            </c:forEach>
        </ul>
    </div>
    <div>
        <h2>
            Your phone number: ${employee.phoneNumber}
        </h2>
    </div>
    <div>
        <h2>
            Your email: ${employee.email}
        </h2>
    </div>
</div>
</body>
</html>