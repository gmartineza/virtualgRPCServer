package user;

import com.cursoGrpc.grpc.User;
import com.cursoGrpc.grpc.userGrpc.userImplBase;
import io.grpc.stub.StreamObserver;
import com.cursoGrpc.grpc.User.*;
import logic.BuscadorDeUsuarios;
import logic.CreacionDeUsuarios;
import logic.ListaUsuarios;

public class UserService extends userImplBase {

    @Override
    public void login(com.cursoGrpc.grpc.User.LoginRequest request, io.grpc.stub.StreamObserver<com.cursoGrpc.grpc.User.APIResponse> responseObserver) {

        CreacionDeUsuarios users = new CreacionDeUsuarios();
        ListaUsuarios lista = users.getListaUsuarios();
        BuscadorDeUsuarios buscador = new BuscadorDeUsuarios(lista);

        System.out.println("Inside Loqin");
        String username = request.getUsername();
        String password = request.getPassword();

        APIResponse.Builder response = APIResponse.newBuilder();

        if(buscador.existe(username, password)){
            response.setResponseCode(3).setResponsemessage("SUCCESS");
        }else{
            response.setResponseCode(0).setResponsemessage("INVALID");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

/*
    @Override
    public void logout(com.cursoGrpc.grpc.User.Empty request, io.grpc.stub.StreamObserver<com.cursoGrpc.grpc.User.APIResponse> responseObserver) {asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }*/

}
