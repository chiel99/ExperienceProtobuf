#! /bin/sh

rm -rf cpp java javamicro javanano python
mkdir cpp java javamicro javanano python
protoc -I./ \
    --cpp_out=./cpp \
    --java_out=./java \
    --javamicro_out=./javamicro \
    --javanano_out=./javanano \
    --python_out=./python \
    Person.proto Response.proto Request.proto
