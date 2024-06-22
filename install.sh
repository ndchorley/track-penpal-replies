#!/bin/bash

set -e

JAR_BASE_NAME=track-penpal-replies-1.0-SNAPSHOT-all
INSTALL_DIRECTORY=~/software

NEW_JAR=$INSTALL_DIRECTORY/$JAR_BASE_NAME-new.jar
cp build/libs/$JAR_BASE_NAME.jar $NEW_JAR

OLD_JAR=$INSTALL_DIRECTORY/$JAR_BASE_NAME.jar

if [ -e $OLD_JAR ]
then
  rm -v $OLD_JAR
fi

mv -v $NEW_JAR $OLD_JAR
