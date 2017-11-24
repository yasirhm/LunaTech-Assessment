<%--
  Created by IntelliJ IDEA.
  User: Yasi
  Date: 11/22/2017
  Time: 12:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error!</title>
</head>
<body>
<div style="width:100%;height:100%;">
    <a href="/index.jsp">Home</a>

    <table style="width:100%;height:40%;">
        <tr>
            <td align="center">
                <Span style="font-size: 40px;font-family: sans-serif;">${exception.message}</Span>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
