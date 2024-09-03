package com.romazal.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "Author_TBL")
@NamedQueries({
        @NamedQuery(
                name = "Author.findByNamedQuery",
                query = "SELECT a from Author a WHERE a.age >= :age"
        ),
        @NamedQuery(
                name = "Author.updateByNamedQuery",
                query = "UPDATE Author a SET a.age = :age"
        )
})

public class Author extends BaseEntity {

/*    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )

    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    private Integer id;*/


    @Column(
        name = "f_name",
        nullable = false,
        length = 30
    )
    private String firstName;

    @Column(
        name = "l_name",
        nullable = false,
        length = 30
    )
    private String lastName;

    @Column(
            length = 50,
            nullable = false,
            unique = true
    )
    private String email;

    private int age;






    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
    private List<Course> courses;

}
