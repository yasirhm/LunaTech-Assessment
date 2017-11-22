<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="presentation.CountryView" %>
<%@ page import="presentation.AirportView" %>
<%@ page import="presentation.RunwayView" %>
<html lang="en" contentType="text/html  ؛">
<head>
    <meta http-equiv="Content-Type" content="text/html;">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <title>Home Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <link type="text/css" rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/themes/base/jquery-ui.css" media="all"/>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
    <link REL="StyleSheet" TYPE="text/css" HREF="style.css">
    <script type="text/javascript" src="util.js"></script>
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
                <input type="submit" class="btn btn-default" value="search" onclick="validateInput()">
            </div>
        </form>

        <form action="/getReport" method="post">
            <input type="submit" class="btn btn-default" value="Reports">
        </form>

        <%if(request.getAttribute("showResult") != null && (boolean) request.getAttribute("showResult")){%>
        <%CountryView countryView =  (request.getAttribute("countryView") != null ? (CountryView)request.getAttribute("countryView") : null);%>
            <%if (countryView != null){%>
                <div align="center" class="tg-wrap container">
                    <div align="center">
                        <ul class="pagination">
                            <li>
                                <c:if test="${currentPage != 1}">
                                    <a href="countrySearcht?pageNumber=${1}">FirstPage</a>
                                </c:if>
                            </li>
                            <li>
                                <c:if test="${currentPage != 1}">
                                    <a href="countrySearch?pageNumber=${currentPage - 1}">Previous</a>
                                </c:if>
                            </li>

                            <c:if test="${noOfPages != 1}">
                                <c:forEach begin="${firstPageIndex}" end="${lastPageIndex}" var="i">
                                    <li>
                                    <c:choose>
                                        <c:when test="${currentPage eq i}">
                                            <li><a>${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="countrySearch?pageNumber=${i}">${i}</a>
                                        </c:otherwise>
                                    </c:choose>
                                    </li>
                                </c:forEach>
                            </c:if>
                            <li>
                                <c:if test="${currentPage lt noOfPages}">
                                    <a href="countrySearch?pageNumber=${currentPage + 1}">Next</a>
                                </c:if>
                            </li>
                            <li>
                                <c:if test="${currentPage lt noOfPages}">
                                    <a href="countrySearch?pageNumber=${noOfPages}">LastPage</a>
                                </c:if>
                            </li>
                        </ul>
                    </div>

                    <table class="table table-bordered table-responsive table-hover tg">
                        <caption>Airports of Country <%=countryView.getName()%> - Code: <%=countryView.getCode()%></caption>
                        <thead>
                        <tr>
                            <th class="tg-yw4l" scope="col">Name</th>
                            <th class="tg-yw4l" scope="col">Identification</th>
                            <th class="tg-yw4l" scope="col">Iso Region</th>
                            <th class="tg-yw4l" scope="col">Runway Types</th>
                        </tr>
                        </thead>
                        <c:forEach var="airportView" items="${countryView.airportViews}">
                            <tr>
                                <td>${airportView.name}</td>
                                <td>${airportView.ident}</td>
                                <td>${airportView.isoRegion}</td>
                                <td colspan="3">
                                    <c:forEach var="RunwayView" items="${airportView.runways}">
                                        ${RunwayView.surface}
                                        <br>
                                    </c:forEach>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            <%}%>
        <%}%>
    </div>
    <br><br>
</div>
</body>
</html>
