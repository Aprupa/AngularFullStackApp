package adcorps.io.backend.entity;

/*This class maps the movies with JSON to query on movie list and work towards registering movies. */


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


//Allows us to create Entity, Table and Named Queries. 
@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Movie.findAll", query = "Select m from Movie m"),
	@NamedQuery(name = "Movie.findByImdbId", query = "Select m from Movie m where m.imdbID = :imdbID"),
	@NamedQuery(name = "Movie.findByTitle", query = "Select m from Movie m where m.movieTitle = :title"),
	@NamedQuery(name = "Movie.findByYear", query = "Select m from Movie m where m.movieYear = :year"),
	@NamedQuery(name = "Movie.findByGenre", query = "Select m from Movie m where m.movieGenre LIKE :genre"),
	@NamedQuery(name = "Movie.findByType", query = "Select m from Movie m where m.type = :type"),
	@NamedQuery(name = "Movie.sortByRating", query = "Select m from Movie m order by m.imdbRating DESC")
})
public class Movie {
	
	
	//Primary Key Denomination below.
	@Id
	private String movieID;
	
	//Mapping with JSON data.
	@JsonProperty(value = "Title")
	private String movieTitle;
	
	@JsonProperty(value = "Year")
	private int movieYear;
	
	@JsonProperty(value = "Released")
	private String movieReleased;
	
	@JsonProperty(value = "Runtime")
	private String movieRuntime;
	
	@JsonProperty(value = "Genre")
	private String movieGenre;
	
	@JsonProperty(value = "Director")
	private String movieDirectorName;
	
	@JsonProperty(value = "Writer")	
	@Column(columnDefinition = "TEXT")
	private String movieWriterName;
	
	@JsonProperty(value = "Actors")
	@Column(columnDefinition = "TEXT")
	private String movieActorsName;
	
	@JsonProperty(value = "Plot")
	@Column(columnDefinition = "TEXT")
	private String moviePlot;
	
	@JsonProperty(value = "Language")
	private String movieLanguage;
	
	@JsonProperty(value = "Country")
	private String movieCountry;
	
	@JsonProperty(value = "Awards")
	private String movieAwards;
	
	@JsonProperty(value = "Poster")
	@Column(columnDefinition = "TEXT")
	private String moviePoster;
	
	@JsonProperty(value = "Metascore")
	private String movieMetaScore;
	
	@JsonProperty(value = "imdbRating")
	private double imdbRating;
	
	@JsonProperty(value = "imdbVotes")
	private int imdbVotes;
	
	@JsonProperty(value = "imdbID")
	@Column(unique = true)
	private String imdbID;
	
	@JsonProperty(value = "Type")
	private String type;
	
	//Generating unique ID for movie ID.	
	public Movie(){
		movieID = UUID.randomUUID().toString();
	}
	
	
	//Generating the Getters and Setters Method. 
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getMovieYear() {
		return movieYear;
	}
	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}
	public String getMovieReleased() {
		return movieReleased;
	}
	public void setMovieReleased(String movieReleased) {
		this.movieReleased = movieReleased;
	}
	public String getMovieRuntime() {
		return movieRuntime;
	}
	public void setMovieRuntime(String movieRuntime) {
		this.movieRuntime = movieRuntime;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieDirectorName() {
		return movieDirectorName;
	}
	public void setMovieDirectorName(String movieDirectorName) {
		this.movieDirectorName = movieDirectorName;
	}
	public String getMovieWriterName() {
		return movieWriterName;
	}
	public void setMovieWriterName(String movieWriterName) {
		this.movieWriterName = movieWriterName;
	}
	public String getMovieActorsName() {
		return movieActorsName;
	}
	public void setMovieActorsName(String movieActorsName) {
		this.movieActorsName = movieActorsName;
	}
	public String getMoviePlot() {
		return moviePlot;
	}
	public void setMoviePlot(String moviePlot) {
		this.moviePlot = moviePlot;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public String getMovieCountry() {
		return movieCountry;
	}
	public void setMovieCountry(String movieCountry) {
		this.movieCountry = movieCountry;
	}
	public String getMovieAwards() {
		return movieAwards;
	}
	public void setMovieAwards(String movieAwards) {
		this.movieAwards = movieAwards;
	}
	public String getMoviePoster() {
		return moviePoster;
	}
	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}
	public String getMovieMetaScore() {
		return movieMetaScore;
	}
	public void setMovieMetaScore(String movieMetaScore) {
		this.movieMetaScore = movieMetaScore;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public int getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}