
    <%@ taglib prefix=  "c" uri=  "http://java.sun.com/jsp/jstl/core"  %>
<jsp:include page="adminHead.jsp"></jsp:include>
 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header" style="margin-left:165px">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6" style="display:flex;justify-content:space-evenly;">
       		<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">buildingName</th>
      <th scope="col">address</th>
      <th scope="col">price</th>
      <th scope="col">area</th>
      <th scope="col">host</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
 <c:forEach items="${apartments}" var="proparities">
    <tr>
      <!--  <th scope="row">1</th> -->
       <th scope="row"><c:out value="${proparities.getId() }"></c:out></th>
      <td><c:out value="${proparities.getBuildingName() }"/></td>
      <td><c:out value="${proparities. getAddress()}"/></td>
      <td><c:out value="${proparities. getPrice()}"/></td>
      <td><c:out value="${proparities. getArea()}"/></td>
       <td><c:out value="${proparities.getHost()}"/></td>
       
         <!--   <td> <p> <a class="btn btn-danger" href="/adminprop/delete/${proparities.id}">Delete</a></p></td> -->
    <td> <form action="/adminprop/delete//${proparities.id}" method="post">
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