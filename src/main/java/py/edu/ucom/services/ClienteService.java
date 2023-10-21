package py.edu.ucom.services;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import py.edu.ucom.config.IDAO;
import py.edu.ucom.entities.Cliente;

@ApplicationScoped
public class ClienteService implements IDAO<Cliente, Integer> {

    @Inject
    EntityManager entityManager;

    @Override
    public Cliente obtener(Integer id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    @Transactional
    public Cliente agregar(Cliente cliente) {
        return entityManager.merge(cliente);
    }

    @Override
    @Transactional
    public Cliente modificar(Cliente cliente) {
        return entityManager.merge(cliente);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        Cliente cliente = obtener(id);
        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }

    @Override
    public List<Cliente> listar() {
        // Use JPQL (Java Persistence Query Language) to retrieve all entities
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }
}
