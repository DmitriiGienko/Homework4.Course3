public class Employee {

    private int id;
    private final String firstName;
    private final String lastName;
    private final String gender;
    private final int age;
    private final City city;

    public Employee(String first_name, String lastName, String gender, int age, City city) {

        this.firstName = first_name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public Employee(int id, String firstName, String lastName, String gender, int age, City city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

//    public City getCityName() {
//        return city;
//    }

    public City getCity() {
        return city;
    }



    @Override
    public String toString() {
        return "Соторудник c " +
                "id: " + id +
                ", имя: " + firstName +
                ", фамилия: " + lastName +
                ", пол: " + gender +
                ", возраст: " + age +
                ", город проживания: " + city.getCityName();
    }
}
