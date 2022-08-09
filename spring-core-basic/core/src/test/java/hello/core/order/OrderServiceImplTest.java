package hello.core.order;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemoryMemberRepository;
import hello.core.discount.FixDiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memeberRepository = new MemoryMemberRepository();
        memeberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memeberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}