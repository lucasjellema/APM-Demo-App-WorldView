package nl.amis.world.model;

import oracle.adf.share.logging.ADFLogger;

import oracle.jbo.Session;
import oracle.jbo.SessionData;
import oracle.jbo.server.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 21 06:24:57 CET 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class WorldModuleImpl extends ApplicationModuleImpl {
    
    private static ADFLogger _logger = 
                ADFLogger.createADFLogger(WorldModuleImpl.class); 
    /**
     * This is the default constructor (do not remove).
     */
    public WorldModuleImpl() {
        _logger.fine("Constructing Application Module");
    }

    @Override
    public void prepareSession(SessionData sessionData) {
        // TODO Implement this method
        super.prepareSession(sessionData);
        _logger.info("prepareSession prepares the database session and performs initialization; this is the place to set client_identitier, module and action through dbms_application_info");
    }

    @Override
    protected void prepareSession(Session session) {
        // TODO Implement this method
        super.prepareSession(session);
    }

    /**
     * Container's getter for CountriesView1.
     * @return CountriesView1
     */
    public CountriesViewImpl getCountriesView1() {
        return (CountriesViewImpl) findViewObject("CountriesView1");
    }
}

