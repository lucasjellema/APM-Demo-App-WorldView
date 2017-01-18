package nl.amis.world.view.beans;

import oracle.adf.share.logging.ADFLogger;

public class MainBean {
    
    private String welcome = "Welcome Guest";

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public String getWelcome() {
        _logger.info("Request welcome");
        return welcome;
    }

    private static ADFLogger _logger = 
                ADFLogger.createADFLogger(MainBean.class); 
    
    public MainBean() {
        super();
        _logger.info("Creating a new instance");
    }
}
