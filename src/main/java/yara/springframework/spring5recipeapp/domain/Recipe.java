package yara.springframework.spring5recipeapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private String directions;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();
    @Lob
    private Byte[] image;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Recipe() {
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getPrepTime() {
        return this.prepTime;
    }

    public Integer getCookTime() {
        return this.cookTime;
    }

    public Integer getServings() {
        return this.servings;
    }

    public String getSource() {
        return this.source;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDirections() {
        return this.directions;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public Set<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public Byte[] getImage() {
        return this.image;
    }

    public Notes getNotes() {
        return this.notes;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String toString() {
        return "Recipe(id=" + this.getId() + ", description=" + this.getDescription() + ", prepTime=" + this.getPrepTime() + ", cookTime=" + this.getCookTime() + ", servings=" + this.getServings() + ", source=" + this.getSource() + ", url=" + this.getUrl() + ", directions=" + this.getDirections() + ", difficulty=" + this.getDifficulty() + ", ingredients=" + this.getIngredients() + ", image=" + java.util.Arrays.deepToString(this.getImage()) + ", notes=" + this.getNotes() + ", categories=" + this.getCategories() + ")";
    }
}
