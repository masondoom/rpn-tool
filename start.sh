#!/bin/bash
# requires kotlin cli tool

mvn clean install && kotlin -cp target/rpn-tool-1.0-SNAPSHOT.jar com.masondoom.rpntool.MainKt