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
public final class TransaccionServiceGrpc {

  private TransaccionServiceGrpc() {}

  public static final String SERVICE_NAME = "TransaccionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Transaccion.TransaccionDTO,
      grpc.Transaccion.ResTransaccionDTO> getAddTransaccionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addTransaccion",
      requestType = grpc.Transaccion.TransaccionDTO.class,
      responseType = grpc.Transaccion.ResTransaccionDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Transaccion.TransaccionDTO,
      grpc.Transaccion.ResTransaccionDTO> getAddTransaccionMethod() {
    io.grpc.MethodDescriptor<grpc.Transaccion.TransaccionDTO, grpc.Transaccion.ResTransaccionDTO> getAddTransaccionMethod;
    if ((getAddTransaccionMethod = TransaccionServiceGrpc.getAddTransaccionMethod) == null) {
      synchronized (TransaccionServiceGrpc.class) {
        if ((getAddTransaccionMethod = TransaccionServiceGrpc.getAddTransaccionMethod) == null) {
          TransaccionServiceGrpc.getAddTransaccionMethod = getAddTransaccionMethod = 
              io.grpc.MethodDescriptor.<grpc.Transaccion.TransaccionDTO, grpc.Transaccion.ResTransaccionDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TransaccionService", "addTransaccion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Transaccion.TransaccionDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Transaccion.ResTransaccionDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new TransaccionServiceMethodDescriptorSupplier("addTransaccion"))
                  .build();
          }
        }
     }
     return getAddTransaccionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Transaccion.GetTransaccionesRequest,
      grpc.Transaccion.LisTransaccionDTO> getGetAllComprasByUsuarioIdRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllComprasByUsuarioIdRequest",
      requestType = grpc.Transaccion.GetTransaccionesRequest.class,
      responseType = grpc.Transaccion.LisTransaccionDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Transaccion.GetTransaccionesRequest,
      grpc.Transaccion.LisTransaccionDTO> getGetAllComprasByUsuarioIdRequestMethod() {
    io.grpc.MethodDescriptor<grpc.Transaccion.GetTransaccionesRequest, grpc.Transaccion.LisTransaccionDTO> getGetAllComprasByUsuarioIdRequestMethod;
    if ((getGetAllComprasByUsuarioIdRequestMethod = TransaccionServiceGrpc.getGetAllComprasByUsuarioIdRequestMethod) == null) {
      synchronized (TransaccionServiceGrpc.class) {
        if ((getGetAllComprasByUsuarioIdRequestMethod = TransaccionServiceGrpc.getGetAllComprasByUsuarioIdRequestMethod) == null) {
          TransaccionServiceGrpc.getGetAllComprasByUsuarioIdRequestMethod = getGetAllComprasByUsuarioIdRequestMethod = 
              io.grpc.MethodDescriptor.<grpc.Transaccion.GetTransaccionesRequest, grpc.Transaccion.LisTransaccionDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TransaccionService", "getAllComprasByUsuarioIdRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Transaccion.GetTransaccionesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Transaccion.LisTransaccionDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new TransaccionServiceMethodDescriptorSupplier("getAllComprasByUsuarioIdRequest"))
                  .build();
          }
        }
     }
     return getGetAllComprasByUsuarioIdRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Transaccion.GetTransaccionesRequest,
      grpc.Transaccion.LisTransaccionDTO> getGetAllVentasByUsuarioIdRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllVentasByUsuarioIdRequest",
      requestType = grpc.Transaccion.GetTransaccionesRequest.class,
      responseType = grpc.Transaccion.LisTransaccionDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Transaccion.GetTransaccionesRequest,
      grpc.Transaccion.LisTransaccionDTO> getGetAllVentasByUsuarioIdRequestMethod() {
    io.grpc.MethodDescriptor<grpc.Transaccion.GetTransaccionesRequest, grpc.Transaccion.LisTransaccionDTO> getGetAllVentasByUsuarioIdRequestMethod;
    if ((getGetAllVentasByUsuarioIdRequestMethod = TransaccionServiceGrpc.getGetAllVentasByUsuarioIdRequestMethod) == null) {
      synchronized (TransaccionServiceGrpc.class) {
        if ((getGetAllVentasByUsuarioIdRequestMethod = TransaccionServiceGrpc.getGetAllVentasByUsuarioIdRequestMethod) == null) {
          TransaccionServiceGrpc.getGetAllVentasByUsuarioIdRequestMethod = getGetAllVentasByUsuarioIdRequestMethod = 
              io.grpc.MethodDescriptor.<grpc.Transaccion.GetTransaccionesRequest, grpc.Transaccion.LisTransaccionDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TransaccionService", "getAllVentasByUsuarioIdRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Transaccion.GetTransaccionesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Transaccion.LisTransaccionDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new TransaccionServiceMethodDescriptorSupplier("getAllVentasByUsuarioIdRequest"))
                  .build();
          }
        }
     }
     return getGetAllVentasByUsuarioIdRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TransaccionServiceStub newStub(io.grpc.Channel channel) {
    return new TransaccionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransaccionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TransaccionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TransaccionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TransaccionServiceFutureStub(channel);
  }

  /**
   * <pre>
   * METODOS PARA CONSUMIR 
   * </pre>
   */
  public static abstract class TransaccionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addTransaccion(grpc.Transaccion.TransaccionDTO request,
        io.grpc.stub.StreamObserver<grpc.Transaccion.ResTransaccionDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getAddTransaccionMethod(), responseObserver);
    }

    /**
     */
    public void getAllComprasByUsuarioIdRequest(grpc.Transaccion.GetTransaccionesRequest request,
        io.grpc.stub.StreamObserver<grpc.Transaccion.LisTransaccionDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllComprasByUsuarioIdRequestMethod(), responseObserver);
    }

    /**
     */
    public void getAllVentasByUsuarioIdRequest(grpc.Transaccion.GetTransaccionesRequest request,
        io.grpc.stub.StreamObserver<grpc.Transaccion.LisTransaccionDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllVentasByUsuarioIdRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddTransaccionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Transaccion.TransaccionDTO,
                grpc.Transaccion.ResTransaccionDTO>(
                  this, METHODID_ADD_TRANSACCION)))
          .addMethod(
            getGetAllComprasByUsuarioIdRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Transaccion.GetTransaccionesRequest,
                grpc.Transaccion.LisTransaccionDTO>(
                  this, METHODID_GET_ALL_COMPRAS_BY_USUARIO_ID_REQUEST)))
          .addMethod(
            getGetAllVentasByUsuarioIdRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Transaccion.GetTransaccionesRequest,
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
  public static final class TransaccionServiceStub extends io.grpc.stub.AbstractStub<TransaccionServiceStub> {
    private TransaccionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransaccionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransaccionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransaccionServiceStub(channel, callOptions);
    }

    /**
     */
    public void addTransaccion(grpc.Transaccion.TransaccionDTO request,
        io.grpc.stub.StreamObserver<grpc.Transaccion.ResTransaccionDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddTransaccionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllComprasByUsuarioIdRequest(grpc.Transaccion.GetTransaccionesRequest request,
        io.grpc.stub.StreamObserver<grpc.Transaccion.LisTransaccionDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllComprasByUsuarioIdRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllVentasByUsuarioIdRequest(grpc.Transaccion.GetTransaccionesRequest request,
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
  public static final class TransaccionServiceBlockingStub extends io.grpc.stub.AbstractStub<TransaccionServiceBlockingStub> {
    private TransaccionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransaccionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransaccionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransaccionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Transaccion.ResTransaccionDTO addTransaccion(grpc.Transaccion.TransaccionDTO request) {
      return blockingUnaryCall(
          getChannel(), getAddTransaccionMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Transaccion.LisTransaccionDTO getAllComprasByUsuarioIdRequest(grpc.Transaccion.GetTransaccionesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllComprasByUsuarioIdRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Transaccion.LisTransaccionDTO getAllVentasByUsuarioIdRequest(grpc.Transaccion.GetTransaccionesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllVentasByUsuarioIdRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * METODOS PARA CONSUMIR 
   * </pre>
   */
  public static final class TransaccionServiceFutureStub extends io.grpc.stub.AbstractStub<TransaccionServiceFutureStub> {
    private TransaccionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransaccionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransaccionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransaccionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Transaccion.ResTransaccionDTO> addTransaccion(
        grpc.Transaccion.TransaccionDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getAddTransaccionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Transaccion.LisTransaccionDTO> getAllComprasByUsuarioIdRequest(
        grpc.Transaccion.GetTransaccionesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllComprasByUsuarioIdRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Transaccion.LisTransaccionDTO> getAllVentasByUsuarioIdRequest(
        grpc.Transaccion.GetTransaccionesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllVentasByUsuarioIdRequestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_TRANSACCION = 0;
  private static final int METHODID_GET_ALL_COMPRAS_BY_USUARIO_ID_REQUEST = 1;
  private static final int METHODID_GET_ALL_VENTAS_BY_USUARIO_ID_REQUEST = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TransaccionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TransaccionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_TRANSACCION:
          serviceImpl.addTransaccion((grpc.Transaccion.TransaccionDTO) request,
              (io.grpc.stub.StreamObserver<grpc.Transaccion.ResTransaccionDTO>) responseObserver);
          break;
        case METHODID_GET_ALL_COMPRAS_BY_USUARIO_ID_REQUEST:
          serviceImpl.getAllComprasByUsuarioIdRequest((grpc.Transaccion.GetTransaccionesRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Transaccion.LisTransaccionDTO>) responseObserver);
          break;
        case METHODID_GET_ALL_VENTAS_BY_USUARIO_ID_REQUEST:
          serviceImpl.getAllVentasByUsuarioIdRequest((grpc.Transaccion.GetTransaccionesRequest) request,
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

  private static abstract class TransaccionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TransaccionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Transaccion.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TransaccionService");
    }
  }

  private static final class TransaccionServiceFileDescriptorSupplier
      extends TransaccionServiceBaseDescriptorSupplier {
    TransaccionServiceFileDescriptorSupplier() {}
  }

  private static final class TransaccionServiceMethodDescriptorSupplier
      extends TransaccionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TransaccionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TransaccionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TransaccionServiceFileDescriptorSupplier())
              .addMethod(getAddTransaccionMethod())
              .addMethod(getGetAllComprasByUsuarioIdRequestMethod())
              .addMethod(getGetAllVentasByUsuarioIdRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
