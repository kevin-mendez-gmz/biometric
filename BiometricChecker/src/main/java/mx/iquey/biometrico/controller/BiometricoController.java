/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.iquey.biometrico.controller;

import com.mx.iquey.to.AsistenciaTO;
import com.mx.iquey.to.ClasificacionPuestoTO;
import com.mx.iquey.to.TrabajadorTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import java.util.List;

import mx.iquey.biometrico.utils.ConstantsDesk;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author kevin-mendez
 */
public class BiometricoController {

    public List<TrabajadorTO> getTrabajadores() throws Exception {

        List<TrabajadorTO> resultList = null;
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        try {
            resultList = client
                    .resource(
                            ConstantsDesk.PARENT_URL_REST_SERVICE + "rest/trabajadores/getAllTrabajadores")
                    .get(new GenericType<List<TrabajadorTO>>() {
                    });

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERROR DE CONEXION");
        }

        return resultList;
    }

    public boolean insertTrabajador(TrabajadorTO trabajadorTO) throws Exception {

        try {

            DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
            defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
            defaultClientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(defaultClientConfig);

            WebResource webResource = client
                    .resource(ConstantsDesk.PARENT_URL_REST_SERVICE + "rest/trabajadores/insertTrabajador");

//            ObjectMapper mapper = new ObjectMapper();
//
//            String inputJson = mapper.writeValueAsString(trabajadorTO);
            ClientResponse response = webResource.type("application/json")
                    .post(ClientResponse.class, trabajadorTO);

            if (response.getStatus() != 201) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();

            e.printStackTrace();
            throw new Exception("ERROR DE CONEXION");
        }

        return true;
    }

    public AsistenciaTO getAsistenciaByTrabajador(int idTrabajador) throws Exception {

        AsistenciaTO resultList = null;
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        try {
            resultList = client
                    .resource(
                            ConstantsDesk.PARENT_URL_REST_SERVICE + "rest/asistencias/getAsistencias/" + idTrabajador)
                    .get(new GenericType<AsistenciaTO>() {
                    });

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERROR DE CONEXION");
        }

        return resultList;
    }

    public boolean insertAsistencia(AsistenciaTO asistenciaTO) throws Exception {

        try {

            DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
            defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
            defaultClientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(defaultClientConfig);

            WebResource webResource = client
                    .resource(ConstantsDesk.PARENT_URL_REST_SERVICE + "rest/asistencias/insertAsistencia");

//            ObjectMapper mapper = new ObjectMapper();
//
////            String inputJson = mapper.writeValueAsString(asistenciaTO);
            ClientResponse response = webResource.type("application/json")
                    .post(ClientResponse.class, asistenciaTO);

            if (response.getStatus() != 201) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERROR DE CONEXION");
        }

        return true;
    }

    public boolean updateAsistencia(AsistenciaTO asistenciaTO) throws Exception {

        try {

            DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
            defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
            defaultClientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            Client client = Client.create(defaultClientConfig);

            WebResource webResource = client
                    .resource(ConstantsDesk.PARENT_URL_REST_SERVICE + "rest/asistencias/updateAsistencia");

//            ObjectMapper mapper = new ObjectMapper();
//
//            String inputJson = mapper.writeValueAsString(asistenciaTO);
            ClientResponse response = webResource.type("application/json")
                    .post(ClientResponse.class, asistenciaTO);

            if (response.getStatus() != 201) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERROR DE CONEXION");
        }

        return true;
    }

    public List<ClasificacionPuestoTO> getClasificaciones() throws Exception {

        List<ClasificacionPuestoTO> resultList = null;
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        try {
            resultList = client
                    .resource(
                            ConstantsDesk.PARENT_URL_REST_SERVICE + "rest/clasificacion/getClasificacion")
                    .get(new GenericType<List<ClasificacionPuestoTO>>() {
                    });

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERROR DE CONEXION");
        }

        return resultList;
    }

}
