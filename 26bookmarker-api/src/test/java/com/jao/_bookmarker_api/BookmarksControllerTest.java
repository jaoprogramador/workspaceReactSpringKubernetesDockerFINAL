package com.jao._bookmarker_api;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.jao._bookmarker_api.domain.Bookmark;
import com.jao._bookmarker_api.domain.BookmarkRepository;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@AutoConfigureMockMvc
@TestPropertySource(properties = {
		//"spring.datasource.url=jdbc:tc:postgresql:9.6.8:14-alpine:///demo"
		"spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})
public class BookmarksControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private BookmarkRepository bookmarkRepository;
	
	private List<Bookmark> bookmarks;

	@BeforeEach
	void setUp() {
		//BORRAMOS TODOS LOS RGs DE bd
		bookmarkRepository.deleteAllInBatch();
		//CARGAMOS RGS
		bookmarks = new ArrayList<>();

        bookmarks.add(new Bookmark(null, "SivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarks.add(new Bookmark(null, "SpringBlog", "https://spring.io/blog", Instant.now()));
        bookmarks.add(new Bookmark(null, "Quarkus", "https://quarkus.io/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Micronaut", "https://micronaut.io/", Instant.now()));
        bookmarks.add(new Bookmark(null, "JOOQ", "https://www.jooq.org/", Instant.now()));
        bookmarks.add(new Bookmark(null, "VladMihalcea", "https://vladmihalcea.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Thoughts On Java", "https://thorben-janssen.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "DZone", "https://dzone.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "DevOpsBookmarks", "http://www.devopsbookmarks.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Kubernetes docs", "https://kubernetes.io/docs/home/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Expressjs", "https://expressjs.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Marcobehler", "https://www.marcobehler.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "baeldung", "https://www.baeldung.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "devglan", "https://www.devglan.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "linuxize", "https://linuxize.com", Instant.now()));

        bookmarkRepository.saveAll(bookmarks);

	}
	
	/*
	 * @Test void shouldGetBookmarks() throws Exception {
	 * mvc.perform(get("/api/bookmarks")) .andExpect(status().isOk())//PRUEBA LA
	 * LLAMADA AL CONTROLLER Y QUE DEVUELVA OK .andExpect( (ResultMatcher)
	 * jsonPath("$.totalElements", CoreMatchers.equalTo(15))) //PRUEBA QUE TIENE 15
	 * ELEMENTOS .andExpect( (ResultMatcher) jsonPath("$.totalPages",
	 * CoreMatchers.equalTo(2))) //PRUEBA QUE TIENE 2 pages .andExpect(
	 * (ResultMatcher) jsonPath("$.currentPage", CoreMatchers.equalTo(1))) //PRUEBA
	 * QUE TIENE 1 current .andExpect( (ResultMatcher) jsonPath("$.isFirst",
	 * CoreMatchers.equalTo(true))) //PRUEBA QUE isFirst .andExpect( (ResultMatcher)
	 * jsonPath("$.isLast", CoreMatchers.equalTo(true))) //PRUEBA QUE isLast
	 * .andExpect( (ResultMatcher) jsonPath("$.hasNext",
	 * CoreMatchers.equalTo(true))) //PRUEBA QUE hasNext .andExpect( (ResultMatcher)
	 * jsonPath("$.hasPrevious", CoreMatchers.equalTo(false))) //PRUEBA QUE
	 * hasPrevious
	 * 
	 * ; }
	 */
	
	//Pruebas parametrizadas
	@ParameterizedTest
	@CsvSource({
		"1,15,3,1,true,false,true,false",
		"2,15,3,2,false,true,false,false"
	})
	void shouldGetBookmarks(int numPage, int totalElements, int totalPages, int currentPage, 
			boolean isFirst,boolean isLast,boolean hasNext,boolean hasPrevious   ) throws Exception  {
		/*
		 * mvc.perform(get("/api/bookmarks")) .andExpect(status().isOk())//PRUEBA LA
		 * LLAMADA AL CONTROLLER Y QUE DEVUELVA OK .andExpect( (ResultMatcher)
		 * jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements))) //PRUEBA
		 * QUE TIENE 15 ELEMENTOS .andExpect( (ResultMatcher) jsonPath("$.totalPages",
		 * CoreMatchers.equalTo(totalPages))) //PRUEBA QUE TIENE 2 pages .andExpect(
		 * (ResultMatcher) jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
		 * //PRUEBA QUE TIENE 1 current .andExpect( (ResultMatcher)
		 * jsonPath("$.isFirst", CoreMatchers.equalTo(isFirst))) //PRUEBA QUE isFirst
		 * .andExpect( (ResultMatcher) jsonPath("$.isLast",
		 * CoreMatchers.equalTo(isLast))) //PRUEBA QUE isLast .andExpect(
		 * (ResultMatcher) jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
		 * //PRUEBA QUE hasNext .andExpect( (ResultMatcher) jsonPath("$.hasPrevious",
		 * CoreMatchers.equalTo(hasPrevious))) //PRUEBA QUE hasPrevious
		 * 
		 * ;
		 */
		// Spring Data empieza en 0
	    int pageIndex = numPage - 1;

	    mvc.perform(get("/api/bookmarks?page=" + pageIndex))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.totalElements").value(totalElements))
	        .andExpect(jsonPath("$.totalPages").value(totalPages))
	        .andExpect(jsonPath("$.currentPage").value(currentPage))
	        .andExpect(jsonPath("$.isFirst").value(isFirst))
	        .andExpect(jsonPath("$.isLast").value(isLast))
	        .andExpect(jsonPath("$.hasNext").value(hasNext))
	        .andExpect(jsonPath("$.hasPrevious").value(hasPrevious));
	}
	
	//PRUEBA POST NUEVO POST OK
	//===========================
	@Test
    void shouldCreateBookmarkSuccessfully() throws Exception {
        this.mvc.perform(
            post("/api/bookmarks")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
            {
                "title": "Robin FOOD Blog",
                "url": "https://www.robinfoodtv.com/es/receta/pasta-viva-rusia"
            }
            """)
        )
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id", notNullValue()))
        .andExpect(jsonPath("$.title", is("Robin FOOD Blog")))
        .andExpect(jsonPath("$.url", is("https://www.robinfoodtv.com/es/receta/pasta-viva-rusia")));
    }
	//PRUEBA NUEVO POST SIN PARAMETRO ERROR
	//======================================

    @Test
    void shouldFailToCreateBookmarkWhenUrlIsNotPresent() throws Exception {
        this.mvc.perform(
                post("/api/bookmarks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                {
                    "title": "ARGUIÑANO Blog"
                }
                """)
            )
            .andExpect(status().isBadRequest())
            .andExpect(header().string("Content-Type", is("application/problem+json")))
            .andExpect(jsonPath("$.type", is("https://zalando.github.io/problem/constraint-violation")))
            .andExpect(jsonPath("$.title", is("Constraint Violation")))
            .andExpect(jsonPath("$.status", is(400)))
            .andExpect(jsonPath("$.violations", hasSize(1)))
            .andExpect(jsonPath("$.violations[0].field", is("url")))
            .andExpect(jsonPath("$.violations[0].message", is("Url should not be empty")))
            .andReturn();
    }

}
