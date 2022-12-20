<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="./css/commons.css" />
  </head>

  <body>
    <%@ include file="navbars.jsp" %>
    <% 
    HashMap<String, String> searchForm = (HashMap<String, String>)request.getAttribute("searchForm"); 
    ArrayList<String> tablesListWithString = (ArrayList<String>)request.getAttribute("tablesListWithString");
    %>
    <div class="container">
      <div class="fs-3">Tables Normal <%= searchForm.get("search_key") %></div>
      <table class="table">
        <thead>
          <tr>
            <th scope="">#</th>
            <th scope="">Handle</th>
          </tr>
        </thead>
        <tbody>
        <% for(int i = 0; i < tablesListWithString.size(); i++){ %>
          <tr>
            <th scope=""><%= (i+1) %></th>
            <td><%= tablesListWithString.get(i) %></td>
          </tr>
          <% } %>
        </tbody>
      </table>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
