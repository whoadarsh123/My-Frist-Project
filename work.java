
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class work {
   static Connection conn;
    public work(Connection conn)
    {
        this.conn = conn;
    }
    //this is the plumber method for calling
    public  void WorkType(int usrid,String work_type)
    {
        Scanner sca1 = new Scanner(System.in);
        String description = "";
        String location = "";
        System.out.println("ENTER YOUR WORK DESCRIPTION");
        description = sca1.nextLine();
        System.out.println("ENTER YOUR WORK LOCATION");
        location = sca1.nextLine();
        try{
            String Query = "INSERT INTO new_work (user_id,location,description,work_type)VALUES('"+usrid+"','"+location+"','"+description+"','"+work_type+"')";
            Statement state = conn.createStatement();
            int effect = state.executeUpdate(Query);
            if(effect>0)
            {
                System.out.println();
                System.out.println("WORK SUBMITTED SUCCESSFULLY");
            }
            else
            {
                System.out.println("FAILED TO SUBMIT THE WORK(try again)");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }
    }
    //this is the method for electrician work;
    public static void electrician()
    {

    }
    //this is the method for carpainter work
    public static void carpainter()
    {

    }
    //this is the method for transport vehicle
    public static void transpost()
    {

    }
    //this is the method for painter
    public static void painter()
    {

    }

    
}
