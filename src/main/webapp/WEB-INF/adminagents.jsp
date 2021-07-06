
    <%@ taglib prefix=  "c" uri=  "http://java.sun.com/jsp/jstl/core"  %>
<jsp:include page="adminHead.jsp"></jsp:include>
 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6" style="display:flex;justify-content:space-evenly;">
       		<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">username</th>
      <th scope="col">email</th>
      <th scope="col">phonenumber</th>
      <th scope="col">Controll</th>

    </tr>
  </thead>
  <tbody>
  <c:forEach items="${agents }" var="agent">
    <tr>
      <th scope="row"><c:out value="${agent.getId() }"></c:out></th>
      <td><c:out value="${agent.getUsername() }"></c:out></td>
      <td><c:out value="${agent.getEmail() }"></c:out></td>
      <td><c:out value="${agent.getPhonenumber() }"></c:out></td>
      <!--  <td> <p> <a class="btn btn-danger" href="">Delete</a>  </p></td> -->
      <td> <form action="/adminagent/delete/${agent.getId()}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input class="btn btn-danger" type="submit" value="Delete">
</form></td>
    </tr>
</c:forEach>
  </tbody>
</table>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
<jsp:include page="adminFooter.jsp"></jsp:include>