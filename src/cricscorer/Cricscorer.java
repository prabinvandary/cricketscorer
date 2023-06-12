/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cricscorer;

import cricscorer.dashboard.Dashboard;

/**
 *
 * @author prabin
 */
public class Cricscorer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dashboard  dashboard=new Dashboard();
        
        // TODO code application logic here
        System.out.println(dashboard.returnDashboard());
    }

}
