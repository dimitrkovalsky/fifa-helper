package com.liberty.fifahelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuyPlayerInfo {
    private Long playerId;
    private String name;
    private Long buyNow;
}
