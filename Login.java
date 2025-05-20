import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
   private static  String url = "jdbc:mysql://localhost:3306/logindetails"; 
     private static String user = "root";  
       private static String password = "ad4321sql";  

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = "";
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,user,password);
        while(!command.equalsIgnoreCase("exit"))
        {
            System.out.println();
            System.out.println("-----Welcome----");
            System.out.println("1:- Login");
            System.out.println("2:- Sign-up");
            System.out.println("Enter exit for exiting the page");
            command=scan.nextLine();
            switch(command)
            {
                case "1":
                {
                     login(conn,scan);
                    break;
                }
                case "2":
                {
                    email(conn,scan);
                     break;
                }
                default:
                {
                    break;
                }
            }
            System.out.println("thank you");
        }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }  
    }
    private static void email(Connection conn,Scanner scan)
    {
        try{
        System.out.print("ENTER YOUR EMIAL;-   ");
         String mail = scan.nextLine();
         System.out.print("ENTER YOUR PASSWORD;-   ");
         String pass = scan.nextLine(); 

         String query = "SELECT * FROM user WHERE email = ?";
         PreparedStatement pst = conn.prepareStatement(query);
         pst.setString(1,mail);
         ResultSet rs = pst.executeQuery();
         if(rs.next())
         {
            System.out.println("email already registered        PLEASE LOGIN");
            email(conn,scan);
         }
         else 
         {
            System.out.print("ENTER CONFIRM PASSWORD;-   ");
            String pass2 = scan.nextLine();
            if(pass2.equals(pass))
            {
                System.out.print("PLEASE ENTER YOUR NAME;-   ");
                String nm = scan.nextLine();
        String sql = "INSERT INTO user (email,password,name) VALUES ('"+mail+"','"+pass+"','"+nm+"')";
        Statement statement = conn.createStatement();
        int effect = statement.executeUpdate(sql);
        if(effect>0)
        {
            System.out.println();
            System.out.println("Signed up");
        }
        else
        {
            System.out.println("failed");
        }
            }
            else
            {
              System.out.println("password not matched...try again");
            } 
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private static void login(Connection conn,Scanner scan)
    { 
        System.out.print("ENTER YOUR EMAIL;-   ");
        String email = scan.nextLine();
        System.out.print("ENTER YOUR PASSWORD;-   ");
        String pass = scan.nextLine();
        profile pro = new profile(conn,email); 
        try{
        String query = "SELECT password,name FROM user WHERE email = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,email);
        ResultSet rs = stmt.executeQuery();
        if(rs.next())
        {
           String storedPassword = rs.getString("password");
           String nm = rs.getString("name");
           if(storedPassword.equals(pass))
           {
            System.out.println();
            System.out.println("WELCOME"+"  "+nm); 
            pro.testing();
            return ;
           }
           else
           {
            System.out.println("incorrect password....try again");
           }
        }
        else 
        {
            System.out.println("Invalid email");
        }
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

