package by.zborovskaya.task08.servise.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(urlPatterns = "/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)   // 50MB
public class UploadServlet extends HttpServlet {
    /**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String UPLOAD_DATA_DIR = "uploadData";
    /**
     * handles file upload
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + UPLOAD_DATA_DIR;
        PrintWriter out = response.getWriter();
        out.println(savePath);
        String parserType = request.getParameter("parserType");
        //Get File name
        String preFileName = "";
        for(Part part : request.getParts()){
            //out.println("PN: "+ part.getName());
            Collection<String> headers = part.getHeaders("content-disposition");
            if (headers == null)
                continue;
            for(String header : headers) {
                if(header.contains("filename=")) {
                    preFileName = header;
                }
                //out.println("CDH: " + header);//CDH: form-data; name="file"; filename="HERE.xml"
            }
        }
        String[] splitBySpacePreFileName = preFileName.split(" ");
        String fileNameWithData = splitBySpacePreFileName[splitBySpacePreFileName.length - 1];
        String tempStr = fileNameWithData.substring(fileNameWithData.indexOf('"')+1);
        String finalFileName=tempStr.substring(0,tempStr.indexOf('"'));
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            if (!fileName.isEmpty()) {
                part.write(savePath + File.separator + fileName);
            }
        }
        request.setAttribute("fileName", finalFileName);
        request.setAttribute("parserType", parserType);
        getServletContext().getRequestDispatcher("/Controller")
                .forward(request, response);
    }

    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}

