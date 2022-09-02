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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: billetera.proto")
public final class BilleteraServiceGrpc {

  private BilleteraServiceGrpc() {}

  public static final String SERVICE_NAME = "BilleteraService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Billetera.PagoProductoDTO,
      grpc.Billetera.ResUsuarioDTO> getPagoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Pago",
      requestType = grpc.Billetera.PagoProductoDTO.class,
      responseType = grpc.Billetera.ResUsuarioDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Billetera.PagoProductoDTO,
      grpc.Billetera.ResUsuarioDTO> getPagoMethod() {
    io.grpc.MethodDescriptor<grpc.Billetera.PagoProductoDTO, grpc.Billetera.ResUsuarioDTO> getPagoMethod;
    if ((getPagoMethod = BilleteraServiceGrpc.getPagoMethod) == null) {
      synchronized (BilleteraServiceGrpc.class) {
        if ((getPagoMethod = BilleteraServiceGrpc.getPagoMethod) == null) {
          BilleteraServiceGrpc.getPagoMethod = getPagoMethod = 
              io.grpc.MethodDescriptor.<grpc.Billetera.PagoProductoDTO, grpc.Billetera.ResUsuarioDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BilleteraService", "Pago"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Billetera.PagoProductoDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Billetera.ResUsuarioDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new BilleteraServiceMethodDescriptorSupplier("Pago"))
                  .build();
          }
        }
     }
     return getPagoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Billetera.CargaSaldoDTO,
      grpc.Billetera.ResUsuarioDTO> getCargarSaldoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CargarSaldo",
      requestType = grpc.Billetera.CargaSaldoDTO.class,
      responseType = grpc.Billetera.ResUsuarioDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Billetera.CargaSaldoDTO,
      grpc.Billetera.ResUsuarioDTO> getCargarSaldoMethod() {
    io.grpc.MethodDescriptor<grpc.Billetera.CargaSaldoDTO, grpc.Billetera.ResUsuarioDTO> getCargarSaldoMethod;
    if ((getCargarSaldoMethod = BilleteraServiceGrpc.getCargarSaldoMethod) == null) {
      synchronized (BilleteraServiceGrpc.class) {
        if ((getCargarSaldoMethod = BilleteraServiceGrpc.getCargarSaldoMethod) == null) {
          BilleteraServiceGrpc.getCargarSaldoMethod = getCargarSaldoMethod = 
              io.grpc.MethodDescriptor.<grpc.Billetera.CargaSaldoDTO, grpc.Billetera.ResUsuarioDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "BilleteraService", "CargarSaldo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Billetera.CargaSaldoDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Billetera.ResUsuarioDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new BilleteraServiceMethodDescriptorSupplier("CargarSaldo"))
                  .build();
          }
        }
     }
     return getCargarSaldoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BilleteraServiceStub newStub(io.grpc.Channel channel) {
    return new BilleteraServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BilleteraServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BilleteraServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BilleteraServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BilleteraServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BilleteraServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void pago(grpc.Billetera.PagoProductoDTO request,
        io.grpc.stub.StreamObserver<grpc.Billetera.ResUsuarioDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getPagoMethod(), responseObserver);
    }

    /**
     */
    public void cargarSaldo(grpc.Billetera.CargaSaldoDTO request,
        io.grpc.stub.StreamObserver<grpc.Billetera.ResUsuarioDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getCargarSaldoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPagoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Billetera.PagoProductoDTO,
                grpc.Billetera.ResUsuarioDTO>(
                  this, METHODID_PAGO)))
          .addMethod(
            getCargarSaldoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Billetera.CargaSaldoDTO,
                grpc.Billetera.ResUsuarioDTO>(
                  this, METHODID_CARGAR_SALDO)))
          .build();
    }
  }

  /**
   */
  public static final class BilleteraServiceStub extends io.grpc.stub.AbstractStub<BilleteraServiceStub> {
    private BilleteraServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BilleteraServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BilleteraServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BilleteraServiceStub(channel, callOptions);
    }

    /**
     */
    public void pago(grpc.Billetera.PagoProductoDTO request,
        io.grpc.stub.StreamObserver<grpc.Billetera.ResUsuarioDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPagoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cargarSaldo(grpc.Billetera.CargaSaldoDTO request,
        io.grpc.stub.StreamObserver<grpc.Billetera.ResUsuarioDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCargarSaldoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BilleteraServiceBlockingStub extends io.grpc.stub.AbstractStub<BilleteraServiceBlockingStub> {
    private BilleteraServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BilleteraServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BilleteraServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BilleteraServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Billetera.ResUsuarioDTO pago(grpc.Billetera.PagoProductoDTO request) {
      return blockingUnaryCall(
          getChannel(), getPagoMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Billetera.ResUsuarioDTO cargarSaldo(grpc.Billetera.CargaSaldoDTO request) {
      return blockingUnaryCall(
          getChannel(), getCargarSaldoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BilleteraServiceFutureStub extends io.grpc.stub.AbstractStub<BilleteraServiceFutureStub> {
    private BilleteraServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BilleteraServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BilleteraServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BilleteraServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Billetera.ResUsuarioDTO> pago(
        grpc.Billetera.PagoProductoDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getPagoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Billetera.ResUsuarioDTO> cargarSaldo(
        grpc.Billetera.CargaSaldoDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getCargarSaldoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PAGO = 0;
  private static final int METHODID_CARGAR_SALDO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BilleteraServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BilleteraServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PAGO:
          serviceImpl.pago((grpc.Billetera.PagoProductoDTO) request,
              (io.grpc.stub.StreamObserver<grpc.Billetera.ResUsuarioDTO>) responseObserver);
          break;
        case METHODID_CARGAR_SALDO:
          serviceImpl.cargarSaldo((grpc.Billetera.CargaSaldoDTO) request,
              (io.grpc.stub.StreamObserver<grpc.Billetera.ResUsuarioDTO>) responseObserver);
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

  private static abstract class BilleteraServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BilleteraServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Billetera.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BilleteraService");
    }
  }

  private static final class BilleteraServiceFileDescriptorSupplier
      extends BilleteraServiceBaseDescriptorSupplier {
    BilleteraServiceFileDescriptorSupplier() {}
  }

  private static final class BilleteraServiceMethodDescriptorSupplier
      extends BilleteraServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BilleteraServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BilleteraServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BilleteraServiceFileDescriptorSupplier())
              .addMethod(getPagoMethod())
              .addMethod(getCargarSaldoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
