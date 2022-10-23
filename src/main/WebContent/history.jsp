
<%@page import="db5.DBSTUDY"%>
<%@page import="db5.Service"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>위치 히스토리 목록</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style> 
 margin-top: 8px;

my-underline{
text-decoration:underline;
}

#member_table {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#member_table td, #member_table th {
  border: 1px solid #ddd;
  padding: 8px;
}

#member_table tr:nth-child(even){background-color: #f2f2f2;}

#member_table tr:hover {background-color: #ddd;}

#member_table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
table, td, th {
  border: 1px solid black;
   text-align: left;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th {
  height: 70px;
}
td{
  text-align: center;
}

th, td {
  padding: 1px;
}

h1{
text-align: left;

}

h2, h4, h6{
 color: hotpink;
 font-size:1px;
 text-decoration: underline;
 display:inline;
}
h3{
 color: solid black;
 font-size:1px;
 display:inline;
}
h5{
 color:solid black;
 font-size:1px;
}
a{
color:hotpink;
}
</style>
		
</head>

<body>
	<%

		 
		 Service service =new Service();
		 
		 List<DBSTUDY> OUTPUTList = service.list();
		 
	%>
<h1 span style="font-weight:bold">위치 히스토리 목록</h1 span>
<a href="http://localhost:8090/Api_Wifi/dataList.jsp">

<h2>홈</h2>
 
</a>
<h3> | </h3>
<a href="http://localhost:8090/Api_Wifi/history.jsp">

<h2>위치 히스토리 목록</h2>
 
</a>
<h3> | </h3>
<a href="http://localhost:8090/Api_Wifi/load-wifi.jsp">

<h2>Open API와이파이 정보 가져오기</h2>
 
</a>
<table id="member_table">
	<thead>
		<tr>	
			<th>ID</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>조회일자</th>
			<th>비고</th>
		</tr>		
		</thead>
		<tbody>
		<tr>
			<%
			
			for(DBSTUDY dbstudy : OUTPUTList) {
			%>
				<tr>
				<td> <%=dbstudy.getID() %></td>
				<td> <%=dbstudy.getLAT() %></td>
				<td> <%=dbstudy.getLNT() %></td>
				<td> <%=dbstudy.getREG_DT() %></td>
				<td> 
				<input type="button" value="삭제" onclick="document.location.href='delete.jsp?ID=<%=dbstudy.getID()%>'">
				</td>
				</tr>		
				
			<% 
				}
			
			%>
		</tr>
		</tbody>
	 </table>
</body>
</html>