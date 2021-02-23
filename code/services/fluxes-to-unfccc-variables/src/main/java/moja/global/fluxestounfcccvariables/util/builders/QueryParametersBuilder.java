/*
 * Copyright (C) 2021 Moja Global
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package moja.global.fluxestounfcccvariables.util.builders;

import moja.global.fluxestounfcccvariables.daos.QueryParameters;
import moja.global.fluxestounfcccvariables.exceptions.ClientException;
import org.springframework.web.reactive.function.server.ServerRequest;

// TODO Exception Checks

/**
 * @author Kwaje Anthony <tony@miles.co.ke>
 * @version 1.0
 * @since 0.0.1
 */
public class QueryParametersBuilder {

    private Long[] ids;
    private Long startPoolId;
    private Long endPoolId;
    private Long unfcccVariableId;
    private String rule;


    public QueryParametersBuilder ids(ServerRequest request) {

        this.ids =
                request.queryParams().get("ids") == null ? null :
                        request.queryParams()
                                .get("ids")
                                .stream()
                                .map(Long::parseLong)
                                .sorted()
                                .toArray(Long[]::new);
        return this;
    }

    public QueryParametersBuilder startPoolId(ServerRequest request) {
        this.startPoolId =
                request.queryParam("startPoolId").isPresent() ?
                        Long.parseLong(request.queryParam("startPoolId").get()) : null;
        return this;
    }

    public QueryParametersBuilder endPoolId(ServerRequest request) {
        this.endPoolId =
                request.queryParam("endPoolId").isPresent() ?
                        Long.parseLong(request.queryParam("endPoolId").get()) : null;
        return this;
    }

    public QueryParametersBuilder unfcccVariableId(ServerRequest request) {
        this.unfcccVariableId =
                request.queryParam("unfcccVariableId").isPresent() ?
                        Long.parseLong(request.queryParam("unfcccVariableId").get()) : null;
        return this;
    }

    public QueryParametersBuilder rule(ServerRequest request) {
        this.rule =
                request.queryParam("rule").isPresent() ?
                        request.queryParam("rule").get() : null;
        return this;
    }

    public QueryParameters build() {
        return new QueryParameters(ids, startPoolId, endPoolId, unfcccVariableId, rule);
    }

}
