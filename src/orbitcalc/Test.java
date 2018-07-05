/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbitcalc;
import java.io.*;
/**
 *
 * @author ShadowCookie
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Orbit orbit1 = new Orbit(12000);
        System.out.println("The orbital velocity for the first orbit is: "+orbit1.v+" m/s");
        Orbit orbit2 = new Orbit(20000);
        System.out.println("The orbital velocity for the second orbit is: "+orbit2.v+" m/s");
        Orbit transferOrbit = new Orbit(orbit1,orbit2);
        System.out.println("The transfer time is: "+transferOrbit.t+" seconds");
        System.out.println("The eccentricity of the transfer orbit is: "+transferOrbit.e);
    }
    
}
