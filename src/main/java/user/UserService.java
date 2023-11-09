package user;

import com.cursoGrpc.grpc.User;
import com.cursoGrpc.grpc.userGrpc.userImplBase;
import io.grpc.stub.StreamObserver;
import com.cursoGrpc.grpc.User.*;

public class UserService extends userImplBase {

    @Override
    public void login(com.cursoGrpc.grpc.User.LoginRequest request, io.grpc.stub.StreamObserver<com.cursoGrpc.grpc.User.APIResponse> responseObserver) {

        System.out.println("Inside Loqin");
        String username = request.getUsername();
        String password = request.getPassword();

        APIResponse.Builder response = APIResponse.newBuilder();

        if(username.equals(password)){
            response.setResponseCode(0).setResponsemessage(password);
        }else{
            response.setResponseCode(100).setResponsemessage("INVALID");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
/*
    @Override
    public void logout(com.cursoGrpc.grpc.User.Empty request, io.grpc.stub.StreamObserver<com.cursoGrpc.grpc.User.APIResponse> responseObserver) {asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }*/

}
