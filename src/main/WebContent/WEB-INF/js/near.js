function setSeoulWifi(cWifi,WifiUrl){
		for(let i=1; i<=17000; i+=1000){
			$.ajax({
				url:"http://openapi.seoul.go.kr:8088/6f6f5a416c776572353369766d6875/json/TbPublicWifiInfo/"+i+"/"+(i+999),
				success:function(data){
					const WifiList = data.Wifi.row;
					WifiList.forEach(function(wifi, i) {
						setWifiMarker(wifi,cWifi,WifiUrl);
					})
				},
				error: function() {
					alert("서버에러");
				}		
			})
		}
	}