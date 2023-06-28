package knu.fit.mit.exam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="pistols")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RocketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;
    public float caliber;
    public int mass;
    public String img;
    public int capacity;
    public int price;
}
