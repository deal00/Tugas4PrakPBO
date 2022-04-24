package tugas4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame{
    JLabel judul = new JLabel("Halaman Login");
    JLabel luname = new JLabel("Username: "); 
    JTextField funame = new JTextField (15);
    JLabel lpass = new JLabel("Password: ");
    JPasswordField fpass = new JPasswordField(15);
    JButton blogin = new JButton("Login");
    JButton bcancel = new JButton("Cancel");
    JLabel lreguname = new JLabel ("Username: ");
    JTextField freguname = new JTextField (15);
    JLabel lregpass = new JLabel("Password: ");
    JPasswordField fregpass = new JPasswordField(15);
    JButton bregister = new JButton("Register");
    
    public GUI() { //Menambahkan Label dan TextField ke App
       setTitle("Login");
       setSize(450, 200);
       
       //LOGIN
       setLayout(null);
       add(judul);
       add(luname);
       add(funame);
       add(lpass);
       add(fpass);
       add(blogin);
       
       //REGISTER
       add(freguname);
       add(lreguname);
       add(lregpass);
       add(fregpass);
       add(bregister);
       
       //TATA LETAK & UKURAN
       judul.setBounds(170,10,120,20);
       luname.setBounds(10, 40, 80, 20);
       funame.setBounds(90, 40, 90, 20);
       lpass.setBounds(10, 80, 80, 20);
       fpass.setBounds(90, 80, 90, 20);
       blogin.setBounds(50, 110, 80, 20);
       lreguname.setBounds(230, 40, 80, 20);
       freguname.setBounds(310, 40, 90, 20);
       lregpass.setBounds(230, 80, 80, 20);
       fregpass.setBounds(310, 80, 90, 20);
       bregister.setBounds(270,110, 100, 20);
       
       blogin.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               Connector con = new Connector();
               String uname = funame.getText();
               System.out.println(uname);
               if(con.cekUsername(uname) && uname != "" && con.cekLogin(uname ,String.valueOf(fpass.getPassword()))){
                   JOptionPane.showMessageDialog(null, "Login Success");
               }else if(uname.isEmpty() || String.valueOf(fpass.getPassword()).isEmpty()){
                   JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
               }
               else if(!con.cekUsername(uname)){
                   JOptionPane.showMessageDialog(null, "Username Salah");
               }
               else{
                   JOptionPane.showMessageDialog(null, "Password Salah");
               }
           }
       });
       
       bregister.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               Connector con = new Connector();
               String reguname = freguname.getText();
               String regpass = String.valueOf(fregpass.getPassword());
               if(!reguname.isEmpty() && !regpass.isEmpty()){
                   con.masukanData(reguname, regpass);
               }
               else if(reguname.isEmpty() || regpass.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
               }
           }
           
       });
       setVisible(true);
    }
}
