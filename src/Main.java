import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n;
            while ((n = sc.nextInt()) != 0) {
                List<int[]> pontos = new ArrayList<>(n + 2);
                for (int i = 0; i < n; i++) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    pontos.add(new int[]{x, y});
                }
                System.out.println(validarConvexo(pontos));
            }
        }
    }

    private static String validarConvexo(List<int[]> pontos) {
        pontos.add(pontos.get(0));
        pontos.add(pontos.get(1));

        if (CCW(pontos.get(0), pontos.get(1), pontos.get(2)) >= 0) {
            for (int i = 1; i < pontos.size() - 2; i++)
                if (CCW(pontos.get(i), pontos.get(i + 1), pontos.get(i + 2)) < 0) return "Yes";
        } else {
            for (int i = 1; i < pontos.size() - 2; i++)
                if (CCW(pontos.get(i), pontos.get(i + 1), pontos.get(i + 2)) > 0) return "Yes";
        }
        return "No";
    }

    private static double CCW(int[] pontoA, int[] pontoB, int[] pontoC) {
        return (pontoB[0] - pontoA[0]) * (pontoC[1] - pontoA[1]) - (pontoB[1] - pontoA[1]) * (pontoC[0] - pontoA[0]);
    }
}