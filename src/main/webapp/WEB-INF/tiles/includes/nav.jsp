<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container-fluid bg-dark">
    <nav class="container navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand" href="/">
            <img src="/assets/imgs/001.jpg" alt="" height="30" width="30" class="rounded">
            <span class="text-white ml-3">Online Media</span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">


                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Posts
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                        <c:forEach var="cats" items="${cats}">
                        <a class="dropdown-item" href="/cat/${cats.id}">${cats.name}</a>
                        </c:forEach>
                    </div>
                </li>


                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Member
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                        <c:if test="${!pageContext.request.userPrincipal.authenticated}">
                            <a class="dropdown-item" href="/login">Login</a>
                            <a class="dropdown-item" href="/register">Register</a>
                        </c:if>

                        <c:if test="${pageContext.request.userPrincipal.authenticated}">
                            <c:url value="/logout" var="logoutUrl"/>
                            <form  action="${logoutUrl}" method="post" >
                                <input type="submit" value="logout" class="btn btn-default ml-2"/>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </c:if>
                    </div>
                </li>

                <c:if test="${pageContext.request.userPrincipal.authenticated}">
                    <li class="nav-item active">
                        <a href="/user/home" class="nav-link text-white">User Panel</a>
                    </li>
                </c:if>


                <li class="nav-item active">
                    <a href="/contact" class="nav-link text-white">Contact</a>
                </li>

            </ul>

        </div>
    </nav>

</div>