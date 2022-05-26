package com.bnta.backend_snack_overflow.repositories;

import com.bnta.backend_snack_overflow.models.Recipe;
import com.bnta.backend_snack_overflow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT recipes.* FROM recipes INNER JOIN users_recipes ON recipes.id=users_recipes.recipe_id " +
            "INNER JOIN users ON users_recipes.user_id = users.id WHERE users.id = ?1", nativeQuery = true)
    List<Recipe> findRecipeByCupboardAndId(Long id);
}
