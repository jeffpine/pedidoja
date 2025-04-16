package com.pinheiro.pedidoja.dto;

import jakarta.validation.constraints.*;

public record OrderRequest(
        @NotBlank(message = "Nome do produto é obrigatório")
        @Size(max = 100, message = "Máximo 100 caracteres")
        String productName,

        @NotNull(message = "Quantidade é obrigatória")
        @Min(value = 1, message = "Quantidade mínima é 1")
        @Max(value = 100, message = "Quantidade máxima é 100")
        Integer quantity,

        @Pattern(regexp = "^[A-Z]{2}-\\d+$", message = "Código deve seguir o padrão 'XX-123'")
        String productCode
) {}
