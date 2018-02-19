package org.gooru.nucleus.libs.tenant.bootstrap;

import javax.sql.DataSource;

import org.gooru.nucleus.libs.tenant.db.entities.Tenant;
import org.postgresql.ds.PGPoolingDataSource;

/**
 * @author ashish on 9/1/17.
 */
public final class TenantInitializer {

    private TenantInitializer() {
        throw new AssertionError();
    }

    public static void initialize(DataSource dataSource) {
        TenantStore.getInstance().initialize(dataSource);
    }

    public static void main(String[] args) {
        PGPoolingDataSource ds = new PGPoolingDataSource();
        ds.setServerName("localhost");
        ds.setPortNumber(5432);
        ds.setDatabaseName("nucleus");
        ds.setUser("nucleus");
        ds.setPassword("nucleus");
        ds.setMaxConnections(10);

        TenantInitializer.initialize(ds);
        for (int i = 0; i < 100; i++) {
            try {
                Tenant tenant = TenantStore.getInstance().getTenantById("ba956a97-ae15-11e5-a302-f8a963065976");
                System.out.println("Got the tenant: " + tenant.getTenantId() + " for iteration " + i);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
