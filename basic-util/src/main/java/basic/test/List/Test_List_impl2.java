package basic.test.List;

public interface Test_List_impl2 extends Test_List {

    @Override
    default Integer getAge(String name) {
        return 20;
    }
}
