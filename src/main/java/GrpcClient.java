
import com.cursoGrpc.grpc.userGrpc.userBlockingStub;
import com.cursoGrpc.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.cursoGrpc.grpc.User.*;

public class GrpcClient {
    public static void main(String[] args){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();//Use this builder class to construct our channel.

        //stubs -> we generate from protofiles.
        //Ahora vamos a usar el proto que ya generamos anteriormente pero lo ideal seria que el cliente tambien tenga sus plugins y genere las protofiles igual que se hizo con el servidor.

        userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        LoginRequest loginrequest = LoginRequest.newBuilder().setUsername("hola").setPassword("hola").build();
        APIResponse response = userStub.login(loginrequest);

        System.out.println(response.getResponsemessage());
    }
}
