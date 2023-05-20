package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@Table(name = "dynamicq")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DynamicData
{
    @Id
    private int id;
    @ElementCollection
    @CollectionTable(name = "values")
    @MapKeyColumn(name = "key")
    @Column(name = "value")
    private Map<String, String> data;
}
