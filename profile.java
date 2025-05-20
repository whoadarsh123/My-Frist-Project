
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class profile{
   static Connection connection;
   static String email;
    public profile(Connection connection, String email)
    {
        this.connection = connection;
        this.email = email;
    }
    public static void testing()  
    {
        Scanner scan = new Scanner(System.in);
         int userid = 0;
         String userinput = "" ;
        try
        {
            String query = "SELECT user_id FROM user WHERE email = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,email);
             ResultSet rs = stmt.executeQuery();
             if(rs.next())
             {
            userid = rs.getInt("user_id");
            //HARE THE USER LOGED IN IN THEIR PROFILE NOW DIFFRENT OPTION 
            while(!userinput.equals("3"))
            {
                System.out.println("-----------------");
                System.out.println("1:-Your Works");
                System.out.println("-----------------");
                System.out.println("2:- I Have a Work");
                System.out.println("-----------------");
                System.out.println("3:-Exit");
                System.out.println("------------------");
                userinput = scan.nextLine();

                switch(userinput)
                {
                    case "1":
                    {

                        yourwork(userid);
                        break;
                    }
                    case "2":
                    {

                        ihwork(userid);
                        break;
                    }
                    case "3":
                    {
                        break; // break the switch statement
                    }
                    default:
                    {
                        System.out.println("Enter the valid key");
                        break;
                    }
                }

            }

        }
        else 
        {
            System.out.println("SORRY NOT EXECUTED");
        }
    }
        catch(SQLException e)
        {
            e.printStackTrace();
        
        }
    }
    //ITS A METHOD WHERE A USER HAVE ANY WORK AND WANNA HIRE SOMEONE
    public static void ihwork(int id)
    {
        work wrk = new work(connection);
        Scanner sca1 = new Scanner(System.in);
        String ss = "";
        System.out.println(" WHICH TYPE OF SERVICE DO YOU NEED? ");
        System.out.println("");
        System.out.println("1:-Plumber");
        System.out.println("------------------------------------");
        System.out.println("2:-Electrician");
        System.out.println("------------------------------------");
        System.out.println("3:-Carpainter");
        System.out.println("------------------------------------");
        System.out.println("4:-Transport(Vehicle)");
        System.out.println("------------------------------------");
        System.out.println("5:-Painter");
        System.out.println("------------------------------------");
        System.out.println("0:-Exit");
        System.out.println("------------------------------------");
        ss = sca1.nextLine();
        switch(ss)
        {
            case ("1"):
            {
                wrk.WorkType(id,"Plumber");
                break;
            }
            case ("2"):
            {
                 wrk.WorkType(id,"Electrician");
                break;
            }
            case ("3"):
            {
                wrk.WorkType(id,"Carpainter");
                break;
            }
            case ("4"):
            {
                wrk.WorkType(id,"Transport");
                break;
            }
            case ("5"):
            {
                wrk.WorkType(id,"Painter");
                break;
            }
            case ("0"):
            {
                //exit this function
                break;
            }
            default:
            {
                System.out.println("Enter valid option");
                break;
            }
        }
    }
    public static void yourwork(int usrid)
    {
        Scanner sa1 = new Scanner(System.in);
        String inp = "";
        try{
            String query = "SELECT * FROM new_work WHERE user_id = ? order by id";
            PreparedStatement state = connection.prepareStatement(query);
            state.setInt(1,usrid);
            ResultSet re = state.executeQuery();
            while(!inp.equalsIgnoreCase("exit"))
            {
             while(re.next())
            {
                int id = re.getInt("id");
                String Location = re.getString("location");
                String description = re.getString("description");
                System.out.println("WORK-"+id);  
                System.out.println("--------------------");
                System.out.println("Id:-"+id);
                System.out.println("Location:-"+Location);
                System.out.println("Description:-"+description);
                System.out.println("--------------------");
                System.out.println("");
            }
            System.out.println("ENTER 'EXIT' FOR EXITING THIS PAGE");
                inp = sa1.nextLine();
        }
        }
        catch(Exception e)
        {
            e.printStackTrace(); 
        }

    }
}