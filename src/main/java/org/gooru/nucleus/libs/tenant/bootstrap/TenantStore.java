package org.gooru.nucleus.libs.tenant.bootstrap;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.gooru.nucleus.libs.tenant.db.entities.Tenant;
import org.gooru.nucleus.libs.tenant.db.services.TenantStoreService;

/**
 * @author ashish on 9/1/17.
 */
public final class TenantStore {

    private volatile boolean initialized = false;
    private final Map<String, Tenant> store = new HashMap<>(20);

    private TenantStore() {
    }

    public static TenantStore getInstance() {
        return Holder.INSTANCE;
    }

    public void initialize(DataSource dataSource) {
        if (!initialized) {
            synchronized (Holder.INSTANCE) {
                if (!initialized) {
                    store.putAll(TenantStoreService.fetchAllActiveTenants(dataSource));
                    initialized = true;
                }
            }
        }
    }

    private static final class Holder {
        private static final TenantStore INSTANCE = new TenantStore();
    }

    public Tenant getTenantById(String id) {
        return store.get(id);
    }

}
