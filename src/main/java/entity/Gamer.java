package entity;

import entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

//@Entity
//@Table(name = "gamers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gamer extends BaseEntity {
//    @Column(name = "name")
    private  String name;
//    @Column(name= "gamer_id")
    private int gamerID;
//    @Column(name = "team_color")
    private int teamColor;
//    @Column(name = "tager_type")
    private int tagerType;
//    @Column(name = "tager_type_name")
    private String tagerTypeName;
//    @Column(name = "fire_count")
    private int fireCount;
//    @Column(name = "killed")
    private int killed;
//    @Column(name = "medicine")
    private int medicine;
//    @Column(name = "damage")
    private int damage;
//    @Column(name = "game_time")
    private LocalTime gameTime;

//    @OneToMany(mappedBy = "gamer" , cascade = CascadeType.ALL)
    private List<HitResult> hitResults;
}
