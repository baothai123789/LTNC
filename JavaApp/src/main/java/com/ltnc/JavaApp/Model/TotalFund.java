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

    public void addFund(long fund) {
        this.fund += fund;
    }
    public void minusFund(long fund){
        if(this.fund <= 0) System.out.println("Don't have enough money");
        else this.fund -= fund;
    }
}
