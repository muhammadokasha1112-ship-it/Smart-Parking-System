package Smartparking;

import java.sql.*;
class DB{
	Connection con;
	DB(){

	try{
		 Class.forName("com.mysql.cj.jdbc.Driver");

			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_parking",
													"root",
													"Okasha123321123");
			System.out.println("database connected...");
		}catch(Exception e){
			System.out.println(e);
		}

	}
	 public void insertData(String type,String id,double hours,double fee){

        try{

            String q = "insert into parking(type,vehicle_id,hours,fee) values(?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(q);

            pst.setString(1,type);
            pst.setString(2,id);
            pst.setDouble(3,hours);
            pst.setDouble(4,fee);

            pst.executeUpdate();
            System.out.println();

            System.out.println("Data Inserted Successfully...");

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public  void showData(){
    	try{
    		System.out.println("****************** OVERALL  RECORD *************************");
    		System.out.println();
    		String w="select * from parking;";
    		PreparedStatement t = con.prepareStatement(w);

    		ResultSet r=t.executeQuery();

    		while(r.next()){
    			System.out.println(
    								r.getInt(1)+" "+
    								r.getString(2)+" "+
    								r.getString(3)+" "+
    								r.getDouble(4)+" "+
    								r.getDouble(5)+" "
    								);
    		}

    	}catch(Exception e){
    		System.out.println(e);
    	}
    }
    public void revenue(){
    	try{
    		System.out.println("$$$$$$$$$$$$$ TOTAL AMOUNT $$$$$$$$$$$$$$");
    		String h="select SUM(fee) from parking;";

    		PreparedStatement er=con.prepareStatement(h);
    		ResultSet r=er.executeQuery();
    		while(r.next()){
    			System.out.println("Total revenue: "+r.getDouble(1));
    		}
    	}catch(Exception e){
    		System.out.println(e);
    	}
    }

}