package org.example.app.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Product {

    private Integer id;
    private String name;
    private Integer quota;
    private  Double price;

    @Override
    public String toString() {
        return "id - " + this.getId() +
                ", name: " + this.getName() +
                ", quota: " + this.getQuota() +
                ", price: " + this.getPrice() + "\n";
    }
}
