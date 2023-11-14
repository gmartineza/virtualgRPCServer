package defaultPackage;

import com.cursoGrpc.grpc.userGrpc;
import com.cursoGrpc.grpc.User.APIResponse;
import com.cursoGrpc.grpc.User.LoginRequest;
import com.cursoGrpc.grpc.userGrpc.userBlockingStub;
import com.cursoGrpc.grpc.userGrpc.userStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {
    public static void main(String[] args){
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
    
    userBlockingStub userStub = userGrpc.newBlockingStub(channel);
    
    LoginRequest loginRequest = LoginRequest.newBuilder().
        setUsername("gabi").
        setPassword("gabicapo").
        build();

    APIResponse response = userStub.login(loginRequest);

    System.out.println(response.getResponsemessage());
    
    }
}
