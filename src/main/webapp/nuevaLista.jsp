<%--
  Created by IntelliJ IDEA.
  User: romme
  Date: 3/06/2023
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Beans.Cancion" %>
<!--Talvez esto no vaya-->
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaCancion"/>

<html>
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value=""/>
</jsp:include>
<body>
<div class="container">
    <h1 class='mb-3'>Añadir canción a lista</h1>
    <form method="POST" action="<%=request.getContextPath()%>/listaCanciones">
        <div class="mb-3">
            <label for="listaNombre">Nombre lista</label>
            <input type="text" class="form-control" name="listaNombre" id="listaNombre">
        </div>

        <a class="btn btn-danger" href="<%=request.getContextPath()%>/listaCanciones">Cancelar</a>
        <button type="submit" class="btn btn-primary">Nueva Lista</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>
