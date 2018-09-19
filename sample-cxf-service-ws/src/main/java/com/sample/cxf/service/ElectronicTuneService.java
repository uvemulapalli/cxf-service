package com.sample.cxf.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.common.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;

import com.sample.cxf.domain.ItemDetail;

@Path("/ElectronicTuneService")
@WebService(targetNamespace = "http://electronic.tune.web.service.com/", portName = "ElectronicTuneServicePort", serviceName = "ElectronicTuneService", wsdlLocation = "WEB-INF/wsdl/ElectronicTuneService.wsdl")
public class ElectronicTuneService {

	private final ItemDetail itemDetail = new ItemDetail("GP-6789", new Integer(1));

	@POST
	@WebMethod
	@Path("/item/{createItem}/")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ItemDetail createItem(@PathVariable("createItem") ItemDetail createItemDetail) throws Exception {
		return createItemDetail;
	}

	@GET
	@WebMethod
	@Path("/items/")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<ItemDetail> getAllItems() throws Exception {
		List<ItemDetail> itemDetails = new ArrayList<ItemDetail>();
		itemDetails.add(itemDetail);
		return itemDetails;
	}

	@GET
	@WebMethod
	@Path("/item/{itemName}/")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ItemDetail getItemDetail(@PathParam("itemName") String itemName) throws Exception {
		if (!StringUtils.isEmpty(itemName)) {
			return itemDetail;
		}
		return new ItemDetail("Please provide a valid search criteria");
	}
}