<%@ page import="presentation.ReportView" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Yasi
  Date: 11/16/2017
  Time: 7:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;">
    <title>reportAccess</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link REL="StyleSheet" TYPE="text/css" HREF="style.css">
    <script src="util.js"></script>
</head>
<body>
<div align="center" style="margin-top: 50px;">
    <a href="/index.jsp">Home</a>
    <br><br>
    <%ReportView reportView = (ReportView) session.getAttribute("result");%>
    <%if (reportView != null){%>
    <div class="form-group" align="center">
        <select name="state" id="maxRows" class="form-control" style="width: 100px;">
            <option value="10">10</option>
            <option value="20">20</option>
            <option value="50">50</option>
            <option value="100">100</option>
        </select>
    </div>
    <div align="center" class="pagination-container">
        <nav>
            <ul class="pagination"></ul>
        </nav>
    </div>
    <div align="center" class="tg-wrap container">
        <div>
            <table id="resultTable" class="table table-bordered table-responsive table-hover tg">
                <caption>Types of Runways Per Country</caption>
                <thead>
                <tr>
                    <th class="tg-yw4l" scope="col">Country Name</th>
                    <th class="tg-yw4l" scope="col">Runway Type</th>
                </tr>
                </thead>
                <% Map<String,List> runwaysTypeByCountry = reportView.getRunwaysTypeByCountry();
                    for (Map.Entry obj: runwaysTypeByCountry.entrySet()){
                %>
                <tr>
                    <td class="tg"><%=obj.getKey()%></td>
                    <td class="tg"><%=obj.getValue()%></td>
                </tr>
                <%}%>
            </table>
        </div>
    </div>
    <%}%>
</div>

</body>
</html>
