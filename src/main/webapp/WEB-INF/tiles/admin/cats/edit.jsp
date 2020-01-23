<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<div class="container my-5">

    <h2 class="text-center mb-4">Category Edit</h2>

    <div class="col-md-6 offset-md-3">
        <form:form method="post" modelAttribute="category" action="/admin/cat/edit/">
            <div class="form-group">
                <label for="name">Category Name</label>
                <form:input path="name" type="text" id="name" name="name" class="form-control" value="${category.name}"/>
            </div>
            <form:input path="id" type="hidden" name="id" value="${category.id}"/>
            <button class="btn btn-primary btn-sm" type="submit">Update</button>
        </form:form>
    </div>
</div>