load("@rules_java//java:defs.bzl", "java_binary")

java_binary(
    name = "demo",
    srcs = [
        "ProjectRunner.java"
    ],
    main_class = "com.example.ProjectRunner",
    deps = [
        "//src/main/java/com/example/gson:gson-lib",
        "//src/main/java/com/example/grpc/thrift/template:thrift-template-lib"
    ]
)

#java_import(
#    name = "local-lib",
#    jars = [
#        "@maven//:com_google_code_gson_gson"
#    ],
#    deps = [],
#)
#java_library(
#    name = "demo-lib",
#    srcs = glob(["src/main/java/com/example/*.java"]),
#    deps = [
#        "@maven//:com_google_code_gson_gson",
#    ],
#)

