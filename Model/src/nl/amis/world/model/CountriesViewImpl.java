package nl.amis.world.model;

import oracle.adf.share.logging.ADFLogger;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 21 06:28:04 CET 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CountriesViewImpl extends ViewObjectImpl {
    private static ADFLogger _logger = ADFLogger.createADFLogger(CountriesViewImpl.class);

    /**
     * This is the default constructor (do not remove).
     */
    public CountriesViewImpl() {
    }

    @Override
    public void executeQuery() {
        // TODO Implement this method
        super.executeQuery();
        _logger.fine("Execute Query in CountriesView");
    }

    @Override
    public void prepareVOForQuery() {
        // TODO Implement this method
        super.prepareVOForQuery();
        _logger.finer("Prepare for Query in CountriesView");
    }

    @Override
    protected void executeQueryForCollection(Object object, Object[] params, int i) {
        _logger.fine("Execute Query For Collection in CountriesView");
        if (params != null) {
            for (Object param : params) {
                Object[] nameValue = (Object[]) param;
                String name = (String) nameValue[0];
                _logger.finest("Param for CountriesView {0}", param + name + "=" + nameValue[1]);
                if ("X".equalsIgnoreCase((String)nameValue[1])) {
                    throw new RuntimeException("That is a parameter value ('X') we cannot handle - Sorry ");
                }
            }
        }
        super.executeQueryForCollection(object, params, i);

    }
}
