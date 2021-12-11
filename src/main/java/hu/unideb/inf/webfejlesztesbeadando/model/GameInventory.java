package hu.unideb.inf.webfejlesztesbeadando.model;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class GameInventory {

    @Id
    @SequenceGenerator(
            name = "gameinventory_sequence",
            sequenceName = "gameinventory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gameinventory_sequence"
    )
    private Long id;

    private String itemName;
    private Integer rarity;
    private String itemClass;
    private Integer count;
    private Integer level;

    public GameInventory(String itemName, Integer rarity, String itemClass, Integer count, Integer level) {
        this.itemName = itemName;
        this.rarity = rarity;
        this.itemClass = itemClass;
        this.count = count;
        this.level = level;
    }
}
