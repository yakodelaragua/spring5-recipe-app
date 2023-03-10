package yara.springframework.spring5recipeapp.services;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import yara.springframework.spring5recipeapp.domain.Recipe;
import yara.springframework.spring5recipeapp.repositories.RecipeRepository;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;
    public ImageServiceImpl(RecipeRepository recipeService) {
        this.recipeRepository = recipeService;
    }
    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {
        log.debug("Received a file");

        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();
            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;
            for(byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }

            recipe.setImage(byteObjects);
            recipeRepository.save(recipe);

        } catch (IOException e) {
            log.error("Error ocurred", e);
            e.printStackTrace();
        }
    }
}