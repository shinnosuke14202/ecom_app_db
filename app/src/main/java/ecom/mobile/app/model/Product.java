package ecom.mobile.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String author;
    private String description;
    private int rating;
    private int price;

    private String type;

    @Lob
    @Column(
            name = "image",
            columnDefinition = "MEDIUMBLOB"
    )
    private byte[] image;

    private int clickAfterSuggestByAI;

    @ManyToMany
    private List<Category> categories;

}
