package br.com.casadocodigo.category;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class CategoryNameUniqueValidator implements Validator {

    private CategoryRepository categoryRepository;

    public CategoryNameUniqueValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NewCategoryForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewCategoryForm form = (NewCategoryForm) target;
        Optional<Category> possibleCategory = categoryRepository.findByName(form.getName());

        if (possibleCategory.isPresent()) {
            errors.rejectValue("name", null, "category.name.unique");
        }
    }
}
