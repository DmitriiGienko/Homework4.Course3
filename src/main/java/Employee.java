import javax.persistence.*;

@Entity
@Table(name = "employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @Column(name = "city_id")
    private int city;

    public Employee() {
    }

    public Employee(String first_name, String lastName, String gender, int age, int city) {

        this.firstName = first_name;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCityId() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Соторудник c " +
                "id: " + id +
                ", имя: " + firstName +
                ", фамилия: " + lastName +
                ", пол: " + gender +
                ", возраст: " + age +
                ", город проживания: " + city;
    }
}
