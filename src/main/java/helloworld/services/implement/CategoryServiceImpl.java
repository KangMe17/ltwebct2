package helloworld.services.implement;

import java.util.List;

import helloworld.dao.ICategoryDao;
import helloworld.dao.implement.CategoryDaoImpl;
import helloworld.models.CategoryModel;
import helloworld.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{

	
	public ICategoryDao cateDao = new CategoryDaoImpl();
	@Override
	public List<CategoryModel> findAll() {
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {

		return cateDao.findById(id);
	}

	@Override
	public CategoryModel findByName(String name) {
		
		return cateDao.findByName(name);
	}

	@Override
	public void insert(CategoryModel category) {
		CategoryModel cate = this.findByName(category.getCategoryname());
		if (cate.getCategoryname() == null) {
			cateDao.insert(category);
		}
		
	}

	@Override
	public void update(CategoryModel category) {
		cateDao.update(category);
		
	}

	@Override
	public void delete(int id) {
		cateDao.delete(id);
		
	}

	@Override
	public void updateStatus(int id, int status) {
		cateDao.updateStatus(id, status);
		
	}

}
