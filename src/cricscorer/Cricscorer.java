/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cricscorer;

import cricscorer.controller.dashboard.MainDashboardController;
import java.sql.SQLException;

/**
 *
 * @author prabin
 */
public class Cricscorer {

    /**
     * @param args the command line arguments
     * @throws java.lang.NoSuchFieldException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws AssertionError, NoSuchFieldException, NumberFormatException, SQLException {
        MainDashboardController mainDashboardController = new MainDashboardController();
        System.out.println(mainDashboardController.returnDashboard());
    }

}
