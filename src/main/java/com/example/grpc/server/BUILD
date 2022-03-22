load("@rules_java//java:defs.bzl", "java_binary")
package(default_visibility = ["//visibility:public"])

java_binary(
    name = "grpc-server",
    srcs = [
        "GRpcServer.java"
    ],
    main_class = "com.example.grpc.server.GRpcServer",
    deps = [
        "@maven//:io_grpc_grpc_api",
        "@maven//:io_grpc_grpc_stub",
        "@maven//:io_grpc_grpc_netty_shaded",
        "@maven//:com_google_code_gson_gson",
    ]
)