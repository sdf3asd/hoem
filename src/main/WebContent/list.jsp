
<%@page import="db5.DBSTUDY"%>
<%@page import="db5.Service2"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	</head>
		
 <body>
  <% 
request.setCharacterEncoding("utf-8");
  
String LAT = request.getParameter("LAT");
String LNT = request.getParameter("LNT");


String url = "jdbc:mariadb://172.17.133.134:3306/Api_db";
String dbUserId = "testuser3";
String dbPassword = "zerobase";

try {
	Class.forName("org.mariadb.jdbc.Driver");
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}

PreparedStatement preparedStatement = null;
Connection connection = null;
ResultSet rs = null;



try {
	connection = DriverManager.getConnection(url,dbUserId,dbPassword);

	String sql = " select * " +
			" from csv_db1 "+
	        " where LAT =? AND LNT= ? ";
	   
		  

	preparedStatement = connection.prepareStatement(sql);

	rs = preparedStatement.executeQuery();

	while (rs.next()) {
		String distance = rs.getString("distance");
		String x_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
		String x_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
		String x_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
		String x_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
		String x_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
		String x_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_TY");
		String x_SWIFI_INSTL_TY = rs.getString("X_SWIFI_INSTL_FLOOR");
		String x_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
		String x_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
		String x_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
		String x_SWIFI_CNSTC_YEAR = rs.getString("X_SWIFI_CNSTC_YEAR");
		String x_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
		String x_SWIFI_REMARS3 = rs.getString("X_SWIFI_REMARS3");
		String lat = rs.getString("LAT");
		String lnt = rs.getString("LNT");
		String rEG_DT = rs.getString("REG_DT");
		

		DBSTUDY dbstudy = new DBSTUDY();
		
		dbstudy.setDistance(distance);
		dbstudy.setX_SWIFI_MGR_NO(x_SWIFI_MGR_NO);
		dbstudy.setX_SWIFI_WRDOFC(x_SWIFI_WRDOFC);
		dbstudy.setX_SWIFI_MAIN_NM(x_SWIFI_MAIN_NM);
		dbstudy.setX_SWIFI_ADRES1(x_SWIFI_ADRES1);
		dbstudy.setX_SWIFI_ADRES2(x_SWIFI_ADRES2);
		dbstudy.setX_SWIFI_INSTL_FLOOR(x_SWIFI_INSTL_FLOOR);
		dbstudy.setX_SWIFI_INSTL_TY(x_SWIFI_INSTL_TY);
		dbstudy.setX_SWIFI_INSTL_MBY(x_SWIFI_INSTL_MBY);
		dbstudy.setX_SWIFI_SVC_SE(x_SWIFI_SVC_SE);
		dbstudy.setX_SWIFI_CMCWR(x_SWIFI_CMCWR);
		dbstudy.setX_SWIFI_CNSTC_YEAR(x_SWIFI_CNSTC_YEAR);
		dbstudy.setX_SWIFI_INOUT_DOOR(x_SWIFI_INOUT_DOOR);
		dbstudy.setX_SWIFI_REMARS3(x_SWIFI_REMARS3);
		dbstudy.setLAT(lat);
		dbstudy.setLNT(lnt);
		dbstudy.setREG_DT(rEG_DT);
		

System.out.println(x_SWIFI_MGR_NO + "," + x_SWIFI_WRDOFC + "," + x_SWIFI_MAIN_NM +"," + x_SWIFI_ADRES1+ "," + x_SWIFI_ADRES2+ "," + x_SWIFI_INSTL_FLOOR+ "," + x_SWIFI_INSTL_TY+ "," + x_SWIFI_INSTL_MBY+ "," + x_SWIFI_SVC_SE+ "," + x_SWIFI_CMCWR+ "," + x_SWIFI_CNSTC_YEAR+ "," + x_SWIFI_INOUT_DOOR+ "," + x_SWIFI_REMARS3+ "," + lat+ "," + lnt+ "," + rEG_DT);

response.sendRedirect("dataList.jsp");


	}

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