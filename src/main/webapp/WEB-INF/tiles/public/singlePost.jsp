<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <div class="card">
        <img src="/assets/imgs/${posts.image}" alt="" class="card-img-top">
        <div class="card-body">
            <h5 class="card-title">${posts.title}</h5>
            <p class="card-text">${posts.content}</p>
        </div>
    </div>
</div>