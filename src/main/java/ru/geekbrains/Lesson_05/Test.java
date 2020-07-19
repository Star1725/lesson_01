package ru.geekbrains.Lesson_05;

/**
 * Created by User on 018 18.07.20.
 */
public class Test {
    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
            new Employee("Директор", "Иванов Иван Иванович", 54, "IvanDir@mail.ru", "89034768954", 130000),
            new Employee("Секретарь", "Шпак Ирина Андреевна", 25, "secIrinf@mail.ru", "89034875063", 60000),
            new Employee("Программист", "Петров Семён Сергеевич", 28, "prog1Semen@mail.ru", "89033867592", 110000),
            new Employee("Программист", "Сидоров Инакентий Александрович", 24, "prog2Kesha@mail.ru", "890333850375", 80000),
            new Employee("Уборщица", "Мельник Зенаида Ивановна", 62, "-", "89037583502", 30000)};

        for (Employee employee : employees) {
            if (employee.getAge() > 40) employee.printInfo();
        }

    }
}
