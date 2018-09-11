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
        Orbit transOrbit = orbit3.HTransferOrbit(orbit3,orbit2);
        System.out.println("The transfer orbit between the third orbit and the second orbit has an eccentricity of e="+transOrbit.e+" and the closest point to Earth is "+transOrbit.rp+" meters away from the center of Earth.");
        System.out.println("The orbital velocity for the transfer orbit is: "+transOrbit.v+" m/s at time t="+transOrbit.t+" s.");
        System.out.println("Lastly the orbit takes "+transOrbit.T+" seconds to transfer between the two orbits.");       
    
        /* This portion doesn't work, I haven't figured out why yet, but it is probably caused by the way I find r2 in ChangeVel.
        orbit2.ChangeVel(2700); 
        System.out.println("We change the velocity of the third orbit to 1700 m/s, which means it gets an eccentricity of e="+orbit2.e+" and the closest point to Earth is "+orbit2.rp+" meters away from the center of Earth.");
        System.out.println("The orbital velocity for the third orbit is then: "+orbit2.v+" m/s at time t="+orbit2.t+" s.");
        System.out.println("Lastly the orbit takes "+orbit2.T+" seconds per full orbit.");
       */ 
        /*        Orbit transferOrbit = new Orbit();
                transferOrbit=HTransferOrbit(orbit1,orbit2);
        System.out.println("The transfer time is: "+transferOrbit.t+" seconds");
        System.out.println("The eccentricity of the transfer orbit is: "+transferOrbit.e+".");*/
       // double e=ChangeVel(orbit1,200);
    }
    
}
