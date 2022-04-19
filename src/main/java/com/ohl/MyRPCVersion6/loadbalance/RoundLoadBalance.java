package com.ohl.MyRPCVersion6.loadbalance;

import java.util.List;

public class RoundLoadBalance implements LoadBalance{
    private int choose = 0;
    @Override
    public String balance(List<String> addressList) {
        choose++;
        choose = choose % addressList.size();
        return addressList.get(choose);
    }
}
