package by.zborovskaya.task08.control.web;

import by.zborovskaya.task08.entity.Candy;
import by.zborovskaya.task08.servise.parser.CandiesBuilder;
import by.zborovskaya.task08.servise.parser.CandiesBuilderFactory;
import by.zborovskaya.task08.view.ViewCandy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(urlPatterns = "/parser")
public class Parser extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
//        //baeldung
//        ///*
//        String resourceName = "data" + File.separator + "candy.xsd";
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource(resourceName).getFile());
//        String absolutePath = file.getAbsolutePath();
//        //*/
//
//        ///*
//        String appPath = getServletContext().getRealPath("");
//        String SAVE_DIR = "WEB-INF" + File.separator + "classes" + File.separator +
//                "data" + File.separator + "candy.xml";
//        String savePath = appPath + File.separator + SAVE_DIR;
//        //*/
//
//        String type = "stax";
//        CandiesBuilder builder = CandiesBuilderFactory.createCandiesBuilder(type,absolutePath);
//        builder.buildSetCandies(savePath);
//        Set<Candy> candies=builder.getCandies();
//        //Try to get
//        // getServletContext().getContextPath()
//
//        //Set flowers = controller.executeTask(CommandName.XML_DOM.name()); ERROR
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
//        ViewCandy viewDOM = new ViewCandy(out, candies);
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
//        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
//        out.println("<title>DOM</title>");
//        out.println("<link href=\"assets/style.css\" rel=\"stylesheet\" type=\"text/css\"/>");
//        out.println("<link href=\"assets/bootstrap-4.3.1-dist/css/bootstrap.min.css\" " +
//                "rel=\"stylesheet\" type=\"text/css\"/>\n");
//        out.println("<link href=\"assets/bootstrap-4.3.1-dist/js/bootstrap.min.js\" " +
//                "rel=\"stylesheet\" type=\"text/css\"/>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<header>");
//        out.println("<h2>Candy catalog</h2>");
//        out.println("</header>");
//        out.println("<main>");
//        viewDOM.htmlShowResult();
//        out.println(getServletContext().getRealPath("") + "");
//        out.println("<br />Absolute <br />");
//        out.println(absolutePath);
//        out.println("</main>");
//        out.println("<h1>Hello World!</h1>");
//        out.println("</body>");
//        out.println("</html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String resourceName = "data" + File.separator + "candy.xsd";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourceName).getFile());
        String absolutePath = file.getAbsolutePath();
        String pathToFile = (String) request.getAttribute("currentFilePath");

        String type = (String) request.getAttribute("parserType");
        CandiesBuilder builder = CandiesBuilderFactory.createCandiesBuilder(type,absolutePath);
        builder.buildSetCandies(pathToFile);
        Set<Candy> candies=builder.getCandies();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        ViewCandy viewDOM = new ViewCandy(out, candies);
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>DOM</title>");
        out.println("<link href=\"assets/style.css\" rel=\"stylesheet\" type=\"text/css\"/>");
        out.println("<link href=\"assets/bootstrap-4.3.1-dist/css/bootstrap.min.css\" " +
                "rel=\"stylesheet\" type=\"text/css\"/>\n");
        out.println("<link href=\"assets/bootstrap-4.3.1-dist/js/bootstrap.min.js\" " +
                "rel=\"stylesheet\" type=\"text/css\"/>");
        out.println("</head>");
        out.println("<body>");
        out.println("<header>");
        out.println("<h2>Candies catalog</h2>");
        out.println("</header>");
        out.println("<main>");
        out.println(type);
        viewDOM.htmlShowResult();
        out.println("</main>");
        out.println("</body>");
        out.println("</html>");
    }

}
