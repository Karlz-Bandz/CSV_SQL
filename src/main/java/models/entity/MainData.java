package models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;


@Entity
@Table(name = "dynamic_data")
@Data
@AllArgsConstructor
public class MainData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;

    public MainData(String name)
    {
        this.name = name;
    }

    //    @OneToMany
//    @JoinColumn(name = "dynamic_data_id")
//    private List<Map<String, String>> data;
}
