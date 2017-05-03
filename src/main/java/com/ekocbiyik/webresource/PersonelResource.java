package com.ekocbiyik.webresource;

import com.ekocbiyik.model.Personel;
import com.ekocbiyik.service.IPersonelService;
import com.ekocbiyik.utils.UtilsForSpring;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

/**
 * Created by enbiya on 02.05.2017.
 */
@Path("/personelresource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class PersonelResource {


    @GET
    @Path("/login")
    public Response login(@HeaderParam("username") String username, @HeaderParam("password") String password) throws Exception {

//        if (!(username.equals("enbiya") && password.equals("6161"))) {
//            throw new Exception("invalid username/password");
//        }

        // burada username bilgisi null geleceği için hata fırlatacak
        if (username.equals("enbiya")){
            System.out.println("ok!");
        }

        GenericEntity<List<Personel>> entity = new GenericEntity<List<Personel>>(UtilsForSpring
                .getSingleBeanOfType(IPersonelService.class)
                .getAllPersonels()) {
        };

        return Response.status(Status.ACCEPTED).entity(entity).build();
    }

    //    @DELETE
    @POST
    @Path("/deletePersonel")
    public Response deletePersonel(Personel p) {

        IPersonelService personelService = UtilsForSpring.getSingleBeanOfType(IPersonelService.class);
        personelService.deletePersonel(p);
        GenericEntity<List<Personel>> entity = new GenericEntity<List<Personel>>(personelService.getAllPersonels()) {
        };
        return Response.status(Status.OK).entity(entity).build();
    }

    //    @PUT
    @POST
    @Path("/updatePersonel")
    public Response updatePersonel(Personel p) {

        IPersonelService personelService = UtilsForSpring.getSingleBeanOfType(IPersonelService.class);
        personelService.savePersonel(p);
        GenericEntity<List<Personel>> entity = new GenericEntity<List<Personel>>(personelService.getAllPersonels()) {
        };
        return Response.status(Status.OK).entity(entity).build();
    }

    @POST
    @Path("/savePersonel")
    public Response savePersonel(Personel p) {

        IPersonelService personelService = UtilsForSpring.getSingleBeanOfType(IPersonelService.class);
        personelService.savePersonel(p);
        GenericEntity<List<Personel>> entity = new GenericEntity<List<Personel>>(personelService.getAllPersonels()) {
        };
        return Response.status(Status.OK).entity(entity).build();
    }

    @GET
    @Path("/getallpersonels")
    public Response getAllPersonels() {
        List<Personel> personelList = UtilsForSpring.getSingleBeanOfType(IPersonelService.class).getAllPersonels();
        GenericEntity<List<Personel>> entity = new GenericEntity<List<Personel>>(personelList) {
        };
        return Response.status(Status.ACCEPTED).entity(entity).build();
    }

//    @GET
//    @Path("/getPersonelById/{personelId}")
//    public Response getPersonelById(@PathParam("personelId") int personelId) {
//        Personel personel = UtilsForSpring.getSingleBeanOfType(IPersonelService.class).getPersonelById(personelId);
//        return Response.status(Status.OK).entity(personel).build();
//    }

    @GET
    @Path("/getPersonelById")
    public Response getPersonelById(@QueryParam("personelId") int personelId) {
        Personel personel = UtilsForSpring.getSingleBeanOfType(IPersonelService.class).getPersonelById(personelId);
        return Response.status(Status.OK).entity(personel).build();
    }
}
