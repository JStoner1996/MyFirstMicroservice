package com.tsi.jake.stoner.program;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer>{

    List<Film> findByTitleLikeOrDescriptionLike(String title, String description);
    List<Film> findByLanguageId(int languageId);

    List<Film> findByLength(int length);

}
