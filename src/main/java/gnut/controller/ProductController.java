package gnut.controller;


import gnut.model.Product;
import gnut.service.IProductService;
import gnut.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> productList = productService.findAll();
        modelAndView.addObject("products", productList);
        return modelAndView;
    }
    @GetMapping("create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("products", new Product());
        return modelAndView;
    }

    @PostMapping("save")
    public ModelAndView save(Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        product.setId((int) (Math.random() * 1000));
        productService.save(product);
        return modelAndView;
    }
    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("products", productService.findById(id));
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(Product product){
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        productService.update(product.getId(), product);
        return modelAndView;
    }
    @GetMapping("{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("products",productService.findById(id));
        return modelAndView;
    }
    @PostMapping("delete")
    public ModelAndView delete(Product product, RedirectAttributes redirect){
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        productService.remove(product.getId());
        redirect.addFlashAttribute("Success","Remove product successfully");
        return modelAndView;

    }
    @GetMapping("{id}/view")
    public ModelAndView view(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("products", productService.findById(id));
        return modelAndView;
    }
}

