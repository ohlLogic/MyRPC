package com.ohl.MyRPCVersion6.client;

import com.ohl.MyRPCVersion6.common.RPCRequest;
import com.ohl.MyRPCVersion6.common.RPCResponse;

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}
