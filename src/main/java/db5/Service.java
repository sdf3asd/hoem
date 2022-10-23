package db5;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Service {

    public List<DBSTUDY> list() {
	    
	List<DBSTUDY> OUTPUTList = new ArrayList<>();    
	    
	String url="jdbc:mariadb://172.17.133.134:3306/db3";
        String dbUserId="testuser3";
        String dbPassword="zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        PreparedStatement preparedStatement =null;
        Connection connection =null;
        ResultSet rs= null;


        try {
             connection =DriverManager.getConnection(url,dbUserId,dbPassword);

            String sql = " select * " +
                    " from OUTPUT "+
                    " where ID < 20 "
                    + " order by ID DESC ";


            preparedStatement =connection.prepareStatement(sql);
    

            rs= preparedStatement.executeQuery();

            while(rs.next()){
                String id =  rs.getString("ID");
                String lat =  rs.getString("LAT");
                String lnt =  rs.getString("LNT");
                String rEG_DT =  rs.getString("REG_DT");

                DBSTUDY dbstudy = new DBSTUDY();
                dbstudy.setID(id);
                dbstudy.setLAT(lat);
                dbstudy.setLNT(lnt);
                dbstudy.setREG_DT(rEG_DT);
                
                OUTPUTList.add(dbstudy);
                
                System.out.println(id +","+lat +","+lnt +","+rEG_DT);

            }


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

        return OUTPUTList;

    }
    
    public Vector<DBSTUDY> getAllDatas() {
	    
	    Vector<DBSTUDY> list = new Vector<DBSTUDY>();
	    String url="jdbc:mariadb://172.17.133.134:3306/db3";
	        String dbUserId="testuser3";
	        String dbPassword="zerobase";

	        try {
	            Class.forName("org.mariadb.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }



	        PreparedStatement preparedStatement =null;
	        Connection connection =null;
	        ResultSet rs= null;


	        try {
	             connection =DriverManager.getConnection(url,dbUserId,dbPassword);

	    
	        String sql = " select * " +
	                        " from csv_db1 "+
	                        " where LAT = ? and LNT = ? "
	                        + " order by LAT DESC ";
	        preparedStatement =connection.prepareStatement(sql);
	        

	            rs= preparedStatement.executeQuery();

	            while(rs.next()){
	                String id =  rs.getString("ID");
	                String lat =  rs.getString("LAT");
	                String lnt =  rs.getString("LNT");
	                String rEG_DT =  rs.getString("REG_DT");

	                DBSTUDY dbstudy = new DBSTUDY();
	                dbstudy.getDistance();
			dbstudy.getX_SWIFI_MGR_NO();
			dbstudy.getX_SWIFI_WRDOFC();
			dbstudy.getX_SWIFI_MAIN_NM();
			dbstudy.getX_SWIFI_ADRES1();
			dbstudy.getX_SWIFI_ADRES2();
			dbstudy.getX_SWIFI_INSTL_FLOOR();
			dbstudy.getX_SWIFI_INSTL_TY();
			dbstudy.getX_SWIFI_INSTL_MBY();
			dbstudy.getX_SWIFI_SVC_SE();
			dbstudy.getX_SWIFI_CMCWR();
			dbstudy.getX_SWIFI_CNSTC_YEAR();
			dbstudy.getX_SWIFI_INOUT_DOOR();
			dbstudy.getX_SWIFI_REMARS3();
			dbstudy.getLAT();
			dbstudy.getLNT();
	 		dbstudy.getREG_DT();
				
	                list.add(dbstudy);
	                

	            }


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

	        return list;

	    }
	    
    
    
    
    

     public void register(DBSTUDY dbstudy){  String url="jdbc:mariadb://172.17.133.134:3306/db3";
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

             String sql = "insert into DBOUT2 (ID, LAT,LNT)" +
                     "value (?,?,?); ";

             preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1, dbstudy.getID());
             preparedStatement.setString(2, dbstudy.getLAT());
             preparedStatement.setString(3, dbstudy.getLNT());


             int affected=preparedStatement.executeUpdate();

             if(affected>0){
                 System.out.println("저장 성공");
             }else{
                 System.out.println("저장 실패");
             }


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


     }

    public void dbUpdate(){  String url="jdbc:mariadb://172.28.72.218:3306/db3";
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

        String idValue="2";
        String latValue="127.04713";
        String lntValue="37.483387";



        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "insert into DBOUT2 (ID, LAT,LNT)" +
                    "value (?,?,?); ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idValue);
            preparedStatement.setString(2, latValue);
            preparedStatement.setString(3, lntValue);


            int affected=preparedStatement.executeUpdate();

            if(affected>0){
                System.out.println("저장 성공");
            }else{
                System.out.println("저장 실패");
            }


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


    }

    public void dbDelete(DBSTUDY dbstudy){ 
	String url="jdbc:mariadb://172.28.72.218:3306/db3";
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

            String sql = " delete from OUTPUT " +
                    " where ID = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dbstudy.getID());




            int affected=preparedStatement.executeUpdate();

            if(affected>0){
                System.out.println("삭제 성공");
            }else{
                System.out.println("삭제 실패");
            }


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


    }

}








