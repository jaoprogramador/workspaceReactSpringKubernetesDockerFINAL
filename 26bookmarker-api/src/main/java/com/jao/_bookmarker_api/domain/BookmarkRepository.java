package com.jao._bookmarker_api.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

	
	@Query("SELECT new com.jao._bookmarker_api.domain.BookmarkDTO(b.id, b.title, b.url, b.createdAt) FROM Bookmark b")
	Page<BookmarkDTO> findBookmarks(Pageable pageable);
	
	@Query("""
	SELECT new com.jao._bookmarker_api.domain.BookmarkDTO(b.id, b.title, b.url, b.createdAt) FROM Bookmark b
	where lower(b.title) like lower(concat('%', :query, '%'))
	""")
	Page<BookmarkDTO> searchBookmarks(String query, Pageable pageable);
	@Query("""
	SELECT new com.jao._bookmarker_api.domain.BookmarkDTO(b.id, b.title, b.url, b.createdAt) FROM Bookmark b
    where lower(b.title) like lower(concat('%', :query, '%'))
	""")
	Page<BookmarkDTO> findByTitleContainsIgnoreCase(String query, Pageable pageable);


}
