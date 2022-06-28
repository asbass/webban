package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String> {
	@Query(value = "SELECT * FROM Categories WHERE name LIKE ?1",nativeQuery = true)
	List<Category> findByKeyword(String keyword);
	Page<Category> findAllByNameLike(String keywords, Pageable pageable);

}
