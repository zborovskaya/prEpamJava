package by.zborovskaya.task08.control.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/Controller")
public class Controller extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        String parserType = (String) request.getAttribute("parserType");
        String fileName = (String) request.getAttribute("fileName");

        String appPath = getServletContext().getRealPath("");
        String SAVE_DIR = "uploadData" + File.separator + fileName;
        String currentFilePath = appPath + SAVE_DIR;
        request.setAttribute("currentFilePath", currentFilePath);
        getServletContext().getRequestDispatcher("/parser")
                .forward(request, response);
//        if ("dom".equals(parserType)) {
//            getServletContext().getRequestDispatcher("/dom")
//                    .forward(request, response);
//
//        } else if ("sax".equals(parserType)) {
//            getServletContext().getRequestDispatcher("/sax")
//                    .forward(request, response);
//        } else if ("stax".equals(parserType)) {
//            getServletContext().getRequestDispatcher("/stax")
//                    .forward(request, response);
//        } //else {
        //  response.sendRedirect("/index.jsp");
        // }

    }
}
