#!/bin/sh
# Maven Wrapper Script
set -e

MAVEN_WRAPPER_JAR=".mvn/wrapper/maven-wrapper.jar"
MAVEN_WRAPPER_PROPERTIES=".mvn/wrapper/maven-wrapper.properties"

# Đọc distributionUrl từ properties
DISTRIBUTION_URL=$(grep "distributionUrl" "$MAVEN_WRAPPER_PROPERTIES" | cut -d'=' -f2)

# Tìm JAVA_HOME
if [ -n "$JAVA_HOME" ]; then
    JAVA_CMD="$JAVA_HOME/bin/java"
else
    JAVA_CMD="java"
fi

# Download wrapper jar nếu chưa có
if [ ! -f "$MAVEN_WRAPPER_JAR" ]; then
    WRAPPER_URL=$(grep "wrapperUrl" "$MAVEN_WRAPPER_PROPERTIES" | cut -d'=' -f2)
    echo "Downloading Maven Wrapper..."
    if command -v curl > /dev/null; then
        curl -o "$MAVEN_WRAPPER_JAR" "$WRAPPER_URL" -s
    elif command -v wget > /dev/null; then
        wget -q -O "$MAVEN_WRAPPER_JAR" "$WRAPPER_URL"
    fi
fi

exec "$JAVA_CMD" -jar "$MAVEN_WRAPPER_JAR" "$DISTRIBUTION_URL" "$@"
