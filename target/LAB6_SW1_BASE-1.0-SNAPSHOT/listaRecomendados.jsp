<%--
  Created by IntelliJ IDEA.
  User: romme
  Date: 2/06/2023
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaRecomendados"/>


<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Reproducciones"/>
    </jsp:include>

    <body>
    <div class='container'>
        <jsp:include page="/includes/navbar.jsp">
            <jsp:param name="page" value="recomendaciones"/>
        </jsp:include>
        <div class="pb-5 pt-4 px-3 titlecolor">
            <div class="col-lg-6">
                <h1 class='text-light'>Lista de canciones Recomendadas</h1>
            </div>
        </div>
        <div class="tabla">
            <table class="table table-dark table-transparent table-hover">
                <thead>
                <th>ID</th>
                <th>CANCION</th>
                <th>BANDA</th>
                <th>Ver</th>
                </thead>
                <%
                    for (Cancion cancion : listaRecomendados) {
                %>
                <tr>
                    <td><%=cancion.getIdCancion()%>
                    </td>
                    <td><%=cancion.getNombreCancion()%>
                    </td>
                    <td><%=cancion.getBanda()%>
                    </td>
                    <td>
                        <a class="btn btn-success" href="<%=request.getContextPath()%>/listaCanciones?action=crear">Más de la banda</a>
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
