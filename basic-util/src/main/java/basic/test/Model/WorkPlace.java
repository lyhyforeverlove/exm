package basic.test.Model;

public class WorkPlace {
    private String workName;
    private String address;

    public WorkPlace() {
    }

    public WorkPlace(String workName, String address) {
        this.workName = workName;
        this.address = address;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "WorkPlace{" +
                "workName='" + workName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
