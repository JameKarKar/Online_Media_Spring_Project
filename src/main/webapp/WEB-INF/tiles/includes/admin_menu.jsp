<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-5">


    <div class="btn-group" role="group" aria-label="Button group with nested dropdown">

        <div class="btn-group" role="group">
            <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Post
            </button>
            <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <a class="dropdown-item" href="/admin/home">Post All</a>
                <a class="dropdown-item" href="/author/post/create">Post Create</a>
            </div>
        </div>
    </div>

    <div class="btn-group" role="group" aria-label="Button group with nested dropdown">

        <div class="btn-group" role="group">
            <button id="btnGroupDrop2" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Category
            </button>
            <div class="dropdown-menu" aria-labelledby="btnGroupDrop2">
                <a class="dropdown-item" href="/admin/cat/all">Category All</a>
                <a class="dropdown-item" href=/admin/cat/create">Category Create</a>
            </div>
        </div>
    </div>

    <a href="/admin/user/all" class="btn btn-primary">All Users</a>

</div>