import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path to file:");
        File file = new File(scanner.nextLine());
        try {
            List<String> stringList = Files.readAllLines(file.toPath());
            arrayList = stringList.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        foo(arrayList);
    }

    public static void foo(List<Integer> integerList) {
        Collections.sort(integerList);
        int medianaIndex = integerList.size() / 2;
        int mediana;

        if (medianaIndex % 2 != 0) {
            mediana = integerList.get(medianaIndex);
            int sum = integerList.stream().mapToInt(value -> Math.abs(mediana - value)).sum();
            System.out.println(sum);
        } else {
            mediana = (integerList.get(medianaIndex) - integerList.get(medianaIndex - 1)) / 2;
            int sum = integerList.stream().mapToInt(value -> Math.abs(mediana - value)).sum();
            System.out.println(sum);
        }
    }
}
