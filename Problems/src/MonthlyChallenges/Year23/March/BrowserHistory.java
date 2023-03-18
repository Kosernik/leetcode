package MonthlyChallenges.Year23.March;

public class BrowserHistory {
    SiteNode currentSite = null;


    /**
     * LeetCode #1472. Design Browser History.
     *
     * @param homepage - a starting url.
     */
    public BrowserHistory(String homepage) {
        currentSite = new SiteNode(homepage);
    }

    public void visit(String url) {
        SiteNode newNode = new SiteNode(url);

        currentSite.next = newNode;
        newNode.prev = currentSite;

        currentSite = currentSite.next;
    }

    public String back(int steps) {
        while (steps > 0) {
            if (currentSite.prev == null) {
                return currentSite.urlName;
            }
            currentSite = currentSite.prev;
            steps--;
        }

        return currentSite.urlName;
    }

    public String forward(int steps) {
        while (steps > 0) {
            if (currentSite.next == null) {
                return currentSite.urlName;
            }
            currentSite = currentSite.next;
            steps--;
        }

        return currentSite.urlName;
    }

    private class SiteNode {
        String urlName;
        SiteNode prev = null;
        SiteNode next = null;

        SiteNode(String url) {
            urlName = url;
        }
    }
}
