import org.junit.Test;

import static org.junit.Assert.*;

public class NewtonAlgorithemTest {

    Function f = new FFunction();
    Function g = new GFunction();
    double kost = 23;
    double x,y;

    @Test
    public void main() throws Exception {

    }

    @Test
    public void findRoot() throws Exception {
        x = NewtonAlgorithem.findRoot(f,4);
        y = NewtonAlgorithem.findRoot(g,x);

        assertEquals(4,x,0.2);
        assertEquals(x,y,0.2);

    }

    @Test
    public void calculateDistance() throws Exception {
        assertNotNull(NewtonAlgorithem.calculateDistance(1,2,3,4));
    }



    @Test
    public void calculateKosten() throws Exception {
        assertNotNull(NewtonAlgorithem.calculateKosten(2,3,4));
    }

    @Test
    public void calculateTunnelVolumen() throws Exception {
        assertNotNull(NewtonAlgorithem.calculateTunnelVolumen(3,2,3,4));
    }

}