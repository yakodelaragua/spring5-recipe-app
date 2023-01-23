package yara.springframework.spring5recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yara.springframework.spring5recipeapp.domain.Category;
import yara.springframework.spring5recipeapp.domain.UnitOfMeasure;
import yara.springframework.spring5recipeapp.repositories.CategoryRepository;
import yara.springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;
import yara.springframework.spring5recipeapp.services.RecipeService;

import java.util.Optional;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
