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
    comments = "Source: Transaccion.proto")
public final class RegistroGrpc {

  private RegistroGrpc() {}

  public static final String SERVICE_NAME = "Registro";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Transaccion.TransaccionDTO,
      grpc.Transaccion.ServerResponse> getAddRegistroMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addRegistro",
      requestType = grpc.Transaccion.TransaccionDTO.class,
      responseType = grpc.Transaccion.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Transaccion.TransaccionDTO,
      grpc.Transaccion.ServerResponse> getAddRegistroMethod() {
    io.grpc.MethodDescriptor<grpc.Transaccion.TransaccionDTO, grpc.Transaccion.ServerResponse> getAddRegistroMethod;
    if ((getAddRegistroMethod = RegistroGrpc.getAddRegistroMethod) == null) {
      synchronized (RegistroGrpc.class) {
        if ((getAddRegistroMethod = RegistroGrpc.getAddRegistroMethod) == null) {
          RegistroGrpc.getAddRegistroMethod = getAddRegistroMethod = 
              io.grpc.MethodDescriptor.<grpc.Transaccion.TransaccionDTO, grpc.Transaccion.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Registro", "addRegistro"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Transaccion.TransaccionDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Transaccion.ServerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RegistroMethodDescriptorSupplier("addRegistro"))
                  .build();
          }
        }
     }
     return getAddRegistroMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Transaccion.GetAllComprasByUsuarioIdRequest,
      grpc.Transaccion.LisTransaccionDTO> getGetAllComprasByUsuarioIdRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllComprasByUsuarioIdRequest",
      requestType = grpc.Transaccion.GetAllComprasByUsuarioIdRequest.class,
      responseType = grpc.Transaccion.LisTransaccionDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Transaccion.GetAllComprasByUsuarioIdRequest,
      grpc.Transaccion.LisTransaccionDTO> getGetAllComprasByUsuarioIdRequestMethod() {
    io.grpc.MethodDescriptor<grpc.Transaccion.GetAllComprasByUsuarioIdRequest, grpc.Transaccion.LisTransaccionDTO> getGetAllComprasByUsuarioIdRequestMethod;
    if ((getGetAllComprasByUsuarioIdRequestMethod = RegistroGrpc.getGetAllComprasByUsuarioIdRequestMethod) == null) {
      synchronized (RegistroGrpc.class) {
        if ((getGetAllComprasByUsuarioIdRequestMethod = RegistroGrpc.getGetAllComprasByUsuarioIdRequestMethod) == null) {
          RegistroGrpc.getGetAllComprasByUsuarioIdRequestMethod = getGetAllComprasByUsuarioIdRequestMethod = 
              io.grpc.MethodDescriptor.<grpc.Transaccion.GetAllComprasByUsuarioIdRequest, grpc.Transaccion.LisTransaccionDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Registro", "getAllComprasByUsuarioIdRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Transaccion.GetAllComprasByUsuarioIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Transaccion.LisTransaccionDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new RegistroMethodDescriptorSupplier("getAllComprasByUsuarioIdRequest"))
                  .build();
          }
        }
     }
     return getGetAllComprasByUsuarioIdRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Transaccion.GetAllVentasByUsuarioIdRequest,
      grpc.Transaccion.LisTransaccionDTO> getGetAllVentasByUsuarioIdRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllVentasByUsuarioIdRequest",
      requestType = grpc.Transaccion.GetAllVentasByUsuarioIdRequest.class,
      responseType = grpc.Transaccion.LisTransaccionDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Transaccion.GetAllVentasByUsuarioIdRequest,
      grpc.Transaccion.LisTransaccionDTO> getGetAllVentasByUsuarioIdRequestMethod() {
    io.grpc.MethodDescriptor<grpc.Transaccion.GetAllVentasByUsuarioIdRequest, grpc.Transaccion.LisTransaccionDTO> getGetAllVentasByUsuarioIdRequestMethod;
    if ((getGetAllVentasByUsuarioIdRequestMethod = RegistroGrpc.getGetAllVentasByUsuarioIdRequestMethod) == null) {
      synchronized (RegistroGrpc.class) {
        if ((getGetAllVentasByUsuarioIdRequestMethod = RegistroGrpc.getGetAllVentasByUsuarioIdRequestMethod) == null) {
          RegistroGrpc.getGetAllVentasByUsuarioIdRequestMethod = getGetAllVentasByUsuarioIdRequestMethod = 
              io.grpc.MethodDescriptor.<grpc.Transaccion.GetAllVentasByUsuarioIdRequest, grpc.Transaccion.LisTransaccionDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Registro", "getAllVentasByUsuarioIdRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Transaccion.GetAllVentasByUsuarioIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Transaccion.LisTransaccionDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new RegistroMethodDescriptorSupplier("getAllVentasByUsuarioIdRequest"))
                  .build();
          }
        }
     }
     return getGetAllVentasByUsuarioIdRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegistroStub newStub(io.grpc.Channel channel) {
    return new RegistroStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegistroBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RegistroBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegistroFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RegistroFutureStub(channel);
  }

  /**
   * <pre>
   * METODOS PARA CONSUMIR 
   * </pre>
   */
  public static abstract class RegistroImplBase implements io.grpc.BindableService {

    /**
     */
    public void addRegistro(grpc.Transaccion.TransaccionDTO request,
        io.grpc.stub.StreamObserver<grpc.Transaccion.ServerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddRegistroMethod(), responseObserver);
    }

    /**
     */
    public void getAllComprasByUsuarioIdRequest(grpc.Transaccion.GetAllComprasByUsuarioIdRequest request,
        io.grpc.stub.StreamObserver<grpc.Transaccion.LisTransaccionDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllComprasByUsuarioIdRequestMethod(), responseObserver);
    }

    /**
     */
    public void getAllVentasByUsuarioIdRequest(grpc.Transaccion.GetAllVentasByUsuarioIdRequest request,
        io.grpc.stub.StreamObserver<grpc.Transaccion.LisTransaccionDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllVentasByUsuarioIdRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddRegistroMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Transaccion.TransaccionDTO,
                grpc.Transaccion.ServerResponse>(
                  this, METHODID_ADD_REGISTRO)))
          .addMethod(
            getGetAllComprasByUsuarioIdRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Transaccion.GetAllComprasByUsuarioIdRequest,
                grpc.Transaccion.LisTransaccionDTO>(
                  this, METHODID_GET_ALL_COMPRAS_BY_USUARIO_ID_REQUEST)))
          .addMethod(
            getGetAllVentasByUsuarioIdRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Transaccion.GetAllVentasByUsuarioIdRequest,
                grpc.Transaccion.LisTransaccionDTO>(
                  this, METHODID_GET_ALL_VENTAS_BY_USUARIO_ID_REQUEST)))
          .build();
    }
  }

  /**
   * <pre>
   * METODOS PARA CONSUMIR 
   * </pre>
   */
  public static final class RegistroStub extends io.grpc.stub.AbstractStub<RegistroStub> {
    private RegistroStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegistroStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistroStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegistroStub(channel, callOptions);
    }

    /**
     */
    public void addRegistro(grpc.Transaccion.TransaccionDTO request,
        io.grpc.stub.StreamObserver<grpc.Transaccion.ServerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddRegistroMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllComprasByUsuarioIdRequest(grpc.Transaccion.GetAllComprasByUsuarioIdRequest request,
        io.grpc.stub.StreamObserver<grpc.Transaccion.LisTransaccionDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllComprasByUsuarioIdRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllVentasByUsuarioIdRequest(grpc.Transaccion.GetAllVentasByUsuarioIdRequest request,
        io.grpc.stub.StreamObserver<grpc.Transaccion.LisTransaccionDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllVentasByUsuarioIdRequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * METODOS PARA CONSUMIR 
   * </pre>
   */
  public static final class RegistroBlockingStub extends io.grpc.stub.AbstractStub<RegistroBlockingStub> {
    private RegistroBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegistroBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistroBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegistroBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Transaccion.ServerResponse addRegistro(grpc.Transaccion.TransaccionDTO request) {
      return blockingUnaryCall(
          getChannel(), getAddRegistroMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Transaccion.LisTransaccionDTO getAllComprasByUsuarioIdRequest(grpc.Transaccion.GetAllComprasByUsuarioIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllComprasByUsuarioIdRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Transaccion.LisTransaccionDTO getAllVentasByUsuarioIdRequest(grpc.Transaccion.GetAllVentasByUsuarioIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllVentasByUsuarioIdRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * METODOS PARA CONSUMIR 
   * </pre>
   */
  public static final class RegistroFutureStub extends io.grpc.stub.AbstractStub<RegistroFutureStub> {
    private RegistroFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegistroFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistroFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegistroFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Transaccion.ServerResponse> addRegistro(
        grpc.Transaccion.TransaccionDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getAddRegistroMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Transaccion.LisTransaccionDTO> getAllComprasByUsuarioIdRequest(
        grpc.Transaccion.GetAllComprasByUsuarioIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllComprasByUsuarioIdRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Transaccion.LisTransaccionDTO> getAllVentasByUsuarioIdRequest(
        grpc.Transaccion.GetAllVentasByUsuarioIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllVentasByUsuarioIdRequestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_REGISTRO = 0;
  private static final int METHODID_GET_ALL_COMPRAS_BY_USUARIO_ID_REQUEST = 1;
  private static final int METHODID_GET_ALL_VENTAS_BY_USUARIO_ID_REQUEST = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegistroImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegistroImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_REGISTRO:
          serviceImpl.addRegistro((grpc.Transaccion.TransaccionDTO) request,
              (io.grpc.stub.StreamObserver<grpc.Transaccion.ServerResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_COMPRAS_BY_USUARIO_ID_REQUEST:
          serviceImpl.getAllComprasByUsuarioIdRequest((grpc.Transaccion.GetAllComprasByUsuarioIdRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Transaccion.LisTransaccionDTO>) responseObserver);
          break;
        case METHODID_GET_ALL_VENTAS_BY_USUARIO_ID_REQUEST:
          serviceImpl.getAllVentasByUsuarioIdRequest((grpc.Transaccion.GetAllVentasByUsuarioIdRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Transaccion.LisTransaccionDTO>) responseObserver);
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

  private static abstract class RegistroBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegistroBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Transaccion.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Registro");
    }
  }

  private static final class RegistroFileDescriptorSupplier
      extends RegistroBaseDescriptorSupplier {
    RegistroFileDescriptorSupplier() {}
  }

  private static final class RegistroMethodDescriptorSupplier
      extends RegistroBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegistroMethodDescriptorSupplier(String methodName) {
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
      synchronized (RegistroGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegistroFileDescriptorSupplier())
              .addMethod(getAddRegistroMethod())
              .addMethod(getGetAllComprasByUsuarioIdRequestMethod())
              .addMethod(getGetAllVentasByUsuarioIdRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
