/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.Util;

/**
 *
 * @author prabin
 */
public class CalculateRunRate {
       public String calculateRunRate(Integer teamScore, Double over) {
        Double runrate = teamScore / over;
        return String.format("%.2f", runrate);
    }

}
