package com.liberty.fifahelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerMonitoring {
    private PlayerProfile playerProfile;
    private BuyPlayerInfo buyPlayerInfo;
}
