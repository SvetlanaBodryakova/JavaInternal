package org.example;

// 1) Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
//      Конструктор класса должен заполнять эти поля при создании объекта.
//      Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
// 2) Создать массив из 5 сотрудников.
//      С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
// 3) Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об
// аттракционах, времени их работы и стоимости.

public class Main {
    public static void main(String[] args) {

        Employee[] employee = new Employee[5];
        employee[0] = new Employee("Иванов Иван", "тестировщик", "ivanov@test.com", "+37529999999", 5000, 30);
        employee[1] = new Employee("Петров Петр", "разработчик", "petrov@test.com", "+375299998888", 5000, 42);
        employee[2] = new Employee("Сидоров Иван", "менеджер", "sidorov@test.com", "+375299997777", 5000, 45);
        employee[3] = new Employee("Андреев Андрей", "аналитик", "andreev@test.com", "+375299996666", 5000, 28);
        employee[4] = new Employee("Федоров Федор", "бухгалтер", "fedorov@test.com", "+375299995555", 5000, 50);

        for (Employee e : employee) {
            if (e.getAge() > 40)
                e.displayInfo();
            System.out.println();
        }

        Park park = new Park("Парк аттракционов", 3);
        park.addAttraction(0, "Вальс", "10.00-21.00", 15.00);
        park.addAttraction(1, "Сюрприз", "10.00-21.00", 17.00);
        park.addAttraction(2, "Веселые горки", "12.00-22.00", 20.00);

        park.getAttractionInfo();
    }
}