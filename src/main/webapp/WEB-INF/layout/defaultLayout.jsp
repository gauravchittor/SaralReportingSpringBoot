<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
<table style="width:100%;height:100%">
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="header" />
        </td>
    </tr>
<!--     <tr>
    	
    </tr> -->
    <tr>
        <td>
            <tiles:insertAttribute name="menu" />
        </td>
  <%--       <td style=" width:20%;">
            <tiles:insertAttribute name="sideMenu" />
        </td> --%>
        <td style="height:100%;">
            <tiles:insertAttribute name="body" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>