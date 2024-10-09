package helloworld.services;

import java.util.List;

import helloworld.models.CategoryModel;

public interface ICategoryService {

	List<CategoryModel> findAll();
	CategoryModel findById(int id);
	CategoryModel findByName(String name);
	
	void insert (CategoryModel category);
	void update (CategoryModel category);
	void delete (int id);
	void updateStatus (int id, int status);
}
