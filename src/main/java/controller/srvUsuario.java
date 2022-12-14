package controller;

import model.DAOUSUARIO;
import model.usuarioVo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "srvUsuario", urlPatterns = {"/srvUsuario"})
public class srvUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "verificar":
                        verificar(request, response);
                        break;
                    case "cerrar":
                        cerrarsession(request, response);
                    default:
                        response.sendRedirect("/views/loginUsuario.jsp");
                }
            } else {
                response.sendRedirect("/views/loginUsuario.jsp");
            }
        } catch (Exception e) {
            try {
                this.getServletConfig().getServletContext().getRequestDispatcher("/mensaje.jsp").forward(request, response);

            } catch (Exception ex) {
                System.out.println("Error" + e.getMessage());
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void verificar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession sesion;
        DAOUSUARIO dao;
        usuarioVo usuario;
        usuario = this.obtenerUsuario(request);
        dao = new DAOUSUARIO();
        usuario = dao.identificar(usuario);
        if (usuario != null && usuario.getRol().getTiporol().equals("Gerente") && usuario.getEstadoUsuario().equals(true)) {
            sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            request.setAttribute("msje", "Bienvenido al sistema");
            System.out.println("Bienvenido Gerente");
            this.getServletConfig().getServletContext().getRequestDispatcher("/views/Usuario/peticionesUsuario.jsp").forward(request, response);
        }else if(usuario != null && usuario.getRol().getTiporol().equals("Operador") && usuario.getEstadoUsuario().equals(true)){
           sesion = request.getSession();
            sesion.setAttribute("Operador", usuario);
            System.out.println("Bienvenido Operador");
            this.getServletConfig().getServletContext().getRequestDispatcher("/operador.jsp").forward(request, response); 
        }else{
            request.setAttribute("msje", "Credenciales Incorrectas");
            System.out.println("El correo o la contrase??a no se encuentran");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
            
    }

    private void cerrarsession(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", null);
        sesion.invalidate();
        response.sendRedirect("/views/loginUsuario.jsp");
        
    }

    private usuarioVo obtenerUsuario(HttpServletRequest request) {
        usuarioVo u = new usuarioVo();
        u.setCorreoUsuario(request.getParameter("Correo"));
        u.setContrasenaUsuario(request.getParameter("Contrasena"));
        return u;
    }

}
