package nl.amis.world.view.beans;

import java.util.ArrayList;
import java.util.List;

import nl.amis.world.view.rss.Feed;
import nl.amis.world.view.rss.FeedMessage;

import nl.amis.world.view.rss.RSSFeedParser;

import oracle.adf.share.logging.ADFLogger;

public class NewsBean {
    String rssFeedUrl;

    
    List<FeedMessage> rssItems;
    Feed feed;

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setRssFeedUrl(String rssFeedUrl) {
        this.rssFeedUrl = rssFeedUrl;
    }

    public String getRssFeedUrl() {
        return rssFeedUrl;
    }
    private static ADFLogger _logger = 
                ADFLogger.createADFLogger(NewsBean.class); 

    public void setRssItems(List<FeedMessage> rssItems) {
        this.rssItems = rssItems;
    }

    public List<FeedMessage> getRssItems() {
        // this may not be the most efficient way to getting hold of RSS Items - retrieving the RSS feed on every occasion!
        prepareRssItems();
        return rssItems;
    }
    
    private void prepareRssItems() {
        _logger.info("prepare and fetch rss feed {0}", getRssFeedUrl());
        RSSFeedParser parser = new RSSFeedParser(getRssFeedUrl());
        setFeed(parser.readFeed());
        _logger.info("parse rss feed {0}", feed.toString());
        rssItems = new ArrayList<FeedMessage>();
        rssItems = getFeed().getMessages();

    }

    public NewsBean() {
        super();
    }
}
