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
    comments = "Source: product.proto")
public final class ProductoServiceGrpc {

  private ProductoServiceGrpc() {}

  public static final String SERVICE_NAME = "ProductoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Product.ProductoDTO,
      grpc.Product.ResProductoDTO> getAddProductoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addProducto",
      requestType = grpc.Product.ProductoDTO.class,
      responseType = grpc.Product.ResProductoDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Product.ProductoDTO,
      grpc.Product.ResProductoDTO> getAddProductoMethod() {
    io.grpc.MethodDescriptor<grpc.Product.ProductoDTO, grpc.Product.ResProductoDTO> getAddProductoMethod;
    if ((getAddProductoMethod = ProductoServiceGrpc.getAddProductoMethod) == null) {
      synchronized (ProductoServiceGrpc.class) {
        if ((getAddProductoMethod = ProductoServiceGrpc.getAddProductoMethod) == null) {
          ProductoServiceGrpc.getAddProductoMethod = getAddProductoMethod = 
              io.grpc.MethodDescriptor.<grpc.Product.ProductoDTO, grpc.Product.ResProductoDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ProductoService", "addProducto"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Product.ProductoDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Product.ResProductoDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new ProductoServiceMethodDescriptorSupplier("addProducto"))
                  .build();
          }
        }
     }
     return getAddProductoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Product.ProductoFilterDTO,
      grpc.Product.ProductosDTO> getGetByFilterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getByFilter",
      requestType = grpc.Product.ProductoFilterDTO.class,
      responseType = grpc.Product.ProductosDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Product.ProductoFilterDTO,
      grpc.Product.ProductosDTO> getGetByFilterMethod() {
    io.grpc.MethodDescriptor<grpc.Product.ProductoFilterDTO, grpc.Product.ProductosDTO> getGetByFilterMethod;
    if ((getGetByFilterMethod = ProductoServiceGrpc.getGetByFilterMethod) == null) {
      synchronized (ProductoServiceGrpc.class) {
        if ((getGetByFilterMethod = ProductoServiceGrpc.getGetByFilterMethod) == null) {
          ProductoServiceGrpc.getGetByFilterMethod = getGetByFilterMethod = 
              io.grpc.MethodDescriptor.<grpc.Product.ProductoFilterDTO, grpc.Product.ProductosDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ProductoService", "getByFilter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Product.ProductoFilterDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Product.ProductosDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new ProductoServiceMethodDescriptorSupplier("getByFilter"))
                  .build();
          }
        }
     }
     return getGetByFilterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Product.Empty,
      grpc.Product.ProductosDTO> getGetAllProductosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllProductos",
      requestType = grpc.Product.Empty.class,
      responseType = grpc.Product.ProductosDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Product.Empty,
      grpc.Product.ProductosDTO> getGetAllProductosMethod() {
    io.grpc.MethodDescriptor<grpc.Product.Empty, grpc.Product.ProductosDTO> getGetAllProductosMethod;
    if ((getGetAllProductosMethod = ProductoServiceGrpc.getGetAllProductosMethod) == null) {
      synchronized (ProductoServiceGrpc.class) {
        if ((getGetAllProductosMethod = ProductoServiceGrpc.getGetAllProductosMethod) == null) {
          ProductoServiceGrpc.getGetAllProductosMethod = getGetAllProductosMethod = 
              io.grpc.MethodDescriptor.<grpc.Product.Empty, grpc.Product.ProductosDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ProductoService", "getAllProductos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Product.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Product.ProductosDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new ProductoServiceMethodDescriptorSupplier("getAllProductos"))
                  .build();
          }
        }
     }
     return getGetAllProductosMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Product.Empty,
      grpc.Product.CategoriasDTO> getGetAllCategoriasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllCategorias",
      requestType = grpc.Product.Empty.class,
      responseType = grpc.Product.CategoriasDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Product.Empty,
      grpc.Product.CategoriasDTO> getGetAllCategoriasMethod() {
    io.grpc.MethodDescriptor<grpc.Product.Empty, grpc.Product.CategoriasDTO> getGetAllCategoriasMethod;
    if ((getGetAllCategoriasMethod = ProductoServiceGrpc.getGetAllCategoriasMethod) == null) {
      synchronized (ProductoServiceGrpc.class) {
        if ((getGetAllCategoriasMethod = ProductoServiceGrpc.getGetAllCategoriasMethod) == null) {
          ProductoServiceGrpc.getGetAllCategoriasMethod = getGetAllCategoriasMethod = 
              io.grpc.MethodDescriptor.<grpc.Product.Empty, grpc.Product.CategoriasDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ProductoService", "getAllCategorias"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Product.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Product.CategoriasDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new ProductoServiceMethodDescriptorSupplier("getAllCategorias"))
                  .build();
          }
        }
     }
     return getGetAllCategoriasMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductoServiceStub newStub(io.grpc.Channel channel) {
    return new ProductoServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProductoServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProductoServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ProductoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addProducto(grpc.Product.ProductoDTO request,
        io.grpc.stub.StreamObserver<grpc.Product.ResProductoDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getAddProductoMethod(), responseObserver);
    }

    /**
     */
    public void getByFilter(grpc.Product.ProductoFilterDTO request,
        io.grpc.stub.StreamObserver<grpc.Product.ProductosDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByFilterMethod(), responseObserver);
    }

    /**
     */
    public void getAllProductos(grpc.Product.Empty request,
        io.grpc.stub.StreamObserver<grpc.Product.ProductosDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllProductosMethod(), responseObserver);
    }

    /**
     */
    public void getAllCategorias(grpc.Product.Empty request,
        io.grpc.stub.StreamObserver<grpc.Product.CategoriasDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllCategoriasMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddProductoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Product.ProductoDTO,
                grpc.Product.ResProductoDTO>(
                  this, METHODID_ADD_PRODUCTO)))
          .addMethod(
            getGetByFilterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Product.ProductoFilterDTO,
                grpc.Product.ProductosDTO>(
                  this, METHODID_GET_BY_FILTER)))
          .addMethod(
            getGetAllProductosMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Product.Empty,
                grpc.Product.ProductosDTO>(
                  this, METHODID_GET_ALL_PRODUCTOS)))
          .addMethod(
            getGetAllCategoriasMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Product.Empty,
                grpc.Product.CategoriasDTO>(
                  this, METHODID_GET_ALL_CATEGORIAS)))
          .build();
    }
  }

  /**
   */
  public static final class ProductoServiceStub extends io.grpc.stub.AbstractStub<ProductoServiceStub> {
    private ProductoServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductoServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductoServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductoServiceStub(channel, callOptions);
    }

    /**
     */
    public void addProducto(grpc.Product.ProductoDTO request,
        io.grpc.stub.StreamObserver<grpc.Product.ResProductoDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddProductoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getByFilter(grpc.Product.ProductoFilterDTO request,
        io.grpc.stub.StreamObserver<grpc.Product.ProductosDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByFilterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllProductos(grpc.Product.Empty request,
        io.grpc.stub.StreamObserver<grpc.Product.ProductosDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllProductosMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCategorias(grpc.Product.Empty request,
        io.grpc.stub.StreamObserver<grpc.Product.CategoriasDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllCategoriasMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProductoServiceBlockingStub extends io.grpc.stub.AbstractStub<ProductoServiceBlockingStub> {
    private ProductoServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductoServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductoServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Product.ResProductoDTO addProducto(grpc.Product.ProductoDTO request) {
      return blockingUnaryCall(
          getChannel(), getAddProductoMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Product.ProductosDTO getByFilter(grpc.Product.ProductoFilterDTO request) {
      return blockingUnaryCall(
          getChannel(), getGetByFilterMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Product.ProductosDTO getAllProductos(grpc.Product.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllProductosMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Product.CategoriasDTO getAllCategorias(grpc.Product.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllCategoriasMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProductoServiceFutureStub extends io.grpc.stub.AbstractStub<ProductoServiceFutureStub> {
    private ProductoServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductoServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductoServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Product.ResProductoDTO> addProducto(
        grpc.Product.ProductoDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getAddProductoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Product.ProductosDTO> getByFilter(
        grpc.Product.ProductoFilterDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByFilterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Product.ProductosDTO> getAllProductos(
        grpc.Product.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllProductosMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Product.CategoriasDTO> getAllCategorias(
        grpc.Product.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllCategoriasMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_PRODUCTO = 0;
  private static final int METHODID_GET_BY_FILTER = 1;
  private static final int METHODID_GET_ALL_PRODUCTOS = 2;
  private static final int METHODID_GET_ALL_CATEGORIAS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_PRODUCTO:
          serviceImpl.addProducto((grpc.Product.ProductoDTO) request,
              (io.grpc.stub.StreamObserver<grpc.Product.ResProductoDTO>) responseObserver);
          break;
        case METHODID_GET_BY_FILTER:
          serviceImpl.getByFilter((grpc.Product.ProductoFilterDTO) request,
              (io.grpc.stub.StreamObserver<grpc.Product.ProductosDTO>) responseObserver);
          break;
        case METHODID_GET_ALL_PRODUCTOS:
          serviceImpl.getAllProductos((grpc.Product.Empty) request,
              (io.grpc.stub.StreamObserver<grpc.Product.ProductosDTO>) responseObserver);
          break;
        case METHODID_GET_ALL_CATEGORIAS:
          serviceImpl.getAllCategorias((grpc.Product.Empty) request,
              (io.grpc.stub.StreamObserver<grpc.Product.CategoriasDTO>) responseObserver);
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

  private static abstract class ProductoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Product.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductoService");
    }
  }

  private static final class ProductoServiceFileDescriptorSupplier
      extends ProductoServiceBaseDescriptorSupplier {
    ProductoServiceFileDescriptorSupplier() {}
  }

  private static final class ProductoServiceMethodDescriptorSupplier
      extends ProductoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductoServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProductoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductoServiceFileDescriptorSupplier())
              .addMethod(getAddProductoMethod())
              .addMethod(getGetByFilterMethod())
              .addMethod(getGetAllProductosMethod())
              .addMethod(getGetAllCategoriasMethod())
              .build();
        }
      }
    }
    return result;
  }
}
