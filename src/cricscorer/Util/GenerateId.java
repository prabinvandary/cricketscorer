/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.Util;

import java.util.Random;

/**
 *
 * @author prabin
 */
public class GenerateId {
    public Integer returnId(){
    Random random=new Random();
    return random.nextInt(200);
    }
}
