package iostar.services;

import java.util.List;
import java.util.Optional;

import iostar.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface CategoryService {

	void deleteById(Integer id);

	long count();

	Optional<Category> findById(Integer id);

	List<Category> findAll();

	<S extends Category> S save(S entity);

	List<Category> findByNameContaining(String name);

	Page<Category> findByNameContaining(String name, Pageable pageable);

	void deleteAll();

	Page<Category> findAll(Pageable pageable);

	List<Category> findAll(Sort sort);

	List<Category> findAllById(Iterable<Integer> ids);
}
