package com.yamunaque.infraccionservice.soap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.uss.infraccionservice.GetAllInfraccionesRequest;
import com.uss.infraccionservice.GetAllInfraccionesResponse;
import com.uss.infraccionservice.InfraccionDetalle;
import com.yamunaque.infraccionservice.entity.Infraccion;
import com.yamunaque.infraccionservice.service.InfraccionService;


@Endpoint
public class InfraccionEndPoint {
	@Autowired
	private InfraccionService service;
	
	@PayloadRoot(namespace = "http://www.uss.com/infraccionservice", localPart = "GetAllInfraccionesRequest")
	@ResponsePayload
	public GetAllInfraccionesResponse findAll (@RequestPayload GetAllInfraccionesRequest request) {
		GetAllInfraccionesResponse response = new GetAllInfraccionesResponse();
		
		Pageable page = PageRequest.of(request.getOffset(), request.getLimit());
		List<Infraccion> infracciones = service.findAll(page);
		
		List<InfraccionDetalle> infraccionesResponse = new ArrayList<>();
		for (Infraccion infraccion : infracciones) {
		    InfraccionDetalle detalle = new InfraccionDetalle();
		    detalle.setId(infraccion.getId());
		    detalle.setDni(infraccion.getDni());
		    detalle.setFecha(infraccion.getFecha());
		    detalle.setTipoInfraccion(infraccion.getTipoInfraccion());
		    detalle.setUbicacion(infraccion.getUbicacion());
		    detalle.setDescripcion(infraccion.getDescripcion());
		    detalle.setMontoMulta(infraccion.getMontoMulta());
		    detalle.setEstado(infraccion.getEstado());
		    
		    infraccionesResponse.add(detalle);
		}
		response.getInfraccionDetalle().addAll(infraccionesResponse);
		return response;
	}
}
