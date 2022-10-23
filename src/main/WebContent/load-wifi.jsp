<%@page import lombok.extern.slf4j.Slf4j %>
<%@page import org.apache.commons.csv.CSVFormat %>
<%@page import org.apache.commons.csv.CSVParser %>
<%@page import org.apache.commons.csv.CSVRecord %>
<%@page import java.io.BufferedReader %>
<%@page import java.io.File %>
<%@page import java.io.FileReader %>
<%@page import java.io.IOException %>
<%@page import java.sql.Connection %>
<%@page import java.sql.DriverManager %>
<%@page import java.sql.PreparedStatement %>
<%@page import java.sql.SQLException %>
<%@page import="db5.DBSTUDY"%>
<%@page import="java.util.List"%>
<%@page import="db5.Service2"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<style>
h1,h2{
 text-align: center;
}

</style>
<body>


<%
@Slf4j
public class CsvFileParseSaveToDB {

	private static String targetFilePath = "C:\\Users\\gram\\eclipse-workspace\\Api_Wifi\\src\\main\\WebContent";

	public static void main(String[] args) {

		//한글 깨지 방지를 위해서 characterEncoding=UTF-8 처리
		final String jdbcURL = "jdbc:mariadb://172.17.133.134:3306/Api_db?characterEncoding=UTF-8";
		final String username = "testuser3";
		final String password = "zerobase";

		final int batchSize =17_763; //bulk insert시 커밋 갯수

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(jdbcURL, username, password);
			connection.setAutoCommit(false);
		
			String sql = " INSERT INTO db1 (X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY,X_SWIFI_INSTL_MBY,X_SWIFI_SVC_SE,X_SWIFI_CMCWR,X_SWIFI_CNSTC_YEAR,X_SWIFI_INOUT_DOOR ,X_SWIFI_REMARS3, LAT, LNT ,WORK_DTTM " +
						" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

			PreparedStatement statement = connection.prepareStatement(sql);

			int columnSize = 16; //CSV 데이터 필드 컬럼 갯수

			List<CSVRecord> records = getCsvRecords();
			for (int row = 0; row < records.size(); row++) {

				CSVRecord data = records.get(row);
				for (int fieldIndex = 0; fieldIndex < columnSize; fieldIndex++) {
					statement.setString(fieldIndex + 1, data.get(fieldIndex));
				}

				statement.addBatch();
				if (row % batchSize == 0) {
					statement.executeBatch();
					System.out.println(String.format("statement.executeBatch ing row ==> %s", row));
					connection.commit(); //DB서버 부하분산을 원하는 대용량 처리시 중간중간 커밋

					sleep(1); //부하 분산
				}

			}

			//남아있는 데이터 처리
			System.out.println("나머지 데이터도 executeBatch ");
			statement.executeBatch();
			connection.commit();

			connection.close();

		} catch (IOException ex) {
			System.err.println(ex);
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private static void sleep(long millis) {

		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static List<CSVRecord> getCsvRecords() throws IOException {

		File targetFile = new File(targetFilePath);

		int sampleDataRow = 0; //샘플 데이터 row번호
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(targetFile))) {

			CSVParser parser = CSVFormat.EXCEL.withFirstRecordAsHeader().withQuote('"').parse(bufferedReader); //엑셀타입 & 쌍따옴표 escape처리
			List<CSVRecord> records = parser.getRecords();

			log.debug("\nCSV 헤더\n\t{}\n데이터 샘플\n\t{}\n", parser.getHeaderMap(), records.get(sampleDataRow));
			log.info("\n\t헤더 필드 갯수 :{}\n\t데이터 갯수 :{}\n\t{}번째 row의 데이터 필드 갯수:{}\n\n", parser.getHeaderMap().size(), records.size(), sampleDataRow,
				records.get(sampleDataRow).size());

			return records;
		}
	}

}
    
     

%>
<h1 span style="font-weight:bold">14497개의 WIFI정보를 정상적으로 저장하였습니다.</h1 span>
<a href="http://localhost:8080/Wifi_Api1/dataList.jsp">

<h2>홈으로가기</h2>
 
</a>

</body>
</html>