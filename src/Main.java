import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(readDataInput().stream()
                .map(Main::isConvex)
                .map(b -> b ? "No" : "Yes")
                .collect(Collectors.joining("\n")));
    }

    private static List<List<int[]>> readDataInput() {
        try (Scanner sc = new Scanner(System.in)) {
            List<List<int[]>> polygons = new ArrayList<>();
            int n = sc.nextInt();
            while (n != 0) {
                List<int[]> points = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    points.add(new int[]{x, y});
                }
                polygons.add(points);
                n = sc.nextInt();
            }
            return polygons;
        }
    }

    private static boolean isConvex(List<int[]> pontos) {
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