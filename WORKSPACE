load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "2.8"
RULES_JVM_EXTERNAL_SHA = "79c9850690d7614ecdb72d68394f994fef7534b292c4867ce5e7dec0aa7bdfad"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")


maven_install(
    artifacts = [
        "com.google.code.gson:gson:2.9.0",
        "org.slf4j:slf4j-api:1.7.36",
        "javax.annotation:javax.annotation-api:1.3.2",
        "org.apache.thrift:libthrift:0.16.0",
        "io.grpc:grpc-api:1.45.0",
        "io.grpc:grpc-stub:1.45.0",
        "io.grpc:grpc-netty-shaded:1.45.0"
    ],
    repositories = [
        "https://repo1.maven.org/maven2"
    ]
)

#load("@io_grpc_grpc_java//:repositories.bzl", "IO_GRPC_GRPC_JAVA_ARTIFACTS", "IO_GRPC_GRPC_JAVA_OVERRIDE_TARGETS", "grpc_java_repositories")
#load("@maven//:compat.bzl", "compat_repositories")

#compat_repositories()
#grpc_java_repositories()

