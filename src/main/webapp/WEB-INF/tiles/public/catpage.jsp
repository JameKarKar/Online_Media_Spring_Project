<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">

    <div class="row">
        <c:forEach var="post" items="${posts}">
            <div class="col-md-3 mb-3">
                <div class="card">
                    <img src="/assets/imgs/${post.image}" alt="" class="card-img-top">
                    <div class="card-body">
                        <h5 class="card-title">${post.title}</h5>
                        <p class="card-text">${post.content}</p>
                        <a href="/singlePost/${post.id}" class="btn btn-primary btn-sm float-right">Details</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


</div>