package com.ltnc.JavaApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalFund {
    @Id
    private long fund;

    public long getFund() {
        return fund;
    }

    public void setFund(long fund) {
        this.fund += fund;
    }
}
