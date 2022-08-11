package com.gkd.store.boot;

import com.gkd.store.dao.ProductRepository;
import com.gkd.store.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
*   1. @Component的作用是什么？
*   2. 这个Java类的作用是什么？
*/
@Component
public class DataLoader implements CommandLineRunner {

    private ProductRepository productRepository;

    /*
    *   @Autowired的作用是什么？
    *   这种依赖注入的方法的名称是什么？
    **/
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /*
    *   下面这个方法的用途是什么？
    * */
    @Override
    public void run(String... args) throws Exception {

        Product product1 = new Product();
        product1.setName("Iphone");
        product1.setImg("https://source.unsplash.com/300x300/?iphone");
        product1.setDescription("iPhone是苹果公司研发及销售的智能手机系列，搭载该公司研发的iOS移动操作系统。");
        product1.setType("手机");
        product1.setCategory("电子设备");
        product1.setPrice(6999.99);

        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Ipad");
        product2.setImg("https://source.unsplash.com/300x300/?ipad");
        product2.setDescription("iPad 用处多多，做各种事都是一把好手。无论你是攻克项目，挥洒创意，还是来一局畅快淋漓的游戏，iPad 都会让你用得带劲又带感。");
        product2.setType("平板电脑");
        product2.setCategory("电子设备");
        product2.setPrice(5999.99);

        productRepository.save(product2);
    }
}
