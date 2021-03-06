// Generated by the protocol buffer compiler.  DO NOT EDIT!

package twincatstudio.io.pokedex.protobuf;

public final class ProtoPokedex {
  private ProtoPokedex() {}
  @SuppressWarnings("hiding")
  public static final class Evolution extends
      com.google.protobuf.micro.MessageMicro {
    public Evolution() {}

    // required string num = 1;
    public static final int NUM_FIELD_NUMBER = 1;
    private boolean hasNum;
    private java.lang.String num_ = "";
    public java.lang.String getNum() { return num_; }
    public boolean hasNum() { return hasNum; }
    public Evolution setNum(java.lang.String value) {
      hasNum = true;
      num_ = value;
      return this;
    }
    public Evolution clearNum() {
      hasNum = false;
      num_ = "";
      return this;
    }

    // required string name = 2;
    public static final int NAME_FIELD_NUMBER = 2;
    private boolean hasName;
    private java.lang.String name_ = "";
    public java.lang.String getName() { return name_; }
    public boolean hasName() { return hasName; }
    public Evolution setName(java.lang.String value) {
      hasName = true;
      name_ = value;
      return this;
    }
    public Evolution clearName() {
      hasName = false;
      name_ = "";
      return this;
    }

    public final Evolution clear() {
      clearNum();
      clearName();
      cachedSize = -1;
      return this;
    }

    public final boolean isInitialized() {
      if (!hasNum) return false;
      if (!hasName) return false;
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.micro.CodedOutputStreamMicro output)
                        throws java.io.IOException {
      if (hasNum()) {
        output.writeString(1, getNum());
      }
      if (hasName()) {
        output.writeString(2, getName());
      }
    }

    private int cachedSize = -1;
    @Override
    public int getCachedSize() {
      if (cachedSize < 0) {
        // getSerializedSize sets cachedSize
        getSerializedSize();
      }
      return cachedSize;
    }

    @Override
    public int getSerializedSize() {
      int size = 0;
      if (hasNum()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(1, getNum());
      }
      if (hasName()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(2, getName());
      }
      cachedSize = size;
      return size;
    }

    @Override
    public Evolution mergeFrom(
        com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            setNum(input.readString());
            break;
          }
          case 18: {
            setName(input.readString());
            break;
          }
        }
      }
    }

    public static Evolution parseFrom(byte[] data)
        throws com.google.protobuf.micro.InvalidProtocolBufferMicroException {
      return (Evolution) (new Evolution().mergeFrom(data));
    }

    public static Evolution parseFrom(
            com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      return new Evolution().mergeFrom(input);
    }

  }

  @SuppressWarnings("hiding")
  public static final class Pokemon extends
      com.google.protobuf.micro.MessageMicro {
    public Pokemon() {}

    // required int32 id = 1;
    public static final int ID_FIELD_NUMBER = 1;
    private boolean hasId;
    private int id_ = 0;
    public int getId() { return id_; }
    public boolean hasId() { return hasId; }
    public Pokemon setId(int value) {
      hasId = true;
      id_ = value;
      return this;
    }
    public Pokemon clearId() {
      hasId = false;
      id_ = 0;
      return this;
    }

    // required string num = 2;
    public static final int NUM_FIELD_NUMBER = 2;
    private boolean hasNum;
    private java.lang.String num_ = "";
    public java.lang.String getNum() { return num_; }
    public boolean hasNum() { return hasNum; }
    public Pokemon setNum(java.lang.String value) {
      hasNum = true;
      num_ = value;
      return this;
    }
    public Pokemon clearNum() {
      hasNum = false;
      num_ = "";
      return this;
    }

    // required string name = 3;
    public static final int NAME_FIELD_NUMBER = 3;
    private boolean hasName;
    private java.lang.String name_ = "";
    public java.lang.String getName() { return name_; }
    public boolean hasName() { return hasName; }
    public Pokemon setName(java.lang.String value) {
      hasName = true;
      name_ = value;
      return this;
    }
    public Pokemon clearName() {
      hasName = false;
      name_ = "";
      return this;
    }

    // required string img = 4;
    public static final int IMG_FIELD_NUMBER = 4;
    private boolean hasImg;
    private java.lang.String img_ = "";
    public java.lang.String getImg() { return img_; }
    public boolean hasImg() { return hasImg; }
    public Pokemon setImg(java.lang.String value) {
      hasImg = true;
      img_ = value;
      return this;
    }
    public Pokemon clearImg() {
      hasImg = false;
      img_ = "";
      return this;
    }

    // required string type = 5;
    public static final int TYPE_FIELD_NUMBER = 5;
    private boolean hasType;
    private java.lang.String type_ = "";
    public java.lang.String getType() { return type_; }
    public boolean hasType() { return hasType; }
    public Pokemon setType(java.lang.String value) {
      hasType = true;
      type_ = value;
      return this;
    }
    public Pokemon clearType() {
      hasType = false;
      type_ = "";
      return this;
    }

    // required string height = 6;
    public static final int HEIGHT_FIELD_NUMBER = 6;
    private boolean hasHeight;
    private java.lang.String height_ = "";
    public java.lang.String getHeight() { return height_; }
    public boolean hasHeight() { return hasHeight; }
    public Pokemon setHeight(java.lang.String value) {
      hasHeight = true;
      height_ = value;
      return this;
    }
    public Pokemon clearHeight() {
      hasHeight = false;
      height_ = "";
      return this;
    }

    // required string weight = 7;
    public static final int WEIGHT_FIELD_NUMBER = 7;
    private boolean hasWeight;
    private java.lang.String weight_ = "";
    public java.lang.String getWeight() { return weight_; }
    public boolean hasWeight() { return hasWeight; }
    public Pokemon setWeight(java.lang.String value) {
      hasWeight = true;
      weight_ = value;
      return this;
    }
    public Pokemon clearWeight() {
      hasWeight = false;
      weight_ = "";
      return this;
    }

    // required string candy = 8;
    public static final int CANDY_FIELD_NUMBER = 8;
    private boolean hasCandy;
    private java.lang.String candy_ = "";
    public java.lang.String getCandy() { return candy_; }
    public boolean hasCandy() { return hasCandy; }
    public Pokemon setCandy(java.lang.String value) {
      hasCandy = true;
      candy_ = value;
      return this;
    }
    public Pokemon clearCandy() {
      hasCandy = false;
      candy_ = "";
      return this;
    }

    // required string egg = 9;
    public static final int EGG_FIELD_NUMBER = 9;
    private boolean hasEgg;
    private java.lang.String egg_ = "";
    public java.lang.String getEgg() { return egg_; }
    public boolean hasEgg() { return hasEgg; }
    public Pokemon setEgg(java.lang.String value) {
      hasEgg = true;
      egg_ = value;
      return this;
    }
    public Pokemon clearEgg() {
      hasEgg = false;
      egg_ = "";
      return this;
    }

    // repeated string weaknesses = 10;
    public static final int WEAKNESSES_FIELD_NUMBER = 10;
    private java.util.List<java.lang.String> weaknesses_ =
      java.util.Collections.emptyList();
    public java.util.List<java.lang.String> getWeaknessesList() {
      return weaknesses_;
    }
    public int getWeaknessesCount() { return weaknesses_.size(); }
    public java.lang.String getWeaknesses(int index) {
      return weaknesses_.get(index);
    }
    public Pokemon setWeaknesses(int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  weaknesses_.set(index, value);
      return this;
    }
    public Pokemon addWeaknesses(java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  if (weaknesses_.isEmpty()) {
        weaknesses_ = new java.util.ArrayList<java.lang.String>();
      }
      weaknesses_.add(value);
      return this;
    }
    public Pokemon clearWeaknesses() {
      weaknesses_ = java.util.Collections.emptyList();
      return this;
    }

    // repeated .Evolution prev_evolution = 11;
    public static final int PREV_EVOLUTION_FIELD_NUMBER = 11;
    private java.util.List<twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution> prevEvolution_ =
      java.util.Collections.emptyList();
    public java.util.List<twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution> getPrevEvolutionList() {
      return prevEvolution_;
    }
    public int getPrevEvolutionCount() { return prevEvolution_.size(); }
    public twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution getPrevEvolution(int index) {
      return prevEvolution_.get(index);
    }
    public Pokemon setPrevEvolution(int index, twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution value) {
      if (value == null) {
        throw new NullPointerException();
      }
      prevEvolution_.set(index, value);
      return this;
    }
    public Pokemon addPrevEvolution(twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution value) {
      if (value == null) {
        throw new NullPointerException();
      }
      if (prevEvolution_.isEmpty()) {
        prevEvolution_ = new java.util.ArrayList<twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution>();
      }
      prevEvolution_.add(value);
      return this;
    }
    public Pokemon clearPrevEvolution() {
      prevEvolution_ = java.util.Collections.emptyList();
      return this;
    }

    // repeated .Evolution next_evolution = 12;
    public static final int NEXT_EVOLUTION_FIELD_NUMBER = 12;
    private java.util.List<twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution> nextEvolution_ =
      java.util.Collections.emptyList();
    public java.util.List<twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution> getNextEvolutionList() {
      return nextEvolution_;
    }
    public int getNextEvolutionCount() { return nextEvolution_.size(); }
    public twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution getNextEvolution(int index) {
      return nextEvolution_.get(index);
    }
    public Pokemon setNextEvolution(int index, twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution value) {
      if (value == null) {
        throw new NullPointerException();
      }
      nextEvolution_.set(index, value);
      return this;
    }
    public Pokemon addNextEvolution(twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution value) {
      if (value == null) {
        throw new NullPointerException();
      }
      if (nextEvolution_.isEmpty()) {
        nextEvolution_ = new java.util.ArrayList<twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution>();
      }
      nextEvolution_.add(value);
      return this;
    }
    public Pokemon clearNextEvolution() {
      nextEvolution_ = java.util.Collections.emptyList();
      return this;
    }

    public final Pokemon clear() {
      clearId();
      clearNum();
      clearName();
      clearImg();
      clearType();
      clearHeight();
      clearWeight();
      clearCandy();
      clearEgg();
      clearWeaknesses();
      clearPrevEvolution();
      clearNextEvolution();
      cachedSize = -1;
      return this;
    }

    public final boolean isInitialized() {
      if (!hasId) return false;
      if (!hasNum) return false;
      if (!hasName) return false;
      if (!hasImg) return false;
      if (!hasType) return false;
      if (!hasHeight) return false;
      if (!hasWeight) return false;
      if (!hasCandy) return false;
      if (!hasEgg) return false;
      for (twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution element : getPrevEvolutionList()) {
        if (!element.isInitialized()) return false;
      }
      for (twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution element : getNextEvolutionList()) {
        if (!element.isInitialized()) return false;
      }
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.micro.CodedOutputStreamMicro output)
                        throws java.io.IOException {
      if (hasId()) {
        output.writeInt32(1, getId());
      }
      if (hasNum()) {
        output.writeString(2, getNum());
      }
      if (hasName()) {
        output.writeString(3, getName());
      }
      if (hasImg()) {
        output.writeString(4, getImg());
      }
      if (hasType()) {
        output.writeString(5, getType());
      }
      if (hasHeight()) {
        output.writeString(6, getHeight());
      }
      if (hasWeight()) {
        output.writeString(7, getWeight());
      }
      if (hasCandy()) {
        output.writeString(8, getCandy());
      }
      if (hasEgg()) {
        output.writeString(9, getEgg());
      }
      for (java.lang.String element : getWeaknessesList()) {
        output.writeString(10, element);
      }
      for (twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution element : getPrevEvolutionList()) {
        output.writeMessage(11, element);
      }
      for (twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution element : getNextEvolutionList()) {
        output.writeMessage(12, element);
      }
    }

    private int cachedSize = -1;
    @Override
    public int getCachedSize() {
      if (cachedSize < 0) {
        // getSerializedSize sets cachedSize
        getSerializedSize();
      }
      return cachedSize;
    }

    @Override
    public int getSerializedSize() {
      int size = 0;
      if (hasId()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(1, getId());
      }
      if (hasNum()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(2, getNum());
      }
      if (hasName()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(3, getName());
      }
      if (hasImg()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(4, getImg());
      }
      if (hasType()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(5, getType());
      }
      if (hasHeight()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(6, getHeight());
      }
      if (hasWeight()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(7, getWeight());
      }
      if (hasCandy()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(8, getCandy());
      }
      if (hasEgg()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(9, getEgg());
      }
      {
        int dataSize = 0;
        for (java.lang.String element : getWeaknessesList()) {
          dataSize += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getWeaknessesList().size();
      }
      for (twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution element : getPrevEvolutionList()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeMessageSize(11, element);
      }
      for (twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution element : getNextEvolutionList()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeMessageSize(12, element);
      }
      cachedSize = size;
      return size;
    }

    @Override
    public Pokemon mergeFrom(
        com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 8: {
            setId(input.readInt32());
            break;
          }
          case 18: {
            setNum(input.readString());
            break;
          }
          case 26: {
            setName(input.readString());
            break;
          }
          case 34: {
            setImg(input.readString());
            break;
          }
          case 42: {
            setType(input.readString());
            break;
          }
          case 50: {
            setHeight(input.readString());
            break;
          }
          case 58: {
            setWeight(input.readString());
            break;
          }
          case 66: {
            setCandy(input.readString());
            break;
          }
          case 74: {
            setEgg(input.readString());
            break;
          }
          case 82: {
            addWeaknesses(input.readString());
            break;
          }
          case 90: {
            twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution value = new twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution();
            input.readMessage(value);
            addPrevEvolution(value);
            break;
          }
          case 98: {
            twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution value = new twincatstudio.io.pokedex.protobuf.ProtoPokedex.Evolution();
            input.readMessage(value);
            addNextEvolution(value);
            break;
          }
        }
      }
    }

    public static Pokemon parseFrom(byte[] data)
        throws com.google.protobuf.micro.InvalidProtocolBufferMicroException {
      return (Pokemon) (new Pokemon().mergeFrom(data));
    }

    public static Pokemon parseFrom(
            com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      return new Pokemon().mergeFrom(input);
    }

  }

  @SuppressWarnings("hiding")
  public static final class Pokedex extends
      com.google.protobuf.micro.MessageMicro {
    public Pokedex() {}

    // repeated .Pokemon pokemon = 1;
    public static final int POKEMON_FIELD_NUMBER = 1;
    private java.util.List<twincatstudio.io.pokedex.protobuf.ProtoPokedex.Pokemon> pokemon_ =
      java.util.Collections.emptyList();
    public java.util.List<twincatstudio.io.pokedex.protobuf.ProtoPokedex.Pokemon> getPokemonList() {
      return pokemon_;
    }
    public int getPokemonCount() { return pokemon_.size(); }
    public twincatstudio.io.pokedex.protobuf.ProtoPokedex.Pokemon getPokemon(int index) {
      return pokemon_.get(index);
    }
    public Pokedex setPokemon(int index, twincatstudio.io.pokedex.protobuf.ProtoPokedex.Pokemon value) {
      if (value == null) {
        throw new NullPointerException();
      }
      pokemon_.set(index, value);
      return this;
    }
    public Pokedex addPokemon(twincatstudio.io.pokedex.protobuf.ProtoPokedex.Pokemon value) {
      if (value == null) {
        throw new NullPointerException();
      }
      if (pokemon_.isEmpty()) {
        pokemon_ = new java.util.ArrayList<twincatstudio.io.pokedex.protobuf.ProtoPokedex.Pokemon>();
      }
      pokemon_.add(value);
      return this;
    }
    public Pokedex clearPokemon() {
      pokemon_ = java.util.Collections.emptyList();
      return this;
    }

    public final Pokedex clear() {
      clearPokemon();
      cachedSize = -1;
      return this;
    }

    public final boolean isInitialized() {
      for (twincatstudio.io.pokedex.protobuf.ProtoPokedex.Pokemon element : getPokemonList()) {
        if (!element.isInitialized()) return false;
      }
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.micro.CodedOutputStreamMicro output)
                        throws java.io.IOException {
      for (twincatstudio.io.pokedex.protobuf.ProtoPokedex.Pokemon element : getPokemonList()) {
        output.writeMessage(1, element);
      }
    }

    private int cachedSize = -1;
    @Override
    public int getCachedSize() {
      if (cachedSize < 0) {
        // getSerializedSize sets cachedSize
        getSerializedSize();
      }
      return cachedSize;
    }

    @Override
    public int getSerializedSize() {
      int size = 0;
      for (twincatstudio.io.pokedex.protobuf.ProtoPokedex.Pokemon element : getPokemonList()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeMessageSize(1, element);
      }
      cachedSize = size;
      return size;
    }

    @Override
    public Pokedex mergeFrom(
        com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            twincatstudio.io.pokedex.protobuf.ProtoPokedex.Pokemon value = new twincatstudio.io.pokedex.protobuf.ProtoPokedex.Pokemon();
            input.readMessage(value);
            addPokemon(value);
            break;
          }
        }
      }
    }

    public static Pokedex parseFrom(byte[] data)
        throws com.google.protobuf.micro.InvalidProtocolBufferMicroException {
      return (Pokedex) (new Pokedex().mergeFrom(data));
    }

    public static Pokedex parseFrom(
            com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      return new Pokedex().mergeFrom(input);
    }

  }

}
