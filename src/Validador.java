import java.util.List;

public class Validador {
    public static String validarPoligono(List<int[]> pontos) {
        return validarConvexo(pontos) ? "Yes" : "No";
    }

    public static String validarPontoCritico(List<int[]> pontos) {
        return validarConvexo(pontos) ? "No" : "Yes";
    }

    private static boolean validarConvexo(List<int[]> pontos) {
        if (CCW(pontos.get(0), pontos.get(1), pontos.get(2))) {
            for (int i = 0; i < pontos.size() - 2; i++)
                if (!CCW(pontos.get(i), pontos.get(i + 1), pontos.get(i + 2))) return false;
        } else {
            for (int i = 0; i < pontos.size() - 2; i++)
                if (CCW(pontos.get(i), pontos.get(i + 1), pontos.get(i + 2))) return false;
        }
        return true;
    }

    private static boolean CCW(int[] pontoA, int[] pontoB, int[] pontoC) {
        return (pontoB[0] - pontoA[0]) * (pontoC[1] - pontoA[1]) - (pontoB[1] - pontoA[1]) * (pontoC[0] - pontoA[0]) < 0;
    }
}
