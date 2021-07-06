    <%@ taglib prefix=  "c" uri=  "http://java.sun.com/jsp/jstl/core"  %>
<jsp:include page="adminHead.jsp"></jsp:include>

 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6" style="display:flex;justify-content:space-evenly;">
       		<a href="/admin/prop" style="text-align: center;width:250px !important;height:250px !important;"type="button" class="btn btn-danger">Appartments:<c:out value="${y }"></c:out></a>
            <a href="/admin/agents" style="text-align: center;width:250px !important;height:250px !important;"type="button" class="btn btn-primary">Agents:<c:out value="${x }"></c:out></a>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->



<jsp:include page="adminFooter.jsp"></jsp:include>