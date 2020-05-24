package com.zimingsir.cart.dao;

import com.zimingsir.cart.pojo.entity.Cart;
import com.zimingsir.cart.pojo.vo.ShopVO;
import com.zimingsir.cart.pojo.vo.SkuVO;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
class CartDAOTest {

    @Autowired
    CartDAO cartDAO;

    @Test
    void getId() {
        // Integer id = cartDAO.getId(1, 1);

        // log.info(id.toString());

    }

    // @Test
    // void addNumber() {
    //     log.info(cartDAO.getId(1, 1).toString());
    // }

    @Test
    void insert() {
        Cart cart = buildCart(11, 22);
        cartDAO.insert(cart);
    }

    private Cart buildCart(Integer userId, Integer skuId) {
        Cart cart = new Cart();
        cart.setUserId(userId).setSkuId(skuId).setNumber(1).setCreateBy(userId).setCreateTime(LocalDateTime.now());
        return cart;
    }

    @Test
    void lock() {
        cartDAO.lock(2);
        // Assert.assertEquals("乐观锁 lock 之后 revision 没有加一", Integer.valueOf(1), cartDAO.get(2).getRevision());
        cartDAO.lock(2);
        // Assert.assertEquals("乐观锁两次 lock 之后 revision 没有等于1",Integer.valueOf(1),cartDAO.get(2).getRevision());
        cartDAO.unlock(2, 1);
        // Assert.assertEquals("乐观锁 unlock 之后 revision 没有加一",Integer.valueOf(0),cartDAO.get(2).getRevision());

    }

    @Test
    void getValue() {
        List<String> values = cartDAO.getValue("1_4_6_8");
        Assert.assertNotNull(values);
    }

    @Test
    void getByUserId() {
        Assert.assertNotNull(cartDAO.getByUserId(1));
        for (ShopVO s : cartDAO.getByUserId(1)) {
            log.info(s.getShopName());
            for (SkuVO sku : s.getSkuVOs()) {
                log.info(sku.toString());
            }
            log.info("============== 商品分割线 ==================");
        }
    }

}