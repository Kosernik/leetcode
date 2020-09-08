package MonthlyChallenges.June;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();

        List<List<String>> test1 = new ArrayList<>();
        List<String> ticket11 = new ArrayList<>(); ticket11.add("MUC");ticket11.add("LHR");
        List<String> ticket12 = new ArrayList<>(); ticket12.add("JFK");ticket12.add("MUC");
        List<String> ticket13 = new ArrayList<>(); ticket13.add("SFO");ticket13.add("SJC");
        List<String> ticket14 = new ArrayList<>(); ticket14.add("LHR");ticket14.add("SFO");
        test1.add(ticket11); test1.add(ticket12); test1.add(ticket13); test1.add(ticket14);

        List<String> result1 = reconstructItinerary.findItinerary(test1);
        reconstructItinerary.printList(result1);

        System.out.println("\nTest #2");
        List<List<String>> test2 = new ArrayList<>();
        List<String> ticket21 = new ArrayList<>(); ticket21.add("JFK");ticket21.add("SFO");
        List<String> ticket22 = new ArrayList<>(); ticket22.add("JFK");ticket22.add("ATL");
        List<String> ticket23 = new ArrayList<>(); ticket23.add("SFO");ticket23.add("ATL");
        List<String> ticket24 = new ArrayList<>(); ticket24.add("ATL");ticket24.add("JFK");
        List<String> ticket25 = new ArrayList<>(); ticket25.add("ATL");ticket25.add("SFO");
        test2.add(ticket21); test2.add(ticket22); test2.add(ticket23); test2.add(ticket24); test2.add(ticket25);

        List<String> result2 = reconstructItinerary.findItinerary(test2);
        reconstructItinerary.printList(result2);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> itinerary = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) {
            return itinerary;
        } else if (tickets.size() == 1) {
            itinerary.add(tickets.get(0).get(0));
            itinerary.add(tickets.get(0).get(1));
            return itinerary;
        }

        Map<String, PriorityQueue<String>> airports = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!airports.containsKey(ticket.get(0))) {
                airports.put(ticket.get(0), new PriorityQueue<>());
            }
            airports.get(ticket.get(0)).add(ticket.get(1));
        }

        getPath(itinerary, airports, "JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }
    private void getPath(List<String> itinerary, Map<String, PriorityQueue<String>> airports, String airport) {
        PriorityQueue<String> currentPQ = airports.get(airport);
        while (currentPQ != null && !currentPQ.isEmpty()) {
            getPath(itinerary, airports, currentPQ.poll());
        }
        itinerary.add(airport);
    }

    private void printList(List<String> list) {
        for (String entry : list) {
            System.out.print(entry + "\t");
        }
        System.out.println();
    }
}
