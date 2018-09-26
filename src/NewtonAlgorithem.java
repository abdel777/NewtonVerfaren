/*
==== Minimum von f(x) ist 2.
==== Minimum von g(x) ist 33.
====
*/

public class NewtonAlgorithem {

public static void main(String args[]){
    int radius =4;
    int xStart = 4; //  Der Boahhamma wird im x = 4 gestart
    int minF = FFunction.minF;
    int minG = GFunction.minG;

    double alpha1; // der erste Angel
    double alpha2; // der zweite Angrl
    double alpha3; // der dritte Angel

    double alphaPrime1; // das ist nur ein temporär Angel, um alpha1 zu finden
    double alphaPrime2; // das ist nur ein temporär Angel, um alpha2 zu finden

    double xA; // das ist die Abszisse, wo der Baohamma am ersten mal gestopt wird
    double xB; // das ist die Abszisse, wo der Baohamma am zweiten mal gestopt wird
    double xC; // das ist die Abszisse, wo der Baohamma am Ende ist

    double dPrime1; // die Distanz zwischen der Punkt Start und A in meter
    double dPrime2; // die Distanz zwischen der Punkt A und B in meter
    double dPrime3; // die Distanz zwischen der Punkt B und C in meter

    /*
     == die sind die Distanz, wo der Baohhamma in jeder Erdreich.
     == damit kann man der Energie in jeder Erdreich rechnen
     == weil der Energie abhängig von der Dichte und die distanz ist
    */
    double d1; //das ist die Distanz, wo der Baohhamma in Erdreich mit der Dicht 1.8
    double d2; // das ist die Distanz, wo der Baohhamma in Erdreich mit der Dicht 5.8
    double d3; // // das ist die Distanz, wo der Baohhamma in Erdreich mit der Dicht 2.8

    double kost; // Kosten in euro
    double volumen; // Tunenvolumen

    GFunction g = new GFunction(); //  g(x) function
    FFunction f = new FFunction(); //  f(x) function

    xA = findRoot(f,xStart); // minimum von f(x), gleichzeitig minimium distance zwischen (4,0) und f(x)
    xB = findRoot(g,xA);     // minimum von g(x), gleichzeitig minimium distance zwischen (xA,2) und g(x)
    xC = xB;

    dPrime1 = calculateDistance(xA,xStart, minF,0) ; // die Distanz between Start(4,0) und A(xA,2)
    dPrime2 = calculateDistance(xB,xA,minG,minF) ;   // die Distanz between A(xA,2) und B(xB,33)
    dPrime3 = calculateDistance(xC,xB,minG,45);  // die Distanz between B(xB,33) und C(xC,45)




    alphaPrime1 = f.findAlphaPrim1(Math.abs(xA-xStart)); // hilft uns um alpha1 zu finden

    alpha1= 90-alphaPrime1;

    alphaPrime2 = g.findAlphaPrim2(Math.abs(xA-xB)); // hilft uns um alpha2 zu finden
    alpha2 = 90 +alphaPrime2;  //

    alpha3= 90;

    d1 = dPrime1+3/Math.cos(alphaPrime2*Math.PI/180);// 3/Math.cos(alphaPrime2*Math.PI/180) ist die Distanz zwischen der Punkt A und die Grenzen von der Strasse
    d2 = dPrime2 - 3/Math.cos(alphaPrime2*Math.PI/180) + 2;
    d3 = dPrime3 - 2;

    System.out.printf("====================== 1 ================== \n");
    System.out.println("Alpha1 :"+alpha1+" degree");
    System.out.println("Alpha2 :"+alpha2+" degree");
    System.out.println("Alpha3:"+alpha3+" degree");
    System.out.printf("====================== 2 ================== \n");
    System.out.println("dPrime1 :"+dPrime1+" m,|| d1="+d1+" m");
    System.out.println("dPrime2 :"+dPrime2+" m,|| d2="+d2+" m");
    System.out.println("dPrime3:"+dPrime3+" m, || d3="+d3+" m");
    System.out.printf("====================== 3 ==================\n");

    kost = calculateKosten(d1,d2,d3);
    System.out.printf("die Kosten sind %f euro \n",kost );
    System.out.printf("====================== 4 ==================\n");
    volumen = calculateTunnelVolumen(radius,dPrime1,dPrime2,dPrime3);
    System.out.printf("Das Volumen des Tunnels ist %f m*3 \n  ",volumen);



}

    // finden die Nullsten durch das Newton Verfahren
    public static double findRoot(Function f, double x) {
        double xneu=0;
        double temp;
        int k = 0;
        try {
            do {
            xneu = x - (f.calculateValue(x) / f.calculateDerivateAtPoint(x));
            if (xneu == Double.POSITIVE_INFINITY )
                throw new ArithmeticException();
            temp = Math.abs(xneu - x);
            x = xneu;
            k++;
        } while (k < 1000 && temp >  0.000001);
        }
        catch (ArithmeticException ae){
            ae.printStackTrace();
        }finally {
            return xneu;
        }
    }

    // berechnen die Distanz zwischen zwei Punkten
    public static  double calculateDistance(double x1, double x2, double y1, double y2){

        return Math.sqrt(Math.pow(x1 - x2,2)+Math.pow(y1 - y2,2));

    }

    // berechnen die Kosten
    public static double calculateKosten(double d1, double d2, double d3){

        // k(d) =  (exp(ρ1) d1 + exp(ρ2) d2 + exp(ρ3)d3)* 56.6589375 €/km

        return (d1*Math.exp(1.8) + d2*Math.exp(5.8) + d3*Math.exp(2.8))*56.6589375*0.001 ;
    }

    public static double calculateTunnelVolumen(double radius,double d1,double d2, double d3){// calculate der Volumen

        // V = π*r*r*h

        return Math.PI*Math.pow(radius,2)*(d1+d2+d3);
    }

}

