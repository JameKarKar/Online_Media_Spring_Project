<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">
    <h2 class="text-center my-4">Post Create Page</h2>

    <div class="col-md-8 offset-md-2 table-bordered">

    <form:form action="/author/post/create" method="post" modelAttribute="post" enctype="multipart/form-data">

        <div class="form-group my-3">
            <label for="title">Title</label>
            <form:input type="text" class="form-control" id="title" name="title" path="title"/>
        </div>

        <div class="form-group">
            <label for="cat_id">Category</label>
            <form:select class="form-control" id="cat_id" path="cat_id" name="cat_id">

                <c:forEach var="cat" items="${cats}">
                    <option value="${cat.id}">${cat.name}</option>
                </c:forEach>

            </form:select>
        </div>

        <div class="form-group">
            <label for="file">Post Image</label>
            <form:input type="file" class="form-control-file" id="file" path="file" name="file"/>
        </div>

        <div class="form-group">
            <label for="content">Content</label>
            <form:textarea class="form-control" id="content" rows="3" path="content" name="content"/>
        </div>

        <button type="submit" class="btn btn-primary mb-3">Create</button>

    </form:form>

    </div>

</div>