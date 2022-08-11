package br.com.casadocodigo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(value = "api/category")
    @Transactional
    public void newCategory(@Valid @RequestBody NewCategoryForm newCategoryForm) {
        Category newCategory = newCategoryForm.newCategory();
        categoryRepository.save(newCategory);
    }
}
