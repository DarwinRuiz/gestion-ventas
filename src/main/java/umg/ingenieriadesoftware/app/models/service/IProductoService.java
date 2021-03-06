package umg.ingenieriadesoftware.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import umg.ingenieriadesoftware.app.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	
	public Page<Producto> findAll(Pageable pageable);
	
	public void save(Producto producto);
	
	public Producto findOne(Long id);
	
	public void delete(Long id);
	
	public Page<Producto> findAllByCategory(String categoria, Pageable pageable);
}
