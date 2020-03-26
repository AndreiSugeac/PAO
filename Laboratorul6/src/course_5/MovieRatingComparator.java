package course_5;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return (int)(o1.getRating() - o2.getRating());
    }
}
