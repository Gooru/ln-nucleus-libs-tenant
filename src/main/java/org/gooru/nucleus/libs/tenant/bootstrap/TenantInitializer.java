package org.gooru.nucleus.libs.tenant.bootstrap;

import javax.sql.DataSource;

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
}
