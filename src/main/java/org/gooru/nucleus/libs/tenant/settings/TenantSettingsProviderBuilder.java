/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gooru.nucleus.libs.tenant.settings;


import org.gooru.nucleus.libs.tenant.bootstrap.TenantStore;

/**
 *
 * @author Ashish <ashish@gooru.org>
 */
public final class TenantSettingsProviderBuilder {

    private TenantSettingsProviderBuilder() {
        throw new AssertionError();
    }

    public static TenantSettingsProvider buildTenantSettingsProvider(String tenantId) {
        if (tenantId == null) {
            throw new IllegalArgumentException("Invalid tenant id passed to fetch tenant provider");
        }

        return TenantStore.getInstance().getTenantById(tenantId);
    }

}
