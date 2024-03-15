import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class PoligonoConvexoTestCase {

    @Test
    public void testColinear() {
        List<int[]> pontos = new ArrayList<>(5);
        pontos.add(new int[]{10, 0});
        pontos.add(new int[]{10, 10});
        pontos.add(new int[]{0, 10});
        pontos.add(new int[]{0, 0});
        assertEquals(Validador.validarConvexo(pontos), "No");
    }

    @Test
    public void testPoligonoConvexoNegativo() {


        assertEquals(Validador.validarConvexo(List.of(
                new int[]{0, 0},
                new int[]{0, 10},
                new int[]{30, 10},
                new int[]{30, 0},
                new int[]{0, 30},
                new int[]{30, 30})), "No");

        assertEquals(Validador.validarConvexo(List.of(
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{100, 0},
                new int[]{50, 100},
                new int[]{30, 30},
                new int[]{50, 90})), "No");

        assertEquals(Validador.validarConvexo(List.of(
                new int[]{3, 0},
                new int[]{3, 3},
                new int[]{0, 0},
                new int[]{3, 0},
                new int[]{3, 3},
                new int[]{0, 3})), "No");
    }

    @Test
    public void testPoligonoConvexoPositivo() {
        assertEquals(Validador.validarConvexo(List.of(
                new int[]{0, 0},
                new int[]{11, 0},
                new int[]{11, 10},
                new int[]{11, 5},
                new int[]{0, 10})), "Yes");

        assertEquals(Validador.validarConvexo(List.of(
                new int[]{0, 0},
                new int[]{3, 0},
                new int[]{1, 1},
                new int[]{0, 3})), "Yes");
    }
}
