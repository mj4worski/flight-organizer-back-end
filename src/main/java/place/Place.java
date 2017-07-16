package place;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter @Setter @EqualsAndHashCode(exclude = "images")
public class Place {
    @Id
    @Column
    @GeneratedValue
    Long id;

    @Column
    private String name;
    @Column
    private String shortDescription;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();

    @Transient
    private List<BigInteger> imageIds;

    protected Place() {
    }

    @JsonIgnore
    public List<Image> getImages() {
        return images;
    }

}
