package zw.co.nbs.gatewayservicecharges.controller;

public @interface Operation {
    String summary();

    String description();

    String method();

    String[] tags();
}
