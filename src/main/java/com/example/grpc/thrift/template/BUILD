package(default_visibility = ["//visibility:public"])
load("@rules_java//java:defs.bzl", "java_binary")

java_library(
    name = "thrift-template-lib",
    srcs = [
        "HelloService.java", "Message.java"
    ],
    deps = [
        "@maven//:org_slf4j_slf4j_api",
        "@maven//:javax_annotation_javax_annotation_api",
        "@maven//:org_apache_thrift_libthrift"
    ],
)

#
#java_binary(
#    name = "thrift_template",
#    srcs = [
#        "*.java"
#    ],
#    deps = [
#        ":thrift-template-lib"
#    ],
#)
#
#java_library(
#    name = "thrift-template-lib",
#    srcs = [
#        "*.java"
#    ],
#    deps = [
#        "@maven//:org_slf4j_slf4j_api",
#        "@maven//:javax_annotation_javax_annotation_api",
#        "@maven//:org_apache_thrift_libthrift",
#    ],
#)
