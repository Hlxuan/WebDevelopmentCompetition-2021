package com.gkd.store.controllers;

import com.gkd.store.dao.ProductRepository;
import com.gkd.store.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
*   @Controller注解的作用是什么？
* */
@Controller
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    /*
    *   这个方法的作用是？
    * */
    @RequestMapping(path = "/products/add", method = RequestMethod.GET)
    public String createProduct(Model model) {

        model.addAttribute("product", new Product());
        return "edit";
    }

    /*
     *   这个方法的作用是？
     * */
    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public String saveProduct(Product product) {

        productRepository.save(product);
        return "redirect:/";
    }

    /*
     *   这个方法的作用是？
     * */
    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public String getAllProducts(Model model) {

        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    /*
     *   这个方法的作用是？
     * */
    @RequestMapping(path = "/products/edit/{id}", method = RequestMethod.GET)
    public String editProduct(Model model, @PathVariable("id") String id) {

        model.addAttribute("product", productRepository.getById(id));
        return "edit";
    }

    /*
     *   这个方法的作用是？
     * */
    @RequestMapping(path = "/products/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") String id) {

        productRepository.deleteById(id);
        return "redirect:/products";
    }

    /*
     *   这个方法的作用是？
     * */
    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(Model model) {

        model.addAttribute("register", productRepository.findAll());
        return "register";
    }

    /*
     *   这个方法的作用是？
     * */
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model) {

        model.addAttribute("login", productRepository.findAll());
        return "login";
    }

}
