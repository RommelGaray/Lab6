package Servlets;

import Beans.Cancion;
import Beans.Tour;
import Daos.CancionDao;
import Daos.TourDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CancionServlet",urlPatterns = {"/listaCanciones"})
public class CancionServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionDao cancionDao = new CancionDao();
        String idBanda = request.getParameter("idBanda");
        String action =request.getParameter("action");
        //                no es nulo  -> caso contrario : listartodo
        if (idBanda!=null){
            ArrayList<Cancion> listaCancion = cancionDao.cancionesPorBanda(idBanda);
            request.setAttribute("listaCancion",listaCancion);
            RequestDispatcher view =request.getRequestDispatcher("listaCanciones.jsp");
            view.forward(request,response);

        } else if (action!=null) {
            switch (action) {
                case "favorito":
                    int idCancion = Integer.parseInt(request.getParameter("idCancion"));
                    int favorito = Integer.parseInt(request.getParameter("favorito"));

                    cancionDao.favorito(idCancion, favorito);
                    response.sendRedirect(request.getContextPath()+"/listaCanciones");
                    break;
                case "crear":
                    request.getRequestDispatcher("nuevaLista.jsp").forward(request, response);
                    break;


            }
        }else {
            ArrayList<Cancion> listaCancion = cancionDao.listaCanciones();
            request.setAttribute("listaCancion",listaCancion);
            RequestDispatcher view =request.getRequestDispatcher("listaCanciones.jsp");
            view.forward(request,response);
        }

    }

}
