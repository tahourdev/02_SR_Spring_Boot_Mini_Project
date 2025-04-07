package com.keanghor.java.miniproject.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Expenses {
    private Integer expense_id;
    private Double amount;
    private String description;
    private Timestamp date;
    private List<Users> user;
//    private List<Categories> category;
}