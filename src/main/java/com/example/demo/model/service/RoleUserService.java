package com.example.demo.model.service;

import com.example.demo.dto.PessoaRoleDTO;
import com.example.demo.model.entity.Pessoa;
import com.example.demo.model.entity.Role;
import com.example.demo.model.repository.PessoaIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleUserService {

    @Autowired
    private PessoaIF pessoaRepository;

    // verificar se o usuário existe na base de dados
    public Pessoa execute(PessoaRoleDTO pessoaRoleDTO) {
        Optional<Pessoa> userExists = pessoaRepository.findById(pessoaRoleDTO.getIdUser());
        List<Role> roles = new ArrayList<>();

        if (userExists.isEmpty()) {
            throw new Error("User does not exists!");
        }

        // se o usuário existir, percorre a lista das roles e mapeia os ids
        // para criar um objeto de role
        roles = pessoaRoleDTO.getIdsRoles().stream().map(role -> {
            return new Role(role);
        }).collect(Collectors.toList());

        Pessoa user = userExists.get();

        user.setRoles(roles);

        pessoaRepository.save(user);

        return user;
    }
}
