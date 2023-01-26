package com.examchristianbarbecho.app.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.examchristianbarbecho.app.entity.Producto;
import com.examchristianbarbecho.app.repository.IProductoRepository;
@Service
public class ProductoServicelmp implements IProductoService {
	@Autowired
	private IProductoRepository productodao;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> findAll() {
		return productodao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {
		return productodao.findAll(pageable);
	}

	@Override
	@Transactional
	public Producto GuardarProducto(Producto producto) {
		return productodao.save(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findByIdProducto(Long id) {
		return productodao.findById(id);
	}

	@Override
	@Transactional
	public void eliminarProducto(Long id) {
		productodao.deleteById(id);
		
	}


}
