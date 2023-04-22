public class Employee {

    private int id;
    private final String firstName;
    private final String lastName;
    private final String gender;
    private final int age;
    private final String cityName;

    public Employee(String first_name, String lastName, String gender, int age, String cityName) {

        this.firstName = first_name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.cityName = cityName;
    }

    public Employee(int id, String firstName, String lastName, String gender, int age, String cityName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Соторудник c " +
                "id: " + id +
                ", имя: " + firstName +
                ", фамилия: " + lastName +
                ", пол: " + gender +
                ", возраст: " + age +
                ", город проживания: " + cityName;
    }
}
