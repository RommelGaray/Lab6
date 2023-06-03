<%--
  Created by IntelliJ IDEA.
  User: romme
  Date: 3/06/2023
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Beans.Cancion" %>

<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Nueva lista"/>
    </jsp:include>
<body>
<div class="container">
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value=""/>
    </jsp:include>
    <h1 class='mb-3 text-white'>Crear nueva lista</h1>
    <form method="POST" action="<%=request.getContextPath()%>/listaCanciones">
        <div class="mb-3">
            <label class="text-white" for="listaNombre">Nombre lista</label>
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
