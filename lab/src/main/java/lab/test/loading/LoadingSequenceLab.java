package lab.test.loading;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 验证 Java 中静态代码块、构造代码块、构造函数与@PostConstruct注解函数的执行顺序
 * 需要依赖 Spring
 *
 * @author jasonsong
 * 2019/4/22
 */

//@Component
public class LoadingSequenceLab {

    static {
        System.out.println("static code area");
    }

    {
        System.out.println("code area");
    }

    public LoadingSequenceLab() {
        System.out.println("construct");
    }

    public static void staticMethod() {
        System.out.println("staticMethod");
    }

    @PostConstruct
    public void init() {
        System.out.println("postConstruct");

    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("preDestroy");

    }

    public void generalMethod() {
        {
            System.out.println("general code area");

        }
    }


}

/**
 * 测试类
 *
 * @RunWith(SpringJUnit4ClassRunner.class)
 * @ContextConfiguration({"classpath*:applicationContext.xml"}) public class LoadingSequenceLabTest {
 * @Autowired LoadingSequenceLab loadingSequenceLab;
 * @Test public void test() {
 * loadingSequenceLab.generalMethod();
 * System.out.println("----------------------------");
 * LoadingSequenceLab loadingSequenceLab1=new LoadingSequenceLab();
 * loadingSequenceLab1.generalMethod();
 * System.out.println("----------------------------");
 * <p>
 * }
 * @Test public void test1() {
 * LoadingSequenceLab.staticMethod();
 * }
 * <p>
 * <p>
 * }
 **/
