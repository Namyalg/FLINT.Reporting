/*
 * Copyright (C) 2021 Moja Global
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package moja.global.fluxestounfcccvariables.handlers.put;

import moja.global.fluxestounfcccvariables.models.FluxToUnfcccVariable;
import moja.global.fluxestounfcccvariables.exceptions.ServerException;
import moja.global.fluxestounfcccvariables.repository.FluxesToUnfcccVariablesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

/**
 * @since 1.0
 * @author Kwaje Anthony <tony@miles.co.ke>
 * @version 1.0
 */
@Component
@Slf4j
public class UpdateFluxesToUnfcccVariablesHandler {

	@Autowired
	FluxesToUnfcccVariablesRepository repository;
	
	/**
	 * Updates fluxes to UNFCCC variable records
	 * @param request the request containing the details of the fluxes to UNFCCC variable records to be updated
	 * @return the response containing the details of the newly updated fluxes to UNFCCC variable records
	 */
	public Mono<ServerResponse> updateFluxesToUnfcccVariables(ServerRequest request) {

		log.trace("Entering updateFluxesToUnfcccVariables()");

		return 
			request
					.bodyToMono(FluxToUnfcccVariable[].class)
					.flatMap(units ->
						ServerResponse
							.ok()
							.contentType(MediaType.APPLICATION_JSON)
							.body(updateFluxesToUnfcccVariables(units), FluxToUnfcccVariable.class))
					.onErrorMap(e -> new ServerException("Fluxes To UNFCCC Variable records update failed", e));
	}
	
	private Flux<FluxToUnfcccVariable> updateFluxesToUnfcccVariables(FluxToUnfcccVariable[] fluxToUnfcccVariables) {
		return 
			Flux.fromStream(Arrays.stream(fluxToUnfcccVariables).sorted())
				.flatMap(unit -> 
					repository
						.updateFluxToUnfcccVariable(unit)
						.flatMap(count -> repository.selectFluxToUnfcccVariable(unit.getId())));

	}

	


}
