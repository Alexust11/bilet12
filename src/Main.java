import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static List<String> books1 = new ArrayList<>();
    static Map<Integer, String> shelfs = new HashMap<>();

    public static <books> void main(String[] args) {
        int quantityShelf = 5;
        List<String> books = new ArrayList<>();

        books.add("Первая");
        books.add("Вторая");
        books.add("Третья");
        books.add("Четвертая");
        books.add("Пятая");
        books.add("Шестая");
        books.add("Седьмая");
        books.add("Восьмая");
        books.add("Девятая");
        books.add("Десятая");
        books.add("Одиннацатя");
        books.add("Двенадцатая");
        books.add("Тринадцатая");
        books.add("Четырнадцатая");
        books.add("Пятнадцатая");
        books.add("Шестнадцатая");
        books.add("Семнадцатая");
        books.add("Восемнадцатая");
        books.add("Девятнадцатая");

        books1 = books.stream().sorted().collect(Collectors.toList());
        System.out.println(books1);
        // если число книг кратно числу полок, то книги делятся поровну на все полки.
        // если число книг не кратно числу полок, то книги делятся (нацело) по числу полок-1, остаток вносится на последнюю полку
        int quantityBookOfShelf = 0;
        if (books1.size() % quantityShelf == 0) {
            quantityBookOfShelf = books1.size() / quantityShelf;//число книг на одной полке
            decompose(books1.size(), quantityBookOfShelf, quantityShelf);
            System.out.println(shelfs);
        } else {
            quantityBookOfShelf = books1.size() / (quantityShelf - 1);
            int remains = books1.size() % quantityBookOfShelf; // остаток книг на последнюю полку
            decompose(books1.size() - remains, quantityBookOfShelf, quantityShelf - 1);
            shelfs.put(quantityShelf, books1.subList(books1.size() - remains, books1.size()).toString());
            System.out.println(shelfs);
        }

    }

    private static void decompose(int size, int quantityBookOfShelf, int quantityShelf) {
        int count = 0;
        String s = "";
        for (int i = 1; i <= quantityShelf; i++) {
            for (int j = 0; j < quantityBookOfShelf; j++) {
                if (count < books1.size()) {
                    s = s + books1.get(count) + ", ";
                    shelfs.put(i, s);
                }
                count++;
            }
            s = "";
        }
    }

}


