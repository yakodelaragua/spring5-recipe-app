package yara.springframework.spring5recipeapp.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import yara.springframework.spring5recipeapp.domain.Recipe;
import yara.springframework.spring5recipeapp.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() throws Exception {
        //Crea una lista de recetas
        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        //Haz como si la base de datos devolviese eso
        when(recipeRepository.findAll()).thenReturn(recipesData);

        //Esto deberia de devolver lo que tiene la base de datos
        Set<Recipe> recipes = recipeService.getRecipes();

        //Comprueba que solo hay un elemento
        assertEquals(recipes.size(), 1);
        //Comprueba que solo se le llama una vez a recipeRepository
        Mockito.verify(recipeRepository, times(1)).findAll();

    }
}