load("@rules_java//java:defs.bzl", "java_binary")

java_binary(
    name = "demo",
    main_class = "com.example.ProjectRunner",
    runtime_deps = [
        ":demo-lib"
    ]
)
java_library(
    name = "demo-lib",
    srcs = glob(["**/*.java"]),
    deps = [
        "@maven//:com_google_code_gson_gson",
        "@maven//:org_slf4j_slf4j_api",
        "@maven//:javax_annotation_javax_annotation_api",
        "@maven//:org_apache_thrift_libthrift",
    ],
)

