package tn.esprit.pidev.bns.controller.hadir;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.hadir.Category;
import tn.esprit.pidev.bns.serviceInterface.hadir.ICategorieService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Category")
public class CategoryController {

ICategorieService categorieService;

    @GetMapping("/retrieve-all-Categorys")
    public List<Category> getCategorys() {
        List<Category> listCategorys = categorieService.retrieveAllCategorys();
        return listCategorys;
    }
    @GetMapping("/retrieve-Category/{Category-id}")
    public Category retrieveCategory(@PathVariable("Category-id") Integer contratId) {
        return categorieService.retrieveCategory(contratId);
    }
    @PostMapping("/add-Category")
    public Category addCategory(@RequestBody Category c) {
        Category category = categorieService.addCategory(c);
        return category;
    }

    @DeleteMapping("/remove-Category/{Category-id}")
    public void removeContrat(@PathVariable("Category-id") Integer categoryId) {
        categorieService.removeCategory(categoryId);
    }
    @PutMapping("/update-Category")
    public boolean updateCategory(@RequestBody Category c) {
        return categorieService.updateCategory(c);
    }
}
