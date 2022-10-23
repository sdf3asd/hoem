package db5;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    public List<DBSTUDY> list() {
	    
	List<DBSTUDY> OUTPUTList = new ArrayList<>();    
	    
	String url="jdbc:mariadb://172.20.15.148:3306/db3";
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

            String sql = " select ID, LAT, LNT, REG_DT " +
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

     public void register(DBSTUDY dbstudy){  String url="jdbc:mariadb://172.28.72.218:3306/db3";
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








