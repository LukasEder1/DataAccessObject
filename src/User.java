public class User {
    private String name;
    private String surname;
    private String username;

    public User(String name, String surname, String username) {
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }
}
