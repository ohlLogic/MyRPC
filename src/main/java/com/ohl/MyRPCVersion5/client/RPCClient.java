package com.ohl.MyRPCVersion5.client;

import com.ohl.MyRPCVersion5.common.RPCRequest;
import com.ohl.MyRPCVersion5.common.RPCResponse;

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}
