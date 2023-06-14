/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cricscorer;

import cricscorer.controller.dashboard.DashboardController;
import cricscorer.controller.dashboard.MainDashboardController;
import cricscorer.dashboard.Dashboard;
import java.sql.SQLException;

/**
 *
 * @author prabin
 */
public class Cricscorer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AssertionError, NoSuchFieldException, NumberFormatException, SQLException {
        MainDashboardController mainDashboardController = new MainDashboardController();
//        DashboardController dashboard = new DashboardController();
//        // TODO code application logic here
//        System.out.println(dashboard.returnDashboard());

        System.out.println(mainDashboardController.returnDashboard());
    }

}
