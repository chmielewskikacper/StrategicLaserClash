package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hitResults")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HitResult {

    @ManyToOne
    private Gamer gamer;

    private int hits;
}
