package MonthlyChallenges.Year25.September;

import java.util.*;

public class DesignMovieRentalSystem {

    /**
     * LeetCode №1912. Design Movie Rental System.
     */
    class MovieRentingSystem {
        //  shopID -> { movieID -> MovieEntry }
        private final Map<Integer, Map<Integer, MovieEntry>> stock;

        //  movieID -> Set<MovieEntry>
        private final Map<Integer, NavigableSet<MovieEntry>> available;

        private final NavigableSet<MovieEntry> rented;

        public MovieRentingSystem(int n, int[][] entries) {
            this.stock = new HashMap<>();
            this.available = new HashMap<>();
            this.rented = new TreeSet<>();

            for (int i = 0; i < n; i++) stock.put(i, new HashMap<>());

            for (int[] entry : entries) {
                int shopID = entry[0];
                int movieID = entry[1];
                int price = entry[2];

                MovieEntry movieEntry = new MovieEntry(shopID, movieID, price);

                stock.get(shopID).put(movieID, movieEntry);

                if (!available.containsKey(movieID)) {
                    available.put(movieID, new TreeSet<>());
                }
                available.get(movieID).add(movieEntry);
            }
        }

        public List<Integer> search(int movie) {
            List<Integer> result = new ArrayList<>();

            NavigableSet<MovieEntry> shops = available.getOrDefault(movie, new TreeSet<>());

            int idx = 0;
            for (MovieEntry entry : shops) {
                result.add(entry.shopID);

                idx++;
                if (idx == 5) break;
            }

            return result;
        }

        public void rent(int shop, int movie) {
            MovieEntry movieEntry = stock.get(shop).get(movie);

            available.get(movie).remove(movieEntry);
            rented.add(movieEntry);
        }

        public void drop(int shop, int movie) {
            MovieEntry movieEntry = stock.get(shop).get(movie);

            rented.remove(movieEntry);
            available.get(movie).add(movieEntry);
        }

        public List<List<Integer>> report() {
            List<List<Integer>> result = new ArrayList<>();

            int idx = 0;
            for (MovieEntry movieEntry : rented) {
                List<Integer> entry = new ArrayList<>();
                entry.add(movieEntry.shopID);
                entry.add(movieEntry.movieID);

                result.add(entry);

                idx++;
                if (idx == 5) break;
            }

            return result;
        }

        static class MovieEntry implements Comparable<MovieEntry> {
            final int shopID;
            final int movieID;
            final int price;

            MovieEntry(int shopID, int movieID, int price) {
                this.shopID = shopID;
                this.movieID = movieID;
                this.price = price;
            }

            @Override
            public int compareTo(MovieEntry other) {
                if (price != other.price) {
                    return Integer.compare(price, other.price);
                } else if (shopID != other.shopID) {
                    return Integer.compare(shopID, other.shopID);
                } else {
                    return Integer.compare(movieID, other.movieID);
                }
            }
        }
    }
}
