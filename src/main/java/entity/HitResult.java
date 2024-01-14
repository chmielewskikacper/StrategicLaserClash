package entity;

import entity.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "hitResults")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HitResult extends BaseEntity {

//    @ManyToOne
//    @JoinColumn(name = "gamer_id")
    private int gamerId;

    private int hits;
}
