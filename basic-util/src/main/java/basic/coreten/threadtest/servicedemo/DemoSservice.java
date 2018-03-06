package basic.coreten.threadtest.servicedemo;

/**接口可用于多继承：只要实现类中实现了所有接口就可以，重复的接口只要实现其中的一个就可以
 * @author ying
 */
public interface DemoSservice extends PersonService,UserService {
    String getAddress();

    void getName();
}
