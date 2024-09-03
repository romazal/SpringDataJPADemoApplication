package com.romazal.jpa.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Polymorphism(type = PolymorphismType.EXPLICIT)
//@PrimaryKeyJoinColumn(name = "video_id") JOINED only
//@DiscriminatorValue("V")
public class Video extends Resource{

    private int length;
}
