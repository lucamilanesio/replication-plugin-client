load("@rules_java//java:defs.bzl", "java_library")
load("//tools/bzl:junit.bzl", "junit_tests")
load("//tools/bzl:plugin.bzl", "PLUGIN_DEPS", "PLUGIN_TEST_DEPS", "gerrit_plugin")

gerrit_plugin(
    name = "replication-client",
    srcs = glob(["src/main/java/**/*.java"]),
    manifest_entries = [
        "Implementation-Title: Replication plugin admin client",
        "Implementation-URL: https://github.com/lucamilanesio/replication-plugin-client",
        "Gerrit-PluginName: replication-client",
        "Gerrit-Module: com.googlesource.gerrit.plugins.replication.client.ReplicationClientModule",
    ],
    resources = glob(["src/main/resources/**/*"]),
    deps = [
        ":replication-neverlink",
        "//lib/auto:auto-value-gson",
    ],
)

java_library(
    name = "replication-neverlink",
    neverlink = 1,
    exports = ["//plugins/replication"],
)
