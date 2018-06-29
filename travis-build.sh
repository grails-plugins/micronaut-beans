#!/bin/bash
set -e
rm -rf *.zip
./gradlew clean app:check micronaut-beans:assemble

EXIT_STATUS=0

exit $EXIT_STATUS
