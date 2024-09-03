package com.romazal.jpa.specification;

import com.romazal.jpa.models.Author;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {

    public static Specification<Author> hasAge(int age) {
        return (root, query, cb) -> {
            if (age < 0) return null;

            return cb.equal(root.get("age"), age);
        };

    }

    public static Specification<Author> fistNameLike(String firstName) {
        return (root, query, cb) -> {
            if (firstName == null) return null;

            return cb.like(root.get("firstName"), "%" + firstName + "%");
        };

    }
}
