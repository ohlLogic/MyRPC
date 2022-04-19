package com.ohl.MyRPCVersion4.client;

import com.ohl.MyRPCVersion4.common.RPCRequest;
import com.ohl.MyRPCVersion4.common.RPCResponse;

public interface RPCClient {
    RPCResponse sendRequest(RPCRequest request);
}
