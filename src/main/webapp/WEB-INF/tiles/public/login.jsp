<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">

    <c:if test="${!empty error}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong class="text-center">${error}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <c:if test="${!empty logout}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong class="text-center">${logout}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <c:if test="${!empty register_success}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <strong class="text-center">${register_success}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <h2 class="text-center">Login Form</h2>

    <div class="col-md-6 offset-md-3">
        <form action="<c:url value="/j_spring_security_check"/>" method="post">
            <div class="form-group">
                <label for="username">Name</label>
                <input type="text" id="username" name="username" class="form-control" />
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" class="form-control" />
            </div>

            <input type="submit" value="Submit" class="btn btn-sm btn-primary float-right"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>

</div>