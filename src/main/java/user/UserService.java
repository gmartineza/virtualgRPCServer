package user;

import com.cursoGrpc.grpc.User.APIResponse;
import com.cursoGrpc.grpc.userGrpc.userImplBase;
import logic.BuscadorDeUsuarios;
import logic.CreacionDeUsuarios;
import logic.ListaUsuarios;

public class UserService extends userImplBase {

    @Override
    public void login(com.cursoGrpc.grpc.User.LoginRequest request, io.grpc.stub.StreamObserver<com.cursoGrpc.grpc.User.APIResponse> responseObserver) {

        CreacionDeUsuarios users = new CreacionDeUsuarios();
        ListaUsuarios lista = users.getListaUsuarios();
        BuscadorDeUsuarios buscador = new BuscadorDeUsuarios(lista);

        System.out.println("Inside Loqin - Usuario: ");
        String username = request.getUsername();
        String password = request.getPassword();

        System.out.println(username);

        APIResponse.Builder response = APIResponse.newBuilder();

        int responseCode = buscador.existe(username, password); //Busca el usuario y la contraseña
        response.setResponseCode(responseCode).setResponsemessage(buscador.getResponseMessage()); //Devuelve con el codigo y mensaje


        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

/*
    @Override
    public void logout(com.cursoGrpc.grpc.User.Empty request, io.grpc.stub.StreamObserver<com.cursoGrpc.grpc.User.APIResponse> responseObserver) {asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }*/

}
