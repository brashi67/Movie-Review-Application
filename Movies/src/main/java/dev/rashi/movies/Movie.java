package dev.rashi.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection ="movies")
@Data //this will take care of all getter setter methods
@AllArgsConstructor //Creating a constructor that takes care of all private fields
@NoArgsConstructor
public class Movie {
    @Id//to ensure id is primary key of this databse
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference //this will store only ids of reviews and reviews will be stored in separate collection
    private List<Review> reviewIds; //embedded relationship
}
