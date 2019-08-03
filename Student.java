package Arrays;

import javax.xml.bind.SchemaOutputResolver;

public class Student {

    private String lastName;
    private String firstName;
    private int age;

    public Student (String last, String first, int x)  // конструктор
    {
        lastName = last;
        firstName = first;
        age = x;
    }

    public void displayStudent()
    {
        System.out.print(" Фамилия: " + lastName);
        System.out.print(" Имя: " + firstName);
        System.out.println(" Возраст: " + age);
    }
    public String getLast()  // получение фамилии
    {
        return lastName;
    }
}  // конец класс "Студент"
////////////////////////
class ArrayStudent {
    private Student[] list;                               // переменная-массив
    private int quantity;                                // переменная кол-во элементов

    public ArrayStudent(int max)                         // конструктор
    {
        list = new Student[max];
        quantity = 0;                                     //пока нет элементов в массиве
    }

    public Student search(String searchName)                // ПОИСК заданного значения в массиве
    {
        int i;
        for(i=0; i<quantity; i++)
            if(list[i].getLast().equals(searchName))          // значение найдено?
                break;                                      // выход из цикла
            if (i == quantity)                              // если элемент последний
                return null;                                // значение не найдено
            else
                return list[i];                               // значение найдено
    }

public void insert( String last,String first, int age)        // ВСТАВКА в массив
{
    list[quantity]= new Student(last, first, age);
    quantity++;
}

public boolean delete(String searchName)                                // УДАЛЕНИЕ из массива
{
    int i;
    for (i = 0; i < quantity; i++)                                          // поиск элемента для удаления
        if (list[i].getLast().equals(searchName))
            break;
    if (i == quantity)
        return false;                                           //найти не удалось
    else {
        for (int n = i; n < quantity; i++)                           //СДВИГ ПОСЛЕДУЮЩЕГО ЭЛЕМЕНТА
            list[n] = list[n + 1];
        quantity--;                                             // меньшение размера массива
        return true;
        }
    }

    public void displayList()                                   //Вывод содержимого массива
    {
        for (int i=0; i<quantity; i++)                          // для каждого элемента
            list[i].displayStudent();                           // Вывод
    }
}
/////////////////////////

class CurrentStudents
{
    public static void main (String[] args) {
        int maxSize = 50;                                          //Размер массива
        ArrayStudent all;                                             // ссылка на массив
        all = new ArrayStudent(maxSize);                         //создание массива
        all.insert("Ivanov", "Roma", 20);
        all.insert("Titov", "Dima", 22);
        all.insert("Sokolov", "Nikonor", 19);
        all.insert("Popov", "Vlad", 18);
        all.insert("Gabrilyan", "Artur", 21);

        all.displayList();                                          //Вывод содержимого
        String searchKey = "Titov";
        Student found;
        found = all.search(searchKey);
        if (found != null) {
            System.out.print("Найден");
            found.displayStudent();
        } else
            System.out.println("Не найден: " + searchKey);

        System.out.println("Удален Titov, Popov");
        all.delete("Titov");
        all.delete("Popov");

        all.displayList();                                              // повторный вывод содержимого

             }

    }


