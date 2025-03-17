import java.util.*;
public class project
{
  static class logedin
  {
    static HashSet<String> hash = new HashSet<>();
    public static void pass()
    {
      HashSet<String> psshash = new HashSet<>();
      Scanner sc = new Scanner(System.in);
      System.out.println("enter your password");
      String pass = sc.nextLine();
      System.out.println("enter your confirn password");
      String pass2 = sc.nextLine();
      if(pass2.equals(pass))
      {
        System.out.println("logged in successfully");
        return;
      }
      else
      {
        System.out.println("psssword not matched");
        System.out.println("ENTER AGAIN");
      }
      for(int i=2 ;i>=0;i--)
      {
         pass2 = sc.nextLine();
         if(pass2.equals(pass))
         {
          System.out.println("logged in successfully");
          return;
         }
         else 
         {
          System.out.println("you have"+i+"more chance");
          System.out.println("enter again");
         }
      }
      System.out.println("sorry try again");
    }
    public static String email()
    {
      Scanner sc = new Scanner(System.in);
      String email ="";
          System.out.println("Plese enter your email");
            email = sc.nextLine();
          if(hash.contains(email))
          {
            System.out.println("email already logged in ");
           email();
          }
          else 
          {
            hash.add(email);
            System.out.println("email verified");
            pass();
          }
          return email;
    }
  }
  public static void main(String args[])
  {
    logedin log = new logedin();
    Scanner sc = new Scanner(System.in);
   String comm = "";
    while(!comm.equalsIgnoreCase("exit"))
    {
    System.out.println("login"+"press - 1");
    System.out.println("------------");
    System.out.println("sign up "+"press - 2");
    System.out.println("-------------");
    System.out.println("type exit for quit");
    comm = sc.nextLine();
    switch (comm)
    {
      case "1":
      {
        System.out.println("login your acc");
        break;
      }
      case "2":
      {
        log.email();
      }
      default:
      {
      break;
      }
    }
    System.out.println("thank you");
}
} 
}