package yara.springframework.spring5recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import yara.springframework.spring5recipeapp.domain.Category;
import yara.springframework.spring5recipeapp.domain.UnitOfMeasure;
import yara.springframework.spring5recipeapp.repositories.CategoryRepository;
import yara.springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;

import java.util.Optional;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureRepositoryOptional = unitOfMeasureRepository.findByDescription("Cup");
        System.out.println("Cat id is: " +  categoryOptional.get().getId());
        System.out.println("UOM id is: " +  unitOfMeasureRepositoryOptional.get().getId());


        return "index";
    }
}
