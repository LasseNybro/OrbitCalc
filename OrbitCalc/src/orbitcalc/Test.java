/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbitcalc;
import java.io.*;
/**
 *
 * @author LasseNybro
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Orbit orbit1 = new Orbit(12000, 0.7, 0, 0, 7000);
        System.out.println("The first orbit has an eccentricity of e="+orbit1.e+" and the closest point to Earth is "+orbit1.rp+" meters away from the center of Earth.");
        System.out.println("The orbital velocity for the first orbit is v="+orbit1.v+" m/s at time t="+orbit1.t+" s.");
        System.out.println("Lastly the orbit takes "+orbit1.T+" seconds per full orbit.");
        Orbit orbit2 = new Orbit(200000, 0, 0, 0);
        System.out.println("The second orbit has an eccentricity of e="+orbit2.e+" and the closest point to Earth is "+orbit2.rp+" meters away from the center of Earth.");
        System.out.println("The orbital velocity for the second orbit is: "+orbit2.v+" m/s at time t="+orbit2.t+" s.");
        System.out.println("Lastly the orbit takes "+orbit2.T+" seconds per full orbit.");
        Orbit orbit3 = new Orbit(90000000);
        System.out.println("The third orbit has an eccentricity of e="+orbit3.e+" and the closest point to Earth is "+orbit3.rp+" meters away from the center of Earth.");
        System.out.println("The orbital velocity for the third orbit is: "+orbit3.v+" m/s at time t="+orbit3.t+" s.");
        System.out.println("Lastly the orbit takes "+orbit3.T+" seconds per full orbit.");
/*        Orbit transferOrbit = new Orbit();
                transferOrbit=HTransferOrbit(orbit1,orbit2);
        System.out.println("The transfer time is: "+transferOrbit.t+" seconds");
        System.out.println("The eccentricity of the transfer orbit is: "+transferOrbit.e+".");*/
       // double e=ChangeVel(orbit1,200);
    }
    
}
