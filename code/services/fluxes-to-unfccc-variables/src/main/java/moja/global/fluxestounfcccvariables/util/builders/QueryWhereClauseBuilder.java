/*
 * Copyright (C) 2021 Moja Global
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package moja.global.fluxestounfcccvariables.util.builders;

import moja.global.fluxestounfcccvariables.daos.QueryParameters;

/**
 * @since 0.0.1
 * @author Kwaje Anthony <tony@miles.co.ke>
 * @version 1.0
 */
public class QueryWhereClauseBuilder {

    private QueryParameters queryParameters;

    public QueryWhereClauseBuilder queryParameters(QueryParameters queryParameters){
        this.queryParameters = queryParameters;
        return this;
    }

    public String build() {

        StringBuilder query = null;

        // Ids
        if(queryParameters.getIds() != null && queryParameters.getIds().length != 0) {
            if(queryParameters.getIds().length == 1) {
                query = new StringBuilder("id = " + queryParameters.getIds()[0]);
            } else {
                query = new StringBuilder("id IN (");

                int i = 0;
                while (i < queryParameters.getIds().length) {
                    query.append(queryParameters.getIds()[i]);
                    if(i < queryParameters.getIds().length - 1){
                        query.append(",");
                    }
                    i++;
                }

                query.append(")");
            }
        }


        // Start Pool Id
        if(queryParameters.getStartPoolId() != null){

            if(query != null){
                query.append(" AND ");
            } else {
                query = new StringBuilder();
            }

            query.append("start_pool_id = ").append(queryParameters.getStartPoolId());

        }


        // End Pool Id
        if(queryParameters.getEndPoolId() != null){

            if(query != null){
                query.append(" AND ");
            } else {
                query = new StringBuilder();
            }

            query.append("end_pool_id = ").append(queryParameters.getEndPoolId());

        }

        //  UNFCCC Variable
        if(queryParameters.getUnfcccVariableId() != null){

            if(query != null){
                query.append(" AND ");
            } else {
                query = new StringBuilder();
            }

            query.append("unfccc_variable_id = ").append(queryParameters.getUnfcccVariableId());

        }

        //  Rule
        // See: https://stackoverflow.com/questions/23419087/stringutils-isblank-vs-string-isempty
        if(queryParameters.getRule()!= null && !queryParameters.getRule().isBlank()){

            if(query != null){
                query.append(" AND ");
            } else {
                query = new StringBuilder();
            }

            query.append("rule LIKE '%").append(queryParameters.getRule()).append("%'");

        }

        return query == null ? "" : " WHERE " + query.toString();
    }
}
