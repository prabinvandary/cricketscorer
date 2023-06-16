/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.controller.dashboard;

import cricscorer.controller.PlayerController;
import java.util.Scanner;

/**
 *
 * @author prabin
 */
public class DeleteDashboard {

    PlayerController playerController = new PlayerController();

    Scanner sc = new Scanner(System.in);

    public Boolean returnDashboard(DashboardController dashboardController) {
        returnDeleteCreateAddViewDashboard(dashboardController);
        return true;
    }

    private void deleteDashboard(DashboardController dashboardController) {
        System.out.println("Enter 1. For  Player 2. For Match 3. For Tournament");
        Integer menuId = sc.nextInt();
        sc.nextLine();
        dashboardSelection(menuId, dashboardController);
    }

    private void dashboardSelection(Integer menuId, DashboardController dashboardController) {
        switch (menuId) {
            case 1:
                playerController.deletePlayerFromDatabase(dashboardController);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void returnDeleteCreateAddViewDashboard(DashboardController dashboardController) {
        System.out.println("Enter 1. For Create 2. For View 3. For Delete");
        Integer menuId = sc.nextInt();
        sc.nextLine();
        menuSelection(menuId, dashboardController);

    }

    private void menuSelection(Integer menuId, DashboardController dashboardController) {
        switch (menuId) {
            case 1:
                createDashboard(dashboardController);
                returnDeleteCreateAddViewDashboard(dashboardController);

                break;
            case 2:
                viewDasboard(dashboardController);
                returnDeleteCreateAddViewDashboard(dashboardController);
            case 3:
                deleteDashboard(dashboardController);
                returnDeleteCreateAddViewDashboard(dashboardController);

                break;
            default:
                returnDeleteCreateAddViewDashboard(dashboardController);
        }
    }

    private void createDashboard(DashboardController dashboardController) {
        playerController.savePlayer(dashboardController);
    }

    private void viewDasboard(DashboardController dashboardController) {
        System.out.println("1. For View By Id 2.  For List");
        Integer menuId = sc.nextInt();
        sc.nextLine();
        switch (menuId) {
            case 1:
                playerController.getPlayerByIdFromDatabase(dashboardController);
                returnDashboard(dashboardController);
                break;
            case 2:
                playerController.getAllPlayerFromDatabase(dashboardController);
                returnDashboard(dashboardController);

                break;
            default:
                returnDashboard(dashboardController);
        }
    }
}
