package entity;

import entity.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "gamers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gamer extends BaseEntity {

    private String name;
    private int teamColor;
    private int tagerType;
    private String tagerTypeName;
    private int fireCount;
    private int killed;
    private int medicine;
    private int damage;

    private LocalTime gameTime;

    @OneToMany(mappedBy = "gamer")
    private List<HitResult> hitResults;

}
