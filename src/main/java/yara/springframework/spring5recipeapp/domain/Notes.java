package yara.springframework.spring5recipeapp.domain;

import jakarta.persistence.*;

@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipèNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipèNotes() {
        return recipèNotes;
    }

    public void setRecipèNotes(String recipèNotes) {
        this.recipèNotes = recipèNotes;
    }
}
