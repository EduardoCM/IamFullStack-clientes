package com.clientes.repository;

import java.util.List;

import com.clientes.model.Cliente;

public interface ClienteRepository {

	Cliente add(Cliente cliente);

	List<Cliente> findAll();

	Cliente findById(Long id);

	void deleteById(Long id);

}
