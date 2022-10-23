$(document).ready(function(){
	
	$.ajax({
		
		
		//ajax옵션 설정
		url:"http://openapi.seoul.go.kr:8088/6f6f5a416c776572353369766d6875/json/TbPublicWifiInfo/1/14497/",
		type:"GET",
		dataType:"json",
		
		//요청이 성공시 할 일 처리
		success:function(data){
			console.log(data.TbPublicWifiInfo.row);
			console.log(typeof data);
			
			data=JSON.stringify(data);
			console.log(typeof data);
			
			data=JSON.parse(data);
			console.log(typeof data);
			
			//할 일 처리
			let api_data="";
			$.each(data.TbPublicWifiInfo.row,function(key, value){
				
				api_data+="<tr>";
				api_data+="<td>"+ "" +"</td>";
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
				api_data+="<td>"+ value.WORK_DTTM  +"</td>";
				api_data+="</tr>";
				
			});
			
			
			//페이지단에 붙이기
			$('#member_table').append(api_data);
			
		}
		
		
	});
	
	
});