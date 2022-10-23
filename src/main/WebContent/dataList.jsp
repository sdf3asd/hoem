<%@page import="db5.DBSTUDY"%>
<%@page import="java.util.List"%>
<%@page import="db5.Service2"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
	<title>와이파이 정보 구하기 </title>

		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
        $(document).ready(function(){ 
            $("#buttonSubmit").on('click',function(){ // 제출 버튼 이벤트 지정
                $.ajax({
                    url: "./save.jsp", // 목적지
                    type: "POST", // HTTP Method
                    data: $("#theForm").serialize(), // 전송 데이터
                    dataType: 'text', // 전송 데이터 형식
                    success: function(res){ // 성공 시 실행
                        $("#result_name").html(res.name);
                        $("#result_ph_number").html(res.ph_number);
                        $("#result_address").html(res.address);
                        
                        
              
                        
                    },
                    error:function(er){ //실패 시 실행
                        alert("실패 원인 : " + er);
                    }
                });
            });
        });
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
	 Service2 service =new Service2();
               		 
      List<DBSTUDY> CSV_DBList = service.list();
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
 <form id="theForm">
LAT : <input type="text" name="LAT">, LNT:  <input type="text" name="LNT"> <input type="submit" value="내위치가져오기">  <input id="buttonSubmit" type="button" value="근처 Wifi 정보 보기">
</foam>
 
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
			
			for(DBSTUDY dbstudy : CSV_DBList) {
			%>
				<tr>
			
				<td> <%=dbstudy.getX_SWIFI_MGR_NO() %></td>
				<td> <%=dbstudy.getX_SWIFI_WRDOFC() %></td>
				<td> <%=dbstudy.getX_SWIFI_MAIN_NM() %></td>
				<td> <%=dbstudy.getX_SWIFI_ADRES1() %></td>
				<td> <%=dbstudy.getX_SWIFI_ADRES2() %></td>
				<td> <%=dbstudy.getX_SWIFI_INSTL_FLOOR() %></td>
				<td> <%=dbstudy.getX_SWIFI_INSTL_TY() %></td>
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