/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbitcalc;
import java.math.*;
/**
 *
 * @author LasseNybro
 */
public class Orbit {
    //Declaration of basic orbital parameters
    double e, rp, i, omega;
    //Declaration of time variable
    double t;
    //Declaration of derived orbital paramters
    double ra, a, T, phi, v, r, dv, v1, v2, r1, r2, a1, a2, e1, e2;
    //global parameters: Earth Radius and standard gravitational parameter for Earth
    public double earthR=6371.0;
    public double mu=3.986004418*Math.pow(10,14);
    
    Orbit(double distance, double e, double i, double omega, double t) {
        this.e=e;
        this.i=0;
        this.omega=0;
        this.rp=(distance+earthR)*1000;
        this.ra=rp*(1+e)/(1-e);
        this.a=(ra+rp)/2;
        this.T=2*Math.sqrt(Math.pow(a,3)/mu)*Math.PI;
        this.t=t;
        this.phi=t/(e-1); //This is a 1st order taylor approximation of the real value since an analytical solution hasn't been found yet.
        this.r=a*(1-Math.pow(e,2))/(1+e*Math.cos(phi));
        this.v=Math.sqrt(mu*(2/r-1/a));
                
    }
    Orbit(double distance, double e, double i, double omega) {
        this(distance, e, i, omega, 0);
       
    }
    Orbit(double distance, double i, double omega) {
        this(distance, 0, i, omega, 0);
       
    }
    Orbit(double distance, double e) {
        this(distance, e, 0, 0, 0);
       
    }
    Orbit(double distance) {
        this(distance, 0, 0, 0, 0);
       
    }
    Orbit() {
        this(0, 0, 0, 0, 0);
       
    }
   /* Orbit(Orbit Orbit1, Orbit Orbit2) {
        //Calculates the Hohmann transfer between the two orbits.
        //Reading in parameters from the two orbits
        v1=Orbit1.v;
        v2=Orbit2.v;
        r1=Orbit1.r;
        r2=Orbit2.r;
        a1=Orbit1.a;
        a2=Orbit2.a;
        //Calculating the semimajor axis
        double aSemi=(r1+r2)/2;
        //finding the eccentricity of the transfer orbit
        if (r2>r1)
            e=(r2-r1)/(2*aSemi);
        else
            e=(r1-r2)/(2*aSemi);
        //finding the relevant parameters to change from one orbit to the other
        double dv1=Math.sqrt(mu/r1)*(Math.sqrt((2*r2)/(r1+r2))-1);
        double dv2=Math.sqrt(mu/r2)*(1-Math.sqrt((2*r1)/(r1+r2)));
        double totaldv=dv1+dv2;
        t=Math.PI*Math.sqrt(Math.pow(r1+r2,3)/(8*mu)); //transfer time
    } */
    public Orbit HTransferOrbit(Orbit Orbit1, Orbit Orbit2) {
        e1=Orbit1.e;
        e2=Orbit2.e;
        double angle11=Orbit1.i;
        double angle12=Orbit2.i;
        double angle21=Orbit1.omega;
        double angle22=Orbit2.omega;
        i=Math.abs(angle12-angle11);
        omega=Math.abs(angle22-angle21);
        v1=Orbit1.v;
        v2=Orbit2.v;
        r1=Orbit1.rp;
        r2=Orbit2.rp;
        a1=Orbit1.a;
        a2=Orbit2.a;
        a=(r1+r2)/2;
        if (r2>r1) {
            r=r1;
            e=(r2-r1)/(2*a);}
        else {
            r=r2;
            e=(r1-r2)/(2*a);}
        double dv1=Math.sqrt(mu/r1)*(Math.sqrt((2*r2)/(r1+r2))-1);
        double dv2=Math.sqrt(mu/r2)*(1-Math.sqrt((2*r1)/(r1+r2)));
        double totaldv=dv1+dv2;
        T=Math.PI*Math.sqrt(Math.pow(r1+r2,3)/(8*mu));
        Orbit HTOrbit = new Orbit(r,e,i,omega);
        return HTOrbit;
    }
    public void ChangeVel(double v2){
        dv=Math.abs(v-v2);
        System.out.println("The absolute value of"+v+" minus "+v2+" equals "+dv);
        v=v2;
        r1=rp;
        double top = (Math.pow(dv*r1,2)+2*dv*Math.pow(r1,2)*Math.sqrt(mu/r1)+mu*r1);
        double bottom = (mu-Math.pow(dv,2)*r1-2*dv*r1*Math.sqrt(mu/r1));
        System.out.println(mu+" "+Math.pow(dv,2)*r1+" "+2*dv*r1*Math.sqrt(mu/r1));
        r2=top/bottom;
        if (r1>r2){
            ra=r1; rp=r2;
            System.out.println("r1 is larger than r2."+ra+" "+rp);}
        else{
            ra=r2; rp=r1;
            System.out.println("r2 is larger than r1."+ra+" "+rp);}
        this.e=(ra-rp)/(2*(ra+rp));
        this.i=0;
        this.omega=0;
        this.a=(ra+rp)/2;
        this.t=0;
        this.T=2*Math.sqrt(Math.pow(a,3)/mu)*Math.PI;
        this.phi=t/(e-1); //This is a 1st order taylor approximation of the real value since an analytical solution hasn't been found yet.
        this.r=a*(1-Math.pow(e,2))/(1+e*Math.cos(phi));
        this.v=Math.sqrt(mu*(2/r-1/a));
    }
}
