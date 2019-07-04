package com.clientes.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.clientes.model.Cliente;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

private static List<Cliente> clientes = new ArrayList<>();
	
	static {
		Cliente eduardo = new Cliente();
		eduardo.setId(1L);
		eduardo.setNombre("Eduardo");
		eduardo.setApellidos("Castillo Mendoza");
		eduardo.setEdad(28);
		eduardo.setGenero("Masculino");
		eduardo.setDireccion("Juan Escutia 128");
		
		clientes.add(eduardo);
	}

	@Override
	public Cliente add(Cliente cliente) {
		cliente.setId((long)clientes.size() + 1);
		clientes.add(cliente);
		return cliente;
	}

	@Override
	public List<Cliente> findAll() {
		return clientes;
	}

	@Override
	public Cliente findById(Long id) {
		return clientes.stream().filter(it -> it.getId().equals(id)).findFirst().get();
	}

	@Override
	public void deleteById(Long id) {
		 clientes.remove(clientes.stream().filter(it -> it.getId().equals(id)).findFirst().get());
	}
	
	

}
