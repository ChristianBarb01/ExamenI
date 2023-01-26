package com.examchristianbarbecho.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.examchristianbarbecho.app.entity.Producto;


public interface IProductoService {


	public Iterable<Producto>findAll();
	public Page<Producto> findAll(Pageable pageable);
	
	public Producto GuardarProducto(Producto producto);


	public Optional<Producto> findByIdProducto(Long id);
			
	public void eliminarProducto(Long id);

}
