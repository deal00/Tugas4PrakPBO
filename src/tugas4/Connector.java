
package tugas4;
import java.sql.*;
import javax.swing.JOptionPane;

public class Connector {
    //Koneksi Ke DB
    String DBurl = "jdbc:mysql://localhost:3306/tugasjdbc";
    String DBusername = "root";
    String DBpassword = "";
    
    String data[] = new String[2];
    Connection conn;
    Statement statement;
    static String[] username;
    
    //void untuk koneksi ke DB
    public Connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Connection Berhasil");
        }catch(Exception ex){
            System.out.println("Connection Failed " + ex.getMessage());
        }
    }
    
    //Void untuk masukan data ke DB
    void masukanData(String username, String password){
        try {
            if(!cekUsername(username)){
                String query = "INSERT INTO `users`(`username`,`password`) "
                    + "VALUES('" + username + "','" + password + "')";

                statement = conn.createStatement();
                statement.executeUpdate(query);

                System.out.println("Input Berhasil");
                JOptionPane.showMessageDialog(null, "Register Berhasil");
            }else{
                JOptionPane.showMessageDialog(null, "Username Sudah Ada");
            }
            
        } catch (Exception ex) {
            System.out.println("Input Failed");
        }
    }
    
     //Method untuk cek 
     boolean cekLogin(String username, String password){
         try {
             String query = "SELECT * FROM `users` WHERE username='"+username+"'";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){ //konversi tabel ke string
                data[0] = resultSet.getString("username"); 
                data[1] = resultSet.getString("password");
            }
            statement.close();
             System.out.println(data[1].toString());
             System.out.println(password);
            if(data[1].toString().equals(password)){
                return true;
            }else{
                return false;
            }
         } catch (Exception e) {
             System.out.println("Tidak Ada!");
            return false;
         }
     }
     
    //Method untuk baca data
     String[] bacaData(){
        try {
            String query = "SELECT * FROM `users`";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){ //konversi tabel ke string
                data[0] = resultSet.getString("username");
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Ada Error SQL");
        } finally {
            return data;
        }
    }
     
     //Method untuk cek username
     boolean cekUsername(String username){
         try {
             String query = "SELECT * FROM `users` WHERE username='"+username+"'";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            
            while(resultSet.next()){ //konversi tabel ke string
                data[0] = resultSet.getString("username"); 
            }
            statement.close();
            data[0].toString();
            return true;
         } catch (Exception e) {
             System.out.println("Tidak Ada!");
            return false;
         }    
     }
     
}
