package user;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: user.proto")
public final class UsuarioServiceGrpc {

  private UsuarioServiceGrpc() {}

  public static final String SERVICE_NAME = "user.UsuarioService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<user.User.Usuario,
      user.User.IdUsuario> getPostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Post",
      requestType = user.User.Usuario.class,
      responseType = user.User.IdUsuario.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<user.User.Usuario,
      user.User.IdUsuario> getPostMethod() {
    io.grpc.MethodDescriptor<user.User.Usuario, user.User.IdUsuario> getPostMethod;
    if ((getPostMethod = UsuarioServiceGrpc.getPostMethod) == null) {
      synchronized (UsuarioServiceGrpc.class) {
        if ((getPostMethod = UsuarioServiceGrpc.getPostMethod) == null) {
          UsuarioServiceGrpc.getPostMethod = getPostMethod = 
              io.grpc.MethodDescriptor.<user.User.Usuario, user.User.IdUsuario>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UsuarioService", "Post"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  user.User.Usuario.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  user.User.IdUsuario.getDefaultInstance()))
                  .setSchemaDescriptor(new UsuarioServiceMethodDescriptorSupplier("Post"))
                  .build();
          }
        }
     }
     return getPostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<user.User.UsuarioLogin,
      user.User.Usuario> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Login",
      requestType = user.User.UsuarioLogin.class,
      responseType = user.User.Usuario.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<user.User.UsuarioLogin,
      user.User.Usuario> getLoginMethod() {
    io.grpc.MethodDescriptor<user.User.UsuarioLogin, user.User.Usuario> getLoginMethod;
    if ((getLoginMethod = UsuarioServiceGrpc.getLoginMethod) == null) {
      synchronized (UsuarioServiceGrpc.class) {
        if ((getLoginMethod = UsuarioServiceGrpc.getLoginMethod) == null) {
          UsuarioServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<user.User.UsuarioLogin, user.User.Usuario>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "user.UsuarioService", "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  user.User.UsuarioLogin.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  user.User.Usuario.getDefaultInstance()))
                  .setSchemaDescriptor(new UsuarioServiceMethodDescriptorSupplier("Login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UsuarioServiceStub newStub(io.grpc.Channel channel) {
    return new UsuarioServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UsuarioServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UsuarioServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UsuarioServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UsuarioServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UsuarioServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void post(user.User.Usuario request,
        io.grpc.stub.StreamObserver<user.User.IdUsuario> responseObserver) {
      asyncUnimplementedUnaryCall(getPostMethod(), responseObserver);
    }

    /**
     */
    public void login(user.User.UsuarioLogin request,
        io.grpc.stub.StreamObserver<user.User.Usuario> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPostMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                user.User.Usuario,
                user.User.IdUsuario>(
                  this, METHODID_POST)))
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                user.User.UsuarioLogin,
                user.User.Usuario>(
                  this, METHODID_LOGIN)))
          .build();
    }
  }

  /**
   */
  public static final class UsuarioServiceStub extends io.grpc.stub.AbstractStub<UsuarioServiceStub> {
    private UsuarioServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UsuarioServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsuarioServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UsuarioServiceStub(channel, callOptions);
    }

    /**
     */
    public void post(user.User.Usuario request,
        io.grpc.stub.StreamObserver<user.User.IdUsuario> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(user.User.UsuarioLogin request,
        io.grpc.stub.StreamObserver<user.User.Usuario> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UsuarioServiceBlockingStub extends io.grpc.stub.AbstractStub<UsuarioServiceBlockingStub> {
    private UsuarioServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UsuarioServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsuarioServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UsuarioServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public user.User.IdUsuario post(user.User.Usuario request) {
      return blockingUnaryCall(
          getChannel(), getPostMethod(), getCallOptions(), request);
    }

    /**
     */
    public user.User.Usuario login(user.User.UsuarioLogin request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UsuarioServiceFutureStub extends io.grpc.stub.AbstractStub<UsuarioServiceFutureStub> {
    private UsuarioServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UsuarioServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsuarioServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UsuarioServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<user.User.IdUsuario> post(
        user.User.Usuario request) {
      return futureUnaryCall(
          getChannel().newCall(getPostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<user.User.Usuario> login(
        user.User.UsuarioLogin request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_POST = 0;
  private static final int METHODID_LOGIN = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UsuarioServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UsuarioServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_POST:
          serviceImpl.post((user.User.Usuario) request,
              (io.grpc.stub.StreamObserver<user.User.IdUsuario>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((user.User.UsuarioLogin) request,
              (io.grpc.stub.StreamObserver<user.User.Usuario>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UsuarioServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UsuarioServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return user.User.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UsuarioService");
    }
  }

  private static final class UsuarioServiceFileDescriptorSupplier
      extends UsuarioServiceBaseDescriptorSupplier {
    UsuarioServiceFileDescriptorSupplier() {}
  }

  private static final class UsuarioServiceMethodDescriptorSupplier
      extends UsuarioServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UsuarioServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UsuarioServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UsuarioServiceFileDescriptorSupplier())
              .addMethod(getPostMethod())
              .addMethod(getLoginMethod())
              .build();
        }
      }
    }
    return result;
  }
}
