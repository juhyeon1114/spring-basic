package hello.springbasic.scan;

import hello.springbasic.AutoAppConfig;
import hello.springbasic.member.MemberRepository;
import hello.springbasic.member.MemberService;
import static org.assertj.core.api.Assertions.*;

import hello.springbasic.order.OrderServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    public void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = bean.getMemberRepository();

        System.out.println("memberRepository = " + memberRepository);
    }
}
