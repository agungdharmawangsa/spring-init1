package springtutorial1.example.springtutorial1.dto;

import jakarta.validation.constraints.NotEmpty;

public class categoryData {

    @NotEmpty(message = "name is required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
