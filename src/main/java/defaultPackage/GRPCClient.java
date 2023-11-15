package defaultPackage;

import com.cursoGrpc.grpc.User.APIResponse;
import com.cursoGrpc.grpc.User.LoginRequest;
import com.cursoGrpc.grpc.userGrpc;
import com.cursoGrpc.grpc.userGrpc.userBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {

    private ManagedChannel channel;

    public GRPCClient(){
    channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
    }
    public ManagedChannel getChannel() {
        return channel;
    }
}
