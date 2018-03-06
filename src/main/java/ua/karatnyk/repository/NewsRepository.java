package ua.karatnyk.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.karatnyk.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>{
	
	@Query("Select c from News c where c.isDeleted = false")
	Page<News> findAllNewsNotActived(Pageable pageable);
	
	@Query("Select c from News c where c.isDeleted = false")
	List<News> findAllNewsNotActived();
	
	@Query("Select c from News c where c.isDeleted = false and c.title like %:filter%")
	Page<News> findAllNewsNotActivedWithTitleFilter(Pageable pageable, @Param("filter") String filter);
	
}
