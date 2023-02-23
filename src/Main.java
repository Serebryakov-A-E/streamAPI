import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        List<Integer> list = List.of(1, 2, 3, 50, 88, 184, 0, -10, 56);

        m.findMinMax(list.stream(), Comparator.comparingInt(i -> i), (integer, integer2) -> System.out.printf("min = %d, max = %d", integer, integer2));

        m.countEvenNumbers(list);
    }

    public <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.sorted(order).toList();

        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            T min = list.get(0);
            T max = list.get(list.size() - 1);
            minMaxConsumer.accept(min, max);
        }
    }

    public void countEvenNumbers(List<Integer> list) {
        List<Integer> even = list.stream()
                .filter(x -> x % 2 == 0)
                .toList();
        System.out.println("\nКоличество четных чисел в списке = " + even.size());
        even.forEach(System.out::println);
    }
}
