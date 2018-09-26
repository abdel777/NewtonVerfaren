/**
 * Created by Abdula on 12/4/2016.
 */
public class GFunction implements Function {

    static int minG = 33; // minimum von der Funktion g(x)


    @Override

    public double calculateValue(double x) {
        return ( Math.cos(Math.pow(x, 2)) + 1);
    }

    @Override
    public double calculateDerivateAtPoint(double x) {
        return -2 * x * Math.sin(Math.pow(x, 2));
    }

    // mit welchem Angel wir der Boahhamma gestart
    public double findAlphaPrim2(double x){
        return Math.toDegrees(Math.atan(x/(minG-2))); // konvertieren nach degree
    }
}
