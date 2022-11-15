package hello.springbasic.lifecycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); // 서버 종료
    }

    @Configuration
    static class LifeCycleConfig {
        /**
         * destroyMethod의 기본값은 (inferred)이다.
         * (inferred)는 (추론)이라는 뜻이다.
         * Class에 close() 또는 shutdown()을 찾아서 종료 메소드로 사용한다.
         * destroyMethod를 ""으로 설정하면 추론기능이 동작하지 않는다.
         */
//        @Bean(initMethod = "init", destroyMethod = "close")
//        public NetworkClient networkClient() {
//            NetworkClient nc = new NetworkClient();
//            nc.setUrl("https://hello.com");
//            return nc;
//        }

        @Bean()
        public NetworkClient networkClient() {
            NetworkClient nc = new NetworkClient();
            nc.setUrl("https://hello.com");
            return nc;
        }
    }
}
