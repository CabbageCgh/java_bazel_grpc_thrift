package com.example.grpc.server;

import com.google.gson.Gson;
import io.grpc.BindableService;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class GRpcServer {

    private static final String SERVICE_NAME = "GRPC_THRIFT";

    public static void main(String[] args) throws IOException, InterruptedException {
        new GRpcServer().start();
    }

    public void start() throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(2020)
//                .addService(("", ServerCalls))
                .addService(new HelloThriftServiceImplBase())
                .build()
                .start();

        server.awaitTermination();
    }

    static class HelloRequest {
        private int id = 100;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    static class HelloResult {

    }

    static final MethodDescriptor<HelloRequest, HelloResult> CREATE_METHOD = MethodDescriptor.newBuilder(
                    marshallerFor(HelloRequest.class),
                    marshallerFor(HelloResult.class)
            ).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Create"))
            .setType(MethodDescriptor.MethodType.UNARY)
            .build();

    static <T> MethodDescriptor.Marshaller<T> marshallerFor(Class<T> clz) {
        Gson gson = new Gson();
        return new MethodDescriptor.Marshaller<T>() {
            @Override
            public InputStream stream(T value) {
                return new ByteArrayInputStream(gson.toJson(value, clz).getBytes(StandardCharsets.UTF_8));
            }

            @Override
            public T parse(InputStream stream) {
                return gson.fromJson(new InputStreamReader(stream, StandardCharsets.UTF_8), clz);
            }
        };
    }

    static abstract class ThriftServiceImplBase implements BindableService {

        public abstract void create(HelloRequest request, StreamObserver<HelloResult> streamObserver);

        @Override
        public ServerServiceDefinition bindService() {

            return ServerServiceDefinition.builder("")
                    .addMethod(CREATE_METHOD, ServerCalls.asyncUnaryCall(
                            this::create
                    ))
                    .build();
        }
    }

    static class HelloThriftServiceImplBase extends ThriftServiceImplBase {

        @Override
        public void create(HelloRequest request, StreamObserver<HelloResult> streamObserver) {
            System.out.println(new Gson().toJson(request));
        }
    }


}
