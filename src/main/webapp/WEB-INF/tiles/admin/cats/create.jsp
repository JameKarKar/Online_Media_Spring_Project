<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<div class="container my-5">

    <div class="col-md-6 offset-md-3">
        <form:form method="post" modelAttribute="category" action="/admin/cat/create">
            <div class="form-group">
                <label for="name">Category Name</label>
                <input:input path="name" type="text" id="name" name="name" class="form-control" ></input:input>
            </div>
            <button class="btn btn-primary btn-sm" type="submit">Create</button>
        </form:form>
    </div>
</div>