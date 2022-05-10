package umg.ingenieriadesoftware.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import umg.ingenieriadesoftware.app.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
}
