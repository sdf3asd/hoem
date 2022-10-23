package db5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service2 {

	public List<DBSTUDY> list() {

		List<DBSTUDY> CSV_DBList = new ArrayList<>();

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
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = " select * " +
				     " from db1 ";
				  

			preparedStatement = connection.prepareStatement(sql);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
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
				
				dbstudy.setLAT(x_SWIFI_MGR_NO);
				dbstudy.setLNT(x_SWIFI_WRDOFC);
				dbstudy.setREG_DT(x_SWIFI_MAIN_NM);
				dbstudy.setID(x_SWIFI_ADRES1);
				dbstudy.setLAT(x_SWIFI_ADRES2);
				dbstudy.setLNT(x_SWIFI_INSTL_FLOOR);
				dbstudy.setREG_DT(x_SWIFI_INSTL_TY);
				dbstudy.setID(x_SWIFI_INSTL_MBY);
				dbstudy.setLAT(x_SWIFI_SVC_SE);
				dbstudy.setLNT(x_SWIFI_CMCWR);
				dbstudy.setREG_DT(x_SWIFI_CNSTC_YEAR);
				dbstudy.setID(x_SWIFI_REMARS3);
				dbstudy.setLAT(lat);
				dbstudy.setLNT(lnt);
				dbstudy.setREG_DT(rEG_DT);

				
				CSV_DBList.add(dbstudy);

System.out.println(x_SWIFI_MGR_NO + "," + x_SWIFI_WRDOFC + "," + x_SWIFI_MAIN_NM +"," + "," + x_SWIFI_ADRES1
+ "," + x_SWIFI_ADRES2+ "," + x_SWIFI_INSTL_FLOOR+ "," + x_SWIFI_INSTL_TY+ "," + x_SWIFI_INSTL_MBY+ "," + x_SWIFI_SVC_SE+ "," + x_SWIFI_CMCWR
+ "," + x_SWIFI_CNSTC_YEAR+ "," + x_SWIFI_INOUT_DOOR+ "," + "," + x_SWIFI_REMARS3+ "," + lat+ "," + lnt+ "," + rEG_DT);

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

		return CSV_DBList;

	}

		public List<DBSTUDY> insert() {

			List<DBSTUDY> CSV_DBList = new ArrayList<>();

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
				connection = DriverManager.getConnection(url, dbUserId, dbPassword);

				String sql = " INSERT INTO db1 VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
					  

				preparedStatement = connection.prepareStatement(sql);

				rs = preparedStatement.executeQuery();

				while (rs.next()) {
					
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
					
					dbstudy.setLAT(x_SWIFI_MGR_NO);
					dbstudy.setLNT(x_SWIFI_WRDOFC);
					dbstudy.setREG_DT(x_SWIFI_MAIN_NM);
					dbstudy.setID(x_SWIFI_ADRES1);
					dbstudy.setLAT(x_SWIFI_ADRES2);
					dbstudy.setLNT(x_SWIFI_INSTL_FLOOR);
					dbstudy.setREG_DT(x_SWIFI_INSTL_TY);
					dbstudy.setID(x_SWIFI_INSTL_MBY);
					dbstudy.setLAT(x_SWIFI_SVC_SE);
					dbstudy.setLNT(x_SWIFI_CMCWR);
					dbstudy.setREG_DT(x_SWIFI_CNSTC_YEAR);
					dbstudy.setID(x_SWIFI_REMARS3);
					dbstudy.setLAT(lat);
					dbstudy.setLNT(lnt);
					dbstudy.setREG_DT(rEG_DT);

					
					CSV_DBList.add(dbstudy);

	System.out.println(x_SWIFI_MGR_NO + "," + x_SWIFI_WRDOFC + "," + x_SWIFI_MAIN_NM +"," + "," + x_SWIFI_ADRES1
	+ "," + x_SWIFI_ADRES2+ "," + x_SWIFI_INSTL_FLOOR+ "," + x_SWIFI_INSTL_TY+ "," + x_SWIFI_INSTL_MBY+ "," + x_SWIFI_SVC_SE+ "," + x_SWIFI_CMCWR
	+ "," + x_SWIFI_CNSTC_YEAR+ "," + x_SWIFI_INOUT_DOOR+ "," + "," + x_SWIFI_REMARS3+ "," + lat+ "," + lnt+ "," + rEG_DT);

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

			return CSV_DBList;

		}
}



//     public void register(DBSTUDY dbstudy){  String url="jdbc:mariadb://172.17.133.134:3306/tesuser3";
//         String dbUserId="testuser3";
//         String dbPassword="zerobase";
//
//         try {
//             Class.forName("org.mariadb.jdbc.Driver");
//         } catch (ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//
//         Connection connection =null;
//         PreparedStatement preparedStatement =null;
//         ResultSet rs= null;
//
//
//
//         try {
//             connection = DriverManager.getConnection(url, dbUserId, dbPassword);
//
//             String sql = " INSERT INTO db1 VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
//         
//             preparedStatement = connection.prepareStatement(sql);
//             preparedStatement.setString(1, dbstudy.getX_SWIFI_MGR_NO());
//             preparedStatement.setString(2, dbstudy.getX_SWIFI_WRDOFC());
//             preparedStatement.setString(3, dbstudy.getX_SWIFI_MAIN_NM());
//             preparedStatement.setString(4, dbstudy.getX_SWIFI_ADRES1());
//             preparedStatement.setString(5, dbstudy.getX_SWIFI_ADRES2());
//             preparedStatement.setString(6, dbstudy.getX_SWIFI_INSTL_FLOOR());
//             preparedStatement.setString(7, dbstudy.getX_SWIFI_INSTL_TY());
//             preparedStatement.setString(8, dbstudy.getX_SWIFI_INSTL_MBY());
//             preparedStatement.setString(9, dbstudy.getX_SWIFI_SVC_SE());
//             preparedStatement.setString(10, dbstudy.getX_SWIFI_CMCWR());
//             preparedStatement.setString(11, dbstudy.getX_SWIFI_CNSTC_YEAR());
//             preparedStatement.setString(12, dbstudy.getX_SWIFI_INOUT_DOOR());
//             preparedStatement.setString(13, dbstudy.getX_SWIFI_REMARS3());
//             preparedStatement.setString(14, dbstudy.getLAT());
//             preparedStatement.setString(15, dbstudy.getLNT());
//             preparedStatement.setString(16, dbstudy.getWORK_DTTM());
//            
//             
//             preparedStatement.executeUpdate();
//
//         
//
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }finally {
//
//             try{
//
//                 if(rs != null && !rs.isClosed()){
//                     rs.close();
//                 }
//             }catch(SQLException e){
//                 e.printStackTrace();
//             }
//
//             try{
//                 if(preparedStatement != null && !preparedStatement.isClosed()){
//                     preparedStatement.close();
//                 }
//             }catch(SQLException e){
//                 e.printStackTrace();
//             }
//
//             try{
//                 if(connection !=null && !connection.isClosed()){
//                     connection.close();
//                 }
//             }catch (SQLException e){
//                 e.printStackTrace();
//             }
//         }
//     }
//}
//
//
//     }
//
//    public void dbUpdate(){  String url="jdbc:mariadb://172.25.75.55:3306/db3";
//        String dbUserId="testuser3";
//        String dbPassword="zerobase";
//
//        try {
//            Class.forName("org.mariadb.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Connection connection =null;
//        PreparedStatement preparedStatement =null;
//        ResultSet rs= null;
//
//        String idValue="2";
//        String latValue="127.04713";
//        String lntValue="37.483387";
//
//
//
//        try {
//            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
//
//            String sql = "insert into DBOUT2 (ID, LAT,LNT)" +
//                    "value (?,?,?); ";
//
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, idValue);
//            preparedStatement.setString(2, latValue);
//            preparedStatement.setString(3, lntValue);
//
//
//            int affected=preparedStatement.executeUpdate();
//
//            if(affected>0){
//                System.out.println("저장 성공");
//            }else{
//                System.out.println("저장 실패");
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//
//            try{
//
//                if(rs != null && !rs.isClosed()){
//                    rs.close();
//                }
//            }catch(SQLException e){
//                e.printStackTrace();
//            }
//
//            try{
//                if(preparedStatement != null && !preparedStatement.isClosed()){
//                    preparedStatement.close();
//                }
//            }catch(SQLException e){
//                e.printStackTrace();
//            }
//
//            try{
//                if(connection !=null && !connection.isClosed()){
//                    connection.close();
//                }
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//
//
//    }
//
//    public void dbDelete(DBSTUDY dbstudy){  String url="jdbc:mariadb://172.25.75.55:3306/db3";
//        String dbUserId="testuser3";
//        String dbPassword="zerobase";
//
//        try {
//            Class.forName("org.mariadb.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Connection connection =null;
//        PreparedStatement preparedStatement =null;
//        ResultSet rs= null;
//
//
//
//
//
//
//
//        try {
//            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
//
//            String sql = " delete from DBOUT2 " +
//                    " where ID = ? ";
//
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, dbstudy.getID());
//
//
//
//
//            int affected=preparedStatement.executeUpdate();
//
//            if(affected>0){
//                System.out.println("삭제 성공");
//            }else{
//                System.out.println("삭제 실패");
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//
//            try{
//
//                if(rs != null && !rs.isClosed()){
//                    rs.close();
//                }
//            }catch(SQLException e){
//                e.printStackTrace();
//            }
//
//            try{
//                if(preparedStatement != null && !preparedStatement.isClosed()){
//                    preparedStatement.close();
//                }
//            }catch(SQLException e){
//                e.printStackTrace();
//            }
//
//            try{
//                if(connection !=null && !connection.isClosed()){
//                    connection.close();
//                }
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//
//
//    }
//
//}
//
//
//
//
//
