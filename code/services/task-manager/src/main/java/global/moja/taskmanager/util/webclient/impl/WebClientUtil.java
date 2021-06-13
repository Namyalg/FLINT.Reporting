/*
 * Copyright (C) 2021 Second Mile
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package global.moja.taskmanager.util.webclient.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @since 0.0.1
 * @author Kwaje Anthony <tony@miles.co.ke>
 * @version 1.0
 */
@Component
public class

WebClientUtil {

    @Autowired
    AccountabilitiesWebClientUtil accountabilitiesWebClientUtil;

    @Autowired
    AccountabilityRulesWebClientUtil accountabilityRulesWebClientUtil;

    @Autowired
    QuantityObservationsWebClientUtil quantityObservationsWebClientUtil;

    public WebClient getAccountabilitiesWebClient() {
        return accountabilitiesWebClientUtil.getAccountabilitiesWebClient();
    }

    public WebClient getAccountabilityRulesWebClient() {
        return accountabilityRulesWebClientUtil.getAccountabilityRulesWebClient();
    }

    public WebClient getQuantityObservationsWebClient() {
        return quantityObservationsWebClientUtil.getQuantityObservationsWebClient();
    }

}
