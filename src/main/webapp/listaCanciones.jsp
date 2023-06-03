<%--
  Created by IntelliJ IDEA.
  User: romme
  Date: 1/06/2023
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Beans.Cancion" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaCancion"/>

<html>
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Lista de Canciones"/>
</jsp:include>
<body>
<div class='container'>
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="canciones"/>
  </jsp:include>

  <% if(request.getParameter("idBanda") == null){ %>
  <div class="pb-5 pt-4 px-3 titlecolor">
    <div class="row">
      <div class="col-lg-6">
        <h1 class='text-light'>Lista de Canciones</h1>
      </div>

    </div>
  </div>

  <% } else {%>
  <div class="pb-5 pt-4 px-3 titlecolor">
    <div class="row">
      <div class="col-lg-6">
        <h1 class='text-light'>Lista de Canciones por banda</h1>
      </div>
      <div class="col-lg-4 align-items-end">
        <a class="btn btn-warning" href="<%=request.getContextPath()%>/listaCanciones">Mostrar todas las canciones</a>
      </div>
    </div>
  </div>
  <%}%>

  <div class="tabla">
    <table class="table table-dark table-transparent table-hover">
      <thead>
      <th>ID</th>
      <th>CANCION</th>
      <th>BANDA</th>
      <th></th>
      <th></th>
      </thead>
      <%
        for (Cancion cancion : listaCancion) {
      %>
      <tr>
        <td><%=cancion.getIdCancion()%>
        </td>
        <td><%=cancion.getNombreCancion()%>
        </td>
        <td><%=cancion.getBanda()%>
        </td>
        <td>
          <a href="<%=request.getContextPath()%>/listaCanciones?action=favorito&idCancion=<%=cancion.getIdCancion()%>&favorito=<%=cancion.getFavorito()%>"><i class="bi <%=(cancion.getFavorito()==0)?"bi-heart-fill cr7":"bi-heart-fill mechi"%>"></i></a>
        </td>
        <td>
          <a href=""><i class="bi bi-plus-square"></i></a>
        </td>
      </tr>
      <%
        }
      %>
    </table>
  </div>

</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
