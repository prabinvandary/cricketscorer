
package cricscorer.dashboard;

import cricscorer.dashboard.addmatch.AddMatchDashboard;
import java.util.Scanner;
public class Dashboard {

   public Boolean returnDashboard() {
       AddMatchDashboard addMatchDashboard=new AddMatchDashboard();
        System.out.println("Hello welcome to the  cric scorer system.");
        System.out.println("How can i assit you??\n Availale services are:"
                + "\n 1.Add Match Entries   2.Update Entities      3.Create Entities"
                + "     4.View statistics and Details\n");
        System.out.println(" Enter the respective numbers to access the menus:");
        Scanner sc=new Scanner(System.in);
        Integer menuNumber=sc.nextInt();
        switch (menuNumber) {
           case 1:addMatchDashboard.returnAddMatchDashboard();
               
               break;
           default:
               throw new AssertionError();
       }
        return true;
    }
}
