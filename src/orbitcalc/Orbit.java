/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbitcalc;
import java.math.*;
/**
 *
 * @author ShadowCookie
 */
public class Orbit {
    //eccentricity of the orbit, orbital velocity, orbital radius, and orbital acceleration
    double e, v, r, a, t;
    //global parameters: Earth Radius and standard gravitational parameter for Earth
    public double earthR=6371.0;
    public double mu=3.986004418*Math.pow(10,14);
    /*Orbit(double ellipticity, double distance) {
        e=ellipticity;
        r=distance+earthR;
    } */
    Orbit(double distance) {
        e=0;
        r=(distance+earthR)*1000;
        v=Math.sqrt(mu/r);
        a=Math.pow(v,2)/r; //acceleration
        t=2*r*Math.PI/v;
    }
    Orbit(Orbit Orbit1, Orbit Orbit2) {
        //Calculates the Hohmann transfer between the two orbits.
        //Reading in parameters from the two orbits
        double v1=Orbit1.v;
        double v2=Orbit2.v;
        double r1=Orbit1.r;
        double r2=Orbit2.r;
        double a1=Orbit1.a;
        double a2=Orbit2.a;
        //Calculating the semimajor axis
        double aSemi=(r1+r2)/2;
        //finding the eccentricity of the transfer orbit
        if (r2>r1)
            e=(r2-r1)/(2*aSemi);
        else
            e=(r1-r2)/(2*aSemi);
        //finding the relevant parameters to change from one orbit to the other
        double dv1=Math.sqrt(mu/r1)*(Math.sqrt((2*r2)/(r1+r2)-1));
        double dv2=Math.sqrt(mu/r2)*(1-Math.sqrt((2*r1)/(r1+r2)));
        double totaldv=dv1+dv2;
        t=Math.PI*Math.sqrt(Math.pow(r1+r2,3)/(8*mu)); //transfer time
    }
}
