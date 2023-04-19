public class Employee {

    private final int id;
    private final String first_name;
    private final String last_name;
    private final String gender;
    private final int age;
    private final String city_name;

    public Employee(int id, String first_name, String last_name, String gender, int age, String city_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city_name = city_name;
    }


    @Override
    public String toString() {
        return "Соторудник c " +
                "id: " + id +
                ", имя: " + first_name +
                ", фамилия: " + last_name +
                ", пол: " + gender  +
                ", возраст: " + age +
                ", город проживания: " + city_name;
    }
}
