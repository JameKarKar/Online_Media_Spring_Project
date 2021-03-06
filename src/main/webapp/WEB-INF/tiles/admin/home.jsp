<div class="container my-5">

    <h2 class="my-3 text-center text-success">Admin Page</h2>


        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <table class="table table-bordered">
            <thead>
            <tr class="bg-dark text-white">
                <th scope="col">Id</th>
                <th scope="col">Title</th>
                <th scope="col">Author</th>
                <th scope="col">Category</th>
                <th scope="col">Image</th>
                <th scope="col">Content</th>
                <th scope="col">Action</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach var="posts" items="${posts}">

                <tr>

                    <td>${posts.id}</td>
                    <td>${posts.title}</td>
                    <td>${posts.user.username}</td>
                    <td>${posts.category.name}</td>
                    <td>
                        <img src="/assets/imgs/${posts.image}" alt="" width="70" height="70">
                    </td>
                    <td>${posts.content}</td>
                    <td>
                        <a href="/author/post/edit/${posts.id}" class="btn btn-sm btn-warning"><i class="fa fa-edit"></i></a>
                        <a href="/author/post/delete/${posts.id}" class="btn btn-sm btn-danger"><i class="fa fa-trash"></i></a>
                    </td>

                </tr>

            </c:forEach>

            </tbody>
        </table>


</div>