package lab.test;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @author jasonsong
 * 2020/4/21
 */

@Configurable
@Slf4j
public class SpringTest {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 作为配置类（Configuration Class）
        applicationContext.register(SpringTest.class);

        // 启动应用上下文
        applicationContext.refresh();

        Map<String, SessionDTO> beansOfType = applicationContext.getBeansOfType(SessionDTO.class);

        beansOfType.forEach((key, value) -> log.info("beansOfType key:{},value:{}", key, JSON.toJSONString(value)));

        applicationContext.close();

    }

    @Bean()
    public SessionDTO sessionDTO() {
        return new SessionDTO("1");
    }

    @Bean()
    public SessionDTO sessionDTO1() {
        return new SessionDTO("2");
    }

    @Bean
    public SessionDTO sessionDTO2() {
        return new SessionDTO("3");
    }

}
