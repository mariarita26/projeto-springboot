package com.example.demo.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PessoaRoleDTO {

    private UUID idUser;

    private List<UUID> idsRoles;

}
