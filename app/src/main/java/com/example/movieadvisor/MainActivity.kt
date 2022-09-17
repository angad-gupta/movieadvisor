package com.example.movieadvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findMovies = findViewById<Button>(R.id.find_movie)

        findMovies.setOnClickListener {
            val movieGenres = findViewById<Spinner>(R.id.movie_genre)
            val genre = movieGenres.selectedItem
            val movieList = getMovies(genre.toString())
            val descriptionList = getDescription(genre.toString())
            val reducedMoviesList = movieList.reduce {str, item -> str + '\n' + item}
            val reduceDescriptionList = descriptionList.reduce {str, item -> str}
            val movies = findViewById<TextView>(R.id.movies)
            val description = findViewById<TextView>(R.id.description)
            description.text = reduceDescriptionList
            movies.text = reducedMoviesList
        }
    }
}

fun getMovies(genre: String) : List<String> {
    return when (genre) {
        "Action" -> listOf("Men in Black", "Tom Raider", "Star Wars")
        "Adventure" -> listOf("Lord of Rings", "Hobbit", "Zelda")
        "Drama" -> listOf("Spectre", "Remember me", "House of Gucci")
        "Romantic" -> listOf("Elvis", "Spencer", "Titanic")
        else -> listOf("Spider Man", "Batman", "Avenger")
    }
}


fun getDescription(genre: String) : List<String> {
    return when (genre) {
        "Action" -> listOf("Action films are a film genre where action sequences, such as fighting, stunts, car chases or explosions, take precedence over elements like characterization or complex plotting. The action typically involves individual efforts on the part of the hero, in contrast with most war films.")
        "Adventure" -> listOf("A common theme of adventure films is of characters leaving their home or place of comfort and going to fulfill a goal, embarking on travels, quests, treasure hunts, heroic journeys; and explorations or searches for the unknown. Subgenres of adventure films include swashbuckler films, pirate films, and survival films.")
        "Drama" -> listOf("Drama Films are serious presentations or stories with settings or life situations that portray realistic characters in conflict with either themselves, others, or forces of nature. A dramatic film shows us human beings at their best, their worst, and everything in-between.")
        "Romantic" -> listOf("Romance Films: Romance films are love stories, or affairs of the heart that center on passion, emotion, and the romantic, affectionate involvement of the main characters (usually a leading man and lady), and the journey that their love takes through courtship or marriage.")
        else -> listOf("In screenwriting, a movie synopsis is a brief summary of a completed screenplay's core concept, major plot points, and main character arcs.")
    }
}


