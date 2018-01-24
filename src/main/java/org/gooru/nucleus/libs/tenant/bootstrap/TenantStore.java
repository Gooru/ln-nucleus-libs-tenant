package org.gooru.nucleus.libs.tenant.bootstrap;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.sql.DataSource;

import org.gooru.nucleus.libs.tenant.db.entities.Tenant;
import org.gooru.nucleus.libs.tenant.db.services.TenantStoreService;

/**
 * @author ashish on 9/1/17.
 */
public final class TenantStore {

    private static final int PERIOD = 1000 * 60 * 60 * 6;
    private static final int DELAY = 600000;
    private volatile boolean initialized = false;
    private volatile Map<String, Tenant> store = new HashMap<>(20);

    private TenantStore() {
    }

    public static TenantStore getInstance() {
        return Holder.INSTANCE;
    }

    public void initialize(DataSource dataSource) {
        if (!initialized) {
            synchronized (Holder.INSTANCE) {
                if (!initialized) {
                    store = TenantStoreService.fetchAllActiveTenants(dataSource);
                    initialized = true;
                    runRefresher(dataSource);
                }
            }
        }
    }

    private void runRefresher(DataSource dataSource) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                store = TenantStoreService.fetchAllActiveTenants(dataSource);
            }
        };

        Timer timer = new Timer("LibTenantRefresher", true);
        timer.scheduleAtFixedRate(timerTask, DELAY, PERIOD);
    }

    private static final class Holder {
        private static final TenantStore INSTANCE = new TenantStore();
    }

    public Tenant getTenantById(String id) {
        return store.get(id);
    }

}
