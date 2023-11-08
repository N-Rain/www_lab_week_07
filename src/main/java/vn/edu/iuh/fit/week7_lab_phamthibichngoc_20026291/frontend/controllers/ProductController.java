package vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.models.Product;
import vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.week7_lab_phamthibichngoc_20026291.backend.services.ProductServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductServices productServices;
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/products")
    public String showProductListPaging(HttpSession session, Model model, @RequestParam("page")Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        session.setAttribute("product", "List All Product");

        int currrentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<Product> productPage = productServices.findPaginated(currrentPage - 1, pageSize, "name", "asc");
        model.addAttribute("productPage", productPage);

        int totalPages = productPage.getTotalPages();
        if (totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                                                    .boxed()
                                                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "admin/product/listing";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute("product") Product product, BindingResult result, Model model){
        productRepository.save(product);
        return "redirect:/products";
    }
    @GetMapping("/products/show-add-form")
    public String addForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "admin/product/add-form";
    }
    @GetMapping("/products/delete/{id}")
    public String delete(@PathVariable("id") long id){
        Product product = productRepository.findById(id).orElse(new Product());
        productRepository.delete(product);
        return "redirect:/products";
    }


}
