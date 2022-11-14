package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t02.n01.model.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t02.n01.model.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository <Usuario, Integer>  {
	

}

/*
 * Ahora podemos usar los métodos de JpaRepository:
 * save(), findOne(), findById(), findAll(), count(), delete(), deleteById()…
 * sin implementar estos métodos.
 */