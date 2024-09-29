package com.example.calculadoralucian;

public class Operations {
    public String doOperation(String input) {
        try {
            // Ejecutar la operación y devolver el resultado
            if (input.contains("+")) {
                String[] parts = input.split("\\+");
                int result = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
                return String.valueOf(result);
            } else if (input.contains("-")) {
                String[] parts = input.split("-");
                int result = Integer.parseInt(parts[0]) - Integer.parseInt(parts[1]);
                return String.valueOf(result);
            }
        } catch (Exception e) {
            return "ERROR";
        }
        return "ERROR";
    }
}
