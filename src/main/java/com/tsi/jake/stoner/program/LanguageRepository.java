package com.tsi.jake.stoner.program;

import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, Integer>  {
    Language findByName(String name);
}
