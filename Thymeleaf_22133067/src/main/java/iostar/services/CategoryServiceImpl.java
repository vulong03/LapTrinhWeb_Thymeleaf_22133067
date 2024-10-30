package iostar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import iostar.entity.Category;
import iostar.Repository.CategoryRepository;
import org.thymeleaf.util.StringUtils;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryRepository categoryRepositoty;
    @Autowired
    private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepositoty) {
		this.categoryRepositoty = categoryRepositoty;
	}

	@Override
	public <S extends Category> S save(S entity) {
		if(entity.getCategoryId() == null) {
			return categoryRepositoty.save(entity);
		}
		else {
			Optional<Category> opt = findById(entity.getCategoryId());
			if (opt.isPresent()) {
				if(StringUtils.isEmpty(entity.getCategoryName())) {
					entity.setCategoryName(opt.get().getCategoryName());
				}
				else {
					entity.setCategoryName(entity.getCategoryName());
				}
			}
		}
		return categoryRepositoty.save(entity);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepositoty.findAll();
	}

	@Override
	public Optional<Category> findById(Integer id) {
		return categoryRepositoty.findById(id);
	}

	@Override
	public long count() {
		return categoryRepositoty.count();
	}

	@Override
	public void deleteById(Integer id) {
		categoryRepositoty.deleteById(id);
	}
	@Override
	public List<Category> findByNameContaining(String name) {
		return categoryRepository.findByCategoryNameContaining(name);
	}
	@Override
	public Page<Category> findByNameContaining(String name, Pageable pageable) {
		return categoryRepository.findByCategoryNameContaining(name, pageable);
	}
	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}
	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}

	@Override
	public List<Category> findAllById(Iterable<Integer> ids) {
		return categoryRepository.findAllById(ids);
	}


}
