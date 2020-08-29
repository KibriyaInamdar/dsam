package de.uniba.dsg.jaxrs.controller;

import de.uniba.dsg.jaxrs.model.Bottle;
import de.uniba.dsg.jaxrs.model.dto.BottleDTO;
import de.uniba.dsg.jaxrs.model.dto.BottlePostDTO;
import de.uniba.dsg.jaxrs.model.error.ErrorMessage;
import de.uniba.dsg.jaxrs.model.error.ErrorType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.logging.Logger;

//@Path("bottles")
@RestController
//@RequestMapping("/beverage")
public class BottleResource{
    private static final Logger logger = Logger.getLogger("BottleResource");

//    @RequestMapping("bottles/{bottleId}")
    public Bottle getBottle( @PathVariable("bottleId") final int id) {
        logger.info("Get bottle with id " + id);
   /*     final Bottle bottle = BottleService.instance.getBottle(id);
        if (bottle == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(new BottleDTO(bottle)).build();*/
        return new Bottle(1, "Pils", 0.5, true, 4.8, 0.79, "Keesmann", 34);
    }
/*

    @GET
    @Path("search")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMinAndMaxBottle(@Context final UriInfo info,@QueryParam("min")final double min,@QueryParam("max")final double max)
    {
        logger.info("Get bottle with mininum price:" + min +" and maximum price:"+max);
        if(min< 0)
        {
            final ErrorMessage errorMessage = new ErrorMessage(ErrorType.INVALID_PARAMETER, "Minimum value of range cannot be less than 0");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
        }
        else if(max<0)
        {
            final ErrorMessage errorMessage = new ErrorMessage(ErrorType.INVALID_PARAMETER, "Maximum value of range cannot be less than 0");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
        }
        else if(min> max)
        {
            final ErrorMessage errorMessage = new ErrorMessage(ErrorType.INVALID_PARAMETER, "Minimum value of range should be less than maximum value");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
        }
        List<BottleDTO> resultList = BottleDTO.marshallPagination(BottleService.instance.getMinAndMaxPriceBeverages(min,max));
        if(resultList.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();
        else
            return Response.ok(new GenericEntity<List<BottleDTO>>(resultList){}).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getBeverages() {
        List<Bottle> bottleList = BottleService.instance.getBeverages();
        List<BottleDTO> bottleDTOList =  BottleDTO.marshallPagination(bottleList);
        return Response.ok(new GenericEntity<List<BottleDTO>>(bottleDTOList){}).build();
    }

    @POST
    public Response createBottle(final BottlePostDTO newBottle, @Context final UriInfo uriInfo) {
        logger.info("Create Bottle " + newBottle);
        if (newBottle == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorMessage(ErrorType.INVALID_PARAMETER, "Body was empty")).build();
        }
        final Bottle bottle = newBottle.unmarshall();
        String validationResult = parameterValidation(bottle);
        if(validationResult.equalsIgnoreCase("success"))
        {
            BottleService.instance.addBottle(bottle);
            return Response.created(UriBuilder.fromUri(uriInfo.getBaseUri()).path(BottleResource.class).path(BottleResource.class, "getBottle").build(bottle.getId())).build();
        }
        else
        {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorMessage(ErrorType.INVALID_PARAMETER,validationResult)).build();
        }
    }

    @PUT
    @Path("{bottle-id}")
    public Response updateBottle(@Context final UriInfo uriInfo, @PathParam("bottle-id") final int id, final BottlePostDTO updatedBottle) {
        logger.info("Update bottle " + updatedBottle);
        if (updatedBottle == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorMessage(ErrorType.INVALID_PARAMETER, "Body was empty")).build();
        }

        final Bottle bottle = BottleService.instance.getBottle(id);

        if (bottle == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        String validationResult = parameterValidation(bottle);
        if(validationResult.equalsIgnoreCase("success")){
            final Bottle resultBottle = BottleService.instance.updateBottle(id, updatedBottle.unmarshall());
            return Response.ok().entity(new BottleDTO(resultBottle)).build();
        }
        else
        {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorMessage(ErrorType.INVALID_PARAMETER,validationResult)).build();
        }
    }

    @DELETE
    @Path("{bottleId}")
    public Response deleteSpecificBottle(@PathParam("bottleId") final int id) {
        logger.info("Delete bottle with id " + id);
        final boolean deleted = BottleService.instance.deleteBottle(id);

        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok().build();
        }
    }

    private String parameterValidation(Bottle bottle){
        String success="success";
        if(bottle.getName().equalsIgnoreCase("string"))
            return "Please enter bottle name.";
        if(bottle.getSupplier().equalsIgnoreCase("string"))
            return "Please enter supplier name";
        if(bottle.isAlcoholic())
            if(bottle.getVolumePercent()==0)
                return "Please enter alcohol volume percent";
        if(bottle.getPrice()==0)
            return "Please enter bottle price";
        if(bottle.getInStock()==0)
            return "Please enter bottles in stock";
        return success;
    }
*/
}
