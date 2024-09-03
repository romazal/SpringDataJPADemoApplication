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
@Table(
        name = "Course_TBL"
)
public class Course extends BaseEntity {

    @Column(
            length = 50,
            nullable = false
    )
    private String title;

    @Column(
            length = 200
    )
    private String description;

    @ManyToMany
    @JoinTable(
            name = "authors_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;

    @OneToMany(
            mappedBy = "course"
    )
    private List<Section> sections;


}
