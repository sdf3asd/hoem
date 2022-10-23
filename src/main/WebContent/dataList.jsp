
<%@page import="db5.Service"%>
<%@page import="db5.DBSTUDY"%>
<%@page import="db5.Service2"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Vector"%>
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
	<title>와이파이 정보 구하기 </title>

		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
	$(document).ready(function(){
	    $("#wth-form").submit(function(e){
	    e.preventDefault()
	    const LAT = this.LAT.value
	    const LNT = this.LNT.value
	    $.ajax({
	        url:"./list.jsp",
	        type : "get",
	        dataType: "json",
	        error: function(err){
	            console.errer(err.status)
	        },
	        success: function(result){
	         
	        	let api_data="";
				$.each(,function(key, value){
					
					api_data+="<tr>";
					api_data+="<td>"+ "" +"</td>";
					api_data+="<td>"+ value.distanse +"</td>";
					api_data+="<td>"+ value.X_SWIFI_MGR_NO +"</td>";
					api_data+="<td>"+ value.X_SWIFI_WRDOFC  +"</td>";
					api_data+="<td>"+ value.X_SWIFI_MAIN_NM  +"</td>";
					api_data+="<td>"+ value.X_SWIFI_ADRES1  +"</td>";
					api_data+="<td>"+ value.X_SWIFI_ADRES2  +"</td>";
					api_data+="<td>"+ "" +"</td>";
					api_data+="<td>"+ value.X_SWIFI_INSTL_TY  +"</td>"; //설치유형
					api_data+="<td>"+ value.X_SWIFI_INSTL_MBY  +"</td>";//설치기관
					api_data+="<td>"+ value.X_SWIFI_SVC_SE  +"</td>";//서비스구분
					api_data+="<td>"+ value.X_SWIFI_CMCWR  +"</td>"; //망종류
					api_data+="<td>"+ value.X_SWIFI_CNSTC_YEAR  +"</td>";//설치년도
					api_data+="<td>"+ value.X_SWIFI_INOUT_DOOR  +"</td>";//실내외구분
					api_data+="<td>"+ "" +"</td>"; 
					api_data+="<td>"+ value.LNT  +"</td>";
					api_data+="<td>"+ value.LAT  +"</td>";
					api_data+="<td>"+ value.REG_DT  +"</td>";
					api_data+="</tr>";
					
				});
				
				
				//페이지단에 붙이기
				$('#member_table').append(api_data);
	        }      
	    })
	})
	})

	</script>
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

	Service service = new Service();
	Vector<DBSTUDY> list = service.getAllDatas();
	    
	%>
	
<h1 span style="font-weight:bold">와이파이 정보 구하기</h1 span>
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
<form id="wth-form" method="post">
LAT : <input type="text" name="LAT">, LNT:  <input type="text" name="LNT"> <input type="submit" value="내위치가져오기"> <button id="req" type="submit"> "근처 Wifi 정보 보기" </button>
</form>
 
<thead>
	 <table id="member_table">
		<tr>
			<th>거리(Km)</th>
			<th>관리번호</th>
			<th>자치구</th>
			<th>와이파이명</th>
			<th>도로명주소</th>
			<th>상세주소</th>
			<th>설치위치(층)</th>
			<th>설치유형</th>
			<th>설치기관</th>
			<th>서비스구분</th>
			<th>망종류</th>
			<th>설치년도</th>
			<th>실내외구분</th>
			<th>WIFI접속환경</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>작업일자</th>
		</tr>		
		</thead>
	<tbody>
		<tr>
			<%
			for(int i =0; i<list.size(); i++)
			{	
				DBSTUDY dbstudy=list.get(i);  
			
			%>
				<tr>	
				<td><%= i+1 %></td>
				<td> <%=dbstudy.getDistance() %></td>
				<td> <%=dbstudy.getX_SWIFI_MGR_NO() %></td>
				<td> <%=dbstudy.getX_SWIFI_WRDOFC() %></td>
				<td> <%=dbstudy.getX_SWIFI_MAIN_NM() %></td>
				<td> <%=dbstudy.getX_SWIFI_ADRES1() %></td>
				<td> <%=dbstudy.getX_SWIFI_ADRES2() %></td>
				<td> <%=dbstudy.getX_SWIFI_INSTL_FLOOR() %></td>
				<td> <%=dbstudy.getX_SWIFI_INSTL_TY() %></td>
				<td> <%=dbstudy.getX_SWIFI_INSTL_MBY() %></td>
				<td> <%=dbstudy.getX_SWIFI_SVC_SE() %></td>
				<td> <%=dbstudy.getX_SWIFI_CMCWR() %></td>
				<td> <%=dbstudy.getX_SWIFI_CNSTC_YEAR() %></td>
				<td> <%=dbstudy.getX_SWIFI_INOUT_DOOR() %></td>
				<td> <%=dbstudy.getX_SWIFI_REMARS3() %></td>
				<td> <%=dbstudy.getLAT() %></td>
				<td> <%=dbstudy.getLNT() %></td>
		 		<td> <%=dbstudy.getREG_DT() %></td>
				</tr>	
			<% 
				}
			
			%>
		</tr>
	</tbody>
 </table>

	</body>
</html>