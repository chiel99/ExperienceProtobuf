# Protocol Buffer Demo

This is a demo for using protocol buffer on Android.

### Prepare the protocol buffer

* Download the android protocol buffer source

```sh

$ git clone https://github.com/android/platform_external_protobuf.git

```

* Setup protocol buffer config

```sh

# Mac
$ brew install automake

# Ubuntu
$ sudo apt-get install automake
$ sudo apt-get install libtool

# Autogen config
$ ./autogen.sh

# Setup config for Mac
$ ./configurate

# Setup config for Ubuntu:
./configure --prefix=/usr

```

* Build protocol buffer

```sh

# Compile source code
$ make

# Run tests
$ make check

# If failed due to "tr1/tuple file not found", rerun config again
$ ./configure CPPFLAGS=-DGTEST_USE_OWN_TR1_TUPLE=1

# Install
$ make install

```

* Check protocol buffer version

```sh

# Check version
$ protoc --version
libprotoc 2.6.1

```

* Build Java lib

```sh

$ cd java/
$ mvn test
$ mvn install

# Generate lite version
$ mvn package -P lite
$ mv target/protobuf-java-2.6.1.jar target/protobuf-java-lite-2.6.1.jar

# Generate micro version
$ mvn package -P micro
$ mv target/protobuf-java-2.6.1.jar target/protobuf-java-micro-2.6.1.jar

# Generate nano version (apply misc/FixNanoBuildFailed.patch first)
$ mvn package -P nano
$ mv target/protobuf-java-2.6.1.jar target/protobuf-java-nano-2.6.1.jar

```

* Copy the java libs to AndroidApp

```sh

$ cp target/protobuf-java-nano-2.6.1.jar <AppRoot>/app/libs/

```

### Generate the java code from .proto files

```sh

$ cd <your folder to store .proto files>
$ mkdir cpp java javamicro javanano python

$ protoc -I<.proto source folder> \
    --cpp_out=./cpp \
    --java_out=./java \
    --javamicro_out=./javamicro \
    --javanano_out=./javanano \
    --python_out=./python \
    YOUR.proto

$ cp javano/*.java <AppRoot>/app/src/main/java/<pacakge name>/protobufs/

```
