
<%@page import="db5.DBSTUDY"%>
<%@page import="db5.Service"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
<html>

<head>
<meta charset="UTF-8">
<title>삭제 완료</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>	
h2 {
 color: hotpink;
 text-decoration: underline;

}
</style>	
	</head>

<body>

<a href="http://localhost:8090/Api_Wifi/history.jsp">
	<h2 font-size= "7">돌아가기</h2>
</a> 

<%
String id = request.getParameter("ID");

String url = "jdbc:mariadb://172.28.72.218:3306/db3";
String dbUserId = "testuser3";
String dbPassword = "zerobase";

try {
	Class.forName("org.mariadb.jdbc.Driver");
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}

Connection connection = null;
PreparedStatement preparedStatement = null;
ResultSet rs = null;

try {

	connection = DriverManager.getConnection(url, dbUserId, dbPassword);

	String sql = " delete from OUTPUT " + " where ID = ? ";

	preparedStatement = connection.prepareStatement(sql);

	preparedStatement.setString(1, id);

	preparedStatement.executeUpdate();

} catch (SQLException e) {
	e.printStackTrace();
} finally {

	try {

		if (rs != null && !rs.isClosed()) {
	rs.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	try {
		if (preparedStatement != null && !preparedStatement.isClosed()) {
	preparedStatement.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	try {
		if (connection != null && !connection.isClosed()) {
	connection.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
%>



</body>
</html>