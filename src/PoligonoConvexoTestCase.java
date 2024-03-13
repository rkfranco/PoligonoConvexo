import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class PoligonoConvexoTestCase {

    @Test
    public void testPoligonoConvexoPositivo() {
        assertEquals(Validador.validarPoligono(List.of(
                new int[]{0, 0},
                new int[]{0, 10},
                new int[]{30, 10},
                new int[]{30, 0},
                new int[]{0, 30},
                new int[]{30, 30})), "Yes");

        assertEquals(Validador.validarPoligono(List.of(
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{100, 0},
                new int[]{50, 100},
                new int[]{30, 30},
                new int[]{50, 90})), "Yes");

        assertEquals(Validador.validarPoligono(List.of(
                new int[]{3, 0},
                new int[]{3, 3},
                new int[]{0, 0},
                new int[]{3, 0},
                new int[]{3, 3},
                new int[]{0, 3})), "Yes");
    }

    @Test
    public void testPoligonoConvexoNegativo() {
        assertEquals(Validador.validarPoligono(List.of(
                new int[]{0, 0},
                new int[]{11, 0},
                new int[]{11, 10},
                new int[]{11, 5},
                new int[]{0, 10})), "No");

        assertEquals(Validador.validarPoligono(List.of(
                new int[]{0, 0},
                new int[]{3, 0},
                new int[]{1, 1},
                new int[]{0, 3})), "No");
    }
}
