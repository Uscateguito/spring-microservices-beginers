package com.microservice.service.controller;

import com.microservice.service.model.AlojamientoModel;
import com.microservice.service.model.ClientModel;
import com.microservice.service.model.ProviderModel;
import com.microservice.service.model.TransportModel;
import com.microservice.service.model.inputs.AlojamientoInput;
import com.microservice.service.model.inputs.ClienteInput;
import com.microservice.service.model.inputs.ProveedorInput;
import com.microservice.service.model.inputs.TransporteInput;
import com.microservice.service.model.intermedias.Alojamiento_Persona;
import com.microservice.service.model.intermedias.Alojamiento_Proveedor;
import com.microservice.service.model.intermedias.Transporte_Persona;
import com.microservice.service.model.intermedias.Transporte_Proveedor;
import com.microservice.service.repository.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class GraphQlController {

    @Autowired
    private AlojamientoRepository alojamientoRepository;
    @Autowired
    private Alojamiento_PersonaRepository alojamiento_persona;
    @Autowired
    private Alojamiento_ProveedorRepository alojamiento_proveedor;
    @Autowired
    private TransporteRepository transporteRepository;
    @Autowired
    private Transporte_PersonaRepository transporte_persona;
    @Autowired
    private Transporte_ProveedorRepository transporte_proveedor;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private Alojamiento_PersonaRepository alojamiento_PersonaRepository;

    Logger log = Logger.getLogger(GraphQlController.class.getName());

//    START QUERY MAPPINGS

    @QueryMapping
    Iterable<AlojamientoModel> alojamientos(){
        return alojamientoRepository.findAll();
    }

    @QueryMapping
    Iterable<TransportModel> transportes(){
        return transporteRepository.findAll();
    }

    @QueryMapping
    Iterable<ClientModel> clientes(){
        log
        return clienteRepository.findAll();
    }

    @QueryMapping
    Iterable<ProviderModel> proveedores(){
        return proveedorRepository.findAll();
    }

    @QueryMapping
    Optional<AlojamientoModel> alojamientoById(@Argument String id){
        return alojamientoRepository.findById(id);
    }

    @QueryMapping
    Optional<TransportModel> transporteById(@Argument String id){
        return transporteRepository.findById(id);
    }

    @QueryMapping
    Optional<ClientModel> clienteByCorreo(@Argument String correo){
        return Optional.ofNullable(clienteRepository.findByCorreo(correo));
    }

    @QueryMapping
    Optional<ProviderModel> proveedorByCorreo(@Argument String correo){
        return Optional.ofNullable(proveedorRepository.findByCorreo(correo));
    }

    @QueryMapping
    Iterable<Alojamiento_Persona> alojamientosByCliente(@Argument String clienteCorreo){
        return alojamiento_PersonaRepository.findAllByCliente_Correo(clienteCorreo);
    }

    @QueryMapping
    int countAlojamientosByCliente(@Argument String clienteCorreo){
        return alojamiento_PersonaRepository.countAllByCliente_Correo(clienteCorreo);
    }

    @QueryMapping
    Iterable<Transporte_Persona> transportesByCliente(@Argument String clienteCorreo){
        return transporte_persona.findAllByCliente_Correo(clienteCorreo);
    }

    @QueryMapping
    int countTransportesByCliente(@Argument String clienteCorreo){
        return transporte_persona.countAllByCliente_Correo(clienteCorreo);
    }

    @QueryMapping
    Iterable<Alojamiento_Proveedor> alojamientosByProveedor(@Argument String proveedorCorreo){
        return alojamiento_proveedor.findAllByProveedor_Correo(proveedorCorreo);
    }

    @QueryMapping
    int countAlojamientosByProveedor(@Argument String proveedorCorreo){
        return alojamiento_proveedor.countAllByProveedor_Correo(proveedorCorreo);
    }

    @QueryMapping
    Iterable<Transporte_Proveedor> transportesByProveedor(@Argument String proveedorCorreo){
        return transporte_proveedor.findAllByProveedor_Correo(proveedorCorreo);
    }

    @QueryMapping
    int countTransportesByProveedor(@Argument String proveedorCorreo){
        return transporte_proveedor.countAllByProveedor_Correo(proveedorCorreo);
    }

//    END QUERY MAPPINGS


//    START MUTATION MAPPINGS

    @MutationMapping
    ClientModel addCliente(@Argument ClienteInput cliente){

        return clienteRepository.save(
                ClientModel.builder()
                        .nombre(cliente.nombre())
                        .correo(cliente.correo())
                        .edad(cliente.edad())
                        .foto(cliente.foto())
                        .descripcion(cliente.descripcion())
                        .build()
        );
    }

    @MutationMapping
    ProviderModel addProveedor(@Argument ProveedorInput proveedor){

        return proveedorRepository.save(
                ProviderModel.builder()
                        .nombre(proveedor.nombre())
                        .correo(proveedor.correo())
                        .edad(proveedor.edad())
                        .foto(proveedor.foto())
                        .descripcion(proveedor.descripcion())
                        .telefono(proveedor.telefono())
                        .pagWeb(proveedor.pagWeb())
                        .contactoRedes(proveedor.contactoRedes())
                        .build()
        );
    }

    @MutationMapping
    AlojamientoModel addAlojamiento(@Argument AlojamientoInput alojamiento){

        return alojamientoRepository.save(
                AlojamientoModel.builder()
                        .nombre(alojamiento.nombre())
                        .calificacion(alojamiento.calificacion())
                        .ubicacion(alojamiento.ubicacion())
                        .precioPorNoche(alojamiento.precioPorNoche())
                        .build()
        );
    }

    @MutationMapping
    TransportModel addTransporte(@Argument TransporteInput transporte){

        return transporteRepository.save(
                TransportModel.builder()
                        .tipo(transporte.tipo())
                        .capacidad(transporte.capacidad())
                        .operador(transporte.operador())
                        .precio(transporte.precio())
                        .calificacion(transporte.calificacion())
                        .origen(transporte.origen())
                        .destino(transporte.destino())
                        .fechaSalida(transporte.fechaSalida())
                        .horaSalida(transporte.horaSalida())
                        .duracionEstimada(transporte.duracionEstimada())
                        .build()
        );
    }

    @MutationMapping
    Alojamiento_Persona rentAlojamiento(
            @Argument String alojamientoId,
            @Argument String personaCorreo,
            @Argument String fechaCheckIn,
            @Argument String fechaCheckOut
    ){
        AlojamientoModel alojamiento = alojamientoRepository.findById(alojamientoId).orElse(null);
        ClientModel persona = clienteRepository.findByCorreo(personaCorreo);

        return alojamiento_persona.save(
                Alojamiento_Persona.builder()
                        .fechaCheckIn(fechaCheckIn)
                        .fechaCheckOut(fechaCheckOut)
                        .alojamiento(alojamiento)
                        .cliente(persona)
                        .build()
        );
    }

    @MutationMapping
    Alojamiento_Proveedor addAlojamientoProveedor(
            @Argument String alojamientoId,
            @Argument String proveedorCorreo
    ){
        AlojamientoModel alojamiento = alojamientoRepository.findById(alojamientoId).orElse(null);
        ProviderModel proveedor = proveedorRepository.findByCorreo(proveedorCorreo);

        return alojamiento_proveedor.save(
                Alojamiento_Proveedor.builder()
                        .alojamiento(alojamiento)
                        .proveedor(proveedor)
                        .build()
        );
    }

    @MutationMapping
    Transporte_Persona rentTransporte(
            @Argument String transporteId,
            @Argument String personaCorreo,
            @Argument String numeroPlaca
    ){
        TransportModel transporte = transporteRepository.findById(transporteId).orElse(null);
        ClientModel persona = clienteRepository.findByCorreo(personaCorreo);

        return transporte_persona.save(
                Transporte_Persona.builder()
                        .numeroPlaca(numeroPlaca)
                        .transporte(transporte)
                        .cliente(persona)
                        .build()
        );
    }

    @MutationMapping
    Transporte_Proveedor addTransporteProveedor(
            @Argument String transporteId,
            @Argument String proveedorCorreo
    ){
        TransportModel transporte = transporteRepository.findById(transporteId).orElse(null);
        ProviderModel proveedor = proveedorRepository.findByCorreo(proveedorCorreo);

        return transporte_proveedor.save(
                Transporte_Proveedor.builder()
                        .transporte(transporte)
                        .proveedor(proveedor)
                        .build()
        );
    }

    @MutationMapping
    ClientModel updateClienteData(
            @Argument String correo,
            @Argument ClienteInput cliente
    ){
        ClientModel client = clienteRepository.findByCorreo(correo);

        client.setNombre(cliente.nombre());
        client.setCorreo(cliente.correo());
        client.setEdad(cliente.edad());
        client.setFoto(cliente.foto());
        client.setDescripcion(cliente.descripcion());

        return clienteRepository.save(client);
    }

    @MutationMapping
    ProviderModel updateProveedorData(
            @Argument String correo,
            @Argument ProveedorInput proveedor
    ){
        ProviderModel provider = proveedorRepository.findByCorreo(correo);

        provider.setNombre(proveedor.nombre());
        provider.setCorreo(proveedor.correo());
        provider.setEdad(proveedor.edad());
        provider.setFoto(proveedor.foto());
        provider.setDescripcion(proveedor.descripcion());
        provider.setTelefono(proveedor.telefono());
        provider.setPagWeb(proveedor.pagWeb());
        provider.setContactoRedes(proveedor.contactoRedes());

        return proveedorRepository.save(provider);
    }

    @MutationMapping
    AlojamientoModel updateAlojamientoData(
            @Argument String id,
            @Argument AlojamientoInput alojamiento
    ){
        AlojamientoModel aloj = alojamientoRepository.findById(id).orElseThrow(() -> new RuntimeException("Alojamiento no encontrado"));
        ProviderModel proveedor = proveedorRepository.findByCorreo(alojamiento.proveedorCorreo());

        aloj.setNombre(alojamiento.nombre());
        aloj.setUbicacion(alojamiento.ubicacion());
        aloj.setCalificacion(alojamiento.calificacion());
        aloj.setPrecioPorNoche(alojamiento.precioPorNoche());
        aloj.setProveedor(proveedor);

        return alojamientoRepository.save(aloj);
    }

    @MutationMapping
    TransportModel updateTransporteData(
            @Argument String id,
            @Argument TransporteInput transporte
    ){
        TransportModel transporteFinal = transporteRepository.findById(id).orElseThrow(() -> new RuntimeException("Transporte no encontrado"));
        ProviderModel proveedor = proveedorRepository.findByCorreo(transporte.proveedorCorreo());

        transporteFinal.setTipo(transporte.tipo());
        transporteFinal.setCapacidad(transporte.capacidad());
        transporteFinal.setOperador(transporte.operador());
        transporteFinal.setPrecio(transporte.precio());
        transporteFinal.setCalificacion(transporte.calificacion());
        transporteFinal.setOrigen(transporte.origen());
        transporteFinal.setDestino(transporte.destino());
        transporteFinal.setFechaSalida(transporte.fechaSalida());
        transporteFinal.setHoraSalida(transporte.horaSalida());
        transporteFinal.setDuracionEstimada(transporte.duracionEstimada());
        transporteFinal.setProveedor(proveedor);

        return transporteRepository.save(transporteFinal);

    }

    @MutationMapping
    void deleteAlojamiento(@Argument String id){
        alojamientoRepository.deleteById(id);
    }

    @MutationMapping
    void deleteTransporte(@Argument String id){
        transporteRepository.deleteById(id);
    }

    @MutationMapping
    boolean deleteCliente(@Argument String correo){
        return clienteRepository.deleteByCorreo(correo);
    }

    @MutationMapping
    boolean deleteProveedor(@Argument String correo){
        return proveedorRepository.deleteByCorreo(correo);
    }

//    END MUTATION MAPPINGS

}
