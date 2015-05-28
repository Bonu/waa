package app04a.repositoryimpl;

import java.util.ArrayList;
import java.util.List;

import app04a.domain.Product;
import app04a.repository.ProductRepository;

 public class ProductRepositoryImpl implements ProductRepository {
	
		private List<Product> listOfProducts = new ArrayList<Product>();

	 
	 public final static ProductRepositoryImpl INSTANCE = new ProductRepositoryImpl();
	private ProductRepositoryImpl() {
		
	}
	
	public List<Product> getAll() {
		return listOfProducts;
	}
	
	public void save(Product product) {
		listOfProducts.add(product);
		return ;
	}
	
	
		   
}
 
