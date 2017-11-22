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
</head>
<body>
<div align="center" style="margin-top: 50px;">
    <a href="/index.jsp">Home</a>
    <br><br>
    <%if(request.getAttribute("reportResult") != null && (boolean) request.getAttribute("reportResult")){%>
    <%ReportView reportView = (request.getAttribute("result") != null ? (ReportView) request.getAttribute("result") : null);%>
    <%if (reportView != null){%>
    <a align="left" type="text" href="runwayTypesReport.jsp"> <h4>Next Report Page</h4></a>
    <div align="center" class="container">
        <div align="left" class="part1">
            <table class="table table-bordered table-responsive table-hover tg">
                <caption>Countries WIth Highest Number of Airports</caption>
                <thead>
                <tr>
                    <th class="tg-yw4l" scope="col"></th>
                    <th class="tg-yw4l" scope="col">Country Name</th>
                    <th class="tg-yw4l" scope="col">Number of Airports</th>
                </tr>
                </thead>
                <% if (!reportView.getCountriesWithMaxAirports().isEmpty())
                    for (Object object: reportView.getCountriesWithMaxAirports()){
                    Object[] fields = (Object[]) object;
                %>
                <tr>
                    <td class="count"></td>
                    <td class="tg"><%=String.valueOf(fields[0])%></td>
                    <td class="tg"><%=String.valueOf(fields[1])%></td>
                </tr>
                <%}%>
            </table>
        </div>

        <div class="part2" align="center">
            <table class="table table-bordered  table-responsive table-hover tg">
                <caption>Countries WIth Lowest Number of Airports</caption>
                <thead>
                <tr>
                    <th class="tg-yw4l" scope="col"></th>
                    <th class="tg-yw4l" scope="col">Country Name</th>
                    <th class="tg-yw4l" scope="col">Number of Airports</th>
                </tr>
                </thead>
                <%if (!reportView.getCountriesWithMinAirports().isEmpty())
                    for (Object object: reportView.getCountriesWithMinAirports()){
                    Object[] fields = (Object[]) object;
                %>
                <tr>
                    <td class="count"></td>
                    <td class="tg"><%=String.valueOf(fields[0])%></td>
                    <td class="tg"><%=String.valueOf(fields[1])%></td>
                </tr>
                <%}%>
            </table>
        </div>

        <div style="margin-top: -635px " class="part3">
            <table class="table table-bordered table-responsive table-hover tg">
                <caption>Top 10 Most Common Runway Identifications</caption>
                <thead>
                <tr>
                    <th class="tg-yw4l" scope="col"></th>
                    <th class="tg-yw4l" scope="col">Identification</th>
                </tr>
                </thead>
                <%if (!reportView.getCommonRunwaysLeIdent().isEmpty()){
                    for (Object object: reportView.getCommonRunwaysLeIdent()){
                    Object[] fields = (Object[]) object;
                %>
                <tr>
                    <td class="count"></td>
                    <td class="tg"><%=String.valueOf(fields[0])%></td>
                </tr>
                <%}}else {%>
                    <td class="tg"><%=reportView.getErrorMessage()%></td>
                <%}%>
            </table>
        </div>
    </div>
    <%}%>
    <%}%>
</div>

</body>
</html>
