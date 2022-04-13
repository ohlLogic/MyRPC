package com.ohl.MyRPCVersion3.client;

import com.ohl.MyRPCVersion3.common.RPCRequest;
import com.ohl.MyRPCVersion3.common.RPCResponse;

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}
