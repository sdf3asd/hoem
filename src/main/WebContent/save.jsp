
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




<%

String id = request.getParameter("ID");
String lat = request.getParameter("LAT");
String lnt = request.getParameter("LNT");
String rEG_DT = request.getParameter("REG_DT");

String url="jdbc:mariadb://172.20.15.148:3306/db3";
String dbUserId="testuser3";
String dbPassword="zerobase";

try {
    Class.forName("org.mariadb.jdbc.Driver");
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}

Connection connection =null;
PreparedStatement preparedStatement =null;
ResultSet rs= null;



try {
    connection = DriverManager.getConnection(url, dbUserId, dbPassword);

    String sql = "insert into OUTPUT (ID, LAT,LNT,REG_DT)" +
            "value (?,?,?,now()); ";
            
            String sql2 = " SELECT * " +
        		  		  " FROM OUTPUT ";
            

        	
          
    preparedStatement = connection.prepareStatement(sql);
    preparedStatement = connection.prepareStatement(sql2);
    preparedStatement.setString(1, id);
    preparedStatement.setString(2, lat);
    preparedStatement.setString(3, lnt);
    preparedStatement.setString(4, rEG_DT);



   preparedStatement.executeUpdate();

   


} catch (SQLException e) {
    e.printStackTrace();
}finally {

    try{

        if(rs != null && !rs.isClosed()){
            rs.close();
        }
    }catch(SQLException e){
        e.printStackTrace();
    }

    try{
        if(preparedStatement != null && !preparedStatement.isClosed()){
            preparedStatement.close();
        }
    }catch(SQLException e){
        e.printStackTrace();
    }

    try{
        if(connection !=null && !connection.isClosed()){
            connection.close();
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
}
%>