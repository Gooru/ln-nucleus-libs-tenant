package org.gooru.nucleus.libs.tenant.db.services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.gooru.nucleus.libs.tenant.db.entities.Tenant;
import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ashish on 10/1/17.
 */
public final class TenantStoreService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TenantStoreService.class);

    private TenantStoreService() {
        throw new AssertionError();
    }

    public static Map<String, Tenant> fetchAllActiveTenants(DataSource dataSource) {
        List<Tenant> tenants;
        Map<String, Tenant> store = new HashMap<>(20);
        try {
            setupTransaction(dataSource);
            tenants = Tenant.findBySQL(Tenant.QUERY_FETCH_TENANT);
            tenants.forEach(tenant -> store.put(tenant.getTenantId(), tenant));
            Base.commitTransaction();
        } catch (Exception e) {
            LOGGER.error("Not able to initialize tenant store", e);
            Base.rollbackTransaction();
        } finally {
            Base.close();
        }
        return store;
    }

    private static void setupTransaction(DataSource dataSource) throws SQLException {
        Base.open(dataSource);
        Base.connection().setReadOnly(true);
        Base.openTransaction();
    }
}
