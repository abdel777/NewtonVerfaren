/*
==== Minimum von f(x) ist 2,
====
====
*/
public class FFunction implements Function {
    static int minF = 2; // minimum von der Funktion f(x)

    @Override
    public double calculateValue(double x) {
        return ( Math.sin(Math.pow(x, 2)) + 1);
    }

    @Override
    public double calculateDerivateAtPoint(double x) {

        return 2 * x * Math.cos(Math.pow(x, 2));
    }
    public double findAlphaPrim1(double x){
        return Math.toDegrees(Math.atan(x/minF)); // konvertieren nach degree
    }
}
