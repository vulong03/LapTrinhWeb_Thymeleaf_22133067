package iostar.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iostar.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer >{
	List<Category> findByCategoryNameContaining(String categoryName);
	Page<Category> findByCategoryNameContaining(String name, Pageable pageable);
}
