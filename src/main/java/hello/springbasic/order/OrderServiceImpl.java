package hello.springbasic.order;

import hello.springbasic.annotation.MainDiscountPolicy;
import hello.springbasic.discount.DiscountPolicy;
import hello.springbasic.member.Member;
import hello.springbasic.member.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Getter
//@RequiredArgsConstructor // final 또는 @NotNull이 붙은 필드에 대한 constructor를 자동으로 생성해줌. -> constructor를 따로 만들필요도 없고, @Autowired를 쓸 필요도 없다.
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
