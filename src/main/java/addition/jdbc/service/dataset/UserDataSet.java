package addition.jdbc.service.dataset;

/**
 * Created by alterG on 18.07.2017.
 */
public class UserDataSet {
    private long id;
    private String name;

    public UserDataSet(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
