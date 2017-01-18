package nl.amis.world.view.rss;

public class FeedTester {
    public static void main(String[] args) {
        RSSFeedParser parser = new RSSFeedParser("http://rss.cnn.com/rss/cnn_topstories.rss");
        Feed feed = parser.readFeed();
        System.out.println(feed);
        for (FeedMessage message : feed.getMessages()) {
            System.out.println(message);

        }

    }
}