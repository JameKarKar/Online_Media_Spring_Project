<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">

    <a href="/admin/cat/create" class="btn btn-sm btn-primary mb-4">Create <i class="fa fa-plus"></i></a>

    <table class="table table-bordered">
        <thead>
            <tr class="bg-dark text-white text-center">
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>

        <for:forEach var="cat" items="${cats}">
            <tr class="text-center">
                <td>${cat.id}</td>
                <td>${cat.name}</td>
                <td>
                    <a href="/admin/cat/edit/${cat.id}" class="btn btn-warning btn-sm"><i class="fa fa-edit"></i></a>
                    <a href="/admin/cat/delete/${cat.id}" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i></a>
                </td>
            </tr>
        </for:forEach>

        </tbody>

    </table>
</div>