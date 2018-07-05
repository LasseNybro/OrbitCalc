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
        System.out.println("and the orbit takes "+orbit1.t+" seconds per full orbit.");
        Orbit orbit2 = new Orbit(200000);
        System.out.println("The orbital velocity for the second orbit is: "+orbit2.v+" m/s");
        System.out.println("and the orbit takes "+orbit2.t+" seconds per full orbit.");
        Orbit transferOrbit = new Orbit(orbit1,orbit2);
        System.out.println("The transfer time is: "+transferOrbit.t+" seconds");
        System.out.println("The eccentricity of the transfer orbit is: "+transferOrbit.e+".");
    }
    
}
