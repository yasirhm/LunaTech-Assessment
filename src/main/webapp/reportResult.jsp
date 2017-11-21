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
    <br><br>
    <%if(request.getAttribute("reportResult") != null && (boolean) request.getAttribute("reportResult")){%>
    <%ReportView reportView = (request.getAttribute("result") != null ? (ReportView) request.getAttribute("result") : null);%>
    <%if (reportView != null){%>
    <div align="center" class="tg-wrap container">

        <div  class="part1">
            <table class="table table-responsive table-hover tg">
                <caption>Type of Runways Per Country</caption>
                <thead>
                <tr>
                    <th class="tg-yw4l" scope="col"></th>
                    <th class="tg-yw4l" scope="col">Country Name</th>
                    <th class="tg-yw4l" scope="col">Runway Type</th>
                </tr>
                </thead>
                <% Map<String,List> runwaysTypeByCountry = reportView.getRunwaysTypeByCountry();
                    for (Map.Entry obj: runwaysTypeByCountry.entrySet()){
                %>
                <tr>
                    <td class="count"></td>
                    <td class="tg"><%=obj.getKey()%></td>
                    <td class="tg"><%=obj.getValue()%></td>
                </tr>
                <%}%>
            </table>
        </div>
        <div></div>
        <table align="left" style="margin-left: 35px">
            <tr>
                <td>
                </td>
                <td>
                    <div class="part2">
                        <table class="table table-responsive table-hover tg">
                            <caption>Countries WIth Highest Number of Airports</caption>
                            <thead>
                            <tr>
                                <th class="tg-yw4l" scope="col"></th>
                                <th class="tg-yw4l" scope="col">Country Name</th>
                                <th class="tg-yw4l" scope="col">Number of Airports</th>
                            </tr>
                            </thead>
                            <%for (Object object: reportView.getCountriesWithMaxAirports()){
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
                </td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <div class="part3"><br><br>
                        <table class="table table-responsive table-hover tg">
                            <caption>Countries WIth Lowest Number of Airports</caption>
                            <thead>
                            <tr>
                                <th class="tg-yw4l" scope="col"></th>
                                <th class="tg-yw4l" scope="col">Country Name</th>
                                <th class="tg-yw4l" scope="col">Number of Airports</th>
                            </tr>
                            </thead>
                            <%for (Object object: reportView.getCountriesWithMinAirports()){
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
                </td>

            </tr>
            <tr>
                <td></td>
                <td>
                    <div class="part4"><br><br>
                        <table class="table table-responsive table-hover tg">
                            <caption>Top 10 Most Common Runway Identifications</caption>
                            <thead>
                            <tr>
                                <th class="tg-yw4l" scope="col"></th>
                                <th class="tg-yw4l" scope="col">Identification</th>
                            </tr>
                            </thead>
                            <%for (Object object: reportView.getCommonRunwaysLeIdent()){
                                Object[] fields = (Object[]) object;
                            %>
                            <tr>
                                <td class="count"></td>
                                <td class="tg"><%=String.valueOf(fields[0])%></td>
                            </tr>
                            <%--<td class="tg"><%=String.valueOf(fields[1])%></td>--%>
                            <%}%>
                        </table>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <%}%>
    <%}%>
</div>

</body>
</html>
