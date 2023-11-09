import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Nout> ноутбуки = new HashSet<>();
        ноутбуки.add(new Nout("Модель 1", 8, 512, "Windows", "Серый"));
        ноутбуки.add(new Nout("Модель 2", 16, 1024, "MacOS", "Серебристый"));
        ноутбуки.add(new Nout("Модель 3", 8, 256, "Linux", "Черный"));


        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> критерии = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объём ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int выбранныйКритерий = scanner.nextInt();
        scanner.nextLine(); // Считывание символа новой строки после ввода числа

        switch (выбранныйКритерий) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                int минимальныйОбъемОЗУ = scanner.nextInt();
                критерии.put(1, минимальныйОбъемОЗУ);
                break;

            case 2:
                System.out.println("Введите минимальный объём ЖД:");
                int минимальныйОбъемЖД = scanner.nextInt();
                критерии.put(2, минимальныйОбъемЖД);
                break;

            case 3:
                System.out.println("Введите операционную систему:");
                String операционнаяСистема = scanner.nextLine();
                критерии.put(3, операционнаяСистема);
                break;

            case 4:
                System.out.println("Введите цвет:");
                String цвет = scanner.nextLine();
                критерии.put(4, цвет);
                break;

            default:
                System.out.println("Некорректный выбор критерия.");
                return;
        }


        Set<Nout> результаты = Nout.фильтроватьНоутбуки(ноутбуки, критерии);
        if (результаты.isEmpty()) {
            System.out.println("Нет ноутбуков, удовлетворяющих заданным критериям.");
        } else {
            System.out.println("Найденные ноутбуки:");
            for (Nout ноутбук : результаты) {
                System.out.println(ноутбук.getМодель());
            }
        }
    }
}