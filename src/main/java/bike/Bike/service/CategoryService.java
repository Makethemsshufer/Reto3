/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bike.Bike.service;

import bike.Bike.model.Category;
import bike.Bike.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wmg_m
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int CategoryId) {
        return categoryRepository.getCategory(CategoryId);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> myCategory = categoryRepository.getCategory(category.getId());

            if (myCategory.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }

    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> myCategory = categoryRepository.getCategory(category.getId());
            if (!myCategory.isEmpty()) {
                if (category.getDescription() != null) {
                    myCategory.get().setDescription(category.getDescription());
                }
                if (category.getName() != null) {
                    myCategory.get().setName(category.getName());
                }
                return categoryRepository.save(myCategory.get());
            }
        }
        return category;
    }

    
      public boolean deleteCategory(int categoryId){
        Boolean myCategory = getCategory(categoryId).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return myCategory;
    }
    
}
