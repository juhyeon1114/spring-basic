package hello.springbasic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.springbasic",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Configuration.class
        ) // excludeFilters: 컴포넌트 스캔에서 제외할 대상. AppConfig는 컴포넌트 스캔에서 제외
)
public class AutoAppConfig {

}
