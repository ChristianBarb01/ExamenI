package com.examchristianbarbecho.app.controller;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examchristianbarbecho.app.entity.Producto;
import com.examchristianbarbecho.app.service.IProductoService;

import org.springframework.data.domain.Example;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	@PostMapping("/guardar")
	public ResponseEntity<?>create(@Validated @RequestBody Producto producto){

		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.GuardarProducto(producto));
	}
	

	@GetMapping("/buscar/{codigo}")
	public ResponseEntity<Optional<Producto>> read (@PathVariable(value= "codigo")Long codigo){
		Optional<Producto> oprod = productoService.findByIdProducto(codigo);
		if(!oprod.isPresent()) {
//			return ResponseEntity.notFound().build();
		    throw new NoSuchElementException("No existe usuario con el codigo: " + codigo);
		}
		return ResponseEntity.ok(oprod);
	}
	

	@PutMapping("/modificar/{codigo}")
	public ResponseEntity<?>update (@RequestBody Producto prodDetails, @PathVariable(value= "codigo")Long codigo){
		Optional<Producto> prod = productoService.findByIdProducto(codigo);
		if(!prod.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		prod.get().setDescripcion(prodDetails.getDescripcion());
		prod.get().setPrecio(prodDetails.getPrecio());
		prod.get().setCantidad(prodDetails.getCantidad());
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.GuardarProducto(prod.get()));
	}
	

	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<?>delet (@PathVariable(value = "codigo")Long codigo){
		if(!productoService.findByIdProducto(codigo).isPresent()){
			return ResponseEntity.notFound().build();
		}
		productoService.eliminarProducto(codigo);
		return ResponseEntity.ok().build();
				
	}

	@GetMapping("/listar")
	public List<Object> readAll(){
		List<Object>users =StreamSupport
				.stream(productoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return users;
		
	}	
	}