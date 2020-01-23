<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container my-5">
    <h2 class="text-center">Register Form</h2>

    <div class="col-md-6 offset-md-3">
        <form:form action="/register" method="post" modelAttribute="user">
            <div class="form-group">
                <label for="username">Name</label>
                <form:input type="text" id="username" name="username" class="form-control" path="username"/>
                <form:errors path="username" class="text-danger"></form:errors>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <form:input type="email" id="email" name="email" class="form-control" path="email"/>
                <form:errors path="email" class="text-danger"></form:errors>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <form:input type="password" id="password" name="password" class="form-control" path="password"/>
                <form:errors path="password" class="text-danger"></form:errors>
            </div>

            <input type="submit" value="Submit" class="btn btn-sm btn-primary float-right"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form:form>
    </div>

</div>