<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="presentation.CountryView" %>
<%@ page import="presentation.AirportView" %>
<%@ page import="presentation.RunwayView" %>
<html lang="en" contentType="text/html  ؛">
<head>
    <meta http-equiv="Content-Type" content="text/html;">
    <title>Home Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link REL="StyleSheet" TYPE="text/css" HREF="style.css">
</head>
<body>

<div align="center" style="margin-top: 50px;">
    <div>
        <br><br>
        <form action="/countrySearch" method="post">
            <div class="form-group">
                <label for="countryName">Country Name</label>
                <input type="text" name="name" id="countryName">
                <label for="countryCode">Code</label>
                <input type="text" name="code" id="countryCode">
                <input type="submit" class="btn btn-default" value="search" onclick="inputCheck()">
            </div>
        </form>

        <form action="/getReport" method="post">
            <input type="submit" class="btn btn-default" value="Reports">
        </form>

        <%if(request.getAttribute("showResult") != null && (boolean) request.getAttribute("showResult")){%>
        <%CountryView countryView =  (request.getAttribute("result") != null ? (CountryView)request.getAttribute("result") : null);%>
            <%if (countryView != null){%>
                <div align="center" class="tg-wrap container">
                    <table class="table table-responsive table-hover tg">
                <caption>Airports of Country <%=countryView.getName()%></caption>
                <thead>
                <tr>
                    <th class="tg-yw4l" scope="col"></th>
                    <th class="tg-yw4l" scope="col">Name</th>
                    <th class="tg-yw4l" scope="col">Identification</th>
                    <th class="tg-yw4l" scope="col">Iso Region</th>
                    <th class="tg-yw4l" scope="col">Runways</th>
                </tr>
                </thead>
                <%for (AirportView airportView : countryView.getAirports()){%>
                <tr>
                    <td class="count"></td>
                    <td><%=airportView.getName()%></td>
                    <td><%=airportView.getIdent()%></td>
                    <td><%=airportView.getIsoRegion()%></td>
                    <td class="tg">
                        <%for (RunwayView runwayView : airportView.getRunways()){%>
                        <p><%=runwayView.getSurface()%></p>
                        <%}%>
                    </td>
                    <%--<td><%=airportView.getRunways().get(0).getSurface()%></td>--%>
                </tr>
                <%}%>
            </table>
                    <ul class="pagination">
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
            </ul>
                </div>
            <%}%>
        <%}%>
    </div>
</div>
<script type="text/javascript">
    function inputCheck() {
        var countryName = document.getElementById("countryName");
        var countryCode = document.getElementById("countryCode");
        if ((countryName == null || countryName.value() == "") && (countryCode == null || countryCode.value() == "")){
            alert("Please enter country name or country code.");
            return false;
        }
        else return true;
    }
</script>
</body>
</html>
