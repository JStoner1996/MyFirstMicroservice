package com.tsi.jake.stoner.controllers;

import com.tsi.jake.stoner.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private FilmActorRepository filmActorRepository;
    @Autowired
    private FilmCategoryRepository filmCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    static final String FILM_STRING = "Film ";
    static final String DOES_NOT_EXIST = " does not exist.";

    public FilmController(FilmRepository filmRepository,
                          FilmActorRepository filmActorRepository,
                          FilmCategoryRepository filmCategoryRepository,
                          CategoryRepository categoryRepository) {
        this.filmRepository = filmRepository;
        this.filmActorRepository = filmActorRepository;
        this.filmCategoryRepository = filmCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    // Returns a list of all films
    @GetMapping("/All_Films")
    public @ResponseBody
    Iterable<Film>getAllFilms(){
        return filmRepository.findAll();
    }

    // Returns a list of all film ids their category ids
    @GetMapping("/All_FilmCategories")
    public @ResponseBody
    Iterable<FilmCategory>getAllFilmCategories(){
        return filmCategoryRepository.findAll();
    }

    // Returns a list of all categories and their ids
    @GetMapping("/All_Categories")
    public @ResponseBody
    Iterable<Category>getAllCategories(){
        return categoryRepository.findAll();
    }

    // returns a film's information by its ID
    @GetMapping("/Film_By_ID/{film_id}")
    public @ResponseBody Optional<Film> getFilmById (@PathVariable int film_id){

        if (filmRepository.existsById(film_id)){
            return filmRepository.findById(film_id);
        } else throw new ResourceNotFoundException(FILM_STRING + film_id + DOES_NOT_EXIST);

    }

    // Returns a list of films that have the keyword
    // SQL Query: SELECT * FROM sakila.film WHERE title LIKE '%{keyword}%' OR description LIKE '%{keyword}%’;
    // NEED TO CHANGE TO ADD FILM_TEXT TABLE AND USE THAT INSTEAD!
    @GetMapping("/Film_By_Keyword/{keyword}")
    public ResponseEntity<List<Film>> getFilmByKeyword(@PathVariable String keyword){
        // Used for the SQL query:
        keyword = "%" + keyword + "%";
        return new ResponseEntity<>(filmRepository.findByTitleLikeOrDescriptionLike(keyword,  keyword), HttpStatus.OK);
    }

    // Returns a list of actor id's and their film id's
    @GetMapping("/All_Film_Actors")
    public @ResponseBody
    Iterable<FilmActor>getAllFilmActors(){
        return filmActorRepository.findAll();
    }

    // Returns list of film ids by actor id - plan to use this to get film information
    // SQL Query:
    @GetMapping("/Film_By_Actor/{actorId}")
    public ResponseEntity <List<FilmActor>> getFilmByActor(@PathVariable int actorId){
        return new ResponseEntity<>(filmActorRepository.findByActorId(actorId),HttpStatus.OK);
    }

}
