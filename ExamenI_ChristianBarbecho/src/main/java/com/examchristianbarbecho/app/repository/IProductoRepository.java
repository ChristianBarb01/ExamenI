package com.examchristianbarbecho.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examchristianbarbecho.app.entity.Producto;


public interface IProductoRepository extends JpaRepository<Producto, Long> {

}
