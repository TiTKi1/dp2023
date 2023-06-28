package knu.fit.mit.exam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="rocket")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RocketEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String img;
    public String name;
    public int price;
}
