package ru.geekbrains.lesson5;

public class MainHomeWork5 {
    public static void main(String[] args) {
        Employee employee = new Employee("Иванов Иван Иванович", "Самый главный", "blabla@blabla.bla", "+777777", 2, 43);

        employee.showInfo();

        Employee[]  arrayEmployee = new Employee[5];
        arrayEmployee[0] = new Employee("Иванов Иван Иванович","Самый главный", "blabla@blabla.bla", "+777777", 5, 50);
        arrayEmployee[1] = new Employee("Сергеев Сергей Сергеевич","Первый после главного", "bla@bla.bla", "+6666666", 4, 43);
        arrayEmployee[2] = new Employee("Дмитриев Дмитрий Дмитриевич","Второй после главного", "ifif@blaif.bla", "+5555555", 3, 39);
        arrayEmployee[3] = new Employee("Артемов Артем Артемович","Второй с конца", "email@email.bla", "+4444444", 2, 51);
        arrayEmployee[4] = new Employee("Павлов Павел Павлович","Первый с конца", "emailbla@blabla.bla", "+3333333", 1, 20);

        for (int i = 0; i < arrayEmployee.length ; i++) {
            if (arrayEmployee[i].getAge() > 40 ) {
                arrayEmployee[i].showInfo();
            }
        }
    }

}



