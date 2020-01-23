<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <h2 class="text-center">Show All Users</h2>

    <table class="table table-bordered my-3">
        <thead>
        <tr class="bg-dark text-white">
            <th scope="col">Id</th>
            <th scope="col">UserName</th>
            <th scope="col">Email</th>
            <th scope="col">Action</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach var="user" items="${users}">

            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>
                    <c:if test="${user.enabled}">
                        <a href="/admin/user/toggle/${user.id}" class="btn btn-sm btn-danger">Ban</a>
                    </c:if>
                    <c:if test="${!user.enabled}">
                        <a href="/admin/user/toggle/${user.id}" class="btn btn-sm btn-success">Active</a>
                    </c:if>
                </td>
<%--                <td>--%>
<%--                    <a href="/admin/user/edit/${user.id}" class="btn btn-sm btn-warning"><i class="fa fa-edit"></i></a>--%>
<%--                    <a href="/admin/user/delete/${user.id}" class="btn btn-sm btn-danger"><i class="fa fa-trash"></i></a>--%>
<%--                </td>--%>
            </tr>

        </c:forEach>

        </tbody>
    </table>




</div>