package grpc;

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
 * <pre>
 * METODOS PARA CONSUMIR 
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Usuario.proto")
public final class UsuarioGrpc {

  private UsuarioGrpc() {}

  public static final String SERVICE_NAME = "Usuario";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.UsuarioOuterClass.UsuarioDTO,
      grpc.UsuarioOuterClass.ServerResponse> getAddUsuarioMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addUsuario",
      requestType = grpc.UsuarioOuterClass.UsuarioDTO.class,
      responseType = grpc.UsuarioOuterClass.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.UsuarioOuterClass.UsuarioDTO,
      grpc.UsuarioOuterClass.ServerResponse> getAddUsuarioMethod() {
    io.grpc.MethodDescriptor<grpc.UsuarioOuterClass.UsuarioDTO, grpc.UsuarioOuterClass.ServerResponse> getAddUsuarioMethod;
    if ((getAddUsuarioMethod = UsuarioGrpc.getAddUsuarioMethod) == null) {
      synchronized (UsuarioGrpc.class) {
        if ((getAddUsuarioMethod = UsuarioGrpc.getAddUsuarioMethod) == null) {
          UsuarioGrpc.getAddUsuarioMethod = getAddUsuarioMethod = 
              io.grpc.MethodDescriptor.<grpc.UsuarioOuterClass.UsuarioDTO, grpc.UsuarioOuterClass.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Usuario", "addUsuario"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.UsuarioOuterClass.UsuarioDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.UsuarioOuterClass.ServerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UsuarioMethodDescriptorSupplier("addUsuario"))
                  .build();
          }
        }
     }
     return getAddUsuarioMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.UsuarioOuterClass.GetByUsuarioYClaveRequest,
      grpc.UsuarioOuterClass.UsuarioObjDTO> getGetByUsuarioYClaveRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getByUsuarioYClaveRequest",
      requestType = grpc.UsuarioOuterClass.GetByUsuarioYClaveRequest.class,
      responseType = grpc.UsuarioOuterClass.UsuarioObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.UsuarioOuterClass.GetByUsuarioYClaveRequest,
      grpc.UsuarioOuterClass.UsuarioObjDTO> getGetByUsuarioYClaveRequestMethod() {
    io.grpc.MethodDescriptor<grpc.UsuarioOuterClass.GetByUsuarioYClaveRequest, grpc.UsuarioOuterClass.UsuarioObjDTO> getGetByUsuarioYClaveRequestMethod;
    if ((getGetByUsuarioYClaveRequestMethod = UsuarioGrpc.getGetByUsuarioYClaveRequestMethod) == null) {
      synchronized (UsuarioGrpc.class) {
        if ((getGetByUsuarioYClaveRequestMethod = UsuarioGrpc.getGetByUsuarioYClaveRequestMethod) == null) {
          UsuarioGrpc.getGetByUsuarioYClaveRequestMethod = getGetByUsuarioYClaveRequestMethod = 
              io.grpc.MethodDescriptor.<grpc.UsuarioOuterClass.GetByUsuarioYClaveRequest, grpc.UsuarioOuterClass.UsuarioObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Usuario", "getByUsuarioYClaveRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.UsuarioOuterClass.GetByUsuarioYClaveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.UsuarioOuterClass.UsuarioObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new UsuarioMethodDescriptorSupplier("getByUsuarioYClaveRequest"))
                  .build();
          }
        }
     }
     return getGetByUsuarioYClaveRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.UsuarioOuterClass.UpdateUsuarioCargaSaldoRequest,
      grpc.UsuarioOuterClass.UsuarioObjDTO> getUpdateUsuarioCargaSaldoRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateUsuarioCargaSaldoRequest",
      requestType = grpc.UsuarioOuterClass.UpdateUsuarioCargaSaldoRequest.class,
      responseType = grpc.UsuarioOuterClass.UsuarioObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.UsuarioOuterClass.UpdateUsuarioCargaSaldoRequest,
      grpc.UsuarioOuterClass.UsuarioObjDTO> getUpdateUsuarioCargaSaldoRequestMethod() {
    io.grpc.MethodDescriptor<grpc.UsuarioOuterClass.UpdateUsuarioCargaSaldoRequest, grpc.UsuarioOuterClass.UsuarioObjDTO> getUpdateUsuarioCargaSaldoRequestMethod;
    if ((getUpdateUsuarioCargaSaldoRequestMethod = UsuarioGrpc.getUpdateUsuarioCargaSaldoRequestMethod) == null) {
      synchronized (UsuarioGrpc.class) {
        if ((getUpdateUsuarioCargaSaldoRequestMethod = UsuarioGrpc.getUpdateUsuarioCargaSaldoRequestMethod) == null) {
          UsuarioGrpc.getUpdateUsuarioCargaSaldoRequestMethod = getUpdateUsuarioCargaSaldoRequestMethod = 
              io.grpc.MethodDescriptor.<grpc.UsuarioOuterClass.UpdateUsuarioCargaSaldoRequest, grpc.UsuarioOuterClass.UsuarioObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Usuario", "updateUsuarioCargaSaldoRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.UsuarioOuterClass.UpdateUsuarioCargaSaldoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.UsuarioOuterClass.UsuarioObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new UsuarioMethodDescriptorSupplier("updateUsuarioCargaSaldoRequest"))
                  .build();
          }
        }
     }
     return getUpdateUsuarioCargaSaldoRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.UsuarioOuterClass.UpdateUsuarioCompraProductoRequest,
      grpc.UsuarioOuterClass.UsuarioObjDTO> getUpdateUsuarioCompraProductoRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateUsuarioCompraProductoRequest",
      requestType = grpc.UsuarioOuterClass.UpdateUsuarioCompraProductoRequest.class,
      responseType = grpc.UsuarioOuterClass.UsuarioObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.UsuarioOuterClass.UpdateUsuarioCompraProductoRequest,
      grpc.UsuarioOuterClass.UsuarioObjDTO> getUpdateUsuarioCompraProductoRequestMethod() {
    io.grpc.MethodDescriptor<grpc.UsuarioOuterClass.UpdateUsuarioCompraProductoRequest, grpc.UsuarioOuterClass.UsuarioObjDTO> getUpdateUsuarioCompraProductoRequestMethod;
    if ((getUpdateUsuarioCompraProductoRequestMethod = UsuarioGrpc.getUpdateUsuarioCompraProductoRequestMethod) == null) {
      synchronized (UsuarioGrpc.class) {
        if ((getUpdateUsuarioCompraProductoRequestMethod = UsuarioGrpc.getUpdateUsuarioCompraProductoRequestMethod) == null) {
          UsuarioGrpc.getUpdateUsuarioCompraProductoRequestMethod = getUpdateUsuarioCompraProductoRequestMethod = 
              io.grpc.MethodDescriptor.<grpc.UsuarioOuterClass.UpdateUsuarioCompraProductoRequest, grpc.UsuarioOuterClass.UsuarioObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Usuario", "updateUsuarioCompraProductoRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.UsuarioOuterClass.UpdateUsuarioCompraProductoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.UsuarioOuterClass.UsuarioObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new UsuarioMethodDescriptorSupplier("updateUsuarioCompraProductoRequest"))
                  .build();
          }
        }
     }
     return getUpdateUsuarioCompraProductoRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UsuarioStub newStub(io.grpc.Channel channel) {
    return new UsuarioStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UsuarioBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UsuarioBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UsuarioFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UsuarioFutureStub(channel);
  }

  /**
   * <pre>
   * METODOS PARA CONSUMIR 
   * </pre>
   */
  public static abstract class UsuarioImplBase implements io.grpc.BindableService {

    /**
     */
    public void addUsuario(grpc.UsuarioOuterClass.UsuarioDTO request,
        io.grpc.stub.StreamObserver<grpc.UsuarioOuterClass.ServerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddUsuarioMethod(), responseObserver);
    }

    /**
     */
    public void getByUsuarioYClaveRequest(grpc.UsuarioOuterClass.GetByUsuarioYClaveRequest request,
        io.grpc.stub.StreamObserver<grpc.UsuarioOuterClass.UsuarioObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByUsuarioYClaveRequestMethod(), responseObserver);
    }

    /**
     */
    public void updateUsuarioCargaSaldoRequest(grpc.UsuarioOuterClass.UpdateUsuarioCargaSaldoRequest request,
        io.grpc.stub.StreamObserver<grpc.UsuarioOuterClass.UsuarioObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateUsuarioCargaSaldoRequestMethod(), responseObserver);
    }

    /**
     */
    public void updateUsuarioCompraProductoRequest(grpc.UsuarioOuterClass.UpdateUsuarioCompraProductoRequest request,
        io.grpc.stub.StreamObserver<grpc.UsuarioOuterClass.UsuarioObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateUsuarioCompraProductoRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddUsuarioMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.UsuarioOuterClass.UsuarioDTO,
                grpc.UsuarioOuterClass.ServerResponse>(
                  this, METHODID_ADD_USUARIO)))
          .addMethod(
            getGetByUsuarioYClaveRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.UsuarioOuterClass.GetByUsuarioYClaveRequest,
                grpc.UsuarioOuterClass.UsuarioObjDTO>(
                  this, METHODID_GET_BY_USUARIO_YCLAVE_REQUEST)))
          .addMethod(
            getUpdateUsuarioCargaSaldoRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.UsuarioOuterClass.UpdateUsuarioCargaSaldoRequest,
                grpc.UsuarioOuterClass.UsuarioObjDTO>(
                  this, METHODID_UPDATE_USUARIO_CARGA_SALDO_REQUEST)))
          .addMethod(
            getUpdateUsuarioCompraProductoRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.UsuarioOuterClass.UpdateUsuarioCompraProductoRequest,
                grpc.UsuarioOuterClass.UsuarioObjDTO>(
                  this, METHODID_UPDATE_USUARIO_COMPRA_PRODUCTO_REQUEST)))
          .build();
    }
  }

  /**
   * <pre>
   * METODOS PARA CONSUMIR 
   * </pre>
   */
  public static final class UsuarioStub extends io.grpc.stub.AbstractStub<UsuarioStub> {
    private UsuarioStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UsuarioStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsuarioStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UsuarioStub(channel, callOptions);
    }

    /**
     */
    public void addUsuario(grpc.UsuarioOuterClass.UsuarioDTO request,
        io.grpc.stub.StreamObserver<grpc.UsuarioOuterClass.ServerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddUsuarioMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getByUsuarioYClaveRequest(grpc.UsuarioOuterClass.GetByUsuarioYClaveRequest request,
        io.grpc.stub.StreamObserver<grpc.UsuarioOuterClass.UsuarioObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByUsuarioYClaveRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUsuarioCargaSaldoRequest(grpc.UsuarioOuterClass.UpdateUsuarioCargaSaldoRequest request,
        io.grpc.stub.StreamObserver<grpc.UsuarioOuterClass.UsuarioObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateUsuarioCargaSaldoRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUsuarioCompraProductoRequest(grpc.UsuarioOuterClass.UpdateUsuarioCompraProductoRequest request,
        io.grpc.stub.StreamObserver<grpc.UsuarioOuterClass.UsuarioObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateUsuarioCompraProductoRequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * METODOS PARA CONSUMIR 
   * </pre>
   */
  public static final class UsuarioBlockingStub extends io.grpc.stub.AbstractStub<UsuarioBlockingStub> {
    private UsuarioBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UsuarioBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsuarioBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UsuarioBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.UsuarioOuterClass.ServerResponse addUsuario(grpc.UsuarioOuterClass.UsuarioDTO request) {
      return blockingUnaryCall(
          getChannel(), getAddUsuarioMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.UsuarioOuterClass.UsuarioObjDTO getByUsuarioYClaveRequest(grpc.UsuarioOuterClass.GetByUsuarioYClaveRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetByUsuarioYClaveRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.UsuarioOuterClass.UsuarioObjDTO updateUsuarioCargaSaldoRequest(grpc.UsuarioOuterClass.UpdateUsuarioCargaSaldoRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateUsuarioCargaSaldoRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.UsuarioOuterClass.UsuarioObjDTO updateUsuarioCompraProductoRequest(grpc.UsuarioOuterClass.UpdateUsuarioCompraProductoRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateUsuarioCompraProductoRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * METODOS PARA CONSUMIR 
   * </pre>
   */
  public static final class UsuarioFutureStub extends io.grpc.stub.AbstractStub<UsuarioFutureStub> {
    private UsuarioFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UsuarioFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UsuarioFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UsuarioFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.UsuarioOuterClass.ServerResponse> addUsuario(
        grpc.UsuarioOuterClass.UsuarioDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getAddUsuarioMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.UsuarioOuterClass.UsuarioObjDTO> getByUsuarioYClaveRequest(
        grpc.UsuarioOuterClass.GetByUsuarioYClaveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByUsuarioYClaveRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.UsuarioOuterClass.UsuarioObjDTO> updateUsuarioCargaSaldoRequest(
        grpc.UsuarioOuterClass.UpdateUsuarioCargaSaldoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateUsuarioCargaSaldoRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.UsuarioOuterClass.UsuarioObjDTO> updateUsuarioCompraProductoRequest(
        grpc.UsuarioOuterClass.UpdateUsuarioCompraProductoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateUsuarioCompraProductoRequestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_USUARIO = 0;
  private static final int METHODID_GET_BY_USUARIO_YCLAVE_REQUEST = 1;
  private static final int METHODID_UPDATE_USUARIO_CARGA_SALDO_REQUEST = 2;
  private static final int METHODID_UPDATE_USUARIO_COMPRA_PRODUCTO_REQUEST = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UsuarioImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UsuarioImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_USUARIO:
          serviceImpl.addUsuario((grpc.UsuarioOuterClass.UsuarioDTO) request,
              (io.grpc.stub.StreamObserver<grpc.UsuarioOuterClass.ServerResponse>) responseObserver);
          break;
        case METHODID_GET_BY_USUARIO_YCLAVE_REQUEST:
          serviceImpl.getByUsuarioYClaveRequest((grpc.UsuarioOuterClass.GetByUsuarioYClaveRequest) request,
              (io.grpc.stub.StreamObserver<grpc.UsuarioOuterClass.UsuarioObjDTO>) responseObserver);
          break;
        case METHODID_UPDATE_USUARIO_CARGA_SALDO_REQUEST:
          serviceImpl.updateUsuarioCargaSaldoRequest((grpc.UsuarioOuterClass.UpdateUsuarioCargaSaldoRequest) request,
              (io.grpc.stub.StreamObserver<grpc.UsuarioOuterClass.UsuarioObjDTO>) responseObserver);
          break;
        case METHODID_UPDATE_USUARIO_COMPRA_PRODUCTO_REQUEST:
          serviceImpl.updateUsuarioCompraProductoRequest((grpc.UsuarioOuterClass.UpdateUsuarioCompraProductoRequest) request,
              (io.grpc.stub.StreamObserver<grpc.UsuarioOuterClass.UsuarioObjDTO>) responseObserver);
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

  private static abstract class UsuarioBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UsuarioBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.UsuarioOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Usuario");
    }
  }

  private static final class UsuarioFileDescriptorSupplier
      extends UsuarioBaseDescriptorSupplier {
    UsuarioFileDescriptorSupplier() {}
  }

  private static final class UsuarioMethodDescriptorSupplier
      extends UsuarioBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UsuarioMethodDescriptorSupplier(String methodName) {
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
      synchronized (UsuarioGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UsuarioFileDescriptorSupplier())
              .addMethod(getAddUsuarioMethod())
              .addMethod(getGetByUsuarioYClaveRequestMethod())
              .addMethod(getUpdateUsuarioCargaSaldoRequestMethod())
              .addMethod(getUpdateUsuarioCompraProductoRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
