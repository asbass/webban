package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Category;
import com.poly.entity.Order;
import com.poly.entity.OrderDetail;
import com.poly.entity.Product;
import com.poly.entity.Report;



public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{
	@Query("SELECT new Report(o.id, sum(o.price), count(o)) "
			+ " FROM OrderDetail o "
			+ " GROUP BY o.id"
			+ " ORDER BY sum(o.price) DESC")
	List<Report> getInventoryByoder();
//	List<OrderDetail> findByOrder();


}