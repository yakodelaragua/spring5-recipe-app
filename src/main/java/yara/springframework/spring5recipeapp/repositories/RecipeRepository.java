package yara.springframework.spring5recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import yara.springframework.spring5recipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
