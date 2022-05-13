package api.cliente.api_cliente.domain.service;

import java.util.List;
import java.util.stream.Collectors;
import api.cliente.api_cliente.domain.dto.ResponseDto;
import api.cliente.api_cliente.domain.dto.ClienteDto;
import api.cliente.api_cliente.domain.entity.Cliente;
import api.cliente.api_cliente.domain.enumeration.Status;
import api.cliente.api_cliente.domain.repository.ClienteRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    ClienteRepository clienteRepository;

    public ResponseDto saveCliente(Cliente cliente) {
        responseDto.setId(clienteRepository.save(cliente).getId());
        responseDto.setMessage("Cliente incluído com sucesso...");
        responseDto.setStatus(Status.SUCCESS.value());
        return responseDto;
    }

    public List<ClienteDto> getAllCliente() {
        List<ClienteDto> listAllClienteDto = clienteRepository.findAll().stream()
                .map(Cliente -> modelMapper.map(Cliente, ClienteDto.class))
                .collect(Collectors.toList());
        return listAllClienteDto;
    }

    public List<ClienteDto> getAllClienteOrderByName() {
        List<ClienteDto> listAllClienteDto = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome")).stream()
                .map(Cliente -> modelMapper.map(Cliente, ClienteDto.class))
                .collect(Collectors.toList());
        return listAllClienteDto;
    }

    public ClienteDto getClienteById(Long id) {
        return modelMapper.map(clienteRepository.findById(id).get(), ClienteDto.class);
    }

    public ResponseDto updateCliente(Cliente cliente) {
        responseDto.setId(clienteRepository.save(cliente).getId());
        if (clienteRepository.existsById(cliente.getId())) {
        // if (cliente.getId() > 0) {
            clienteRepository.save(cliente);
            responseDto.setMessage("Cliente alterado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMessage("ID do Cliente inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

    public ResponseDto deleteCliente(Long id) {
        responseDto.setId(id);
        if (id > 0) {
            clienteRepository.deleteById(id);
            responseDto.setMessage("Cliente deletado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMessage("ID do Cliente inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

    // public UserDto validateLogin(String login, String password) {
    //    return modelMapper.map(userRepository.findUserByLoginAndPassword(login, password), UserDto.class);
    // }

}
