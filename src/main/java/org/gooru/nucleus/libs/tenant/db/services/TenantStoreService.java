package org.gooru.nucleus.libs.tenant.db.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.gooru.nucleus.libs.tenant.db.entities.Tenant;
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
        Map<String, Tenant> store = new HashMap<>(20);
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(Tenant.QUERY_FETCH_TENANT);
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Tenant tenant = new Tenant(resultSet);
                store.put(tenant.getTenantId(), tenant);
            }
            LOGGER.info("Initialized tenant store with '{}' records", store.size());
        } catch (Exception e) {
            LOGGER.error("Not able to initialize tenant store", e);
            Runtime.getRuntime().halt(2);
        }
        return store;
    }
}
