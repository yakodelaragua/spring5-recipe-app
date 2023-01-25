package yara.springframework.spring5recipeapp.services;

import yara.springframework.spring5recipeapp.commands.RecipeCommand;
import yara.springframework.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Object findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long l);

    void deleteById(Long valueOf);
}
