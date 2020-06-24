package labs.lab2;

public class Lab2 {

    public static void main(String[] args) {
        System.out.println(Person.toJson(new Person("Michael", "Canada", 23)));
        System.out.println(Person.fromJson("{\"name\":\"Michael\",\"address\":\"Canada\",\"age\":23}"));
    }
}
