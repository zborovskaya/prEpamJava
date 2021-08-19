<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 012 12.08.21
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Candy</title>
    <link href="assets/style.css" rel="stylesheet" type="text/css"/>
    <link href="assets/bootstrap-4.3.1-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/bootstrap-4.3.1-dist/js/bootstrap.min.js" rel="stylesheet" type="text/css"/>
    <style type="text/css">
      .borderApp {
        border-style: dashed;
        margin: 1rem;
        padding: 1.5rem;
      }
      .main-blocks {
        margin-top: 2rem;
        margin-bottom: 2rem;
      }
    </style>
  </head>
  <body>
    <header>
      <h2>Welcome to XML parser</h2>
    </header>
    <main>
        <form method="post" action="UploadServlet"
              enctype="multipart/form-data">
          <p>Select the type of parsing and the file you want to parse:</p>
          <div class="main-blocks">
            <input type="file" name="file" size="60" required />
          </div>
          <div class="main-blocks">
            <select name="parserType" title="Parser type"  required>
              <option value="dom">DOM</option>
              <option value="sax">SAX</option>
              <option value="stax">StAx</option>
            </select>
          </div>
          <div class="main-blocks">
            <input type="submit" value="Upload" />
          </div>
        </form>
    </main>
    <script src="assets/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
  </body>
</html>
