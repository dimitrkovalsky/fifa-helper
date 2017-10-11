package com.liberty.fifahelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyPlayerInfo {
    @NotNull
    private String playerId;
    @Min(250)
    @NotNull
    private Long buyNow;
    @Min(250)
    @NotNull
    private Long sellStartBid;
    @NotNull
    @Min(250)
    private Long sellBuyNow;
}
