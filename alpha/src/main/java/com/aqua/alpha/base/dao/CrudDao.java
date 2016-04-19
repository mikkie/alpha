package com.aqua.alpha.base.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface CrudDao<T, ID extends Serializable> extends PagingAndSortingRepository<T,ID>,
		JpaSpecificationExecutor<T> {

}
