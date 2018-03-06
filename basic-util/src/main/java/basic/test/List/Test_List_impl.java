package basic.test.List;

public class Test_List_impl implements Test_List_1,Test_List{

    @Override
    public Integer getAge(String name) {
        return null;
    }

    @Override
    public String getName(Integer id) {
        return "abstract class Test_List_impl ---> getName(Integer id)";
    }
    //让人员自己选择，如有集成类，遵循类优先原则
    @Override
    public String getName() {
        return Test_List.super.getName();
    }
}
