import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CakeOrder order = new CakeOrder(new ClassicCake());

        // Получаем выбор пользователя для типа коржа
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип коржа:");
        System.out.println("1. Классический");
        System.out.println("2. Шоколадный");
        int cakeType = scanner.nextInt();

        // Добавляем выбранный тип коржа в заказ
        if (cakeType == 2) {
             order = new CakeOrder(new ChocolateCake());
        }


        // Получаем выбор пользователя для типа пропитки
        System.out.println("Выберите тип пропитки:");
        System.out.println("1. Фруктовая");
        System.out.println("2. Ягодная");
        int fillingType = scanner.nextInt();

        // Добавляем выбранный тип пропитки в заказ
        if (fillingType == 2) {
            order.addDecorator(new BerryDecorator(order.cake));
        } else {
            order.addDecorator(new FruitDecorator(order.cake));
        }

        // Получаем выбор пользователя для типа глазури
        System.out.println("Выберите тип глазури:");
        System.out.println("1. Сливочная");
        System.out.println("2. Шоколадная");
        int icingType = scanner.nextInt();

        // Добавляем выбранный тип глазури в заказ
        if (icingType == 4) {
            order.addDecorator(new ChocolateDecorator(order.cake));
        } else {
            order.addDecorator(new CreamDecorator(order.cake));
        }

        // Выводим информацию о заказе на экран
        System.out.println(order.getDescription());
    }
}
// Интерфейс компонента, представляющий торт
interface Cake {
    String getDescription();
}

// Класс конкретного компонента, представляющий классический корж торта
class ClassicCake implements Cake {
    @Override
    public String getDescription() {
        return "классический корж";
    }
}

// Класс конкретного компонента, представляющий шоколадный корж торта
class ChocolateCake implements Cake {
    @Override
    public String getDescription() {
        return "шоколадный корж";
    }
}

// Абстрактный класс декоратора, который будет расширять функциональность компонента
abstract class CakeDecorator implements Cake {
    protected Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    @Override
    public String getDescription() {
        return cake.getDescription();
    }
}

// Класс декоратора, представляющий фруктовую пропитку для торта
class FruitDecorator extends CakeDecorator {
    public FruitDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getDescription() {
        return cake.getDescription() + ", фруктовая пропитка";
    }
}

// Класс декоратора, представляющий ягодную пропитку для торта
class BerryDecorator extends CakeDecorator {
    public BerryDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getDescription() {
        return cake.getDescription() + ", ягодная пропитка";
    }
}

// Класс декоратора, представляющий сливочную глазурь для торта
class CreamDecorator extends CakeDecorator {
    public CreamDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getDescription() {
        return cake.getDescription() + ", сливочная глазурь";
    }
}

// Класс декоратора, представляющий шоколадную глазурь для торта
class ChocolateDecorator extends CakeDecorator {
    public ChocolateDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getDescription() {
        return cake.getDescription() + ", шоколадная глазурь";
    }
}

// Класс, представляющий оформление заказа на торт
class CakeOrder {
    Cake cake;

    public CakeOrder(Cake cake) {
        this.cake = cake;
    }

    public void addDecorator(CakeDecorator decorator) {
        cake = decorator;
    }

    public String getDescription() {
        return "Был заказан следующий торт: " + cake.getDescription() + ". Все верно?";
    }
}