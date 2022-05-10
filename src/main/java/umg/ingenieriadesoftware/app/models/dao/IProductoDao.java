package umg.ingenieriadesoftware.app.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import umg.ingenieriadesoftware.app.models.entity.Producto;

public interface IProductoDao extends PagingAndSortingRepository<Producto, Long> {

	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre(String term);

	public List<Producto> findByNombreLikeIgnoreCase(String term);

	@Query("select p from Producto p where p.id=?1")
	public Producto getquantityvailablebyproductid(Long id);
	
	@Query("select p from Producto p where p.categoria=?1")
	public Page<Producto> findAllByCategory(String categoria, Pageable pageable);

}
