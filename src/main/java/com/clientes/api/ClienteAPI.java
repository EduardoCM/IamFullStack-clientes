package com.clientes.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.model.Cliente;
import com.clientes.repository.ClienteRepository;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteAPI {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@PostMapping
	public Cliente add(@RequestBody Cliente cliente) {
		System.out.println(":: Creando cliente " + cliente);
		clienteRepository.add(cliente);
		return cliente;
	}
	
	@GetMapping
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Cliente findById(@PathVariable("id")Long id) {
		return clienteRepository.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		clienteRepository.deleteById(id);
	}
}